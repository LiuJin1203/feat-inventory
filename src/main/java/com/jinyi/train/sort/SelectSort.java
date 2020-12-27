package com.jinyi.train.sort;

import java.util.Arrays;

/**
 * 选择排序
 * （不断选择剩余元素之中的最小值）
 * 首先，找到数组中最小的那个元素，其次，将它和数组的第一个元素交换位置，
 * 再次，将剩下的元素中找到最小的元素，将它与数组的第二个元素交换位置，
 * 如此往复，直到将整个数组排序。
 * ***************************************
 * 比较次数：N²/2
 * 交换次数：N
 * 时间复杂度：O(N²)
 * 空间复杂度：O(1)
 * ***************************************
 * @author liujin
 * @date 2020/12/27
 * @since JDK8
 */
public class SelectSort extends AbstractSortBase {
    public static Sort getInstance(){
        return new SelectSort();
    }
    @Override
    public void sort(Comparable[] arr) {
        if(arr==null||arr.length<2){
            return;
        }
        int N = arr.length;
        int min;
        for (int i = 0; i < N-1; i++) {
            min = i;
            for (int j = i+1; j < N; j++) {
                if(less(arr[j],arr[min])){min = j;}
            }
            exchage(arr,i,min);
        }
        show(arr);
    }
}
