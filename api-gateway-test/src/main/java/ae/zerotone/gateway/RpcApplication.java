package ae.zerotone.gateway;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Configurable
@EnableDubbo
public class RpcApplication {

  public static void main(String[] args) {
    SpringApplication.run(RpcApplication.class, args);
  }
}
