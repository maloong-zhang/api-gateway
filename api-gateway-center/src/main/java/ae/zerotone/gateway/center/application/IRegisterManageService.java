package ae.zerotone.gateway.center.application;


import ae.zerotone.gateway.center.domain.register.model.vo.ApplicationInterfaceMethodVO;
import ae.zerotone.gateway.center.domain.register.model.vo.ApplicationInterfaceVO;
import ae.zerotone.gateway.center.domain.register.model.vo.ApplicationSystemVO;

/**
 * @description 接口注册服务
 */
public interface IRegisterManageService {

    void registerApplication(ApplicationSystemVO applicationSystemVO);

    void registerApplicationInterface(ApplicationInterfaceVO applicationInterfaceVO);

    void registerApplicationInterfaceMethod(ApplicationInterfaceMethodVO applicationInterfaceMethodVO);

}
