package com.jinyi.train.designpattern.structural.flyweight;

/**
 * @author liujin
 * @date 2019/11/6
 * @since JDK8
 */
public class FlyweightSprintCar extends RaceCar{
  /*Track number of flyweight instantiation*/
  public static int num;
  public FlyweightSprintCar()
  {
    num++;
  }
  /*This method accepts car location (extrinsic). No reference to current
   *or new location is maintained inside the flyweight implementation*/
  @Override
  public void moveCar(int currentX, int currentY, int newX ,int newY)
  {
    System.out.println("New location of "+this.name+" is X"+newX + " - Y"+newY);
  }
}
