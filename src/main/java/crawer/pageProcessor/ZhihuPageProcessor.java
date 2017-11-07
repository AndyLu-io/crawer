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
        System.out.println(page.getHtml());
    }

    @Override
    public Site getSite() {
        return null;
    }

    public static void main(String[] args) {
        Spider.create(new ZhihuPageProcessor())
                .addUrl("http://www.360doc.com/content/16/0507/22/33093571_557135232.shtml")
                .thread(3).run();
    }

}
