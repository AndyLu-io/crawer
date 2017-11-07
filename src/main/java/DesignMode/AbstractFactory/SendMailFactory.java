package DesignMode.AbstractFactory;

/**
 * @Author : qingxiao
 * @Description:
 * @Date : Created in 16:19  2017/11/7
 */
public class SendMailFactory implements Provider{
    @Override
    public Sender produce() {
        return new MailSender();
    }
}
