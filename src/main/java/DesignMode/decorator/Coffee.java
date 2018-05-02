package DesignMode.decorator;

/**
 * @Author : qingxiao
 * @Description:
 * @Date : Created in 17:42  2018/5/2
 */
public class Coffee implements Drink{
    @Override
    public double cost() {
        return 10;
    }

    @Override
    public String desc() {
        return "一杯咖啡";
    }
}
