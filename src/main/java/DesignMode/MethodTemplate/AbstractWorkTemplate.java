package DesignMode.MethodTemplate;

/**
 * @Author : qingxiao
 * @Description:
 * @Date : Created in 16:38  2018/5/2
 */
public abstract class AbstractWorkTemplate {
    public void goToCompany() {
        eatBreakFast();
        goToSubway();
    }

    protected abstract void eatBreakFast();

    protected abstract void goToSubway();


}
