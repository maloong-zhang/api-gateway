package ae.zerotone.gateway.core.session.defaults;

import ae.zerotone.gateway.core.datasource.DataSource;
import ae.zerotone.gateway.core.datasource.DataSourceFactory;
import ae.zerotone.gateway.core.datasource.unpooled.UnpooledDataSourceFactory;
import ae.zerotone.gateway.core.executor.Executor;
import ae.zerotone.gateway.core.session.Configuration;
import ae.zerotone.gateway.core.session.GatewaySession;
import ae.zerotone.gateway.core.session.GatewaySessionFactory;

/**
 * @description 默认网关会话工厂
 */
public class DefaultGatewaySessionFactory implements GatewaySessionFactory {

  private final Configuration configuration;

  public DefaultGatewaySessionFactory(Configuration configuration) {
    this.configuration = configuration;
  }

  @Override
  public GatewaySession openSession(String uri) {
    // 获取数据源连接信息：这里把 Dubbo、HTTP 抽象为一种连接资源
    DataSourceFactory dataSourceFactory = new UnpooledDataSourceFactory();
    dataSourceFactory.setProperties(configuration, uri);
    DataSource dataSource = dataSourceFactory.getDataSource();
    // 创建执行器
    Executor executor = configuration.newExecutor(dataSource.getConnection());
    // 创建会话：DefaultGatewaySession
    return new DefaultGatewaySession(configuration, uri, executor);
  }

  public Configuration getConfiguration() {
    return configuration;
  }
}
