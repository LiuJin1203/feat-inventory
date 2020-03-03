package com.jinyi.train.behavioral.chainofresponsibility;

/**
 * @author liujin
 * @date 2019/11/9
 * @since JDK8
 */
public abstract class ChainHandler {

  void execute(Chain chain){
    handlerProcess();
    chain.proceed();
  }
  abstract void handlerProcess();
}
