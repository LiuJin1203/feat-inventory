package com.jinyi.train.behavioral.chainofresponsibility;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liujin
 * @date 2019/11/9
 * @since JDK8
 */
public class Chain {

  private List<ChainHandler> handlers;
  private int index;
  public Chain(List<ChainHandler> handlers) {
    this.handlers = handlers;
  }

  public void proceed(){
    if (index>=handlers.size()) return;
    handlers.get(index++).execute(this);
  }
}
