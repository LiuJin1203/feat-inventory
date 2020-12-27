package com.jinyi.train.sort;

/**
 * @author liujin
 * @date 2020/12/27
 * @since JDK8
 */
@FunctionalInterface
public interface Sort {
    /**
     * 排序算法，被排序的数组实现了Comparable接口
     * @link Comparable
     * @param arr
     */
    void sort(Comparable[] arr);
}
