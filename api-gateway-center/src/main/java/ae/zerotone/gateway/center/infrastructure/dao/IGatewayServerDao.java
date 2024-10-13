package ae.zerotone.gateway.center.infrastructure.dao;

import ae.zerotone.gateway.center.infrastructure.common.OperationRequest;
import ae.zerotone.gateway.center.infrastructure.po.GatewayServer;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description
 */
@Mapper
public interface IGatewayServerDao {

  List<GatewayServer> queryGatewayServerList();

  List<GatewayServer> queryGatewayServerListByPage(OperationRequest<String> request);

  int queryGatewayServerListCountByPage(OperationRequest<String> request);
}
