package spring.aop;

import java.lang.reflect.Proxy;

/**
 * @author qingxiao
 * @date 2019-01-21  20:54
 */
public class SimpleAOP {
    public static Object getProxy(Object bean, Advice advice) {
        Object proxyInstance = Proxy.newProxyInstance(SimpleAOP.class.getClassLoader(), bean.getClass().getInterfaces(), advice);
        return proxyInstance;
    }
}
