package Test;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

public class Job_Processor implements PageProcessor {
    //解析页面
    public void process(Page page) {
        //解析返回的数据page,并且把解析的结果放到ResultItem中
//        page.putField("div",page.getHtml().css("div.dt.cw-icon").all());

        //xpath
        page.putField("div2",page.getHtml().xpath("//div[@id=shortcut]/div/ul[@class=fr]/li[@clstag]/div/a").all());

        //xpath+正则表达式
        page.putField("div3",page.getHtml()
                .xpath("//div[@id=header]/div/div[@id=navitems]/ul[@id=navitems-group2]/li/a").regex(".*京东.*").all());

        //结果处理API
        page.putField("div4",page.getHtml()
                .xpath("//div[@id=header]/div/div[@id=navitems]/ul[@id=navitems-group2]/li/a").regex(".*京东.*").get());
        page.putField("div5",page.getHtml().
                xpath("//div[@id=header]/div/div[@id=navitems]/ul[@id=navitems-group2]/li/a").regex(".*京东.*").toString());

    }

    private Site site = Site.me();
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new Job_Processor())
                .addUrl("https://jd.com")
                .run();
    }
}
