package emerson.wenjieyang.autotestapplication.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @BelongsProject : demo1
 * @BelongsPackage : com.example.demo.config
 * @Author : YWJ
 * @CreateTime : 2024-10-22  15:32
 * @Description : 基础配置类 ，此处配置包括 ：浏览器驱动地址 ，以及 每个页面的URL配置 ，远程地址
 * @Version : 1.0
 */

@Configuration
//配置文件存放地址
@PropertySource("file:${user.home}/autotest-config/autotest.properties")
public class BaseConfig {

    // 浏览器驱动地址
    @Value("${webdriver.chrome.driver:defaultValue}")
    private String chromeDriverPath;

    // 安全审计地址
    @Value("${url.securityAudit:defaultValue}")
    private String securityAuditUrl;

    @Value("${secadmin.username:ywj1}")
    private String secadminUsername;

    @Value("${secadmin.password:020517ywJ@}")
    private String secadminPassword;

    @Value("${remote.host.address}")
    private String remoteHostAddress;


    //... 按照以上格式添加剩余配置 ，还需按需添加对应的getter方法，例如 getUrl() 写在本文件最后的几个方法，照着写


    // 安全审计地址的getter方法， 调用此方法返回安全审计的地址
    public String getSecurityAuditUrl() {
        System.out.println(securityAuditUrl);
        return securityAuditUrl;
    }



    //调用此方法返回Chrome驱动的本机地址
    public String getChromeDriverPath() {
        return chromeDriverPath;
    }

    public String getSecadminUsername() {
        return secadminUsername;
    }

    public String getSecadminPassword() {
        return secadminPassword;
    }

    public String getRemoteHostAddress() {
        return remoteHostAddress;
    }
}