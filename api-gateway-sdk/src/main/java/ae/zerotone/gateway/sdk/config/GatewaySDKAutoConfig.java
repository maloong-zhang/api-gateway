package ae.zerotone.gateway.sdk.config;

import ae.zerotone.gateway.sdk.application.GatewaySDKApplication;
import ae.zerotone.gateway.sdk.domain.service.GatewayCenterService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description 网关SDK配置服务
 */
@Configuration
@EnableConfigurationProperties(GatewaySDKServiceProperties.class)
@ConditionalOnProperty(
    prefix = "api-gateway-sdk",
    name = "enabled",
    havingValue = "true",
    matchIfMissing = true)
public class GatewaySDKAutoConfig {

  @Bean
  public GatewayCenterService gatewayCenterService() {
    return new GatewayCenterService();
  }

  @Bean
  public GatewaySDKApplication gatewaySDKApplication(
      GatewaySDKServiceProperties properties, GatewayCenterService gatewayCenterService) {
    return new GatewaySDKApplication(properties, gatewayCenterService);
  }
}
