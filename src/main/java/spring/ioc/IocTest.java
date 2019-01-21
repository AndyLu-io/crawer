package spring.ioc;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author qingxiao
 * @date 2019-01-21  20:37
 */
public class IocTest {

    @Test
    public void getBean() throws Exception {
        String location = SimpleIoc.class.getClassLoader().getResource("ioc.xml").getFile();
        SimpleIoc simpleIoc = new SimpleIoc(location);
        Wheel wheel = (Wheel) simpleIoc.getBean("wheel");
        System.out.println(wheel);
        Car car = (Car) simpleIoc.getBean("car");
        System.out.println(car);
    }

    @Test
    public void springGetBean() throws Exception {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("ioc.xml");
        Car car = (Car) classPathXmlApplicationContext.getBean("car");
        System.out.println(car);
    }


}
