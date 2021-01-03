package com.jinyi.train.sort;

import java.util.Arrays;

/**
 * 插入排序
 * 基于前面的数据已经是有序的，后面的数据依次插入到已排序数据中正确的位置上，
 * 直到最后一个元素插入到正确的位置上，排序完成。
 * ***************************************
 * 比较次数：平均:N²/4；最坏:N²/2；最好:N-1;
 * 交换次数：平均:N²/4；最坏:N²/2；最好:0;
 * 时间复杂度：O(N²)
 * 空间复杂度：O(1)
 * ***************************************
 *
 * @author liujin
 * @date 2020/12/27
 * @since JDK8
 */
public class InsertSort extends AbstractSortBase {
    int method = 2;

    public InsertSort() {
    }

    public InsertSort(int method) {
        this.method = method;
    }

    public static Sort getInstance() {
        return new InsertSort();
    }

    public static Sort getInstance(int method) {
        return new InsertSort(method);
    }

    @Override
    public void sort(Comparable[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        switch (method) {
            case 1:
                method1(arr);
                break;
            default:
                method2(arr);
        }
        show(arr);
    }

    /**
     * doBySelf
     *
     * @param arr
     */
    private void method1(Comparable[] arr) {
        int N = arr.length;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (less(arr[i], arr[j]))
                    exchange(arr, i, j);

            }
        }
    }

    /**
     * book
     *
     * @param arr
     */
    private void method2(Comparable[] arr) {
        int N = arr.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(arr[j], arr[j - 1]); j--) {
                exchange(arr, j, j - 1);
            }
        }
    }

}
