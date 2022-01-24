package com.jinyi.train.dsl.inter;


import java.util.function.Function;

/**
 * @author liujin
 * @date 2022/1/18
 * @since JDK8
 */
@FunctionalInterface
public interface IPrint{
    ISqrt the(Function<Double,Double> what);
}
