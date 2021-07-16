package jd.task;

import com.fasterxml.jackson.databind.ObjectMapper;
import jd.pojo.Item;
import jd.service.ItemService;
import jd.util.HttpUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class ItemTask {
    @Autowired
    private HttpUtil httpUtil = new HttpUtil();
    @Autowired
    private ItemService itemService;
    private static final ObjectMapper Mapper = new ObjectMapper();

    //当下载任务完成后，每个多长时间进行下一次任务
    @Scheduled(fixedDelay = 10 * 10000)
    public void task() throws Exception{
        String url = "https://search.jd.com/Search?keyword=%E6%89%8B%E6%9C%BA&s=1&click=1&page=";
        for (int i = 1; i < 5; i+=2) {
            System.out.println(i);
            String html = httpUtil.doGetHtml(url + i);
            parse(html);
        }
        System.out.println("获取完成");
    }

    //解析界面，获取信息保存至数据库
    private void parse(String html) throws Exception{
        //解析html界面，获取doc文档
        Document doc = Jsoup.parse(html);

        //获取数据信息
        Elements spueles = doc.select("div#J_goodsList > ul > li");
        for (Element element : spueles) {
            //获取spu
            long spu = Long.parseLong(element.attr("data-spu"));
            //获取sku
            Elements skueles = spueles.select("li.ps-item");
            for (Element skuele : skueles) {
                long sku = Long.parseLong(skuele.select("[data-sku]").attr("data-sku"));

                //根据sku查询商品数据
                Item item = new Item();
                item.setSku(sku);
                List<Item> list = itemService.findAll(item);

                //如果商品已存在，就进行下一个循环
                if (list.size() > 0){
                    continue;
                }

                //商品不存在，保存商品信息
                //保存spu
                item.setSpu(spu);
                //保存url
                String itemurl = "https://item.jd.com/"+sku+".html";
                item.setUrl(itemurl);
                //保存创建时间
                item.setCreated(new Date());
                //保存图片
                String picurl = skuele.select("img[data-sku]").first().attr("data-lazy-img");
                picurl = picurl.replace("/n7/","/n1/");
                String picName = httpUtil.doGetImage(picurl);
                item.setPic(picName);
                //保存价格
                String pricejson = httpUtil.doGetHtml("https://p.3.cn/prices/mgets?skuIds=J_" + sku);
                double price = Mapper.readTree(pricejson).get(0).get("p").asDouble();
                item.setPrice(price);
                //保存标题
                String iteminfo = httpUtil.doGetHtml(item.getUrl());
                String title = Jsoup.parse(iteminfo).select("div.sku-name").text();
                item.setTitle(title);
                //保存更新时间
                item.setUpdated(item.getCreated());

                itemService.save(item);
            }
        }
    }
}
