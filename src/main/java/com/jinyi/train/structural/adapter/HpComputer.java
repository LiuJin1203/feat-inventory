package com.jinyi.train.structural.adapter;

/**
 * @author liujin
 * @date 2019/10/31
 * @since JDK8
 */
public class HpComputer implements Computer {

  @Override
  public String readUSB(USBInterface u) {
    return u.read();
  }

  @Override
  public void writeUSB(USBInterface u, String context) {
    u.write(context);
  }
}
