package com.jinyi.train.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 通过交换两个相邻的元素
 * ********************************
 * 时间复杂度: O(N²)
 * 空间复杂度: O(1)
 * ********************************
 *
 * @author liujin
 * @date 2020/12/27
 * @since JDK8
 */
public class BubbleSort extends AbstractSortBase {
    @Override
    public void sort(Comparable[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1 - i; j++) {
                if (less(arr[j + 1], arr[j])) {
                    exchage(arr, j + 1, j);
                }
            }
        }
        show(arr);
    }
}
