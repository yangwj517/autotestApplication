package emerson.wenjieyang.autotestapplication.pojo.securityaudit.page;

import emerson.wenjieyang.autotestapplication.pojo.securityaudit.testCase.DetectionPolicyTestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @className: DetectionPolicyPage
 * @author: WenjieYang
 * @date: 2024/11/5 11:19
 * @Version: 1.0
 * @description: 检测策略配置页实体类
 */


public class DetectionPolicyPage {

    // 新增
    @FindBy(css = "button[id='detectpolicy_btnAdd']")
    private WebElement buttonDetectpolicyAdd;

    // 删除
    @FindBy(css = "button[id='detectpolicy_btnDel']")
    private WebElement buttonDetectpolicyDel;

    // 启用规则
    @FindBy(css = "button[id='detectpolicy_btnEnableRule']")
    private WebElement buttonDetectpolicyEnableRule;

    // 禁用规则
    @FindBy(css = "button[id='detectpolicy_btnDisableRule']")
    private WebElement buttonDetectpolicyDisableRule;

    // 策略表头
    @FindBy(css = "thead")
    private WebElement thead;

    // 策略表body
    @FindBy(css = "tbody")
    private WebElement tbodyIdsTestAddressTestaddress;

    // 新增弹出框 -- 名称
    @FindBy(xpath = "//input[@maxlength='64']")
    private WebElement newPolicyName;

    // 新增弹出框 -- 描述
    @FindBy(xpath = "//input[@maxlength='128']")
    private WebElement newPolicyInf;

    // 新增弹出框 -- 时间选择下拉选择框
    @FindBy(xpath = "//*[@id='detectpolicy_adddialog_time_opt']")
    private WebElement selectDetectpolicyAdddialogTimeOpt;

    // 新增弹出框 -- 源地址 源地址选择下拉选择框
    @FindBy(xpath = "//*[@id='detectpolicy_adddialog_srcaddr_opt']")
    private WebElement selectDetectpolicyAdddialogOpt;

    // 新增弹出框 -- 目标地址
    @FindBy(xpath = "//*[@id='detectpolicy_adddialog_dstaddr_opt']")
    private WebElement selectDetectpolicyAdddialogOpt2;

    // 新增弹出框 -- 规则集
    @FindBy(xpath = "//*[@id='detectpolicy_adddialog_rule_opt']")
    private WebElement selectDetectpolicyAdddialogRuleOpt;

    // 新增弹出框 -- 确认
    @FindBy(xpath = "//button[@style='float:left']")
    private WebElement buttonEnsure;

    // 新增弹出框 -- 取消
    @FindBy(xpath = "//button[@style='float:right']")
    private WebElement buttonCancel;

    // 消息弹出框容器
    @FindBy(xpath = "//div[contains(@class, 'layui-layer-dialog')]")
    private WebElement divLayer;

    // 消息弹出框文本
    @FindBy(xpath = "//div[contains(@class, 'layui-layer-padding')]")
    private WebElement divLayerText;

    // 消息弹出框 -- 确定
    @FindBy(xpath = "//a[@class='layui-layer-btn0']")
    private WebElement divLayerEnsure;


    public DetectionPolicyPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    /**
     *点击新增按钮
     */
    private void clickButtonDetectpolicyAdd(){
        buttonDetectpolicyAdd.click();
    }

    /**
     * 名称
     */
    private void enterNewPolicyName(String newPolicyName){
        this.newPolicyName.sendKeys(newPolicyName);
    }

    /**
     * 描述
     */
    private void enterNewPolicyInf(String newPolicyInf){
        this.newPolicyInf.sendKeys(newPolicyInf);
    }

    /**
     * 选择时间对象
     */
    private void selectDetectpolicyAdddialogTimeOpt(String detectpolicyAdddialogTimeOpt){
        Select select = new Select(this.selectDetectpolicyAdddialogTimeOpt);
        select.selectByVisibleText(detectpolicyAdddialogTimeOpt);
    }

    /**
     * 选择源地址对象
     */
    private void selectDetectpolicyAdddialogOpt(String detectpolicyAdddialogOpt){
        if(detectpolicyAdddialogOpt.equals("any")||detectpolicyAdddialogOpt.isEmpty()) return ;
        Select select = new Select(this.selectDetectpolicyAdddialogOpt);
        select.selectByVisibleText(detectpolicyAdddialogOpt);
    }

    /**
     * 选择目标地址对象
     */
    public void selectDetectpolicyAdddialogOpt2(String detectpolicyAdddialogOpt2){
        if(detectpolicyAdddialogOpt2.equals("any")||detectpolicyAdddialogOpt2.isEmpty()) return ;
        Select select = new Select(this.selectDetectpolicyAdddialogOpt2);
        select.selectByVisibleText(detectpolicyAdddialogOpt2);
    }

    /**
     * 选择规则集
     */
    private void selectDetectpolicyAdddialogRuleOpt(String detectpolicyAdddialogRuleOpt){
        if(detectpolicyAdddialogRuleOpt.equals("any")||detectpolicyAdddialogRuleOpt.isEmpty()) return ;
        Select select = new Select(this.selectDetectpolicyAdddialogRuleOpt);
        select.selectByVisibleText(detectpolicyAdddialogRuleOpt);
    }

    /**
     * 新增弹出框 -- 确认
     */
    private void clickButtonEnsure(){
        this.buttonEnsure.click();
    }

    /**
     * 弹窗容器是否显示出来
     */
    private boolean divLayerIsDisplayed(){
        try{
            return this.divLayer.isDisplayed();
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }
        return false ;
    }

    /**
     * 弹窗文本信息 获取
     */
    private String getDivLayerText(){
        return this.divLayerText.getText();
    }

    /**
     * 弹窗 -- 确认按键
     */
    private void clickDivLayerEnsure(){
        this.divLayerEnsure.click();
    }

    /**
     * 新增页 取消按键按下
     */
    private void clickButtonCancel(){
        this.buttonCancel.click();
    }

    // TODO: IDS审计策略 方法需要进一步补充

    public DetectionPolicyTestCase createNewDetectionPolicy(DetectionPolicyTestCase testCase) {
        testCase.setResult(true);
        // 首先判断测策略个数是否已经==5个
        if(!isNotFull()){
            // 设置测试消息
            testCase.setMsg("策略列表已满，请先清理清理");
            // 设置结果为False
            testCase.setResult(false);
            // 直接返回
            return testCase;
        }
        // 点击新增
        this.clickButtonDetectpolicyAdd();
        // 填写名称
        this.enterNewPolicyName(testCase.getName());
        // 填写描述
        this.enterNewPolicyInf(testCase.getDesc());
        // 选择时间对象
        this.selectDetectpolicyAdddialogTimeOpt(testCase.getTimeName());
        // 选择源地址对象
        this.selectDetectpolicyAdddialogOpt(testCase.getSourceAddressName());
        // 选择目的地址对象
        this.selectDetectpolicyAdddialogOpt2(testCase.getTargetAddressName());
        // 选择规则集
        this.selectDetectpolicyAdddialogRuleOpt(testCase.getRuleName());
        // 点击确认
        this.clickButtonEnsure();
        popUpWindowSolution(testCase);
        return testCase;
    }

    private boolean isNotFull() {
        List<WebElement> elements = tbodyIdsTestAddressTestaddress.findElements(By.tagName("tr"));
        return elements.size()!=5 ;
    }


    // FIXME : 需要进一步补充 弹窗处理  目前仅能处理绝对正确的情况。
    private void popUpWindowSolution(DetectionPolicyTestCase testCase) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(divLayerIsDisplayed()){
            if(!getDivLayerText().contains("成功"))testCase.setResult(false);
            testCase.setMsg(getDivLayerText());
            // 关闭弹窗
            clickDivLayerEnsure();
            // 关闭新增页面
            try{
                clickButtonCancel();
            }catch (NoSuchElementException e){}
        }
    }

}
