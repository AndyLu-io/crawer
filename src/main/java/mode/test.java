package mode;

import com.alibaba.fastjson.JSON;
import org.assertj.core.util.Lists;

import java.util.ArrayList;

/**
 * @author qingxiao
 * @date 2018-12-18  16:57
 */
public class test {

    public static void main(String[] args) {
        Config config = new Config();
        config.setPageUrl("https://mall.hipac.cn/ytms/page/meiribiqiang.html");
        config.setPageId(1L);
        config.setTitle("每日必抢");
        config.setSubTitle("每日10点 抢到赚到");
        config.setMoreInfo("更多链接");
        config.setMoreInfoLink("baidu.com");
        Config config1 = new Config();
        config1.setPageUrl("https://mall.hipac.cn/ytms/page/xinpinqx.html");
        config1.setPageId(2L);
        config1.setTitle("新品抢先");
        config1.setMoreInfo("更多链接");
        config1.setMoreInfoLink("baidu.com");
        ArrayList<Config> configs = Lists.newArrayList();
        configs.add(config);
        configs.add(config1);
        String s = JSON.toJSONString(configs);
        System.out.println(s);

    }
}
