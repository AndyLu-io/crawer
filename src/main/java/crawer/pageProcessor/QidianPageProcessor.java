package crawer.pageProcessor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.CssSelector;

import java.util.List;

/**
 * 起点网站爬虫
 * Created by luxiaobo on 2017/4/11.
 */
@Service
public class QidianPageProcessor implements PageProcessor {
    private static final Logger logger = LoggerFactory.getLogger(QidianPageProcessor.class);

    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    @Override
    public void process(Page page) {
        List<String> textList =  page.getHtml().select(new CssSelector(".volume .cf li a", "text")).all();
//        page.addTargetRequests(textList);
        for (String text: textList) {
            logger.info(text);
        }
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        logger.info("爬虫开始");
        Spider.create(new QidianPageProcessor()).addUrl("http://book.qidian.com/info/3681560").thread(5).run();
    }

}
