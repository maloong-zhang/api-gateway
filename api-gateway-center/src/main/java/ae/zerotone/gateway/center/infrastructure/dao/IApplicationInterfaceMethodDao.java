package ae.zerotone.gateway.center.infrastructure.dao;

import ae.zerotone.gateway.center.domain.operation.model.vo.ApplicationInterfaceMethodDataVO;
import ae.zerotone.gateway.center.infrastructure.common.OperationRequest;
import ae.zerotone.gateway.center.infrastructure.po.ApplicationInterfaceMethod;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description 应用接口方法
 */
@Mapper
public interface IApplicationInterfaceMethodDao {

  void insert(ApplicationInterfaceMethod applicationInterfaceMethod);

  List<ApplicationInterfaceMethod> queryApplicationInterfaceMethodList(
      ApplicationInterfaceMethod req);

  List<ApplicationInterfaceMethod> queryApplicationInterfaceMethodListByPage(
      OperationRequest<ApplicationInterfaceMethodDataVO> request);

  int queryApplicationInterfaceMethodListCountByPage(
      OperationRequest<ApplicationInterfaceMethodDataVO> request);

  boolean isExistByInterfaceMethodId(ApplicationInterfaceMethod applicationInterfaceMethod);
}
