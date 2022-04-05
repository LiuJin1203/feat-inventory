package com.jinyi.train.sort;

import com.jinyi.train.sort.util.DataGenerator;

import java.util.Arrays;

/**
 * 非标准题目,一种猜想解决思路
 * @author liujin
 * @date 2022/2/10
 * @since JDK8
 */
public class TopK {

    public static void main(String[] args) {
        int row = 30;
        int col = 20;
        int K = 10;
        Comparable[][] arr = DataGenerator.fakeIntegerArr.apply(row, col);
        Comparable[] top = findTopK(arr, K);
        show(top);
    }

    private static Comparable[] findTopK(Comparable[][] arr, int k) {
        Comparable[] top = new Comparable[k];
        initTopArr(top, arr);
        show(top);
        getTopK(top, arr);
        return top;
    }

    private static void getTopK(Comparable[] top, Comparable[][] arr) {
        int row = arr.length;
        for (int i = 0; i < row; i++) {
            changeTopK(top, arr[i]);
        }
    }

    private static void changeTopK(Comparable[] top, Comparable[] arr) {
        int len = arr.length;
        int nums = top.length;
        //如果数组最大值比目标数组最小值还小，即不做任何修改
        if (less(arr[len - 1], top[0])) return;
        //从最大的开始依次插入top数组，只比较最多nums个最大数即可
        for (int i = len - 1; i > len - nums - 1; i--) {
            if (less(arr[i], top[0])) break;
            //替换最小值后再排序，有限个数排序
            top[0] = arr[i];
            Arrays.sort(top);
        }

    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) <= 0;
    }

    private static void initTopArr(Comparable[] top, Comparable[][] arr) {
        int k = top.length;
        for (int i = 0; i < k; i++) {
            top[i] = arr[0][i];
        }
        Arrays.sort(top);
    }


    public static void show(Comparable[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}
