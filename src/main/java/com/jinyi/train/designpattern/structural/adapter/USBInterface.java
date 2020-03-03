package com.jinyi.train.designpattern.structural.adapter;

/**
 * @author liujin
 * @date 2019/10/31
 * @since JDK8
 */
public interface USBInterface {
  String read();
  void write(String context);
}
