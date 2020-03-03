package com.jinyi.train.behavioral.state;

/**
 * @author liujin
 * @date 2019/11/6
 * @since JDK8
 */
public class FirstGear extends GearState {


  public FirstGear(Bike bike) {
    super(bike);
  }

  @Override
  public void gearUp() {
    System.out.println("Moving Up from FirstGear to SecondGear");
    bike.setGearState(new SecondGear(bike));
  }

  @Override
  public void gearDown() {
    System.out.println("Already in the FirstGear - cannot go lower");
  }
}
