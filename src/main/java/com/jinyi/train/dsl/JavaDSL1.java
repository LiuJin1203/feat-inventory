package com.jinyi.train.dsl;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author liujin
 * @date 2022/1/18
 * @since JDK8
 */
public class JavaDSL1 {
    public static void main(String[] args) {
       please(show).get("the").apply(square_root).get("of").accept(100.0);
    }

    public static  Consumer<String> show = it -> System.out.println(it);
    public static Function<Double,Double> square_root = it -> Math.sqrt(it);

    public static Map<String,Function<Function<Double,Double>,Map<String,Consumer<Double>>>> please(Consumer<String> action){
        Map<String,Function<Function<Double,Double>,Map<String,Consumer<Double>>>> map = new HashMap<>();
        Function< Function<Double,Double>,Map<String,Consumer<Double>> > whatFun3 =   what -> {
           Map<String,Consumer<Double>> map1 = new HashMap<>();
           map1.put("of",it -> action.accept("Java: "+what.apply(it)));
           return map1;
        };
        map.put("the",whatFun3);
        return map;
    }

}
