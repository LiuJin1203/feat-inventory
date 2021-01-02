package com.jinyi.train.sort;

import java.util.Arrays;

/**
 * @author liujin
 * @date 2020/12/27
 * @since JDK8
 */
public abstract class AbstractSortBase implements SortBase {

    @Override
    public boolean less(Comparable v, Comparable w) {
        return v.compareTo(w)<0;
    }

    @Override
    public void exchage(Comparable[] arr, int i, int j) {
        Comparable t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    @Override
    public boolean isSorted(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if(less(arr[i],arr[i-1]))return false;
        }
        return true;
    }
    public boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }
    public void show(Comparable[] arr){
        System.out.println(Arrays.toString(arr));
    }
}
