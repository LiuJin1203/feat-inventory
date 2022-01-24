package com.jinyi.train.dsl;

import com.jinyi.train.dsl.inter.IPrint;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author liujin
 * @date 2022/1/18
 * @since JDK8
 */
public class JavaDSL2 {

    public static void main(String[] args) {
        please(show).the(square_root).of(100.0);
    }

    public static Consumer<String> show = it -> System.out.println(it);
    public static Function<Double, Double> square_root = it -> Math.sqrt(it);

    public static IPrint please(Consumer<String> action) {
        return what -> it -> action.accept("Java: " + what.apply(it));
    }

}

