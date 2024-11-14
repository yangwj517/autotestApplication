package emerson.wenjieyang.autotestapplication.service.securityaudit;

import emerson.wenjieyang.autotestapplication.config.BaseConfig;
import emerson.wenjieyang.autotestapplication.config.securityaudit.FilePathConfig;
import emerson.wenjieyang.autotestapplication.pojo.Response;
import emerson.wenjieyang.autotestapplication.pojo.securityaudit.page.LeftMenuPage;
import emerson.wenjieyang.autotestapplication.pojo.securityaudit.page.LogOffPage;
import emerson.wenjieyang.autotestapplication.pojo.securityaudit.page.SecurityEventAlarmConfigurePage;
import emerson.wenjieyang.autotestapplication.pojo.securityaudit.testCase.AlarmConfigureTestCase;
import emerson.wenjieyang.autotestapplication.service.CreateNewWebDriverComponent;
import emerson.wenjieyang.autotestapplication.util.GetTestcaseListUtil;
import emerson.wenjieyang.autotestapplication.util.LogCreateUtil;
import emerson.wenjieyang.autotestapplication.util.LogOutputUtil;
import emerson.wenjieyang.autotestapplication.util.RespondUtil;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @className: SecurityEventService
 * @author: WenjieYang
 * @date: 2024/11/13 10:03
 * @Version: 1.0
 * @description: 安全事件  相关功能测试service
 */
@Service
public class SecurityEventService {
    @Autowired
    private FilePathConfig filePathConfig ;

    @Autowired
    private CreateNewWebDriverComponent createNewWebDriverComponent;

    @Autowired
    private BaseConfig baseConfig;

    @Autowired
    private LoginService loginService ;

    /**
     * 新建安全事件 告警配置
     * @return
     */
    public Response<Object> createNewAlarmConfigure(){
        // 创建驱动
        WebDriver driver = createNewWebDriverComponent.createNewWebDriver(10);
        driver.get(baseConfig.getSecurityAuditUrl());
        // 登录系统
        Response<Object> objectResponse = loginService.loginSystem(baseConfig.getSecadminUsername(), baseConfig.getSecadminPassword(), driver);
        if(objectResponse.getCode()==444){
            driver.quit();
            return objectResponse ;
        }
        // 创建页面
        SecurityEventAlarmConfigurePage page = new SecurityEventAlarmConfigurePage(driver) ;
        // 实例化左侧菜单进行页面跳转
        LeftMenuPage leftMenuPage = new LeftMenuPage(driver) ;
        leftMenuPage.securityEvent();
        leftMenuPage.alarmConfiguration();
        // 加载测试用例
        List<AlarmConfigureTestCase> testCaseList = GetTestcaseListUtil.getAlarmConfigureTestCaseList(filePathConfig.getAddAlarmConfigurePath());
        for(AlarmConfigureTestCase testCase:testCaseList){
            testCase = page.createNewAlarmConfigureTestCase(testCase) ;
            LogOutputUtil.saveLog(filePathConfig.getLogOutPath(), LogCreateUtil.createLog(testCase.toString()));
        }
        // 登出
        LogOffPage logOffPage = new LogOffPage(driver);
        logOffPage.logOff();
        driver.quit();
        return RespondUtil.success("新增告警配置测试完成，请转到日志页查看详情");
    }

}
