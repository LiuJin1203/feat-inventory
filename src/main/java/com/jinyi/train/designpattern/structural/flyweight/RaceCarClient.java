package com.jinyi.train.designpattern.structural.flyweight;

/**
 * @author liujin
 * @date 2019/11/6
 * @since JDK8
 */
public class RaceCarClient {
  private RaceCar raceCar;
  public RaceCarClient(String name) {
    /*Ask factory for a RaceCar*/
    raceCar = CarFactory.getRaceCar(name);
  }
  /**
   * The extrinsic state of the flyweight is maintained by the client
   */
  private int currentX = 0;
  private int currentY=0;
  public void moveCar(int newX, int newY){
    /*Car movement is handled by the flyweight object*/
    raceCar.moveCar(currentX, currentY, newX, newY);
    currentX = newX;
    currentY = newY;
  }
}
