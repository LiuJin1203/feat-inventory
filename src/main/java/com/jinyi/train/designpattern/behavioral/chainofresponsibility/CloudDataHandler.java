package com.jinyi.train.designpattern.behavioral.chainofresponsibility;

/**
 * @author liujin
 * @date 2019/11/9
 * @since JDK8
 */
public class CloudDataHandler implements RequestHandler {
  private RequestHandler requestHandler;
  @Override
  public void setNextRequestHandler(RequestHandler requestHandler) {
    this.requestHandler = requestHandler;
  }
  @Override
  public boolean process(RequestData requestData) {
    requestData.setMetaCloudData("Meta Data from Cloud is populated");
    return requestHandler == null ? true : requestHandler.process(requestData);
  }
}
