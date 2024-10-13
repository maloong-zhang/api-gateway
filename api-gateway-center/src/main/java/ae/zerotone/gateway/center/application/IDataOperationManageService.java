package ae.zerotone.gateway.center.application;

import ae.zerotone.gateway.center.domain.operation.model.vo.*;
import ae.zerotone.gateway.center.infrastructure.common.OperationRequest;
import ae.zerotone.gateway.center.infrastructure.common.OperationResult;

/**
 * @description 网关运营数据管理
 */
public interface IDataOperationManageService {

  OperationResult<GatewayServerDataVO> queryGatewayServer(OperationRequest<String> request);

  OperationResult<ApplicationSystemDataVO> queryApplicationSystem(
      OperationRequest<ApplicationSystemDataVO> request);

  OperationResult<ApplicationInterfaceDataVO> queryApplicationInterface(
      OperationRequest<ApplicationInterfaceDataVO> request);

  OperationResult<ApplicationInterfaceMethodDataVO> queryApplicationInterfaceMethod(
      OperationRequest<ApplicationInterfaceMethodDataVO> request);

  OperationResult<GatewayServerDetailDataVO> queryGatewayServerDetail(
      OperationRequest<GatewayServerDetailDataVO> request);

  OperationResult<GatewayDistributionDataVO> queryGatewayDistribution(
      OperationRequest<GatewayDistributionDataVO> request);
}
