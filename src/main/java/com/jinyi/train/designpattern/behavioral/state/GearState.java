package com.jinyi.train.designpattern.behavioral.state;

/**
 * @author liujin
 * @date 2019/11/6
 * @since JDK8
 */
public abstract class GearState {

  Bike bike;

  public GearState(Bike bike) {
    this.bike = bike;
  }

  public abstract void gearUp();
  public abstract void gearDown();
}
