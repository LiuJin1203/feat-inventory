package com.jinyi.train.behavioral.command;

/**
 * @author liujin
 * @date 2019/11/22
 * @since JDK8
 */
public class SellStock implements Order {
  private Stock abcStock;

  public SellStock(Stock abcStock){
    this.abcStock = abcStock;
  }

  public void execute() {
    abcStock.sell();
  }
}
