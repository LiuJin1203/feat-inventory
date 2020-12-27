package com.jinyi.train.sort;

import java.util.Arrays;

/**
 * @author liujin
 * @date 2020/12/27
 * @since JDK8
 */
public class InsertSort extends AbstractSortBase {
    int method = 1;
    public InsertSort() {
    }

    public InsertSort(int method) {
        this.method = method;
    }

    @Override
    public void sort(Comparable[] arr) {
        if(arr==null||arr.length<2){
            return;
        }
        switch (method){
            case 2:method2(arr);break;
            default:method1(arr);
        }
        show(arr);
    }

    private void method1(Comparable[] arr) {
        int N = arr.length;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if(less(arr[i],arr[j])){
                    exchage(arr,i,j);
                }
            }
        }
    }
    private void method2(Comparable[] arr) {
        int N = arr.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j >0; j--) {
                if(less(arr[j],arr[j-1])){
                    exchage(arr,j,j-1);
                }
            }
        }
    }

}
