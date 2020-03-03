package com.jinyi.train.designpattern.behavioral.strategy.function;

/**
 * @author liujin
 * @date 2019/11/6
 * @since JDK8
 */
public  class MoneyMarketInterestCalculation implements InterestCalculationStrategy {
  @Override
  public double calculateInterest(double accountBalance) {
    return accountBalance * (0.06/12);
  }
}
