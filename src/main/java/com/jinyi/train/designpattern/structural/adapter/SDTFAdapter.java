package com.jinyi.train.designpattern.structural.adapter;

/**
 * @author liujin
 * @date 2019/10/31
 * @since JDK8
 */
public class SDTFAdapter implements USBInterface {
  private SDCard sdCard = null;
  private TFCard tfCard = null;

  public SDTFAdapter(SDCard sdCard) {
    this.sdCard = sdCard;
  }

  public SDTFAdapter(TFCard tfCard) {
    this.tfCard = tfCard;
  }

  @Override
  public String read() {
    if(sdCard==null) return tfCard.readTF();
    else return sdCard.readSD();
  }

  @Override
  public void write(String context) {
    if(sdCard==null) tfCard.writeTF(context);
    else sdCard.writeSD(context);
  }
}
