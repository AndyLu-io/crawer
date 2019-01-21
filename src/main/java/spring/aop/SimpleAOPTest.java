package spring.aop;

import org.junit.Test;

/**
 * @author qingxiao
 * @date 2019-01-21  20:57
 */
public class SimpleAOPTest {
    @Test
    public void getProxy() throws Exception {
        // 1. 创建一个 MethodInvocation 实现类
        MethodInvocation logTask = () -> System.out.println("log task start");

        HelloService helloServiceImpl = new HelloServiceImpl();

        // 2. 创建一个 Advice
        Advice beforeAdvice = new BeforeAdvice(helloServiceImpl, logTask);

        // 3. 为目标对象生成代理
        HelloService helloServiceProxy = (HelloService) SimpleAOP.getProxy(helloServiceImpl, beforeAdvice);

        helloServiceProxy.sayHelloWorld();
    }
}
