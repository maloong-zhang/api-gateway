package ae.zerotone.gateway.center.infrastructure.dao;

import ae.zerotone.gateway.center.domain.operation.model.vo.GatewayServerDetailDataVO;
import ae.zerotone.gateway.center.infrastructure.common.OperationRequest;
import ae.zerotone.gateway.center.infrastructure.po.GatewayServerDetail;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description
 */
@Mapper
public interface IGatewayServerDetailDao {

  void insert(GatewayServerDetail gatewayServerDetail);

  GatewayServerDetail queryGatewayServerDetail(GatewayServerDetail gatewayServerDetail);

  boolean updateGatewayStatus(GatewayServerDetail gatewayServerDetail);

  List<GatewayServerDetail> queryGatewayServerDetailList();

  List<GatewayServerDetail> queryGatewayServerDetailListByPage(
      OperationRequest<GatewayServerDetailDataVO> request);

  int queryGatewayServerDetailListCountByPage(OperationRequest<GatewayServerDetailDataVO> request);
}
