package DesignMode.decorator;

/**
 * @Author : qingxiao
 * @Description:
 * @Date : Created in 17:42  2018/5/2
 */
public class Suger extends Decorator{
    public Suger(Drink drink) {
        super(drink);
    }

    @Override
    public double cost() {
        return super.cost() + 1;
    }

    @Override
    public String desc() {
        return super.desc() + "糖";
    }
}
