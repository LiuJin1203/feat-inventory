package com.jinyi.train.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liujin
 * @date 2019/11/9
 * @since JDK8
 */
public class Subject {

  private List<Observer> observers
      = new ArrayList<Observer>();
  private int state;

  public int getState() {
    return state;
  }

  public void setState(int state) {
    this.state = state;
    notifyAllObservers();
  }

  public void attach(Observer observer){
    observers.add(observer);
  }

  public void notifyAllObservers(){
    for (Observer observer : observers) {
      observer.update();
    }
  }
}
