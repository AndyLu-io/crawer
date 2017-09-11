package crawer.service;

import com.alibaba.fastjson.JSONArray;
import crawer.dao.AuthorMapper;
import crawer.model.Author;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by luxiaobo on 2017/4/12.
 */
@Service
public class AuthorService {
    @Autowired
    private AuthorMapper authorMapper;

    public int add(String realName, String nickName) {
        return this.authorMapper.add(realName, nickName);
    }
    public int update(String realName, String nickName, Long id) {
        return this.authorMapper.update(realName, nickName, id);
    }
    public int delete(Long id) {
        return this.authorMapper.delete(id);
    }
    public Author findAuthor(Long id) {
        return this.authorMapper.findAuthor(id);
    }
    public List<Author> findAuthorList() {
        return this.authorMapper.findAuthorList();
    }

    public static void getChapterImagesForSite1VIP(String url) throws IOException {
        Connection.Response response = Jsoup.connect(url).userAgent(
                "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_1) AppleWebKit/537.73.11 (KHTML, like Gecko) Version/7.0.1 Safari/537.73.11").cookie("p_skey", "IjS4v0Osh3dPn-E0v5X0L31AHOsBmExuj1LP0BH02kw_"
        ).cookie("p_uin", "o0870604904").execute();
        if (response.statusCode() >= 200 && response.statusCode() <= 300) {
//            ChapterImgCache chapterImgCache = new ChapterImgCache();
//            List<ImgCache> imgCachesList = Lists.newArrayList();
            JSONArray imgCaches = new JSONArray();
            Pattern imgDataPattern = Pattern.compile("[\\s\\S]*var DATA        = '([\\s\\S]*)'[\\s\\S]*");
            Matcher imgDataMatcher = imgDataPattern.matcher(response.parse().outerHtml());
            if (imgDataMatcher.matches()) {
                String imgData = imgDataMatcher.group(1);
//                if (StringUtils.isNotEmpty(imgData)) {
//                    try {
//                        List<String> imgUrls = Lists.newArrayList();
//                        imgData = imgData.substring(1);
//                        String jsonData = new String(Base64Utils.decodeFromString(imgData));
//                        JSONObject chapterJSON = JSON.parseObject(jsonData);
//                        JSONArray images = chapterJSON.getJSONArray("picture");
//                        for (int i = 0; i < images.size(); i++) {
//                            ImgCache imgCache = new ImgCache();
//                            JSONObject image = images.getJSONObject(i);
//                            imgCache.setHeight(image.getInteger("height"));
//                            imgCache.setWidth(image.getInteger("width"));
//                            imgCache.setImgUrl(image.getString("url"));
//                            imgUrls.add(imgCache.getImgUrl());
//                            imgCaches.add(imgCache);
//                            imgCachesList.add(imgCache);
//                        }
//                        chapterImgCache.setImgs(imgCachesList);
//                        chapterImgCache.setComicId(chapterJSON.getJSONObject("comic").getInteger("id"));
//                        chapterImgCache.setChapterId(chapterJSON.getJSONObject("chapter").getInteger("cid"));
//                        template.hset(BookChapterCacheKey.findKeyByID(1L), chapterImgCache.getComicId() + "-" + chapterImgCache.getChapterId(), JSON.toJSONString(chapterImgCache));
//                        RabbitTemplateUtil.send(imgUrls, "comic", BookImageRouteKey.findRouteKeyByID(1L));
//                    } catch (NullPointerException e) {
//                        e.printStackTrace();
//                    }
//                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        getChapterImagesForSite1VIP("http://ac.qq.com/ComicView/index/id/530987/cid/216");
    }
}
