package DesignMode.decorator;

/**
 * @Author : qingxiao
 * @Description:
 * @Date : Created in 17:41  2018/5/2
 */
public class Milk extends Decorator{

    public Milk(Drink drink) {
        super(drink);
    }

    @Override
    public double cost() {
        return super.cost() + 2;
    }

    @Override
    public String desc() {
        return super.desc() + "牛奶";
    }
}
