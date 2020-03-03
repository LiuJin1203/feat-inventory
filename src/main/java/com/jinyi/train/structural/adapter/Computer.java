package com.jinyi.train.structural.adapter;

/**
 * @author liujin
 * @date 2019/10/31
 * @since JDK8
 */
public interface Computer {
  String readUSB(USBInterface u);
  void writeUSB(USBInterface u ,String context);
}
