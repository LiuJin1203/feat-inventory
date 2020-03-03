package com.jinyi.train.designpattern.structural.adapter;

/**
 * @author liujin
 * @date 2019/10/31
 * @since JDK8
 */
public class AdapterClient {

  public static void main(String[] args) {
    String context = "Hello World.";
    Computer computer = new HpComputer();
    USBInterface u = new USBDisk();
    computer.writeUSB(u,context);
    String c = computer.readUSB(u);
    System.out.println(c);

    System.out.println("=======operator SDcard==========");
    USBInterface sd = new SDAdapter(new SDCard());
    computer.writeUSB(sd,context);
    String c1 = computer.readUSB(sd);
    System.out.println(c1);

    System.out.println("=======operator TFcard==========");
    USBInterface tf = new TFAdapter(new TFCard());
    computer.writeUSB(tf,context);
    String c2 = computer.readUSB(tf);
    System.out.println(c2);

    System.out.println("=======operator SDTFAdapter.==========");
    USBInterface sdtf1 = new SDTFAdapter(new TFCard());
    USBInterface sdtf2 = new SDTFAdapter(new SDCard());
    computer.writeUSB(sdtf1,context);
    String con1 =computer.readUSB(sdtf1);
    System.out.println(con1);
    computer.writeUSB(sdtf2,context);
    String con2 =computer.readUSB(sdtf2);
    System.out.println(con2);

  }

}
