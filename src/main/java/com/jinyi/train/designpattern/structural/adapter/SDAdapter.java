package com.jinyi.train.designpattern.structural.adapter;

/**
 * @author liujin
 * @date 2019/10/31
 * @since JDK8
 */
public class SDAdapter implements USBInterface {

  private SDCard sdCard;

  public SDAdapter(SDCard sdCard) {
    this.sdCard = sdCard;
  }

  @Override
  public String read() {
    return this.sdCard.readSD();
  }

  @Override
  public void write(String context) {
    this.sdCard.writeSD(context);
  }
}
