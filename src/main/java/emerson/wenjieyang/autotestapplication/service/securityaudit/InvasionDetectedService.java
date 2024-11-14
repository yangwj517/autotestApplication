package emerson.wenjieyang.autotestapplication.service.securityaudit;

import emerson.wenjieyang.autotestapplication.config.BaseConfig;
import emerson.wenjieyang.autotestapplication.config.securityaudit.FilePathConfig;
import emerson.wenjieyang.autotestapplication.pojo.Response;
import emerson.wenjieyang.autotestapplication.pojo.securityaudit.page.*;
import emerson.wenjieyang.autotestapplication.pojo.securityaudit.testCase.AddressObjectTestCase;
import emerson.wenjieyang.autotestapplication.pojo.securityaudit.testCase.DetectionPolicyTestCase;
import emerson.wenjieyang.autotestapplication.pojo.securityaudit.testCase.RuleSetTestCase;
import emerson.wenjieyang.autotestapplication.pojo.securityaudit.testCase.TimeObjectTestCase;
import emerson.wenjieyang.autotestapplication.service.CreateNewWebDriverComponent;
import emerson.wenjieyang.autotestapplication.util.*;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


/**
 * @className: InvasionDetectedService
 * @author: WenjieYang
 * @date: 2024/11/5 10:48
 * @Version: 1.0
 * @description: IDS入侵检测 服务层
 * FIXME : 报文回放，入侵检测未完成。
 */

@Service
public class InvasionDetectedService {


    @Autowired
    private CreateNewWebDriverComponent createNewWebDriverComponent;

    @Autowired
    private FilePathConfig filePathConfig ;

    @Autowired
    private LoginService loginService ;

    @Autowired
    private BaseConfig baseConfig ;

    /**
     * 添加通用时间逻辑
     */
    public Response<Object> addNewTimeObject(){
        // 实例化页面
        WebDriver driver = createNewWebDriverComponent.createNewWebDriver(10);
        driver.get(baseConfig.getSecurityAuditUrl());
        // 登录页面
        Response<Object> objectResponse = loginService.loginSystem(baseConfig.getSecadminUsername(), baseConfig.getSecadminPassword(), driver);
        // 检测登录是否成功，失败直接返回
        // 登录失败 直接返回
        if(objectResponse.getCode()==444){
            driver.quit();
            return  objectResponse ;
        }
        TimeObjectPage page = new TimeObjectPage(driver) ;
        // 读取测试用例
        List<TimeObjectTestCase> testCasesList = GetTestcaseListUtil.getTimeObjectTestCaseList(filePathConfig.getAddTimeObjectPath());
        // 跳转到时间对象 -- 实例化LeftMenu ，跳转页面
        LeftMenuPage leftMenuPage = new LeftMenuPage(driver) ;
        leftMenuPage.intrusionDetection();
        leftMenuPage.timeObject();
        // 循环执行创建
        for (int i = 0; i < testCasesList.size(); i++) {
            TimeObjectTestCase testCase = testCasesList.get(i);
            TimeObjectTestCase timesheet = null ;
            if(testCase.getType().equals("循环时间表")) {
                timesheet = page.createLoopTimesheet(testCase, driver);
                LogOutputUtil.saveLog(filePathConfig.getLogOutPath(),LogCreateUtil.createLog(timesheet.toString()));
                continue;
            }
            timesheet = page.createOnceTimesheet(testCase, driver);
            LogOutputUtil.saveLog(filePathConfig.getLogOutPath(),LogCreateUtil.createLog(timesheet.toString()));
        }
        LogOffPage logOffPage = new LogOffPage(driver);
        logOffPage.logOff();
        driver.quit();
        return RespondUtil.success("时间对象新建测试完成，请转到日志页查看详情");
    }



    /**
     * 添加通用地址逻辑
     */
    public Response<Object> addNewAddressObject(){
        // 实例化页面
        WebDriver driver = createNewWebDriverComponent.createNewWebDriver(10);
        driver.get(baseConfig.getSecurityAuditUrl());
        AddressObjectPage page = new AddressObjectPage(driver) ;
        // 登录页面
        Response<Object> objectResponse = loginService.loginSystem(baseConfig.getSecadminUsername(), baseConfig.getSecadminPassword(), driver);
        // 检测登录是否成功，失败直接返回
        // 登录失败 直接返回
        if(objectResponse.getCode()==444){
            driver.quit();
            return  objectResponse ;
        }
        // 读取测试用例
        List<AddressObjectTestCase> testCasesList = GetTestcaseListUtil.getAddressObjectTestCaseList(filePathConfig.getAddAddressObjectPath());
        // 实例化左侧菜单栏，页面跳转
        LeftMenuPage leftMenuPage = new LeftMenuPage(driver) ;
        leftMenuPage.intrusionDetection();
        leftMenuPage.addressObject();
        for (int i = 0; i < testCasesList.size(); i++) {
            // 新增测试
            AddressObjectTestCase testCase = page.createNewAddressObject(testCasesList.get(i),driver);
            LogOutputUtil.saveLog(filePathConfig.getLogOutPath(), LogCreateUtil.createLog(testCase.toString()));
        }
        // 登出系统
        LogOffPage logOffPage = new LogOffPage(driver) ;
        logOffPage.logOff();
        driver.quit();
        return RespondUtil.success("地址对象新建测试完成,请转到日志页查看详情");
    }




    /**
     * 添加规则集   -- all in
     */
    public Response<Object> addNewRuleSet(){
        // 实例化页面
        WebDriver driver = createNewWebDriverComponent.createNewWebDriver(10);
        driver.get(baseConfig.getSecurityAuditUrl());
        RuleSetPage page = new RuleSetPage(driver);
               // 登录页面
        Response<Object> objectResponse = loginService.loginSystem(baseConfig.getSecadminUsername(), baseConfig.getSecadminPassword(), driver);
        // 登录失败 直接返回
        if(objectResponse.getCode()==444){
            driver.quit();
            return  objectResponse ;
        }
        // 读取测试用例子
        List<RuleSetTestCase> testCasesList = GetTestcaseListUtil.getRuleSetTestCaseList(filePathConfig.getAddRuleSetPath());
        // 实例化 左侧菜单栏 页面跳转
        LeftMenuPage  leftMenuPage = new LeftMenuPage(driver) ;
        leftMenuPage.intrusionDetection();
        leftMenuPage.rulesets();
        // 开始测试
        for(RuleSetTestCase testCase: testCasesList) {
            RuleSetTestCase ruleSetTestCase = page.creatNewRuleSetTest(testCase,driver);
            LogOutputUtil.saveLog(filePathConfig.getLogOutPath(), LogCreateUtil.createLog(ruleSetTestCase.toString()));
        }
        // 退出登录
        LogOffPage logOffPage = new LogOffPage(driver) ;
        logOffPage.logOff();
        // 关闭浏览器驱动
        driver.quit();
        return RespondUtil.success("规则及创建测试完成，请转到日志页查看详情");
    }


    /**
     * 检测策略新增
     */
    public Response<Object> addNewDetectionPolicy(){
        // 实例化页面
        WebDriver driver = createNewWebDriverComponent.createNewWebDriver(10);
        driver.get(baseConfig.getSecurityAuditUrl());
        DetectionPolicyPage page = new DetectionPolicyPage(driver);
         // 登录页面
        Response<Object> objectResponse = loginService.loginSystem(baseConfig.getSecadminUsername(), baseConfig.getSecadminPassword(), driver);
        if(objectResponse.getCode()==444){
            driver.quit();
            return  objectResponse ;
        }
        // 读取测试用例
        List<DetectionPolicyTestCase> testCases = GetTestcaseListUtil.getDetectionPolicyTestCaseList(filePathConfig.getAddDetectionPolicyPath());
        // 实例化左侧菜单栏 -- 页面跳转
        LeftMenuPage leftMenuPage = new LeftMenuPage(driver) ;
        leftMenuPage.intrusionDetection();
        leftMenuPage.detectionPolicy();
        // 开始测试
        for(DetectionPolicyTestCase testCase: testCases) {
            DetectionPolicyTestCase detectionPolicyTestCase = page.createNewDetectionPolicy(testCase);
            LogOutputUtil.saveLog(filePathConfig.getLogOutPath(),LogCreateUtil.createLog(detectionPolicyTestCase.toString()));
        }
        // 退出登录
        LogOffPage logOffPage = new LogOffPage(driver) ;
        logOffPage.logOff();
        driver.quit();
        return RespondUtil.success("检测策略创建测试完毕，请转到日志页查看详情");
    }



    /**
     * 入侵检测报文回访+入侵日志审计
     */
    private Response<Object> ids(){
        return RespondUtil.success("入侵检测测试完毕，请转到日志页查看详情");
    }
}
