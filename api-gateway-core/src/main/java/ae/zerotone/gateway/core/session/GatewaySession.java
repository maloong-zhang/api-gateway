package ae.zerotone.gateway.core.session;

import ae.zerotone.gateway.core.bind.IGenericReference;
import java.util.Map;

/**
 * @description 用户处理网关 HTTP 请求
 */
public interface GatewaySession {

  Object get(String methodName, Map<String, Object> params);

  Object post(String methodName, Map<String, Object> params);

  IGenericReference getMapper();

  Configuration getConfiguration();
}
