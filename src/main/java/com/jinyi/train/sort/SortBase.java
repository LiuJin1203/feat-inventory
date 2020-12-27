package com.jinyi.train.sort;

/**
 * 排序基础接口，规范了排序行为
 * @author liujin
 * @date 2020/12/27
 * @since JDK8
 */
public interface SortBase extends Sort{

    /**
     * 比较入参的大小
     * 当v.compareTo(w)<0 返回true，即第一个入参小于第二个入参
     * @param v
     * @param w
     * @return
     */
    boolean less(Comparable v,Comparable w);

    /**
     * 交换数组中下标i和j的元素
     * @param arr
     * @param i
     * @param j
     */
    void exchage(Comparable[] arr, int i, int j);

    /**
     * 用于判断数组是否是已排序的
     * @param arr
     * @return 如果已排序返回true，没有排好序返回false
     */
    boolean isSorted(Comparable[] arr);

}
