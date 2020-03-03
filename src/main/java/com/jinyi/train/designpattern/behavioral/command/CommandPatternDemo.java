package com.jinyi.train.designpattern.behavioral.command;

/**
 * @author liujin
 * @date 2019/11/22
 * @since JDK8
 */
public class CommandPatternDemo {
  public static void main(String[] args) {
    Stock abcStock = new Stock();

    BuyStock buyStockOrder = new BuyStock(abcStock);
    SellStock sellStockOrder = new SellStock(abcStock);

    Broker broker = new Broker();
    broker.takeOrder(buyStockOrder);
    broker.takeOrder(sellStockOrder);

    broker.placeOrders();
  }
}
