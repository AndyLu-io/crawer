package mode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qingxiao
 * @date 2018-12-19  10:04
 */
public class ModeTest {

    public static void main(String[] args) {
        Price price = new Price();

        price.setType("num");
        price.setValue("3.00-43.11");
        Model model = new Model();
        Item item = new Item();
        item.setPrice(price);
        item.setId(1L);
        item.setHotLevel("");
        item.setItemPicMaskCode(0);
        item.setHiRateItem(false);
        item.setName("ERP99");
        item.setPic("http://img.hicdn.cn/item/201808/08211534113892.jpeg");
        List<Item> itemList = new ArrayList<>();
        itemList.add(item);
        model.setItemList(itemList);
        model.setTitle("每日必抢");
        model.setSubTitle("每日10点 抢到赚到");
        model.setPageUrl("https://mall.hipac.cn/ytms/page/meiribiqiang.html");
        model.setMoreInfo("更多");
        List<Model> models = new ArrayList<>();
        models.add(model);
        String s = JSON.toJSONString(models);
        System.out.println(s);
    }
}
