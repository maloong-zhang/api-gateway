package ae.zerotone.gateway.core.bind;

import ae.zerotone.gateway.core.mapping.HttpStatement;
import ae.zerotone.gateway.core.session.Configuration;
import ae.zerotone.gateway.core.session.GatewaySession;
import java.util.HashMap;
import java.util.Map;

/**
 * @description 泛化调用注册器
 */
public class MapperRegistry {

  private final Configuration configuration;
  // 泛化调用静态代理工厂
  private final Map<String, MapperProxyFactory> knownMappers = new HashMap<>();

  public MapperRegistry(Configuration configuration) {
    this.configuration = configuration;
  }

  public IGenericReference getMapper(String uri, GatewaySession gatewaySession) {
    final MapperProxyFactory mapperProxyFactory = knownMappers.get(uri);
    if (mapperProxyFactory == null) {
      throw new RuntimeException("Uri " + uri + " is not known to the MapperRegistry.");
    }
    try {
      return mapperProxyFactory.newInstance(gatewaySession);
    } catch (Exception e) {
      throw new RuntimeException("Error getting mapper instance. Cause: " + e, e);
    }
  }

  public void addMapper(HttpStatement httpStatement) {
    String uri = httpStatement.getUri();
    // 如果重复注册则报错
    if (hasMapper(uri)) {
      throw new RuntimeException("Uri " + uri + " is already known to the MapperRegistry.");
    }
    knownMappers.put(uri, new MapperProxyFactory(uri));
    // 保存接口映射信息
    configuration.addHttpStatement(httpStatement);
  }

  public <T> boolean hasMapper(String uri) {
    return knownMappers.containsKey(uri);
  }
}
