package com.jinyi.train.designpattern.behavioral.chainofresponsibility;

/**
 * @author liujin
 * @date 2019/11/9
 * @since JDK8
 */

public interface RequestHandler {
  void setNextRequestHandler(RequestHandler requestHandler);
  boolean process(RequestData requestData);
}
