package com.jinyi.train.sort;

import com.jinyi.train.designpattern.creational.singleton.InnerClassSingleton;

import java.util.Random;
import java.util.function.Function;

/**
 * 伪随机数生成器
 * @author liujin
 * @date 2020/12/27
 * @since JDK8
 */
public class DataGenerator {
    private static Random rand = new Random();

    public static Function<Integer,Comparable[]> fake = (number)->{
        Integer[] arr = new Integer[number];
        for (int i = 0; i < number; i++) {
            arr[i] =  rand.nextInt(number*10)+1;
        }
        return arr;
    };
}
