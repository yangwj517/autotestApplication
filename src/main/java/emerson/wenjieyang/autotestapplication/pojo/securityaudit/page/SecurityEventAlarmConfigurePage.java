package emerson.wenjieyang.autotestapplication.pojo.securityaudit.page;

import emerson.wenjieyang.autotestapplication.pojo.securityaudit.testCase.AlarmConfigureTestCase;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

/**
 * @className: SecurityEventAlarmConfigurePage
 * @author: WenjieYang
 * @date: 2024/11/13 11:12
 * @Version: 1.0
 * @description: 安全事件告警配置页面 实体类
 */

public class SecurityEventAlarmConfigurePage {

    // 新增
    @FindBy(css = "button[data-id='associate_rule_btnAdd']")
    private WebElement buttonAssociateRuleAdd;

    // 规则名称
    @FindBy(xpath = "/html/body/div[5]/div[2]/div/ul/li[1]/input")
    private WebElement ruleNameInput;

    // 源地址
    @FindBy(xpath = "/html/body/div[5]/div[2]/div/ul/li[2]/input")
    private WebElement sourceAddressInput;

    // 源端口
    @FindBy(xpath = "/html/body/div[5]/div[2]/div/ul/li[3]/input")
    private WebElement sourcePortInput;
    
    // 目的地址
    @FindBy(xpath = "/html/body/div[5]/div[2]/div/ul/li[4]/input")
    private WebElement targetAddressInput;

    // 目的端口
    @FindBy(xpath = "/html/body/div[5]/div[2]/div/ul/li[5]/input")
    private WebElement targetPortInput;

    // 间隔时间
    @FindBy(xpath = "/html/body/div[5]/div[2]/div/ul/li[6]/input")
    private WebElement timeInput;

    // 事件级别
    @FindBy(xpath = "/html/body/div[5]/div[2]/div/ul/li[7]/select")
    private WebElement eventLevel;

    // 关联事件次数
    @FindBy(xpath = "//input[@min='1']")
    private WebElement eventCount;

    // 关联事件描述
    @FindBy(xpath = "//input[@maxlength='128']")
    private WebElement ruleDesc;

    // 新增弹出框 确认按钮
    @FindBy(xpath = "//button[@class='btn btn-primary']")
    private WebElement buttonPrimary;

    // 新增弹出框 取消按钮
    @FindBy(xpath = "//button[@class='btn btn-danger']")
    private WebElement buttonDanger;

    // 红色文本提示信息
    @FindBy(xpath = "//span[@class='tips']")
    private WebElement spanTips;

    // 消息弹出框容器
    @FindBy(xpath = "//div[contains(@class, 'layui-layer-dialog')]")
    private WebElement divLayer;

    // 消息弹出框 文本
    @FindBy(xpath = "//div[contains(@class, 'layui-layer-padding')]")
    private WebElement divLayerText;

    // 消息弹出框 确认按键
    @FindBy(xpath = "//a[@class='layui-layer-btn0']")
    public WebElement divLayerEnsure;
    
    
    
    

    /**
     * 构造函数，实例化 事件告警配置页面
     * @param driver 浏览器驱动
     */
    public SecurityEventAlarmConfigurePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    /**
     * 判断弹出框是否出现
     */
    private boolean checkDivLayerIsDisplayed() {
        try{
            return divLayer.isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }
    }

    /**
     * 获取弹出框文本
     */
    private String getDivLayerText(){
        return divLayerText.getText();
    }

    /**
     * 点击弹出框确认按钮
     */
    private void clickDivLayerEnsure(){
        divLayerEnsure.click();
    }

    /**
     * 处理红色文本
     */
    private boolean checkSpanTipsIsDisplayed() {
        try{
            return spanTips.isDisplayed() ;
        }catch (NoSuchElementException e){
            return false ;
        }
    }

    /**
     * 点击取消创建按钮
     */
    private void clickButtonDanger() {
        buttonDanger.click();
    }

    /**
     * 点击确认创建
     */
    private void clickButtonPrimary() {
        buttonPrimary.click();
    }

    /**
     * 输入关联事件描述
     */
    private void enterRuleDesc(String ruleDesc) {
        this.ruleDesc.sendKeys(ruleDesc);
    }

    /**
     * 输入事件次数
     */
    private void enterEventCount(String eventCount){
        this.eventCount.sendKeys(eventCount);
    }

    /**
     * 选择事件级别
     */
    private void selectEventLevel(String eventLevel) {
        Select select = new Select(this.eventLevel);
        try{
            select.selectByVisibleText(eventLevel); 
        }catch (Exception e){} // 出错跳过 -- 严格意义上来说，不可能出错。除非测试用例有问题  FIXME：是否有必要修改为测试用例检测。
    }

    /**
     * 输入间隔时间
     */
    private void enterTimeInput(String time) {
        timeInput.sendKeys(time);
    }
    
    /**
     * 输入目的端口
     */
    private void enterTargetPortInput(String targetPort) {
        targetPortInput.sendKeys(targetPort);
    }

    /**
     * 输入目的地址
     */
    private void enterTargetAddressInput(String targetAddress) {
        targetAddressInput.sendKeys(targetAddress);
    }

    /**
     * 输入源端口
     */
    private void enterSourcePortInput(String sourcePort) {
        sourcePortInput.sendKeys(sourcePort);
    }

    /**
     * 输入源地址
     */
    private void enterSourceAddressInput(String sourceAddress) {
        sourceAddressInput.sendKeys(sourceAddress);
    }

    /**
     *  输入规则名
     */
    private void enterRuleNameInput(String ruleName) {
        ruleNameInput.sendKeys(ruleName);
    }

    /**
     * 点击新增
     */
    private void clickButtonAssociateRuleAdd() {
        buttonAssociateRuleAdd.click();
    }

    // TODO : 还需添加弹窗处理


    /**
     * 新增事件告警配置。
     */
    public AlarmConfigureTestCase createNewAlarmConfigureTestCase(AlarmConfigureTestCase alarmConfigureTestCase) {
        alarmConfigureTestCase.setResult(true);
        // 点击新增
        clickButtonAssociateRuleAdd();
        // 输入规则名
        enterRuleNameInput(alarmConfigureTestCase.getRuleName());
        // 输入源地址
        enterSourceAddressInput(alarmConfigureTestCase.getSourceAddress());
        // 输入源端口
        enterSourcePortInput(alarmConfigureTestCase.getSourcePort());
        // 输入目的地址
        enterTargetAddressInput(alarmConfigureTestCase.getTargetAddress());
        // 输入目的端口
        enterTargetPortInput(alarmConfigureTestCase.getTargetPort());
        // 输入间隔时间
        enterTimeInput(alarmConfigureTestCase.getTimeInterval());
        // 选择事件级别
        selectEventLevel(alarmConfigureTestCase.getEventLevel());
        // 输入关联时间次数
        enterEventCount(alarmConfigureTestCase.getEventCount());
        // 输入关联事件描述
        enterRuleDesc(alarmConfigureTestCase.getRuleDesc());
        // 点击确定
        clickButtonPrimary();
        // 处理红色提示文本信息
        spanTipsSolution(alarmConfigureTestCase);
        // 处理弹窗
        popUpWindowSolution(alarmConfigureTestCase);
        return  alarmConfigureTestCase;
    }

    private void spanTipsSolution(AlarmConfigureTestCase alarmConfigureTestCase) {
        if(checkSpanTipsIsDisplayed()){
            alarmConfigureTestCase.setMsg(spanTips.getText());
            alarmConfigureTestCase.setResult(false);
            // 点击取消
            clickButtonDanger();
        }
    }
    
    private void  popUpWindowSolution(AlarmConfigureTestCase alarmConfigureTestCase) {
        if(checkDivLayerIsDisplayed()){
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            String divLayerText1 = getDivLayerText();
            alarmConfigureTestCase.setMsg(divLayerText1);

            // 关闭弹窗
            clickDivLayerEnsure();
            if(divLayerText1.contains("成功")) return;
            alarmConfigureTestCase.setResult(false);
            clickButtonDanger();
        }
    }
}
