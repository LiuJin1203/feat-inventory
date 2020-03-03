package com.jinyi.train.designpattern.behavioral.observer;

/**
 * @author liujin
 * @date 2019/11/9
 * @since JDK8
 */
public class HexaObserver extends Observer{

  public HexaObserver(Subject subject){
    this.subject = subject;
    this.subject.attach(this);
  }

  @Override
  public void update() {
    System.out.println( "Hex String: "
        + Integer.toHexString( subject.getState() ).toUpperCase() );
  }
}
