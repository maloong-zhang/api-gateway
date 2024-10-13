package ae.zerotone.gateway.core.bind;

import ae.zerotone.gateway.core.mapping.HttpCommandType;
import ae.zerotone.gateway.core.session.Configuration;
import ae.zerotone.gateway.core.session.GatewaySession;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @description 绑定调用方法
 */
public class MapperMethod {

  private final HttpCommandType command;
  private String methodName;

  public MapperMethod(String uri, Method method, Configuration configuration) {
    this.methodName = configuration.getHttpStatement(uri).getMethodName();
    this.command = configuration.getHttpStatement(uri).getHttpCommandType();
  }

  public Object execute(GatewaySession session, Map<String, Object> params) {
    Object result = null;
    switch (command) {
      case GET:
        result = session.get(methodName, params);
        break;
      case POST:
        result = session.post(methodName, params);
        break;
      case PUT:
        break;
      case DELETE:
        break;
      default:
        throw new RuntimeException("Unknown execution method for: " + command);
    }
    return result;
  }
}
