package emerson.wenjieyang.autotestapplication.pojo.securityaudit.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @className: AuditPage
 * @author: WenjieYang
 * @date: 2024/10/25 14:04
 * @Version: 1.0
 * @description: 左侧菜单栏实体类，进行页面跳转时，可实例化此类操作
 */

public class LeftMenuPage {
    
    // css 选择器定位 好像是 看起来不太好定位   , 这里使用 xpath 定位
    
    // 系统总览选项
    @FindBy(xpath = "//span[contains(@onclick, \"'系统总览')\")]")
    private WebElement systemOverview;

    // 安全事件
    @FindBy(xpath = "/html/body/div[3]/div[1]/ul/li[2]/span")
    private WebElement securityEvent;

    // 事件信息
    @FindBy(xpath = "//li[contains(@onclick, \"'安全事件')\")]")
    private WebElement eventInformation;

    // 事件分析
    @FindBy(xpath = "//li[contains(@onclick, \"'事件分析')\")]")
    private WebElement eventAnalysis;
    
    // 告警配置
    @FindBy(xpath = "//li[contains(@onclick, \"'告警配置')\")]")
    private WebElement alarmConfiguration;

    // 关键事件
    @FindBy(xpath = "/html/body/div[3]/div[1]/ul/li[3]/span")
    private WebElement keyEvent;

    // 异常指令事件
    @FindBy(xpath = "//li[contains(@onclick, \"'异常指令事件')\")]")
    private WebElement exceptionInstruction;
    
    // 关键操作事件
    @FindBy(xpath = "//li[contains(@onclick, \"'关键操作事件')\")]")
    private WebElement keyOperationalEvent;

    // 关键事件配置
    @FindBy(xpath = "//li[contains(@onclick, \"'关键事件配置')\")]")
    private WebElement keyEventConfiguration;

    // 规则管理
    @FindBy(xpath = "/html/body/div[3]/div[1]/ul/li[4]/span")
    private WebElement ruleManagement;

    // 规则学习
    @FindBy(xpath = "//li[contains(@onclick, \"'规则学习')\")]")
    private WebElement ruleStudy;

    // 白名单规则
    @FindBy(xpath = "//li[contains(@onclick, \"'白名单规则')\")]")
    private WebElement whitelistRules;

    // 漏洞库
    @FindBy(xpath = "//li[contains(@onclick, \"'漏洞库')\")]")
    private WebElement vulnerabilityLibrary;

    // IP/MAC
    @FindBy(xpath = "//li[contains(@onclick, \"'IP/MAC')\")]")
    private WebElement ipAndMacAddress;

    // MAC地址过滤
    @FindBy(xpath = "//li[contains(@onclick, \"'MAC_FILTER')\")]")
    private WebElement macAddressFilter;

    // 服务器非法外联
    @FindBy(xpath = "//li[contains(@onclick, \"'服务器非法外联')\")]")
    private WebElement illegalExternalConnectToServer;

    // 断线重连检测
    @FindBy(xpath = "//li[contains(@onclick, \"'断连重连检测')\")]")
    private WebElement disconnectionAndReConnectionDetection;

    // 协议审计
    @FindBy(xpath = "/html/body/div[3]/div[1]/ul/li[5]/span")
    private WebElement protocolAudit;

    // 审计信息
    @FindBy(xpath = "//li[contains(@onclick, \"'协议列表')\")]")
    private WebElement auditInformation;

    // 审计策略
    @FindBy(xpath = "//li[contains(@onclick, \"'审计策略')\")]")
    private WebElement auditPolicy;

    
    // 自定义协议配置
    @FindBy(xpath = "//li[contains(@onclick, \"'协议模板配置')\")]")
    private WebElement customProtocolConfiguration;

    // 行为审计
    @FindBy(xpath = "//span[contains(@onclick, \"'行为审计')\")]")
    private WebElement behaviorAudit;

    
    // 流量监控
    @FindBy(xpath = "//span[contains(@onclick, \"'流量监控')\")]")
    private WebElement trafficMonitoring;

    // 威胁感知
    @FindBy(xpath = "/html/body/div[3]/div[1]/ul/li[8]/span")
    private WebElement threatPerception;

    // 威胁流信息
    @FindBy(xpath = "//li[contains(@onclick, \"'威胁流信息')\")]")
    private WebElement threatFlowInformation;

    // 分析配置
    @FindBy(xpath = "//li[contains(@onclick, \"'分析配置')\")]")
    private WebElement analyzeConfiguration;

    // 入侵检测
    @FindBy(xpath = "/html/body/div[3]/div[1]/ul/li[9]/span")
    private WebElement intrusionDetection;

    // 规则库
    @FindBy(xpath = "//li[contains(@onclick, \"'规则库')\")]")
    private WebElement ruleBase;

    // 时间对象
    @FindBy(xpath = "//li[contains(@onclick, \"'时间对象')\")]")
    private WebElement timeObject;

    // 地址对象
    @FindBy(xpath = "//li[contains(@onclick, \"'地址对象')\")]")
    private WebElement addressObject;

    // 规则集
    @FindBy(xpath = "//li[contains(@onclick, \"'规则集')\")]")
    private WebElement rulesets;

    // 检测策略
    @FindBy(xpath = "//li[contains(@onclick, \"'检测策略')\")]")
    private WebElement detectionPolicy;

    // 入侵日志
    @FindBy(xpath = "//li[contains(@onclick, \"'入侵日志')\")]")
    private WebElement intrusionLog;

    // 攻击防护
    @FindBy(xpath = "/html/body/div[3]/div[1]/ul/li[10]/span")
    private WebElement attackProtection;

    // 攻击防护配置
    @FindBy(xpath = "//li[contains(@onclick, \"'攻击防护配置')\")]")
    private WebElement attackProtectionConfiguration;

    // 攻击防护日志
    @FindBy(xpath = "//li[contains(@onclick, \"'攻击防护日志')\")]")
    private WebElement attackProtectionLog;

    // 设备日志
    @FindBy(xpath = "//span[contains(@onclick, \"'日志信息')\")]")
    private WebElement deviceLog;

    // 日志采集
    @FindBy(xpath = "//span[contains(@onclick, \"'采集查询')\")]")
    private WebElement logCollection;

    // 资产管理
    @FindBy(xpath = "/html/body/div[3]/div[1]/ul/li[13]/span")
    private WebElement assetManagement;

    // 终端设备管理
    @FindBy(xpath = "//li[contains(@onclick, \"'终端设备管理')\")]")
    private WebElement terminalDeviceManagement;

    // 交换机管理
    @FindBy(xpath = "//li[contains(@onclick, \"'交换机管理')\")]")
    private WebElement swManagement;

    // Ghost 主机信息
    @FindBy(xpath = "//li[contains(@onclick, \"'ghost主机信息')\")]")
    private WebElement ghostInformation;

    // 分中心信息
    @FindBy(xpath = "//span[contains(@onclick, \"'分中心信息')\")]")
    private WebElement subCenterInformation;

    // 报告管理
    @FindBy(xpath = "/html/body/div[3]/div[1]/ul/li[15]/span")
    private WebElement reportManagement;

    // 事件报告
    @FindBy(xpath = "//li[contains(@onclick, \"'事件')\")]")
    private WebElement eventReport;

    // 日志报告
    @FindBy(xpath = "//li[contains(@onclick, \"'日志')\")]")
    private WebElement logReport;

    // 审计报告
    @FindBy(xpath = "//li[contains(@onclick, \"'审计')\")]")
    private WebElement auditReport;

    // 资产报告
    @FindBy(xpath = "//li[contains(@onclick, \"'资产')\")]")
    private WebElement assetReport;

    // 系统管理
    @FindBy(xpath = "/html/body/div[3]/div[1]/ul/li[16]/span")
    private WebElement systemManagement;

    // 授权许可
    @FindBy(xpath = "//li[contains(@onclick, \"'lisence授权')\")]")
    private WebElement license;

    // 设备配置
    @FindBy(xpath = "//li[contains(@onclick, \"'设备配置')\")]")
    private WebElement deviceConfiguration;

    // 系统配置
    @FindBy(xpath = "//li[contains(@onclick, \"'系统配置')\")]")
    private WebElement systemConfiguration;

    // 流量回溯
    @FindBy(xpath = "//li[contains(@onclick, \"'流量回溯')\")]")
    private WebElement trafficBacktracking;

    // 系统调试
    @FindBy(xpath = "//li[contains(@onclick, \"'系统调试')\")]")
    private WebElement systemDebug;

    // 数据备份与恢复
    @FindBy(xpath = "//li[contains(@onclick, \"'数据备份与恢复')\")]")
    private WebElement dataSaveAndRecover;

    // 用户配置
    @FindBy(xpath = "//li[contains(@onclick, \"'用户配置')\")]")
    private WebElement userConfiguration;

    public void systemOverview(){
        systemOverview.click();
    }

    public void securityEvent(){
        securityEvent.click();
    }

    public void eventInformation(){
        eventInformation.click();
    }

    public void eventAnalysis(){
        eventAnalysis.click();
    }

    public void alarmConfiguration(){
        alarmConfiguration.click();
    }

    public void keyEvent(){
        keyEvent.click();
    }

    public void exceptionInstruction(){
        exceptionInstruction.click();
    }

    public void keyOperationalEvent(){
        keyOperationalEvent.click();
    }

    public void keyEventConfiguration(){
        keyEventConfiguration.click();
    }

    public void ruleManagement(){
        ruleManagement.click();
    }

    public void ruleStudy(){
        ruleStudy.click();
    }

    public void whitelistRules(){
        whitelistRules.click();
    }

    public void vulnerabilityLibrary(){
        vulnerabilityLibrary.click();
    }

    public void ipAndMacAddress(){
        ipAndMacAddress.click();
    }

    public void macAddressFilter(){
        macAddressFilter.click();
    }

    public void illegalExternalConnectToServer(){
        illegalExternalConnectToServer.click();
    }

    public void disconnectionAndReConnectionDetection(){
        disconnectionAndReConnectionDetection.click();
    }

    public void protocolAudit(){
        protocolAudit.click();
    }

    public void auditInformation(){
        auditInformation.click();
    }

    public void auditPolicy(){
        auditPolicy.click();
    }

    public void customProtocolConfiguration(){
        customProtocolConfiguration.click();
    }

    public void behaviorAudit(){
        behaviorAudit.click();
    }

    public void trafficMonitoring(){
        trafficMonitoring.click();
    }

    public void threatPerception(){
        threatPerception.click();
    }

    public void threatFlowInformation(){
        threatFlowInformation.click();
    }

    public void analyzeConfiguration(){
        analyzeConfiguration.click();
    }

    public void intrusionDetection(){
        intrusionDetection.click();
    }

    public void ruleBase(){
        ruleBase.click();
    }

    public void timeObject(){
        timeObject.click();
    }

    public void addressObject(){
        addressObject.click();
    }

    public void rulesets(){
        rulesets.click();
    }

    public void detectionPolicy(){
        detectionPolicy.click();
    }

    public void intrusionLog(){
        intrusionLog.click();
    }

    public void attackProtection(){
        attackProtection.click();
    }

    public void attackProtectionConfiguration(){
        attackProtectionConfiguration.click();
    }

    public void attackProtectionLog(){
        attackProtectionLog.click();
    }

    public void deviceConfiguration(){
        deviceConfiguration.click();
    }

    public void systemConfiguration(){
        systemConfiguration.click();
    }

    public void trafficBacktracking(){
        trafficBacktracking.click();
    }

    public void systemDebug(){
        systemDebug.click();
    }

    public void dataSaveAndRecover(){
        dataSaveAndRecover.click();
    }

    public void userConfiguration(){
        userConfiguration.click();
    }

    public void deviceLog(){
        deviceLog.click();
    }

    public void logCollection(){
        logCollection.click();
    }

    public void assetManagement(){
        assetManagement.click();
    }

    public void terminalDeviceManagement(){
        terminalDeviceManagement.click();
    }

    public void swManagement(){
        swManagement.click();
    }

    public void ghostInformation(){
        ghostInformation.click();
    }

    public void subCenterInformation(){
        subCenterInformation.click();
    }

    public void reportManagement(){
        reportManagement.click();
    }

    public void eventReport(){
        eventReport.click();
    }

    public void logReport(){
        logReport.click();
    }

    public void auditReport(){
        auditReport.click();
    }

    public void assetReport(){
        assetReport.click();
    }

    public void systemManagement(){
        systemManagement.click();
    }

    public void license(){
        license.click();
    }

    public LeftMenuPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }


}
