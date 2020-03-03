package com.jinyi.train.structural.adapter;

/**
 * @author liujin
 * @date 2019/10/31
 * @since JDK8
 */
public class USBDisk implements USBInterface {
  private String type = this.getClass().getSimpleName();
  private String diskContext = type;

  private String getDiskContext() {
    return diskContext;
  }

  private void setDiskContext(String diskContext) {
    this.diskContext = diskContext;
  }

  @Override
  public String read() {
    return getDiskContext();
  }

  @Override
  public void write(String context) {
    setDiskContext(type+"::"+context);
  }
}
