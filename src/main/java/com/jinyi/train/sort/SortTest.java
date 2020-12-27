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
        Comparable[] arr = TimerCalc.calcExeTime(DataGenerator.fakeInteger, number);
        System.out.println(Arrays.toString(arr));
        System.out.println(arr.length);
        System.out.println("------------------------------------");

        //冒泡排序
        TimerCalc.calcExeTime(BubbleSort.getInstance(1),CopyArrayUtil.copy(arr));
        TimerCalc.calcExeTime(BubbleSort.getInstance(2),CopyArrayUtil.copy(arr));

        // 选择排序
        TimerCalc.calcExeTime(SelectSort.getInstance(),CopyArrayUtil.copy(arr));

        // 插入排序
        TimerCalc.calcExeTime(InsertSort.getInstance(1),CopyArrayUtil.copy(arr));
        TimerCalc.calcExeTime(InsertSort.getInstance(2),CopyArrayUtil.copy(arr));

    }
}
