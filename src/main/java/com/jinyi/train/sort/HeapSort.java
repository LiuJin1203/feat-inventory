package com.jinyi.train.sort;

/**
 * @author liujin
 * @date 2021/1/3
 * @since JDK8
 */
public class HeapSort extends AbstractSortBase {
    private HeapSort() {
    }

    public static Sort getInstance() {
        return new HeapSort();
    }
    @Override
    public void sort(Comparable[] arr) {
        int N = arr.length;

        // heapify phase
        for (int k = N/2; k >= 1; k--)
            sink(arr, k, N);

        // sortdown phase
        int k = N;
        while (k > 1) {
            exchange(arr, 1, k--);
            sink(arr, 1, k);
        }
        show(arr);
    }


    /***************************************************************************
     * Helper functions to restore the heap invariant.
     ***************************************************************************/

    /**
     * 将小元素下沉，直到不小子节点或者不再有子节点
     * @param pq
     * @param k
     * @param n
     */
    private void sink(Comparable[] pq, int k, int n) {
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && less(pq,j,j+1)) j++;
            if (!less(pq,k,j)) break;
            exchange(pq, k, j);
            k = j;
        }
    }


    private boolean less(Comparable[] pq, int i, int j) {
        return pq[i-1].compareTo(pq[j-1]) < 0;
    }

    @Override
    public void exchange(Comparable[] arr, int i, int j) {
        Comparable swap = arr[i-1];
        arr[i-1] = arr[j-1];
        arr[j-1] = swap;
    }
}
