package com.jinyi.train.sort.util;

import com.jinyi.train.sort.Sort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * 函数执行计时器
 * @author liujin
 * @date 2020/12/27
 * @since JDK8
 */
public class TimerCalc {
    private static final Logger log = LoggerFactory.getLogger(TimerCalc.class);
    public static <T> void calcExeTime(Consumer<T> consumer,T data){
        long start = System.currentTimeMillis();
        consumer.accept(data);
        long end = System.currentTimeMillis();
        log.info("{} exe cost time: {}ms",consumer.getClass().getSimpleName(),(end-start));

    }
    public static <T,R> R calcExeTime(Function<T,R> function,T data){
        long start = System.currentTimeMillis();
        R res = function.apply(data);
        long end = System.currentTimeMillis();
        log.info("{} exe cost time: {}ms",function.getClass().getSimpleName(), (end-start));
        return res;
    }

    public static void calcExeTime(Sort sort, Comparable[] data) {
        long start = System.currentTimeMillis();
        sort.sort(data);
        long end = System.currentTimeMillis();
        log.info("{} exe cost time: {}ms",sort.getClass().getSimpleName(),(end-start));

    }
}
