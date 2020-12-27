package com.jinyi.train.sort;

import com.jinyi.train.sort.util.CopyArrayUtil;
import com.jinyi.train.sort.util.DataGenerator;
import com.jinyi.train.sort.util.TimerCalc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * @author liujin
 * @date 2020/12/27
 * @since JDK8
 */
public class SortTest {
    private static final Logger log = LoggerFactory.getLogger(SortTest.class);

    public static void main(String[] args) {
        int number = 5000;
        Comparable<Integer>[] arr = TimerCalc.calcExeTime(DataGenerator.fake, number);
        System.out.println(Arrays.toString(arr));
        System.out.println(arr.length);
        System.out.println("------------------------------------");


        //冒泡排序
        Sort bubbleSort = new BubbleSort();
        TimerCalc.calcExeTime(bubbleSort, CopyArrayUtil.copy(arr));
        Sort bubbleSort1 = new BubbleSortOne();
        TimerCalc.calcExeTime(bubbleSort1,CopyArrayUtil.copy(arr));

        // 选择排序
        Sort selectSort = new SelectSort();
        TimerCalc.calcExeTime(selectSort,CopyArrayUtil.copy(arr));

        // 插入排序
        Sort insertSort = new InsertSort(1);
        TimerCalc.calcExeTime(insertSort,CopyArrayUtil.copy(arr));

        Sort insertSort2 = new InsertSort(2);
        TimerCalc.calcExeTime(insertSort2,CopyArrayUtil.copy(arr));
    }
}
