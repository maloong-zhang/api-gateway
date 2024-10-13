package ae.zerotone.gateway.core.datasource.unpooled;

import ae.zerotone.gateway.core.datasource.DataSource;
import ae.zerotone.gateway.core.datasource.DataSourceFactory;
import ae.zerotone.gateway.core.datasource.DataSourceType;
import ae.zerotone.gateway.core.session.Configuration;

/**
 * @description
 */
public class UnpooledDataSourceFactory implements DataSourceFactory {

  protected UnpooledDataSource dataSource;

  public UnpooledDataSourceFactory() {
    this.dataSource = new UnpooledDataSource();
  }

  @Override
  public void setProperties(Configuration configuration, String uri) {
    this.dataSource.setConfiguration(configuration);
    this.dataSource.setDataSourceType(DataSourceType.Dubbo);
    this.dataSource.setHttpStatement(configuration.getHttpStatement(uri));
  }

  @Override
  public DataSource getDataSource() {
    return dataSource;
  }
}
