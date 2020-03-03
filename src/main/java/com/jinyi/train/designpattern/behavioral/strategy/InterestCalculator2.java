package com.jinyi.train.designpattern.behavioral.strategy;

import com.jinyi.train.designpattern.behavioral.strategy.function.CurrentAccountInterestCalculation;
import com.jinyi.train.designpattern.behavioral.strategy.function.HighRollerMoneyMarketInterestCalculation;
import com.jinyi.train.designpattern.behavioral.strategy.function.InterestCalculationStrategy;
import com.jinyi.train.designpattern.behavioral.strategy.function.MoneyMarketInterestCalculation;
import com.jinyi.train.designpattern.behavioral.strategy.function.SavingsAccountInterestCalculation;

/**
 * @author liujin
 * @date 2019/11/6
 * @since JDK8
 */
public class InterestCalculator2 {
  //Strategies for calculating interest.
  //Strategies for calculating interest.
  private final InterestCalculationStrategy currentAccountInterestCalculationStrategy = new CurrentAccountInterestCalculation();
  private final InterestCalculationStrategy savingsAccountInterestCalculationStrategy = new SavingsAccountInterestCalculation();
  private final InterestCalculationStrategy moneyMarketAccountInterestCalculationStrategy = new MoneyMarketInterestCalculation();
  private final InterestCalculationStrategy highRollerMoneyMarketAccountInterestCalculationStrategy = new HighRollerMoneyMarketInterestCalculation();
  public double calculateInterest(AccountTypes accountType, double accountBalance) {
    switch (accountType) {
      case CURRENT: return currentAccountInterestCalculationStrategy.calculateInterest(accountBalance);
      case SAVINGS: return savingsAccountInterestCalculationStrategy.calculateInterest(accountBalance);
      case STANDARD_MONEY_MARKET: return moneyMarketAccountInterestCalculationStrategy.calculateInterest(accountBalance);
      case HIGH_ROLLER_MONEY_MARKET: return highRollerMoneyMarketAccountInterestCalculationStrategy.calculateInterest(accountBalance);
      default:
        return 0;
    }
  }
}
