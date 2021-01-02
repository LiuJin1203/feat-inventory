package com.jinyi.train.sort;

/**
 * 归并排序（自顶向下归并）
 *
 * ***************************************
 * 比较次数：½Nlog₂N ~ Nlog₂N;
 * 交换次数：平均:N²/4；最坏:N²/2；最好:0;
 * 时间复杂度：O(NlogN)
 * 空间复杂度：O(N)
 * ***************************************
 * @author liujin
 * @date 2021/1/2
 * @since JDK8
 */
public class MergeSort extends AbstractSortBase{
    private final int CUTOFF = 15;
    public MergeSort() {
    }

    public static Sort getInstance() {
        return new MergeSort();
    }

    @Override
    public void sort(Comparable[] arr) {
        int N = arr.length;
        Comparable[] aux = new Comparable[N];
        sort(arr,aux,0,N-1);
        show(arr);
    }

    // mergesort a[lo..hi] using auxiliary array aux[lo..hi]
    private void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo) return;
//        if (hi <= lo + CUTOFF) {
//            insertionSort(a, lo, hi);
//            return;
//        }
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }
    // stably merge a[lo .. mid] with a[mid+1 ..hi] using aux[lo .. hi]
    private void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        // precondition: a[lo .. mid] and a[mid+1 .. hi] are sorted subarrays
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid+1, hi);

        // copy to aux[]
        System.arraycopy(a, lo, aux, lo, hi - lo + 1);
        // merge back to a[]
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)              a[k] = aux[j++];
            else if (j > hi)               a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else                           a[k] = aux[i++];
        }

        // postcondition: a[lo .. hi] is sorted
//        assert isSorted(a, lo, hi);
    }

    // sort from a[lo] to a[hi] using insertion sort
    private void insertionSort(Comparable[] a, int lo, int hi) {
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > lo && less(a[j], a[j-1]); j--)
                exchage(a, j, j-1);
    }

}
