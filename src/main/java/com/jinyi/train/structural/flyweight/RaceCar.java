package com.jinyi.train.structural.flyweight;

/**
 * @author liujin
 * @date 2019/11/6
 * @since JDK8
 */
public abstract class RaceCar {
  /*Intrinsic state  stored and shared in the Flyweight object*/
  String name;
  int speed;
  int horsePower;
  /* Extrinsic state is stored or computed by client objects, and passed to the Flyweight.*/
  abstract void moveCar(int currentX, int currentY, int newX ,int newY);
}
