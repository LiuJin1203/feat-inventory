package com.jinyi.train.designpattern.structural.decorator;

/**
 * @author liujin
 * @date 2019/11/6
 * @since JDK8
 */
public class Rectangle implements Shape {
  @Override
  public void draw() {
    System.out.println("Drawing Rectangle");
  }
  @Override
  public void resize() {
    System.out.println("Resizing Rectangle");
  }
  @Override
  public String description() {
    return "Rectangle object";
  }
  @Override
  public boolean isHide() {
    return false;
  }
}
