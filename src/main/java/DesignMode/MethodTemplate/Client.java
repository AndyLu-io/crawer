package DesignMode.MethodTemplate;

/**
 * @Author : qingxiao
 * @Description:
 * @Date : Created in 16:42  2018/5/2
 */
public class Client {
    public static void main(String[] args) {
        Today today = new Today();
        today.goToCompany();
        Yesterday yesterday = new Yesterday();
        yesterday.goToCompany();
    }
}
