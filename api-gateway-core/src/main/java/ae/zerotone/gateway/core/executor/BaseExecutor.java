package ae.zerotone.gateway.core.executor;

import ae.zerotone.gateway.core.datasource.Connection;
import ae.zerotone.gateway.core.executor.result.SessionResult;
import ae.zerotone.gateway.core.mapping.HttpStatement;
import ae.zerotone.gateway.core.session.Configuration;
import ae.zerotone.gateway.core.type.SimpleTypeRegistry;
import com.alibaba.fastjson.JSON;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @description 执行器抽象基类
 */
public abstract class BaseExecutor implements Executor {

  protected Configuration configuration;
  protected Connection connection;
  private Logger logger = LoggerFactory.getLogger(BaseExecutor.class);

  public BaseExecutor(Configuration configuration, Connection connection) {
    this.configuration = configuration;
    this.connection = connection;
  }

  @Override
  public SessionResult exec(HttpStatement httpStatement, Map<String, Object> params)
      throws Exception {
    // 参数处理；后续的一些参数校验也可以在这里封装。
    String methodName = httpStatement.getMethodName();
    String parameterType = httpStatement.getParameterType();
    String[] parameterTypes = new String[] {parameterType};
    Object[] args =
        SimpleTypeRegistry.isSimpleType(parameterType)
            ? params.values().toArray()
            : new Object[] {params};
    logger.info(
        "执行调用 method：{}#{}.{}({}) args：{}",
        httpStatement.getApplication(),
        httpStatement.getInterfaceName(),
        httpStatement.getMethodName(),
        JSON.toJSONString(parameterTypes),
        JSON.toJSONString(args));
    // 抽象方法
    try {
      Object data = doExec(methodName, parameterTypes, args);
      return SessionResult.buildSuccess(data);
    } catch (Exception e) {
      return SessionResult.buildError(e.getMessage());
    }
  }

  protected abstract Object doExec(String methodName, String[] parameterTypes, Object[] args);
}
