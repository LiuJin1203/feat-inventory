package com.jinyi.train.designpattern.behavioral.mediator;

/**
 * @author liujin
 * @date 2019/11/13
 * @since JDK8
 */

public class MobileColleague extends Colleague {

  public MobileColleague(Mediator m) {
    super(m);
  }

  public void receive(String message) {
    System.out.println("Mobile Received: " + message);
  }
}
