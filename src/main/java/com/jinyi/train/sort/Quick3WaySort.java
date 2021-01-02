package com.jinyi.train.sort;

/**
 * 三向切分快排
 *
 * @author liujin
 * @date 2020/12/29
 * @since JDK8
 */
public class Quick3WaySort extends AbstractSortBase {
    public static Quick3WaySort getInstance() {
        return new Quick3WaySort();
    }

    @Override
    public void sort(Comparable[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        quickSort3Way(arr, 0, N - 1);
        show(arr);
    }

    /**
     *
     *   left part    center part              right part
     * +-------------------------------------------------+
     * |  < pivot  |   == pivot   |     ?    |  > pivot  |
     * +-------------------------------------------------+
     *              ^              ^        ^
     *              |              |        |
     *             less            k      great
     *
     * Invariants:
     *   all in (left, less)   < pivot
     *   all in [less, k)     == pivot
     *   all in (great, right) > pivot
     *
     * @param arr
     * @param lo
     * @param hi
     */
    private void quickSort3Way(Comparable[] arr, int lo, int hi) {
        if(hi<=lo)return;
        int lt = lo, i=lo+1,gt=hi;
        Comparable v = arr[lo];
//        Comparable v = median3(arr,lo,hi);
        while (i<=gt){
            int cmp = arr[i].compareTo(v);
            if(cmp<0)exchage(arr,lt++,i++);
            else if(cmp>0)exchage(arr,i,gt--);
            else i++;
        }
        quickSort3Way(arr,lo,lt-1);
        quickSort3Way(arr,gt+1,hi);
    }

    private Comparable median3(Comparable[] arr, int left, int right) {
        int center = (left + right) / 2;
        if (less(arr[center], arr[left])) {
            exchage(arr, left, center);
        }
        if (less(arr[right], arr[left])) {
            exchage(arr, left, right);
        }
        if (less(arr[right], arr[center])) {
            exchage(arr, right, center);
        }
        //将中值放在最左侧位置上
        exchage(arr, center, left);
        return arr[left];
    }

}
