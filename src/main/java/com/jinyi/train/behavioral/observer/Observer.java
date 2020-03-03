package com.jinyi.train.behavioral.observer;

/**
 * @author liujin
 * @date 2019/11/9
 * @since JDK8
 */
public abstract class Observer {
  protected Subject subject;
  public abstract void update();
}
