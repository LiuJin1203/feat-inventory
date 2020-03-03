package com.jinyi.train.structural.decorator;

/**
 * @author liujin
 * @date 2019/11/6
 * @since JDK8
 */
public class Circle implements Shape {
  @Override
  public void draw() {
    System.out.println("Drawing Circle");
  }
  @Override
  public void resize() {
    System.out.println("Resizing Circle");
  }
  @Override
  public String description() {
    return "Circle object";
  }
  @Override
  public boolean isHide() {
    return false;
  }
}
