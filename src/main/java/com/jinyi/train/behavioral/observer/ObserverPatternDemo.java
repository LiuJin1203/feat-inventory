package com.jinyi.train.behavioral.observer;

/**
 * @author liujin
 * @date 2019/11/9
 * @since JDK8
 */
public class ObserverPatternDemo {
  public static void main(String[] args) {
    Subject subject = new Subject();

    new HexaObserver(subject);
    new OctalObserver(subject);
    new BinaryObserver(subject);

    System.out.println("First state change: 15");
    subject.setState(15);
    System.out.println("Second state change: 10");
    subject.setState(10);
    System.out.println("Second state change: 91");
    subject.setState(91);
  }
}
