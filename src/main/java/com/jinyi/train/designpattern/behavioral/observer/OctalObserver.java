package com.jinyi.train.designpattern.behavioral.observer;

/**
 * @author liujin
 * @date 2019/11/9
 * @since JDK8
 */
public class OctalObserver extends Observer{

  public OctalObserver(Subject subject){
    this.subject = subject;
    this.subject.attach(this);
  }

  @Override
  public void update() {
    System.out.println( "Octal String: "
        + Integer.toOctalString( subject.getState() ) );
  }
}