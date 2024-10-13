package ae.zerotone.gateway.center.infrastructure.dao;

import ae.zerotone.gateway.center.domain.operation.model.vo.ApplicationSystemDataVO;
import ae.zerotone.gateway.center.infrastructure.common.OperationRequest;
import ae.zerotone.gateway.center.infrastructure.po.ApplicationSystem;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description 应用系统
 */
@Mapper
public interface IApplicationSystemDao {

  void insert(ApplicationSystem applicationSystem);

  List<ApplicationSystem> queryApplicationSystemList(List<String> list);

  List<ApplicationSystem> queryApplicationSystemListByPage(
      OperationRequest<ApplicationSystemDataVO> request);

  int queryApplicationSystemListCountByPage(OperationRequest<ApplicationSystemDataVO> request);

  String queryApplicationSystemName(String systemId);

  boolean isExistBySystemId(String systemId);
}
