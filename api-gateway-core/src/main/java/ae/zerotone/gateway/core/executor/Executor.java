package ae.zerotone.gateway.core.executor;

import ae.zerotone.gateway.core.executor.result.SessionResult;
import ae.zerotone.gateway.core.mapping.HttpStatement;
import java.util.Map;

/**
 * @description 执行器
 */
public interface Executor {

  SessionResult exec(HttpStatement httpStatement, Map<String, Object> params) throws Exception;
}
