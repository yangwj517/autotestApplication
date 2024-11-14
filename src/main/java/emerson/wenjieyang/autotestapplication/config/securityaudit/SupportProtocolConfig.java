package emerson.wenjieyang.autotestapplication.config.securityaudit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

/**
 * @className: SupportProtocolConfig
 * @author: WenjieYang
 * @date: 2024/10/29 16:18
 * @Version: 1.0
 * @description: 从配置文件中加载支持的所有协议，返回一个list
 */
@Configuration
@PropertySource("file:${user.home}/autotest-config/securityaudit/securityAudit.properties")
public class SupportProtocolConfig {

    @Value("${protocol.support.list}")
    List<String> protocols;

    public List<String> getProtocols() {
        return protocols;
    }
}
