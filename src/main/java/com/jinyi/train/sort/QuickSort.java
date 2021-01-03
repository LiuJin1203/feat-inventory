package com.jinyi.train.sort;

/**
 * 快速排序
 * 带有哨兵模式的快速排序
 * 尽管比较次数比归并排序多39%，但是移动数据的次数更少，因此快速排序会更快一些
 * ***************************************
 * 比较次数：平均:2NlnN ~ 1.39NlgN；最坏:N²/2；
 * 交换次数：
 * 时间复杂度：O(NlogN)
 * 空间复杂度：O(logN)
 * ***************************************
 * @author liujin
 * @date 2020/12/27
 * @since JDK8
 */
public class QuickSort extends AbstractSortBase {
    public static QuickSort getInstance() {
        return new QuickSort();
    }

    @Override
    public void sort(Comparable[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        quickSort(arr, 0, N - 1);
        show(arr);
    }

    private void quickSort(Comparable[] arr, int left, int right) {

        if (right <= left) return;
        //只有两个值
        if (right - left == 1) {
            if (less(arr[right], arr[left])) {
                exchange(arr, left, right);
            }
            return;
        }
        //1.选取基准值
        Comparable pivot = median3(arr, left, right);
        int i = left;
        int j = right - 1;
        //2.partion分割操作，将小于基准值数放在基准值左侧，大于基准值数放在基准值右侧
        while (true) {
            while (less(arr[++i], pivot)) ;
            while (less(pivot, arr[--j])) ;
            if (i < j) {
                exchange(arr, i, j);
            } else {
                break;
            }
        }
        exchange(arr, i, right - 1);
        //3.左侧和右侧分别递归排序
        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }

    /**
     * 三元素中最小者被分在arr[left]，最大者被分在arr[right],这两个位置正是分割阶段应该放置的位置。
     * 将枢纽元放到arr[right-1]并在分各阶段将i,j初始化为left+1,right-2。
     * 因为arr[left]比枢纽元小，可以作为j的警戒标记，同理a[right-1]也是警戒标记。
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private Comparable median3(Comparable[] arr, int left, int right) {
        int center = (left + right) / 2;
        if (less(arr[center], arr[left])) {
            exchange(arr, left, center);
        }
        if (less(arr[right], arr[left])) {
            exchange(arr, left, right);
        }
        if (less(arr[right], arr[center])) {
            exchange(arr, right, center);
        }
        //将中值放在right-1位置上
        exchange(arr, center, right - 1);
        return arr[right - 1];
    }
}
