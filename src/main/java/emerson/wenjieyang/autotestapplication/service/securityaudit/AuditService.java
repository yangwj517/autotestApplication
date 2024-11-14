package emerson.wenjieyang.autotestapplication.service.securityaudit;

import emerson.wenjieyang.autotestapplication.config.BaseConfig;
import emerson.wenjieyang.autotestapplication.config.PythonApplicationConfig;
import emerson.wenjieyang.autotestapplication.config.securityaudit.FilePathConfig;
import emerson.wenjieyang.autotestapplication.config.securityaudit.SupportProtocolConfig;
import emerson.wenjieyang.autotestapplication.pojo.Response;
import emerson.wenjieyang.autotestapplication.pojo.securityaudit.page.*;
import emerson.wenjieyang.autotestapplication.pojo.securityaudit.testCase.ProtocolAuditTestCase;
import emerson.wenjieyang.autotestapplication.util.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.time.Duration;
import java.util.List;

/**
 * @className: AuditService
 * @author: WenjieYang
 * @date: 2024/10/25 14:02
 * @Version: 1.0
 * @description: 完成《判断是否审计到对应协议的逻辑》 FIXME: 只能一个一个协议审计，因为弃用所以不做修改
 */
@Deprecated
@Service
public class AuditService {

    // 通过配置类导入，协议数据包存放位置
    @Autowired
    private FilePathConfig filePathConfig;

    // 通过配置类导入，python脚本位置
    @Autowired
    private PythonApplicationConfig pythonApplicationConfig;

    // 通过配置类导入，进入系统的账号和用户名
    @Autowired
    private BaseConfig baseConfig;

    @Autowired
    private SupportProtocolConfig supportProtocolConfig;

    // 创建Driver
    private WebDriver createNewDriver(){
        System.setProperty("webdriver.chrome.driver", baseConfig.getChromeDriverPath());
        // 创建新的driver
        WebDriver driver = new ChromeDriver();
        // 设置隐式等待
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        return driver;
    }

    // 进入页面设置几种模式，然后去调用下面的审计法
    public Response<Object> accessAuditPage(String protocol , String interfaceName){
        WebDriver driver = createNewDriver();
        // 获取报文文件列表
        String filepath = filePathConfig.getPcapFolder()+"\\"+protocol;
        List<File> fileNameList = GetProtocolFileListUtil.getFileNameList(filepath);
        if(fileNameList.isEmpty()){
            return RespondUtil.error("测试用例不存在，请检查！");
        }
        // 登录系统
        driver.get(baseConfig.getSecurityAuditUrl());
        // 拿到登陆页面对象
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        // 处理安全警告页面
        if(loginPage.isAtAlarm(driver)){
            loginPage.securityAlarm();
        }
        // 键入用户名
        loginPage.enterUserName(baseConfig.getSecadminUsername());
        // 键入密码
        loginPage.enterPassword(baseConfig.getSecadminPassword());
        // 点击登录
        loginPage.clickLoginButton();
        // 拿到首页页面对象
        LogOffPage logOffPage = new LogOffPage(driver);
        // 判断是否已经跳转到首页
        try {
            logOffPage.isLogOff() ;
        }catch (Exception e){
            return RespondUtil.error("登录失败，请检查账号用户名配置！") ;
        }
        // 实例化左侧菜单栏 -- 控制页面跳转
        LeftMenuPage leftMenuPage = new LeftMenuPage(driver);
        // 实例化协议开关页面
        ProtocolButtonPage protocolButtonPage = new ProtocolButtonPage(driver);
        // 设置支持协议列表
        protocolButtonPage.setPROTOCOL_LIST(supportProtocolConfig.getProtocols());
        // 创建测试用例对象
        ProtocolAuditTestCase protocolAuditTestCase = new ProtocolAuditTestCase(protocol);
        // 创建审计信息页面对象。
        ProtocolAuditInfPage protocolAuditInfPage = new ProtocolAuditInfPage(driver);
        // 模式一 ： 全开
        model1(leftMenuPage,protocolButtonPage);
        audit("全开",interfaceName,fileNameList,protocolAuditInfPage,protocolAuditTestCase,driver);
        // 模式二 ： 全关
        model2(leftMenuPage,protocolButtonPage);
        audit("全关",interfaceName,fileNameList,protocolAuditInfPage,protocolAuditTestCase,driver);
        // 模式三 ： 单开
        model3(driver,protocol,leftMenuPage,protocolButtonPage) ;
        audit("单开",interfaceName,fileNameList,protocolAuditInfPage,protocolAuditTestCase,driver);
        // 模式四 ：随机开不包含
        model4(driver,protocol,leftMenuPage,protocolButtonPage) ;
        audit("随即开不包含",interfaceName,fileNameList,protocolAuditInfPage,protocolAuditTestCase,driver);
        // 模式五 ： 随即开包含
        model5(driver,protocol,leftMenuPage,protocolButtonPage) ;
        audit("随机开包含",interfaceName,fileNameList,protocolAuditInfPage,protocolAuditTestCase,driver);
        return RespondUtil.success("测试完成，点击日志查看详情");
    }

    // 下面五个方法包括，全开、全关、单开、随即开不包含、随即开包含。

    // 首先 应该打开 协议开关页面 ===》 设置状态  ===》 返回协议审计页面 ===》 是否审计到的逻辑
    private void model1(LeftMenuPage page ,ProtocolButtonPage protocolButtonPage ) {
        // 点击协议审计
        page.protocolAudit();
        // 点击审计策略
        page.auditPolicy();
        // 点击协议审计开关
        protocolButtonPage.liActive();
        //情况一 ： 全开
        // 先关闭所有
        protocolButtonPage.setButtonAuditstrategyManageDisableAll();
        // 打开所有
        protocolButtonPage.setButtonAuditstrategyManageEnableAll();
        // 点击审计信息
        page.auditInformation();
    }

    private void model2(LeftMenuPage page ,ProtocolButtonPage protocolButtonPage ) {
//        // 点击协议审计
//        page.protocolAudit();
        // 点击审计策略
        page.auditPolicy();
        // 点击协议审计开关
        protocolButtonPage.liActive();
        //情况二 ： 全关
        // 先关闭所有
        protocolButtonPage.setButtonAuditstrategyManageDisableAll();
        // 点击审计信息
        page.auditInformation();
    }

    private void model3(WebDriver driver , String protocol ,LeftMenuPage page ,ProtocolButtonPage protocolButtonPage   ) {
//        // 点击协议审计
//        page.protocolAudit();
        // 点击审计策略
        page.auditPolicy();
        // 点击协议审计开关
        protocolButtonPage.liActive();
        //情况三 ： 单开
        // 先关闭所有
        protocolButtonPage.setButtonAuditstrategyManageDisableAll();
        // 单独打开一条
        protocolButtonPage.protocolOn(protocol,driver);
        // 点击审计信息
        page.auditInformation();

    }

    private void model4(WebDriver driver , String protocol ,LeftMenuPage page ,ProtocolButtonPage protocolButtonPage) {
//        // 点击协议审计
//        page.protocolAudit();
        // 点击审计策略
        page.auditPolicy();
        // 点击协议审计开关
        protocolButtonPage.liActive();
        //情况一 ： 随机开不包含
        // 先关闭所有
        protocolButtonPage.setButtonAuditstrategyManageDisableAll();
        // 随即开，不包含被测协议
        protocolButtonPage.protocolRandomOn(protocol,driver);
        // 点击审计信息
        page.auditInformation();
    }

    private void model5(WebDriver driver , String protocol ,LeftMenuPage page ,ProtocolButtonPage protocolButtonPage) {
//        // 点击协议审计
//        page.protocolAudit();
        // 点击审计策略
        page.auditPolicy();
        // 点击协议审计开关
        protocolButtonPage.liActive();
        //情况一 ： 随机开不包含
        // 先关闭所有
        protocolButtonPage.setButtonAuditstrategyManageDisableAll();
        // 随即开，不包含被测协议
        protocolButtonPage.protocolRandomOn(protocol,driver);
        // 打开被测协议
        protocolButtonPage.protocolOn(protocol,driver);
        // 点击审计信息
        page.auditInformation();
    }

    // FIXME: 审计结果判断并未完善，《该功能已在远程service层实现》需要的话可以copy过来。
    private void audit(String type ,String interfaceName , List<File> fileNameList , ProtocolAuditInfPage protocolAuditInfPage , ProtocolAuditTestCase protocolAuditTestCase ,WebDriver    driver) {
        for (int i = 0; i < fileNameList.size(); i++) {
            protocolAuditTestCase.setProtocolFileName(fileNameList.get(i).getName());
            protocolAuditTestCase.setTestType(type);
            protocolAuditTestCase.setProtocolResult(true);
            String updateTime = protocolAuditInfPage.getUpdateTime(driver); // 查看最新审计记录的时间
            // 回放报文
            GetInterfaceAndSendPacketsUtil.sendPackets(pythonApplicationConfig.getSendPacketPath(),interfaceName,fileNameList.get(i).toString());
            // 等待两秒钟
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            // 刷新界面
            protocolAuditInfPage.clickProtocolRefresh();
            // 获取最新时间
            String updateTime1 = protocolAuditInfPage.getUpdateTime(driver);
            if(updateTime1.equals(updateTime)){
                protocolAuditTestCase.setProtocolResult(false);
            }
            boolean flag = protocolAuditInfPage.isProtocolType(protocolAuditTestCase.getProtocolName().replaceAll("-","").trim().toLowerCase(),driver);
            if(!flag){
                protocolAuditTestCase.setProtocolResult(false);
            }
           LogOutputUtil.saveLog( filePathConfig.getLogOutPath() , LogCreateUtil.createLog(protocolAuditTestCase.toString()));
        }
    }


}
