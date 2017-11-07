package DesignMode.Factory;

/**
 * @Author : qingxiao
 * @Description:
 * @Date : Created in 16:04  2017/11/7
 */
public class FactoryModeTest {
    public static void main(String[] args) {
        SendFactoryMethod.ProduceMailSender().sendMsg();
        SendFactoryMethod.produceSmsSender().sendMsg();

        new SendFactory().produc("sms").sendMsg();
    }
}
