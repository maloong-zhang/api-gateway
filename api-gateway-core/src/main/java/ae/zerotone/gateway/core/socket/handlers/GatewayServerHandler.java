package ae.zerotone.gateway.core.socket.handlers;

import ae.zerotone.gateway.core.mapping.HttpStatement;
import ae.zerotone.gateway.core.session.Configuration;
import ae.zerotone.gateway.core.socket.BaseHandler;
import ae.zerotone.gateway.core.socket.agreement.AgreementConstants;
import ae.zerotone.gateway.core.socket.agreement.GatewayResultMessage;
import ae.zerotone.gateway.core.socket.agreement.RequestParser;
import ae.zerotone.gateway.core.socket.agreement.ResponseParser;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @description 会话服务处理器
 */
public class GatewayServerHandler extends BaseHandler<FullHttpRequest> {

  private final Logger logger = LoggerFactory.getLogger(GatewayServerHandler.class);

  private final Configuration configuration;

  public GatewayServerHandler(Configuration configuration) {
    this.configuration = configuration;
  }

  @Override
  protected void session(
      ChannelHandlerContext ctx, final Channel channel, FullHttpRequest request) {
    logger.info("网关接收请求【全局】 uri：{} method：{}", request.uri(), request.method());
    try {
      // 1. 解析参数
      RequestParser requestParser = new RequestParser(request);
      String uri = requestParser.getUri();

      // 2. 保存信息；HttpStatement、Header=token
      HttpStatement httpStatement = configuration.getHttpStatement(uri);
      channel.attr(AgreementConstants.HTTP_STATEMENT).set(httpStatement);

      // 3. 放行服务
      request.retain();
      ctx.fireChannelRead(request);
    } catch (Exception e) {
      // 4. 封装返回结果
      DefaultFullHttpResponse response =
          new ResponseParser()
              .parse(
                  GatewayResultMessage.buildError(
                      AgreementConstants.ResponseCode._500.getCode(),
                      "网关协议调用失败！" + e.getMessage()));
      channel.writeAndFlush(response);
    }
  }
}
