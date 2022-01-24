package com.jinyi.train.dsl;


import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author liujin
 * @date 2022/1/18
 * @since JDK8
 */
public class JavaDSLcn {

    public static void main(String[] args) {
        请(显示).关于(100.0).的(平方根);
    }

    public static Consumer<String> 显示 = it -> System.out.println(it);
    public static Function<Double, Double> 平方根 = it -> Math.sqrt(it);

    public static ISqrt 请(Consumer<String> action) {
        return it -> what -> action.accept("Java: " + what.apply(it));
    }

}

@FunctionalInterface
interface IPrint {
    void 的(Function<Double, Double> what);
}

@FunctionalInterface
interface ISqrt {
    IPrint 关于(Double it);
}

