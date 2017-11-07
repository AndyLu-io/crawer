package DesignMode.Factory;

import org.apache.commons.lang3.StringUtils;

/**
 * @Author : qingxiao
 * @Description:
 * @Date : Created in 16:09  2017/11/7
 */
public class SendFactory {
    public Sender produc(String type) {
        if (StringUtils.equals("sms", type)) {
            return new SmsSender();
        } else if (StringUtils.equals("mail", type)) {
            return new MailSender();
        } else {
            return null;
        }
    }
}
