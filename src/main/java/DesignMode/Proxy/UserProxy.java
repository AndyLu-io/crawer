package DesignMode.Proxy;

/**
 * @author qingxiao
 * @date 2019-01-21  21:53
 */
public class UserProxy implements BuyCar {
    private User user;

    public UserProxy(User user) {
        this.user = user;
    }

    @Override
    public void buyCar() {
        System.out.println("你有神马需求，请说");
        user.buyCar();
    }

}
