package com.jinyi.train.designpattern.behavioral.state;

/**
 * @author liujin
 * @date 2019/11/6
 * @since JDK8
 */
public class SecondGear extends GearState {

  public SecondGear(Bike bike) {
    super(bike);
  }

  @Override
  public void gearUp() {
    System.out.println("Moving Up  from SecondGear to ThirdGear");
    bike.setGearState(new ThirdGear(bike));
  }

  @Override
  public void gearDown() {
    System.out.println("Moving Down from SecondGear to FirstGear");
    bike.setGearState(new FirstGear(bike));
  }
}
