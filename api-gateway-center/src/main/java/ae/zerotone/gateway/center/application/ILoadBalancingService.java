package ae.zerotone.gateway.center.application;

import ae.zerotone.gateway.center.domain.docker.model.aggregates.NginxConfig;

/**
 * @description 负载均衡配置服务
 */
public interface ILoadBalancingService {

  void updateNginxConfig(NginxConfig nginxConfig) throws Exception;
}
