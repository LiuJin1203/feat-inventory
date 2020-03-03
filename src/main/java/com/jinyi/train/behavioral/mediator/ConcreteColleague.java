package com.jinyi.train.behavioral.mediator;

/**
 * @author liujin
 * @date 2019/11/13
 * @since JDK8
 */
public class ConcreteColleague extends Colleague {

  public ConcreteColleague(Mediator m) {
    super(m);
  }

  public void receive(String message) {
    System.out.println("Colleague Received: " + message);
  }
}
