package com.jinyi.train.behavioral.strategy;

import com.jinyi.train.behavioral.strategy.function.InterestCalculationStrategy;

/**
 * @author liujin
 * @date 2019/11/6
 * @since JDK8
 */
public class InterestCalculatorFinal {

  private final InterestCalculationStrategyFactory interestCalculationStrategyFactory = new InterestCalculationStrategyFactory();
  public double calculateInterest(AccountTypes accountType, double accountBalance) {
    InterestCalculationStrategy interestCalculationStrategy = interestCalculationStrategyFactory.getInterestCalculationStrategy(accountType);
    return interestCalculationStrategy.calculateInterest(accountBalance);
  }
}
