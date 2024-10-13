package ae.zerotone.gateway.center.domain.register.service;

import ae.zerotone.gateway.center.application.IRegisterManageService;
import ae.zerotone.gateway.center.domain.register.model.vo.ApplicationInterfaceMethodVO;
import ae.zerotone.gateway.center.domain.register.model.vo.ApplicationInterfaceVO;
import ae.zerotone.gateway.center.domain.register.model.vo.ApplicationSystemVO;
import ae.zerotone.gateway.center.domain.register.repository.IRegisterManageRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description 接口注册服务
 */
@Service
public class IRegisterManageServiceImpl implements IRegisterManageService {

    @Resource
    private IRegisterManageRepository registerManageRepository;

    @Override
    public void registerApplication(ApplicationSystemVO applicationSystemVO) {
        registerManageRepository.registerApplication(applicationSystemVO);
    }

    @Override
    public void registerApplicationInterface(ApplicationInterfaceVO applicationInterfaceVO) {
        registerManageRepository.registerApplicationInterface(applicationInterfaceVO);
    }

    @Override
    public void registerApplicationInterfaceMethod(ApplicationInterfaceMethodVO applicationInterfaceMethodVO) {
        registerManageRepository.registerApplicationInterfaceMethod(applicationInterfaceMethodVO);
    }
}
