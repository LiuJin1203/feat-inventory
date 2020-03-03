package com.jinyi.train.behavioral.strategy.function;

/**
 * @author liujin
 * @date 2019/11/6
 * @since JDK8
 */
public  class SavingsAccountInterestCalculation implements InterestCalculationStrategy {
  @Override
  public double calculateInterest(double accountBalance) {
    return accountBalance * (0.04 / 12);
  }
}
