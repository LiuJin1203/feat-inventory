package com.jinyi.train.behavioral.strategy;

/**
 * https://dzone.com/articles/design-patterns-the-strategy-and-factory-patterns
 * @author liujin
 * @date 2019/11/6
 * @since JDK8
 */
public class StrategyDemo {

  public static void main(String[] args) {
    InterestCalculatorFinal calculator = new InterestCalculatorFinal();
    double r = calculator.calculateInterest(AccountTypes.CURRENT,123_456D);
    System.out.println(r);
  }
}
