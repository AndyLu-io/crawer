package DesignMode.decorator;

/**
 * @Author : qingxiao
 * @Description:
 * @Date : Created in 17:41  2018/5/2
 */
public class App {
    public static void main(String[] args) {
        Drink coffee = new Coffee();
        System.out.println(coffee.cost() + ":" + coffee.desc());
        coffee = new Milk(coffee);
        System.out.println(coffee.cost() + ":" + coffee.desc());
        coffee  =new Suger(coffee);
        System.out.println(coffee.cost() + ":" + coffee.desc());
        coffee  =new Suger(coffee);
        System.out.println(coffee.cost() + ":" + coffee.desc());
    }
}
