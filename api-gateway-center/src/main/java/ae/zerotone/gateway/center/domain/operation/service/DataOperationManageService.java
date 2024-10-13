package ae.zerotone.gateway.center.domain.operation.service;

import ae.zerotone.gateway.center.application.IDataOperationManageService;
import ae.zerotone.gateway.center.domain.operation.model.vo.*;
import ae.zerotone.gateway.center.domain.operation.repository.IDataOperationManageRepository;
import ae.zerotone.gateway.center.infrastructure.common.OperationRequest;
import ae.zerotone.gateway.center.infrastructure.common.OperationResult;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @description 网关运营数据管理
 */
@Service
public class DataOperationManageService implements IDataOperationManageService {

  private Logger logger = LoggerFactory.getLogger(DataOperationManageService.class);

  @Resource private IDataOperationManageRepository repository;

  @Override
  public OperationResult<GatewayServerDataVO> queryGatewayServer(OperationRequest<String> request) {
    List<GatewayServerDataVO> list = repository.queryGatewayServerListByPage(request);
    int count = repository.queryGatewayServerListCountByPage(request);
    return new OperationResult<>(count, list);
  }

  @Override
  public OperationResult<ApplicationSystemDataVO> queryApplicationSystem(
      OperationRequest<ApplicationSystemDataVO> request) {
    List<ApplicationSystemDataVO> list = repository.queryApplicationSystemListByPage(request);
    int count = repository.queryApplicationSystemListCountByPage(request);
    return new OperationResult<>(count, list);
  }

  @Override
  public OperationResult<ApplicationInterfaceDataVO> queryApplicationInterface(
      OperationRequest<ApplicationInterfaceDataVO> request) {
    List<ApplicationInterfaceDataVO> list = repository.queryApplicationInterfaceListByPage(request);
    int count = repository.queryApplicationInterfaceListCountByPage(request);
    return new OperationResult<>(count, list);
  }

  @Override
  public OperationResult<ApplicationInterfaceMethodDataVO> queryApplicationInterfaceMethod(
      OperationRequest<ApplicationInterfaceMethodDataVO> request) {
    List<ApplicationInterfaceMethodDataVO> list =
        repository.queryApplicationInterfaceMethodListByPage(request);
    int count = repository.queryApplicationInterfaceMethodListCountByPage(request);
    return new OperationResult<>(count, list);
  }

  @Override
  public OperationResult<GatewayServerDetailDataVO> queryGatewayServerDetail(
      OperationRequest<GatewayServerDetailDataVO> request) {
    List<GatewayServerDetailDataVO> list = repository.queryGatewayServerDetailListByPage(request);
    int count = repository.queryGatewayServerDetailListCountByPage(request);
    return new OperationResult<>(count, list);
  }

  @Override
  public OperationResult<GatewayDistributionDataVO> queryGatewayDistribution(
      OperationRequest<GatewayDistributionDataVO> request) {
    List<GatewayDistributionDataVO> list = repository.queryGatewayDistributionListByPage(request);
    int count = repository.queryGatewayDistributionListCountByPage(request);
    return new OperationResult<>(count, list);
  }
}
