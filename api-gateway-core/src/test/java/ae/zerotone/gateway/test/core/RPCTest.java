package ae.zerotone.gateway.test.core;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.bootstrap.DubboBootstrap;
import org.apache.dubbo.config.utils.ReferenceConfigCache;
import org.apache.dubbo.rpc.service.GenericService;
import org.junit.Test;

/** 泛化调用测试 官网案例：https://dubbo.apache.org/zh/docs/advanced/generic-reference/ */
public class RPCTest {

  @Test
  public void test_rpc() {

    ApplicationConfig application = new ApplicationConfig();
    application.setName("api-gateway-test");
    application.setQosEnable(false);

    RegistryConfig registry = new RegistryConfig();
    registry.setAddress("zookeeper://127.0.0.1:2181");
    registry.setRegister(false);

    ReferenceConfig<GenericService> reference = new ReferenceConfig<>();
    reference.setInterface("ae.zerotone.gateway.rpc.IActivityBooth");
    reference.setVersion("1.0.0");
    reference.setGeneric("true");

    DubboBootstrap bootstrap = DubboBootstrap.getInstance();
    bootstrap.application(application).registry(registry).reference(reference).start();

    ReferenceConfigCache cache = ReferenceConfigCache.getCache();
    GenericService genericService = cache.get(reference);

    Object result =
        genericService.$invoke("sayHi", new String[] {"java.lang.String"}, new Object[] {"world"});

    System.out.println(result);
  }
}
