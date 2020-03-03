package com.jinyi.train.designpattern.structural.decorator;

/**
 * @author liujin
 * @date 2019/11/6
 * @since JDK8
 */
public interface Shape {
  void draw();
  void resize();
  String description();
  boolean isHide();
}
