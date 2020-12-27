package com.jinyi.train.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author liujin
 * @date 2020/12/27
 * @since JDK8
 */
public class BubbleSortOne extends AbstractSortBase {
    @Override
    public void sort(Comparable[] arr) {
        if(arr==null||arr.length<2){
            return;
        }
        int N = arr.length;
        for (int i = 0; i < N-1; i++) {
            for (int j = i+1; j < N; j++) {
                if(less(arr[j],arr[i])){
                    exchage(arr,i,j);
                }
            }
        }
        show(arr);
    }
}
