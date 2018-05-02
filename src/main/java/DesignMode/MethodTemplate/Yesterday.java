package DesignMode.MethodTemplate;

/**
 * @Author : qingxiao
 * @Description:
 * @Date : Created in 16:41  2018/5/2
 */
public class Yesterday extends AbstractWorkTemplate{
    @Override
    public void eatBreakFast() {
        System.out.println("面包");
    }

    @Override
    public void goToSubway() {
        System.out.println("自行车");
    }
}
