package spring.aop;

/**
 * @author qingxiao
 * @date 2019-01-21  20:56
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public void sayHelloWorld() {
        System.out.println("hello world");
    }
}
