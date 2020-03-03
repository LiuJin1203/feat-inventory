package com.jinyi.train.designpattern.behavioral.state;

/**
 * @author liujin
 * @date 2019/11/6
 * @since JDK8
 */
public class ThirdGear extends GearState {

  public ThirdGear(Bike bike) {
    super(bike);
  }

  @Override
  public void gearUp() {
    System.out.println("Already in the ThirdGear - cannot go higher");
  }
  @Override
  public void gearDown() {
    System.out.println("Moving Down from ThirdGear to SecondGear");
    bike.setGearState(new SecondGear(bike));
  }
}
