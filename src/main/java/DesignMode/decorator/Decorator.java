package DesignMode.decorator;

/**
 * @Author : qingxiao
 * @Description:
 * @Date : Created in 17:44  2018/5/2
 */
public class Decorator implements Drink {
    private Drink drink;

    public Decorator(Drink drink) {
        this.drink = drink;
    }

    @Override
    public double cost() {
        return drink.cost();
    }

    @Override
    public String desc() {
        return drink.desc();
    }
}
