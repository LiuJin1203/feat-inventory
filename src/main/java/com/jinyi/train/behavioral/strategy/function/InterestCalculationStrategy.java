package com.jinyi.train.behavioral.strategy.function;

/**
 * @author liujin
 * @date 2019/11/6
 * @since JDK8
 */
public interface InterestCalculationStrategy {
  double calculateInterest(double accountBalance);  //Note the absence of an access modifier - interface methods are implicitly public.

}
