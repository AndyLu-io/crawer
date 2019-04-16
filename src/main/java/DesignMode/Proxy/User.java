package DesignMode.Proxy;

/**
 * @author qingxiao
 * @date 2019-01-21  21:52
 */
public class User implements BuyCar {

    @Override
    public void buyCar() {
        System.out.println("我要买车");
    }
}
