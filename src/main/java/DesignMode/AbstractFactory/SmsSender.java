package DesignMode.AbstractFactory;


/**
 * @Author : qingxiao
 * @Description:
 * @Date : Created in 16:02  2017/11/7
 */
public class SmsSender implements Sender{
    @Override
    public void sendMsg() {
        System.out.println("sms hello");
    }
}
