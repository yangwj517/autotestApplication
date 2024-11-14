package emerson.wenjieyang.autotestapplication.service.securityaudit;

import com.google.gson.Gson;
import emerson.wenjieyang.autotestapplication.config.BaseConfig;
import emerson.wenjieyang.autotestapplication.config.securityaudit.FilePathConfig;
import emerson.wenjieyang.autotestapplication.config.securityaudit.SupportProtocolConfig;
import emerson.wenjieyang.autotestapplication.pojo.Response;
import emerson.wenjieyang.autotestapplication.pojo.securityaudit.page.*;
import emerson.wenjieyang.autotestapplication.pojo.securityaudit.testCase.ProtocolAuditTestCase;
import emerson.wenjieyang.autotestapplication.util.*;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

/**
 * @className: RemoteAuditService
 * @author: WenjieYang
 * @date: 2024/10/31 9:06
 * @Version: 1.0
 * @description: 调用远程电脑执行报文回访，远程电脑网卡的获取
 * FIXME : dpi清理接口已经写好,还需在合适的地方加上此方法。
 */

@Service
public class RemoteAuditService {

    @Autowired
    private SupportProtocolConfig supportProtocolConfig;

    // 通过配置类导入，协议数据包存放位置
    @Autowired
    private FilePathConfig filePathConfig;

    // 通过配置类导入，进入系统的账号和用户名
    @Autowired
    private BaseConfig baseConfig;

    // 创建Driver
    private WebDriver createNewDriver(){
        System.setProperty("webdriver.chrome.driver", baseConfig.getChromeDriverPath());
        // 创建新的driver
        WebDriver driver = new ChromeDriver();
        // 设置隐式等待
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        return driver;
    }

    public Response<Object> getRemoteInterfaceName()  {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder().url("http://192.168.102.201:8888/getInterfaceNamesList").build();
        Call call = client.newCall(request);
        okhttp3.Response response = null;
        List<String> list = null ;
        try{
            response = call.execute();
            Gson gson = new Gson();
            list = gson.fromJson(response.body().string(), List.class);
        } catch (IOException e) {
            return RespondUtil.error("远程主机网卡名称获取失败！") ;
        }
        return RespondUtil.success("远程主机网卡名称获取成功！" , list ) ;
    }


    public Response<Object> RemoteSendPackets(String interfaceName) {
        // 获取所有的协议类型 -- 后面遍历一次执行所有
        List<String> protocols = supportProtocolConfig.getProtocols();
        // 创建WebDriver
        WebDriver driver = createNewDriver();
        // 登录系统
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
        // 创建审计信息页面对象。
        ProtocolAuditInfPage protocolAuditInfPage = new ProtocolAuditInfPage(driver);
        // 展开协议审计菜单
        leftMenuPage.protocolAudit();
        // 循环所有的协议报文
        for (int i = 22; i < protocols.size(); i++) {
            System.out.println(i+" ====================================");
            // 事实证明每一次循环进来列表的元素顺序就会打乱 《模式四和模式五，会改变数组的元素本身的顺序  ,已解决，随机洗牌导致顺序错误》
            // 此处i确实只加了一但是协议却跳过了很多个。
            String protocol = protocols.get(i);
            //System.out.println(protocol+"======================================================================================================================================");
            // 创建测试用例对象
            ProtocolAuditTestCase protocolAuditTestCase = new ProtocolAuditTestCase(protocol);
//            // 模式一 ： 全开  ------- 并不会影响数组的元素顺序
            model1(leftMenuPage,protocolButtonPage);
            audit("全开",interfaceName,protocolAuditInfPage,protocolAuditTestCase,driver);
//            // 模式二 ： 全关  ------- 并不会影响数组的元素顺序
            model2(leftMenuPage,protocolButtonPage);
            audit("全关",interfaceName,protocolAuditInfPage,protocolAuditTestCase,driver);
//            // 模式三 ： 单开  ------- 也不会影响数组的元素顺序
            model3(driver,protocol,leftMenuPage,protocolButtonPage) ;
            audit("单开",interfaceName,protocolAuditInfPage,protocolAuditTestCase,driver);
            // 模式四 ：随机开不包含  《页面滑动导致部分元素不可见，已解决，增加页面滑动查找逻辑》
            model4(driver,protocol,leftMenuPage,protocolButtonPage) ;
            audit("随即开不包含",interfaceName,protocolAuditInfPage,protocolAuditTestCase,driver);
//            // 模式五 ： 随即开包含
            model5(driver,protocol,leftMenuPage,protocolButtonPage) ;
            audit("随机开包含",interfaceName,protocolAuditInfPage,protocolAuditTestCase,driver);
        }
        return RespondUtil.success("测试完成，点击日志查看详情");
    }

    // 下面五个方法包括，全开、全关、单开、随即开不包含、随即开包含。

    // 首先 应该打开 协议开关页面 ===》 设置状态  ===》 返回协议审计页面 ===》 是否审计到的逻辑
    private void model1(LeftMenuPage page ,ProtocolButtonPage protocolButtonPage ) {
//        // 点击协议审计
//        page.protocolAudit();
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
//      page.protocolAudit();
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

    private void audit(String type ,String interfaceName , ProtocolAuditInfPage protocolAuditInfPage , ProtocolAuditTestCase protocolAuditTestCase ,WebDriver    driver) {
        // 获取远程测试用例列表
        List<String> remoteFileList = GetRemoteFileListUtil.getRemoteFileList(baseConfig.getRemoteHostAddress() + "/getFileList/" + protocolAuditTestCase.getProtocolName());
        if(remoteFileList == null || remoteFileList.isEmpty()) return;
        for (int i = 0; i < remoteFileList.size(); i++) {
            //初始 测试用例对象属性
            protocolAuditTestCase.setProtocolFileName(remoteFileList.get(i));
            protocolAuditTestCase.setTestType(type);
            protocolAuditTestCase.setProtocolResult(true);
            //查看最新审计记录的时间
            String lastTime = protocolAuditInfPage.findFirstNewestTime();
            Boolean result = RemoteSendPacketUtil.remoteSendPacket(baseConfig.getRemoteHostAddress()+"/sendPacket" ,  interfaceName , remoteFileList.get(i).replace("\\","/"));
            if(! result) {
                System.out.println("报文发送失败！");
                continue;
            }
            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            // 刷新界面 -- 刷新前睡7秒 -- 刷新后睡 3秒
            protocolAuditInfPage.clickProtocolRefresh();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            // 判断审计结果是否正确
            boolean flag = protocolAuditInfPage.findProtocol(protocolAuditTestCase.getProtocolName(), type, lastTime,driver);
            if(!flag){
                protocolAuditTestCase.setProtocolResult(false);
            }
            LogOutputUtil.saveLog(filePathConfig.getLogOutPath() , LogCreateUtil.createLog(protocolAuditTestCase.toString()));
        }
    }


}
