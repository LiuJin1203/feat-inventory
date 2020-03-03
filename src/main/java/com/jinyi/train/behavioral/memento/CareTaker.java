package com.jinyi.train.behavioral.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liujin
 * @date 2019/11/13
 * @since JDK8
 */
public class CareTaker {
  private List<Memento> mementoList = new ArrayList<Memento>();

  public void add(Memento state){
    mementoList.add(state);
  }

  public Memento get(int index){
    return mementoList.get(index);
  }
}
