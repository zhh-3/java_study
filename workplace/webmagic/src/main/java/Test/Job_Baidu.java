package Test;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.scheduler.BloomFilterDuplicateRemover;
import us.codecraft.webmagic.scheduler.QueueScheduler;

public class Job_Baidu implements PageProcessor {
    public void process(Page page) {
        page.putField("div1",page.getHtml()
                .xpath("//div[@id=body]/div[@id=focus-top]/div[@class=l-left-col]/div/div[@class=mod-tab-content]" +
                        "/div[@id=pane-news]/div/ul/li[@class=hdline0]/strong/a").all());

        page.addTargetRequests(page.getHtml()
                .xpath("//div[@id=body]/div[@id=focus-top]/div[@class=l-left-col]/div/div[@class=mod-tab-content]" +
                       "/div[@id=pane-news]/div/ul/li[@class=hdline0]/strong/a").links().all());
        page.putField("url",page.getHtml().xpath("div[@class=h-news]/div[@class=h-title]").all());
    }

    private Site site = Site.me()
            .setCharset("utf8")     //设置编码格式
            .setTimeOut(10000)      //设置请求时间
            .setRetrySleepTime(3000)    //设置重试时间间隔
            .setRetryTimes(3)       //设置重试次数
            ;


    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider spider =Spider.create(new Job_Baidu())
                .addUrl("http://news.baidu.com/")
//                .addPipeline(new FilePipeline("E:\\Users\\haha\\Desktop\\result"))
                .setScheduler(new QueueScheduler().setDuplicateRemover(new BloomFilterDuplicateRemover(10000)))
                ;
        spider.run();
    }
}
