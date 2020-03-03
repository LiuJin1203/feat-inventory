package com.jinyi.train.behavioral.chainofresponsibility;

import java.util.Arrays;
import java.util.List;

/**
 * @author liujin
 * @date 2019/11/9
 * @since JDK8
 */
public class ChainTest {

  static class ChainHandlerA extends ChainHandler{
    @Override
    void handlerProcess() {
      System.out.println(this.getClass().getSimpleName()+" process");
    }
  }
  static class ChainHandlerB extends ChainHandler{
    @Override
    void handlerProcess() {
      System.out.println(this.getClass().getSimpleName()+" process");
    }
  }
  static class ChainHandlerC extends ChainHandler{
    @Override
    void handlerProcess() {
      System.out.println(this.getClass().getSimpleName()+" process");
    }
  }

  public static void main(String[] args) {
    List<ChainHandler> handlers = Arrays.asList(
        new ChainHandlerA(),
        new ChainHandlerB(),
        new ChainHandlerC()
    );
    Chain chain = new Chain(handlers);
    chain.proceed();
  }
}
