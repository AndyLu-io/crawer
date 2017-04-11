package crawer.pageProcessor;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

/**
 * 腾讯动漫站点爬虫
 * Created by luxiaobo on 2017/4/11.
 */
public class TencentPageProcessor implements PageProcessor {
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);
    @Override
    public void process(Page page) {
        List<String> urls = page.getHtml().css("ul.mod-tags-list li a", "href").all();
        for (String url : urls) {
//            System.out.println(url);
            page.putField(url, url);
        }
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new TencentPageProcessor()).addUrl("http://ac.qq.com/")
                .addPipeline(new JsonFilePipeline("/Users/luxiaobo/Documents/spriderJsonFile"))
                .addPipeline(new ConsolePipeline())
                .thread(5).run();
    }
}
