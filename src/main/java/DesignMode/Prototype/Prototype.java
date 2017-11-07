package DesignMode.Prototype;

import java.io.Serializable;

/**
 * @Author : qingxiao
 * @Description:
 * @Date : Created in 16:34  2017/11/7
 */
public class Prototype implements Cloneable, Serializable {

    /**
     * 浅拷贝
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        Prototype prototype = (Prototype) super.clone();
        return prototype;
    }

    /**
     * 深拷贝
     * @return
     */
    public Object deepClone() {
        return null;
    }

}
