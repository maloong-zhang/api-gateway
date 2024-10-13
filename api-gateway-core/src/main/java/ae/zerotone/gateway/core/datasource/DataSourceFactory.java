package ae.zerotone.gateway.core.datasource;

import ae.zerotone.gateway.core.session.Configuration;

/**
 * @description 数据源工厂
 */
public interface DataSourceFactory {

  void setProperties(Configuration configuration, String uri);

  DataSource getDataSource();
}
