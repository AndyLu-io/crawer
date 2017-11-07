package DesignMode.Factory;

/**
 * @Author : qingxiao
 * @Description:
 * @Date : Created in 16:07  2017/11/7
 */
public class SendFactoryMethod {
    public static Sender produceSmsSender() {
        return new SmsSender();
    }

    public static Sender ProduceMailSender() {
        return new MailSender();
    }
}
