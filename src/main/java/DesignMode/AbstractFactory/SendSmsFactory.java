package DesignMode.AbstractFactory;

/**
 * @Author : qingxiao
 * @Description:
 * @Date : Created in 16:22  2017/11/7
 */
public class SendSmsFactory implements Provider{
    @Override
    public Sender produce() {
        return new SmsSender();
    }
}
