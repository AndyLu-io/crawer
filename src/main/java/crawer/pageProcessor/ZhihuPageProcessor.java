package crawer.pageProcessor;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.CssSelector;

/**
 * Created by luxiaobo on 2017/4/11.
 */
public class ZhihuPageProcessor implements PageProcessor {
    @Override
    public void process(Page page) {
//        page.getHtml().select(new CssSelector())
    }

    @Override
    public Site getSite() {
        return null;
    }

    public static void main(String[] args) {
        Spider.create(new ZhihuPageProcessor())
                .addUrl("https://github.com/search?l=Java&p=1&q=stars%3A%3E1&s=stars&type=Repositories")
                .thread(3).run();
    }
}
