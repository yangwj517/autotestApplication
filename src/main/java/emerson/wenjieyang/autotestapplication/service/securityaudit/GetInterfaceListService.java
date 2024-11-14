package emerson.wenjieyang.autotestapplication.service.securityaudit;

import emerson.wenjieyang.autotestapplication.config.PythonApplicationConfig;
import emerson.wenjieyang.autotestapplication.util.GetInterfaceAndSendPacketsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @className: GetInterfaceListService
 * @author: WenjieYang
 * @date: 2024/10/25 13:32
 * @Version: 1.0
 * @description: 获取网卡名称列表
 */
@Service
public class GetInterfaceListService {

    @Autowired
    private PythonApplicationConfig pythonApplicationConfig;

    public List<String> getInterfaceName (){
        return GetInterfaceAndSendPacketsUtil.interfaceNames(pythonApplicationConfig.getInterfaceName());
    }
}
