package DesignMode.AbstractFactory;

/**
 * @Author : qingxiao
 * @Description:
 * @Date : Created in 16:22  2017/11/7
 */
public class AbstractFactoryTest {
    public static void main(String[] args) {
        Provider provider = new SendSmsFactory();
        Sender smsSender = provider.produce();
        smsSender.sendMsg();
    }
}
