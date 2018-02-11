package crawer.pageProcessor;

import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

/**
 * @Author : qingxiao
 * @Description:
 * @Date : Created in 20:37  2017/12/20
 */
public class DoubanPageProcessor implements PageProcessor {

    private static final Logger logger = LoggerFactory.getLogger(QidianPageProcessor.class);

    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    private static final String url = "https://book.douban.com/tag/?view=type&icn=index-sorttags-hot#%E6%96%87%E5%AD%A6";

    @Override
    public void process(Page page) {
        Html html = page.getHtml();
        Document document = html.getDocument();
        document.select("scc");
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        logger.info("爬虫开始");
        Spider.create(new DoubanPageProcessor()).addUrl(url).thread(5).run();
    }
}
