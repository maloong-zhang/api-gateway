package ae.zerotone.gateway.center.application;


import java.util.Map;

/**
 * @description 消息服务
 */
public interface IMessageService {

    Map<String, String> queryRedisConfig();

    void pushMessage(String gatewayId, Object message);

}
