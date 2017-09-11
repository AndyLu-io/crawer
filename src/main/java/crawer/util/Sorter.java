package crawer.util;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public interface Sorter {

    /**
     * 排序
     * @param list 待排序的数组
     */
    public <T extends Comparable<T>> void sort(T[] list);

    /**
     *
     * @param list 待排序的数组
     * @param comp 比较两个对象的比较器
     * @param <T>
     */
    public <T> void sort(T[] list, Comparator<T> comp);



}
