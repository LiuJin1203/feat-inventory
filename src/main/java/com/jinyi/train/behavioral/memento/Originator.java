package com.jinyi.train.behavioral.memento;

/**
 * @author liujin
 * @date 2019/11/13
 * @since JDK8
 */
public class Originator {
  private String state;

  public void setState(String state){
    this.state = state;
  }

  public String getState(){
    return state;
  }

  public Memento saveStateToMemento(){
    return new Memento(state);
  }

  public void getStateFromMemento(Memento Memento){
    state = Memento.getState();
  }
}
