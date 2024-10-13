package ae.zerotone.gateway.core.bind;

import ae.zerotone.gateway.core.session.GatewaySession;
import java.lang.reflect.Method;
import java.util.Map;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @description 映射代理调用
 */
public class MapperProxy implements MethodInterceptor {

  private final String uri;
  private GatewaySession gatewaySession;

  public MapperProxy(GatewaySession gatewaySession, String uri) {
    this.gatewaySession = gatewaySession;
    this.uri = uri;
  }

  @Override
  public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy)
      throws Throwable {
    MapperMethod linkMethod = new MapperMethod(uri, method, gatewaySession.getConfiguration());
    // 暂时只获取第0个参数
    return linkMethod.execute(gatewaySession, (Map<String, Object>) args[0]);
  }
}
