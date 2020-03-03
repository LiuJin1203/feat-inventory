package com.jinyi.train.designpattern.behavioral.memento;

/**
 * @author liujin
 * @date 2019/11/13
 * @since JDK8
 */
public class Memento {
  private String state;

  public Memento(String state){
    this.state = state;
  }

  public String getState(){
    return state;
  }
}
