package com.jinyi.train.behavioral.state;

/**
 * <link>https://dzone.com/articles/state-pattern-simplified</link>
 *
 * @author liujin
 * @date 2019/11/6
 * @since JDK8
 */
public class Bike {

  private GearState gearState;

  public Bike() {
    gearState = new FirstGear(this);
  }

  public void gearUp() {
    gearState.gearUp();
  }

  public void gearDown() {
    gearState.gearDown();
  }

  /**
   * 获取
   *
   * @return gearState
   */
  public GearState getGearState() {
    return this.gearState;
  }

  /**
   * 设置
   */
  public void setGearState(GearState gearState) {
    this.gearState = gearState;
  }
}
