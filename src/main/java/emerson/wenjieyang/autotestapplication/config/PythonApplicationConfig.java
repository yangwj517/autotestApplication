package emerson.wenjieyang.autotestapplication.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @className: PythonApplicationConfig
 * @author: WenjieYang
 * @date: 2024/10/25 11:20
 * @Version: 1.0
 * @description: 配置python脚本的位置
 */

@Configuration
@PropertySource("file:${user.home}/autotest-config/pythonFile.properties")
public class PythonApplicationConfig {

    @Value("${python.getInterfaceNames.path:defaultValue}")
    private String interfaceName;

    @Value("${python.sendPacket.path:defaultValue}")
    private String sendPacketPath;

    public String getInterfaceName() {
        return interfaceName;
    }

    public String getSendPacketPath() {
        return sendPacketPath;
    }
}
