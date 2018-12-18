package mode;

/**
 * @author qingxiao
 * @date 2018-12-18  16:54
 */
public class Config {
    private Long pageId;

    private String pageUrl;

    private String title;

    private String subTitle;

    private String moreInfo;

    private String moreInfoLink;

    public Long getPageId() {
        return pageId;
    }

    public void setPageId(Long pageId) {
        this.pageId = pageId;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
    }

    public String getMoreInfoLink() {
        return moreInfoLink;
    }

    public void setMoreInfoLink(String moreInfoLink) {
        this.moreInfoLink = moreInfoLink;
    }
}
