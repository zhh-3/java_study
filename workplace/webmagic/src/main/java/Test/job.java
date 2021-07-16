package Test;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.scheduler.BloomFilterDuplicateRemover;
import us.codecraft.webmagic.scheduler.QueueScheduler;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;

public class job implements PageProcessor {
    private static String url = "https://www.liepin.com/zhaopin/?industries=&subIndustry=&dqs=&salary=&jobKind=&pubTime=&compkind=&compscale=&searchType=1&isAnalysis=&sortFlag=15&d_headId=e7ae308da9f8db22cd75b861f0d9d258&d_ckId=e7ae308da9f8db22cd75b861f0d9d258&d_sfrom=search_fp&d_curPage=0&d_pageSize=40&siTag=LiAE77uh7ygbLjiB5afMYg%7EfA9rXquZc5IkJpXC-Ycixw&key=java";

    @Override
    public void process(Page page) {
        List<Selectable> list = page.getHtml().xpath("//div[@class=sojob-result]/ul/li").nodes();
        page.putField("li",page.getHtml().xpath("//div[@class=sojob-result]/ul/li/div/div[@class=job-info]/h3").all());
        if (list.size()==0){
            //如果列表为空，则是详情页，解析页面，保存数据
            System.out.println(123);
            this.saveJobInfo(page);
        }else {
            //如果列表不为空，则是列表页，解析出详情页的url,放到任务队列中
            for (Selectable selectable : list) {
                //获取url地址
                String jobInfoUrl = selectable.links().toString();
                System.out.println(jobInfoUrl);
//                page.addTargetRequest(jobInfoUrl);
            }

            //获取下一页url

        }
    }

    private void saveJobInfo(Page page) {

    }

    private Site site = Site.me()
            .setCharset("utf8")
            .setRetrySleepTime(3000)
            .setTimeOut(100000)
            .setRetryTimes(3);
    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new job())
                .addUrl(url)
                .setScheduler(new QueueScheduler().setDuplicateRemover(new BloomFilterDuplicateRemover(10000)))
                .thread(3)
                .run();
    }
}
