package ae.zerotone.gateway.core.datasource;

/**
 * @description 数据源接口，RPC、HTTP 都当做连接的数据资源使用
 */
public interface DataSource {

  Connection getConnection();
}
