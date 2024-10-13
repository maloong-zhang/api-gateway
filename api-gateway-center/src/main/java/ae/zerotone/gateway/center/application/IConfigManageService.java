package ae.zerotone.gateway.center.application;

import ae.zerotone.gateway.center.domain.manage.model.aggregates.ApplicationSystemRichInfo;
import ae.zerotone.gateway.center.domain.manage.model.vo.*;
import java.util.List;

/**
 * @description 网关配置服务
 */
public interface IConfigManageService {

  List<GatewayServerVO> queryGatewayServerList();

  List<GatewayServerDetailVO> queryGatewayServerDetailList();

  List<GatewayDistributionVO> queryGatewayDistributionList();

  boolean registerGatewayServerNode(
      String groupId, String gatewayId, String gatewayName, String gatewayAddress);

  ApplicationSystemRichInfo queryApplicationSystemRichInfo(String gatewayId, String systemId);

  String queryGatewayDistribution(String systemId);

  List<ApplicationSystemVO> queryApplicationSystemList();

  List<ApplicationInterfaceVO> queryApplicationInterfaceList();

  List<ApplicationInterfaceMethodVO> queryApplicationInterfaceMethodList();

  void distributionGatewayServerNode(String groupId, String gatewayId, String systemId);
}
