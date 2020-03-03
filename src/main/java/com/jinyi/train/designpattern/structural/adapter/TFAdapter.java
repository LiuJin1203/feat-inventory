package com.jinyi.train.designpattern.structural.adapter;

/**
 * @author liujin
 * @date 2019/10/31
 * @since JDK8
 */
public class TFAdapter implements USBInterface {
  private TFCard tfCard;

  public TFAdapter(TFCard tfCard) {
    this.tfCard = tfCard;
  }

  @Override
  public String read() {
    return tfCard.readTF();
  }

  @Override
  public void write(String context) {
    tfCard.writeTF(context);
  }
}
