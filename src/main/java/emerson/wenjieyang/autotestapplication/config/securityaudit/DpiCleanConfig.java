package emerson.wenjieyang.autotestapplication.config.securityaudit;

//import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

/**
 * @className: DpiCleanConfig
 * @author: WenjieYang
 * @date: 2024/11/6 14:56
 * @Version: 1.0
 * @description: 加载ssh相关配置
 */

@Configuration
@PropertySource("file:${user.home}/autotest-config/securityaudit/securityAudit.properties")
public class DpiCleanConfig {

    @Value("${ssh.host:defaultValue}")
    private String host;

    @Value("${ssh.port:22}")
    private int port;

    @Value("${ssh.username:defaultValue}")
    private String username;

    @Value("${ssh.password:defaultValue}")
    private String password;

    @Value("${ssh.cleandpi.commands:}")
    private List<String> commands;

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<String> getCommands() {
        return commands;
    }
}
