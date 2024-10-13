package ae.zerotone.gateway.core.bind;

import ae.zerotone.gateway.core.executor.result.SessionResult;
import java.util.Map;

/**
 * @description 统一泛化调用接口
 */
public interface IGenericReference {

  SessionResult $invoke(Map<String, Object> params);
}
