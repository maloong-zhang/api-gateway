package ae.zerotone.gateway.center.infrastructure.dao;

import ae.zerotone.gateway.center.domain.operation.model.vo.ApplicationInterfaceDataVO;
import ae.zerotone.gateway.center.infrastructure.common.OperationRequest;
import ae.zerotone.gateway.center.infrastructure.po.ApplicationInterface;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description 应用接口
 */
@Mapper
public interface IApplicationInterfaceDao {

  void insert(ApplicationInterface applicationInterface);

  List<ApplicationInterface> queryApplicationInterfaceList(String systemId);

  List<ApplicationInterface> queryApplicationInterfaceListByPage(
      OperationRequest<ApplicationInterfaceDataVO> request);

  int queryApplicationInterfaceListCountByPage(
      OperationRequest<ApplicationInterfaceDataVO> request);

  boolean isExistByInterfaceId(ApplicationInterface applicationInterface);
}
