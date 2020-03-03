package com.jinyi.train.behavioral.chainofresponsibility;

/**
 * @author liujin
 * @date 2019/11/9
 * @since JDK8
 */
public class FileDataHandler implements RequestHandler {
  private RequestHandler requestHandler;
  @Override
  public void setNextRequestHandler(RequestHandler requestHandler) {
    this.requestHandler = requestHandler;
  }
  @Override
  public boolean process(RequestData requestData) {
    requestData.setMetaFileData("Meta Data from File is populated");
    return requestHandler == null ? true : requestHandler.process(requestData);
  }
}
