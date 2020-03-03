package com.jinyi.train.behavioral.state;

/**
 * @author liujin
 * @date 2019/11/6
 * @since JDK8
 */
public class StateDemo {
  public static void main(String[] args) {
    Bike bike = new Bike();
    bike.gearDown();
    bike.gearUp();
    bike.gearUp();
    bike.gearUp();
    bike.gearUp();
    bike.gearDown();
    bike.gearDown();
    bike.gearDown();
  }
}
