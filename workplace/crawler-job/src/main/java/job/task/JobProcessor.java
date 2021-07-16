package job.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.scheduler.BloomFilterDuplicateRemover;
import us.codecraft.webmagic.scheduler.QueueScheduler;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;

@Component
public class JobProcessor implements PageProcessor {
    private String url = "https://search.51job.com/list/000000,000000,0000,00,9,99,java,2,1.html?" +
            "lang=c&postchannel=0000&workyear=99&cotype=99&degreefrom=99&jobterm=99&companysize=99&" +
            "ord_field=0&dibiaoid=0&line=&welfare=";
    @Override
    public void process(Page page) {
        List<Selectable> list = page.getHtml().xpath("//div[@class=j_joblist]/div").nodes();
        if (list.size()==0){
            //如果列表为空，则是详情页，解析页面，保存数据
            this.saveJobInfo(page);
        }else {
            //如果列表不为空，则是列表页，解析出详情页的url,放到任务队列中
            for (Selectable selectable : list) {
                //获取url地址
                String jobInfoUrl = selectable.links().toString();
                System.out.println(jobInfoUrl);
            }
        }
    }

    private void saveJobInfo(Page page) {

    }

    private Site site = Site.me()
            .setCharset("gbk")
            .setRetrySleepTime(3000)
            .setTimeOut(100000)
            .setRetryTimes(3);
    @Override
    public Site getSite() {
        return site;
    }

    //initialDelay当任务启动后，等待多久执行方法
    //fixedDelay每隔多久执行方法
    @Scheduled(initialDelay = 1000,fixedDelay = 10000)
    public void process(){
        Spider.create(new JobProcessor())
                .addUrl(url)
                .setScheduler(new QueueScheduler().setDuplicateRemover(new BloomFilterDuplicateRemover(100000)))
                .thread(10)
                .run();
    }
}
