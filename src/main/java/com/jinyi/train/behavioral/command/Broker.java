package com.jinyi.train.behavioral.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liujin
 * @date 2019/11/22
 * @since JDK8
 */
public class Broker {
  private List<Order> orderList = new ArrayList<Order>();

  public void takeOrder(Order order){
    orderList.add(order);
  }

  public void placeOrders(){
    for (Order order : orderList) {
      order.execute();
    }
    orderList.clear();
  }
}
