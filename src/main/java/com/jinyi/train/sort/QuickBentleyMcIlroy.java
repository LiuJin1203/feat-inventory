package com.jinyi.train.sort;

/**
 * https://algs4.cs.princeton.edu/23quicksort/QuickBentleyMcIlroy.java.html
 * @author liujin
 * @date 2021/1/3
 * @since JDK8
 */
public class QuickBentleyMcIlroy extends AbstractSortBase {



    // cutoff to insertion sort, must be >= 1
    private static final int INSERTION_SORT_CUTOFF = 8;

    // cutoff to median-of-3 partitioning
    private static final int MEDIAN_OF_3_CUTOFF = 40;

    // This class should not be instantiated.
    private QuickBentleyMcIlroy() { }
    public static QuickBentleyMcIlroy getInstance() {
        return new QuickBentleyMcIlroy();
    }
    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    public void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
        show(a);
    }

    private void sort(Comparable[] a, int lo, int hi) {
        int n = hi - lo + 1;

        // cutoff to insertion sort
        if (n <= INSERTION_SORT_CUTOFF) {
            insertionSort(a, lo, hi);
            return;
        }

        // use median-of-3 as partitioning element
        else if (n <= MEDIAN_OF_3_CUTOFF) {
            int m = median3(a, lo, lo + n/2, hi);
            exchange(a, m, lo);
        }

        // use Tukey ninther as partitioning element
        else  {
            int eps = n/8;
            int mid = lo + n/2;
            int m1 = median3(a, lo, lo + eps, lo + eps + eps);
            int m2 = median3(a, mid - eps, mid, mid + eps);
            int m3 = median3(a, hi - eps - eps, hi - eps, hi);
            int ninther = median3(a, m1, m2, m3);
            exchange(a, ninther, lo);
        }

        // Bentley-McIlroy 3-way partitioning
        int i = lo, j = hi+1;
        int p = lo, q = hi+1;
        Comparable v = a[lo];
        while (true) {
            while (less(a[++i], v))
                if (i == hi) break;
            while (less(v, a[--j]))
                if (j == lo) break;

            // pointers cross
            if (i == j && eq(a[i], v))
                exchange(a, ++p, i);
            if (i >= j) break;

            exchange(a, i, j);
            if (eq(a[i], v)) exchange(a, ++p, i);
            if (eq(a[j], v)) exchange(a, --q, j);
        }


        i = j + 1;
        for (int k = lo; k <= p; k++)
            exchange(a, k, j--);
        for (int k = hi; k >= q; k--)
            exchange(a, k, i++);

        sort(a, lo, j);
        sort(a, i, hi);
    }

    private boolean eq(Comparable a, Comparable b) {
        return a.compareTo(b)==0 ;
    }

    private int median3(Comparable[] arr, int left, int center, int right) {
        if (less(arr[center], arr[left])) {
            exchange(arr, left, center);
        }
        if (less(arr[right], arr[left])) {
            exchange(arr, left, right);
        }
        if (less(arr[right], arr[center])) {
            exchange(arr, right, center);
        }
        return center;
    }


    // sort from a[lo] to a[hi] using insertion sort
    private void insertionSort(Comparable[] a, int lo, int hi) {
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > lo && less(a[j], a[j-1]); j--)
                exchange(a, j, j-1);
    }


}
