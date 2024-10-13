package ae.zerotone.gateway.center.infrastructure.dao;

import ae.zerotone.gateway.center.domain.manage.model.vo.GatewayDistributionVO;
import ae.zerotone.gateway.center.domain.operation.model.vo.GatewayDistributionDataVO;
import ae.zerotone.gateway.center.infrastructure.common.OperationRequest;
import ae.zerotone.gateway.center.infrastructure.po.GatewayDistribution;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description 网关分配
 */
@Mapper
public interface IGatewayDistributionDao {

  List<String> queryGatewayDistributionSystemIdList(String gatewayId);

  String queryGatewayDistribution(String systemId);

  List<GatewayDistribution> queryGatewayDistributionList();

  List<GatewayDistribution> queryGatewayDistributionListByPage(
      OperationRequest<GatewayDistributionDataVO> request);

  int queryGatewayDistributionListCountByPage(OperationRequest<GatewayDistributionDataVO> request);

  void insert(GatewayDistributionVO gatewayDistribution);
}
