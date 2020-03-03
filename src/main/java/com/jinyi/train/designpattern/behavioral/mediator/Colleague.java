package com.jinyi.train.designpattern.behavioral.mediator;

/**
 * @author liujin
 * @date 2019/11/13
 * @since JDK8
 */

//Colleage interface
public abstract class Colleague {

  private Mediator mediator;

  public Colleague(Mediator m) {
    mediator = m;
  }

  //send a message via the mediator
  public void send(String message) {
    mediator.send(message, this);
  }

  //get access to the mediator
  public Mediator getMediator() {
    return mediator;
  }

  public abstract void receive(String message);
}
