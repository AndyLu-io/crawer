package mode;

/**
 * @author qingxiao
 * @date 2018-12-19  10:00
 */
public class Item {
    private String hotLevel;

    private Long id;

    private Boolean isHiRateItem;

    private Integer itemPicMaskCode;

    private String name;

    private String pic;

    private Price price;

    public String getHotLevel() {
        return hotLevel;
    }

    public void setHotLevel(String hotLevel) {
        this.hotLevel = hotLevel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getHiRateItem() {
        return isHiRateItem;
    }

    public void setHiRateItem(Boolean hiRateItem) {
        isHiRateItem = hiRateItem;
    }

    public Integer getItemPicMaskCode() {
        return itemPicMaskCode;
    }

    public void setItemPicMaskCode(Integer itemPicMaskCode) {
        this.itemPicMaskCode = itemPicMaskCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }
}
