package emerson.wenjieyang.autotestapplication.service.securityaudit;

import emerson.wenjieyang.autotestapplication.config.BaseConfig;
import emerson.wenjieyang.autotestapplication.config.securityaudit.FilePathConfig;
import emerson.wenjieyang.autotestapplication.pojo.Response;
import emerson.wenjieyang.autotestapplication.pojo.securityaudit.page.AppWhiteListRulePage;
import emerson.wenjieyang.autotestapplication.pojo.securityaudit.page.LeftMenuPage;
import emerson.wenjieyang.autotestapplication.pojo.securityaudit.page.LogOffPage;
import emerson.wenjieyang.autotestapplication.pojo.securityaudit.testCase.AppWhiteListRuleTestCase;
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
 * @className: RuleManageService
 * @author: WenjieYang
 * @date: 2024/11/13 15:27
 * @Version: 1.0
 * @description: 规则管理 service层
 */

@Service
public class RuleManageService {

    @Autowired
    private CreateNewWebDriverComponent createNewWebDriverComponent;

    @Autowired
    private FilePathConfig filePathConfig;

    @Autowired
    private BaseConfig baseConfig ;

    @Autowired
    private LoginService loginService;

    /**
     * 手动创建新的应用协议白名单
     */
    public Response<Object> addNewAppWhiteListRule(){
        WebDriver driver = createNewWebDriverComponent.createNewWebDriver(10);
        driver.get(baseConfig.getSecurityAuditUrl());
        // 登录
        Response<Object> objectResponse = loginService.loginSystem(baseConfig.getSecadminUsername(), baseConfig.getSecadminPassword(), driver);
        if(objectResponse.getCode()==444){
            driver.quit();
            return objectResponse;
        }
        // 跳转页面
        LeftMenuPage leftMenuPage = new LeftMenuPage(driver);
        leftMenuPage.ruleManagement();
        leftMenuPage.whitelistRules();
        // 实例化应用白名单页面
        AppWhiteListRulePage page = new AppWhiteListRulePage(driver);
        // 加载测试用例
        List<AppWhiteListRuleTestCase> testCases = GetTestcaseListUtil.getAppWhiteListRuleTestCaseList(filePathConfig.getAddAppWhiteListRulePath());
        for(AppWhiteListRuleTestCase testCase : testCases){
            testCase = page.createNewAppWhiteListRuleTestCase(testCase, driver);
            LogOutputUtil.saveLog(filePathConfig.getLogOutPath(), LogCreateUtil.createLog(testCase.toString()));
        }
        // 登出
        LogOffPage logOffPage = new LogOffPage(driver);
        logOffPage.logOff();
        driver.quit();
        return RespondUtil.success("新建应用协议白名单测试完成，请转到日志页面查看详情!");
    }
}
