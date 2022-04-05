package com.jinyi.train.sort.util;

import java.util.Arrays;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * 伪随机数生成器
 * @author liujin
 * @date 2020/12/27
 * @since JDK8
 */
public class DataGenerator {
    private static Random rand = new Random();

    public static Function<Integer,Comparable[]> fakeInteger = (number)->{
        Integer[] arr = new Integer[number];
        for (int i = 0; i < number; i++) {
            arr[i] =  rand.nextInt(number*10)+1;
        }
        return arr;
    };
    /**
     * 二维数组的生成器函数
     */
    public static BiFunction<Integer,Integer,Comparable[][]> fakeIntegerArr = (row,col)->{
        Integer[][] arr = new Integer[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] =  rand.nextInt(row*col*10)+1;

            }
            Arrays.sort(arr[i]);
        }
        return arr;
    };

    public static Function<Integer,Comparable[]> fakeDouble = (number)->{
        Double[] arr = new Double[number];
        for (int i = 0; i < number; i++) {
            arr[i] =  rand.nextDouble()*10*number+1;
        }
        return arr;
    };
}
