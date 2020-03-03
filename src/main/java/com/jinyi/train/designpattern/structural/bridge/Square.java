package com.jinyi.train.designpattern.structural.bridge;

/**
 * @author liujin
 * @date 2019/10/31
 * @since JDK8
 */
public class Square extends Shape {

  @Override
  public String draw() {
    return color.paint(this);
  }
}
