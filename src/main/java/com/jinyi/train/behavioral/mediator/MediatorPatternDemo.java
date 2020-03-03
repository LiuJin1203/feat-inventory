package com.jinyi.train.behavioral.mediator;

/**
 * @author liujin
 * @date 2019/11/13
 * @since JDK8
 */
public class MediatorPatternDemo {


  public static void main(String[] args) {
    ApplicationMediator mediator = new ApplicationMediator();
    Colleague desktop = new ConcreteColleague(mediator);
    Colleague mobile = new MobileColleague(mediator);
    mediator.addColleague(desktop);
    mediator.addColleague(mobile);
    desktop.send("Hello World");
    mobile.send("Hello");
  }
}
