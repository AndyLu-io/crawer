package DesignMode.Proxy;

/**
 * @author qingxiao
 * @date 2019-01-21  21:43
 */
public class ProxyTest {

    public static void main(String[] args) {
        User user = new User();
        BuyCar userProxy = new UserProxy(user);
        userProxy.buyCar();
    }
}
