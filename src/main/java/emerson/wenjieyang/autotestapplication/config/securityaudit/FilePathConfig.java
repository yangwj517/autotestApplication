package emerson.wenjieyang.autotestapplication.config.securityaudit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


/**
 * @className: fileConfig
 * @author: WenjieYang
 * @date: 2024/10/25 11:27
 * @Version: 1.0
 * @description: 安全审计测试配置 ，主要包括 ，测试用例的地址 ，日志的输出地址
 *
 */
@Configuration
@PropertySource("file:${user.home}/autotest-config/securityaudit/securityAudit.properties")
public class FilePathConfig {

    // 测试日志输出地址
    @Value("${test.log.out.path:defaultValue}")
    private String logOutPath;

    // 各种协议报文数据包存放地址
    @Value("${testcase.pcapFileFolder.path:defaultValue }")
    private String pcapFolder;

    // 登录测试用例存放地址
    @Value("${testcase.login.path:defaultValue}")
    private String loginCasePath;

    // 时间对象测试用例存放地址
    @Value("${testcase.addTimeObject.path:defaultValue}")
    private String addTimeObjectPath;

    // 地址对象测试用例存放地址
    @Value("${testcase.addAddressObject.path:defaultValue}")
    private String addAddressObjectPath;

    // 规则集测试用例存放地址
    @Value("${testcase.addRuleSet.path:defaultValue}")
    private String addRuleSetPath;

    // 检测策略测试用例存放地址
    @Value("${testcase.addDetectionPolicy.path:defaultValue}")
    private String addDetectionPolicyPath;

    // 告警配置测试用例
    @Value("${testcase.addAlarmConfigure.path:defaultValue}")
    private String addAlarmConfigurePath;

    @Value("${testcase.addAppWhiteListRule.path:defaultValue}")
    private String addAppWhiteListRulePath;


    public String getLogOutPath() {
        return logOutPath;
    }

    public String getPcapFolder() {
        return pcapFolder;
    }

    public String getLoginCasePath() {
        return loginCasePath;
    }

    public String getAddTimeObjectPath() {
        return addTimeObjectPath;
    }

    public String getAddAddressObjectPath() {
        return addAddressObjectPath;
    }

    public String getAddRuleSetPath() {
        return addRuleSetPath;
    }

    public String getAddDetectionPolicyPath() {
        return addDetectionPolicyPath;
    }

    public String getAddAlarmConfigurePath() {
        return addAlarmConfigurePath;
    }

    public String getAddAppWhiteListRulePath() {
        return addAppWhiteListRulePath;
    }


}
