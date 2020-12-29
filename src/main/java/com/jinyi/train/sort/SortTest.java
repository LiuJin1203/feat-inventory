package com.jinyi.train.sort;

import com.jinyi.train.sort.util.CopyArrayUtil;
import com.jinyi.train.sort.util.DataGenerator;
import com.jinyi.train.sort.util.TimerCalc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * @author liujin
 * @date 2020/12/27
 * @since JDK8
 */
public class SortTest {
    private static final Logger log = LoggerFactory.getLogger(SortTest.class);
    private static final String splitLine = "------------------------------------";
    public static void main(String[] args) {
        int number = 300_000;
        Comparable[] arr = TimerCalc.calcExeTime(DataGenerator.fakeInteger, number);
        System.out.println(Arrays.toString(arr));
        System.out.println(arr.length);
        System.out.println(splitLine);

        // Arrays.sort
        TimerCalc.calcExeTime(consumer, CopyArrayUtil.copy(arr));

        //冒泡排序
//        TimerCalc.calcExeTime(BubbleSort.getInstance(1), CopyArrayUtil.copy(arr));
//        TimerCalc.calcExeTime(BubbleSort.getInstance(2), CopyArrayUtil.copy(arr));

        // 选择排序
//        TimerCalc.calcExeTime(SelectSort.getInstance(), CopyArrayUtil.copy(arr));

        // 插入排序
//        TimerCalc.calcExeTime(InsertSort.getInstance(1), CopyArrayUtil.copy(arr));
//        TimerCalc.calcExeTime(InsertSort.getInstance(2), CopyArrayUtil.copy(arr));

        // 快速排序
        TimerCalc.calcExeTime(QuickSort.getInstance(), CopyArrayUtil.copy(arr));

    }

    /**
     * 调试快排
     */
    private static void testQuick() {
        Comparable[] arr = {46, 38, 63, 10, 4, 63, 40, 33, 29};
        TimerCalc.calcExeTime(QuickSort.getInstance(), arr);
    }

    private static Consumer<Comparable[]> consumer = (data) -> {
        Arrays.sort(data);
    };

}
