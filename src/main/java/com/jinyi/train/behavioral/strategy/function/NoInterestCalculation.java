package com.jinyi.train.behavioral.strategy.function;

/**
 * @author liujin
 * @date 2019/11/6
 * @since JDK8
 */
public class NoInterestCalculation implements InterestCalculationStrategy {

  @Override
  public double calculateInterest(double accountBalance) {
    return 0;
  }
}
