package com.jinyi.train.sort;

/**
 * @author liujin
 * @date 2020/12/31
 * @since JDK8
 */
public class ShellSort extends AbstractSortBase {
    int method = 1;

    public static ShellSort getInstance() {
        return new ShellSort();
    }

    public static ShellSort getInstance(int method) {
        return new ShellSort(method);
    }

    public ShellSort() {
    }

    public ShellSort(int method) {
        this.method = method;
    }

    @Override
    public void sort(Comparable[] arr) {
        if(arr==null||arr.length<2){
            return;
        }
        switch (method){
//            case 1:method1(arr);break;
            default:method1(arr);
        }
        show(arr);
    }

    /**
     * book
     *
     * @param arr
     */
    private void method1(Comparable[] arr) {
        int N = arr.length;
        for (int gap = N / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < N; i++) {
                for (int j = i; j >= gap && less(arr[j], arr[j - gap]); j -= gap) {
                    exchange(arr, j, j - gap);
                }
            }
        }
    }



}
