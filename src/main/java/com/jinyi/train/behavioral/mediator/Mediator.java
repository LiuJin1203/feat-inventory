package com.jinyi.train.behavioral.mediator;

/**
 * @author liujin
 * @date 2019/11/13
 * @since JDK8
 */

public interface Mediator {
  public void send(String message, Colleague colleague);
}
