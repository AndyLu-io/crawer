package DesignMode.Factory;

/**
 * @Author : qingxiao
 * @Description:
 * @Date : Created in 16:03  2017/11/7
 */
public class MailSender implements Sender{
    @Override
    public void sendMsg() {
        System.out.println("mail hello");
    }
}
