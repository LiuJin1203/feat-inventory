package com.jinyi.train.behavioral.strategy.function;

/**
 * @author liujin
 * @date 2019/11/6
 * @since JDK8
 */
public class HighRollerMoneyMarketInterestCalculation implements InterestCalculationStrategy {
  @Override
  public double calculateInterest(double accountBalance) {
    return accountBalance < 100000.00 ? 0 : accountBalance * (0.075/12);
  }
}
