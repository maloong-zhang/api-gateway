package ae.zerotone.gateway.center.domain.operation.repository;

import ae.zerotone.gateway.center.domain.operation.model.vo.*;
import ae.zerotone.gateway.center.infrastructure.common.OperationRequest;
import java.util.List;

/**
 * @description 运营数据查询仓储服务
 */
public interface IDataOperationManageRepository {

  List<GatewayServerDataVO> queryGatewayServerListByPage(OperationRequest<String> request);

  int queryGatewayServerListCountByPage(OperationRequest<String> request);

  List<ApplicationSystemDataVO> queryApplicationSystemListByPage(
      OperationRequest<ApplicationSystemDataVO> request);

  int queryApplicationSystemListCountByPage(OperationRequest<ApplicationSystemDataVO> request);

  List<ApplicationInterfaceDataVO> queryApplicationInterfaceListByPage(
      OperationRequest<ApplicationInterfaceDataVO> request);

  int queryApplicationInterfaceListCountByPage(
      OperationRequest<ApplicationInterfaceDataVO> request);

  List<ApplicationInterfaceMethodDataVO> queryApplicationInterfaceMethodListByPage(
      OperationRequest<ApplicationInterfaceMethodDataVO> request);

  int queryApplicationInterfaceMethodListCountByPage(
      OperationRequest<ApplicationInterfaceMethodDataVO> request);

  List<GatewayServerDetailDataVO> queryGatewayServerDetailListByPage(
      OperationRequest<GatewayServerDetailDataVO> request);

  int queryGatewayServerDetailListCountByPage(OperationRequest<GatewayServerDetailDataVO> request);

  List<GatewayDistributionDataVO> queryGatewayDistributionListByPage(
      OperationRequest<GatewayDistributionDataVO> request);

  int queryGatewayDistributionListCountByPage(OperationRequest<GatewayDistributionDataVO> request);
}
