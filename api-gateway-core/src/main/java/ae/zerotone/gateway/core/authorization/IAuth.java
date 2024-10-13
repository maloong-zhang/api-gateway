package ae.zerotone.gateway.core.authorization;

import io.jsonwebtoken.Claims;

import java.util.Map;

/**
 * @description 认证服务接口
 */
public interface IAuth {

  boolean validate(String id, String token);
}
