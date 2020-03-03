package com.jinyi.train.behavioral.observer;

/**
 * @author liujin
 * @date 2019/11/9
 * @since JDK8
 */
public class BinaryObserver extends Observer{

  public BinaryObserver(Subject subject){
    this.subject = subject;
    this.subject.attach(this);
  }

  @Override
  public void update() {
    System.out.println( "Binary String: "
        + Integer.toBinaryString( subject.getState() ) );
  }
}
