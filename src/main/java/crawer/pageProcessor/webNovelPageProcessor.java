package crawer.pageProcessor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.CssSelector;

import java.util.List;

/**
 * Created by luxiaobo on 2017/4/21.
 */
public class webNovelPageProcessor implements PageProcessor{
    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);


    private static final Logger logger = LoggerFactory.getLogger(webNovelPageProcessor.class);


    @Override
    public void process(Page page) {
        List<String> textList = page.getHtml().select(new CssSelector(".cha-content p", "text")).all();
        for (String text: textList) {
            System.out.println(text);
        }
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new webNovelPageProcessor()).addUrl("https://www.webnovel.com/book/6838665302001605/18716104394327799")
                .thread(5).run();
    }


}
