package emerson.wenjieyang.autotestapplication.pojo.securityaudit.page;

import emerson.wenjieyang.autotestapplication.pojo.securityaudit.testCase.RuleSetTestCase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @className: RuleSetPage
 * @author: WenjieYang
 * @date: 2024/11/5 11:18
 * @Version: 1.0
 * @description: 规则集 页面实体类
 */

public class RuleSetPage {
    // 新增按钮
    @FindBy(css = "button[id='rulelist_addRule']")
    private WebElement buttonRulelistAddRule;

    // 删除按钮
    @FindBy(css = "button[id='rulelist_deleteRule']")
    private WebElement buttonRulelistDeleteRule;

    // 规则集表头
    @FindBy(css = "thead")
    private WebElement thead;

    // 全选
    @FindBy(xpath = "//label[@for='rulelist_selectAll']")
    public WebElement selectAll;

    // 规则集表body
    @FindBy(css = "tbody")
    private WebElement tbodyIdsTest;

    // 新增弹出框 -- 规则集名称
    @FindBy(css = "input[id='ruleDialogName']")
    private WebElement inputRuleDialogName;

    // 新增弹出框 -- 规则集描述
    @FindBy(css = "input[id='ruleDialogDesc']")
    private WebElement inputRuleDialogDesc;

    // 新增弹出框 -- 创建
    @FindBy(css = "button[class='btn btn-primary nextstep']")
    private WebElement buttonPrimaryNextstep;

    // 新增弹出框 -- 取消
    @FindBy(css = "button[class='btn btn-danger']")
    private WebElement buttonDanger;

    // 规则选择页面搜索框
    @FindBy(css = "#rulefilter_txtMacSearch")
    private WebElement inputRuleFilterMacSearch;

    // 规则选择页面搜索按钮
    @FindBy(css = "#rulefilter_btnSearch")
    private WebElement buttonRuleFilterSearch;

    // 规则选择页面 -- 规则类型下拉框
    @FindBy(css = "#rulelist_dialog_category")
    private WebElement inputRuleDialogCategory;

    // 表头
    @FindBy(css = "#rulelist_dialog_ruleSetList > thead")
    private WebElement theadRulesList;

    // 表body
    @FindBy(css = "#rulelist_dialog_ruleSetList > tbody")
    private WebElement tbodyRulesList;

    // 规则选择页面 -- 确定按钮
    @FindBy(css = "#rulelist_dialog_addruleDetail > div.button-box > button")
    private WebElement buttonEnsureRuleDetail;

    // 操作提示弹出框
    @FindBy(xpath = "//div[contains(@class, 'layui-layer-dialog')]")
    private WebElement divLayer;
    private boolean checkDivLayerIsDisplayed() {
        try{
            return divLayer.isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }
    }

    // 操作提示弹出框文本信息
    @FindBy(xpath = "//div[contains(@class, 'layui-layer-padding')]")
    private WebElement divLayerText;
    private String getDivLayerText(){
        return divLayerText.getText();
    }
    
    // 操作提示框 -- 确定按钮
    @FindBy(xpath = "//a[@class='layui-layer-btn0']")
    private WebElement divLayerEnsure;
    private void clickDivLayerEnsure(){
        divLayerEnsure.click();
    }

    // 操作提示框 -- 取消按钮
    @FindBy(xpath = "//a[@class='layui-layer-btn1']")
    private WebElement divLayerCancel;

    // 规则集新建页 全选
    @FindBy(css = "label[for='rulelist_dialog_selectAll']")
    private WebElement choiceAll;

    // 规则集新建页 确认
    @FindBy(css = "button[class='dia_confirm btn btn-primary']")
    public WebElement buttonConfirmPrimary;


    private void clickDivLayerCancel(){
        divLayerCancel.click();
    }

    // 构造函数
    public RuleSetPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }



    // FIXME : 还需进一步添加规则集合方法

    /**
     * 新增按钮点击
     */
    private void clickButtonRulelistAddRule(){
        buttonRulelistAddRule.click();
    }

    /**
     * 删除按钮点击
     */
    private void clickButtonRulelistDeleteRule(){
        buttonRulelistDeleteRule.click();
    }

    /**
     * 全选点击
     */
    private void clickSelectAll(){
        selectAll.click();
    }

    /**
     * 规则集名称填写
     */
    private void enterInputRuleDialogName(String value){
        inputRuleDialogName.sendKeys(value);
    }

    /**
     * 填写规则集描述
     */
    private void enterInputRuleDialogDesc(String value){
        inputRuleDialogDesc.sendKeys(value);
    }

    /**
     * 点击创建
     */
    private void clickButtonPrimaryNextstep(){
        buttonPrimaryNextstep.click();
    }

    /**
     * 点击取消
     */
    private void clickButtonDanger(){
        buttonDanger.click();
    }

    /**
     *  规则选择页面--搜素框内容填写
     */
    private void enterInputRuleFilterMacSearch(String value){
        inputRuleFilterMacSearch.sendKeys(value);
    }

    /**
     * 规则选择页面 -- 搜素按钮点击
     */
    private void clickButtonRuleFilterSearch(){
        buttonRuleFilterSearch.click();
    }

    /**
     * 规则选择页面 -- 下拉选择框 TODO：下拉选择框逻辑等待进一步完成
     */
    private void selectInputRuleDialogCategor(){

    }

    /**
     * 规则选择页面 -- 确定按钮
     */
    private void clickButtonEnsureRuleDetail(){
        buttonEnsureRuleDetail.click();
    }

    /**
     * 规则集新增页面全选
     */
    private void clickChoiceAll(){
        choiceAll.click();
    }

    /**
     * 规则集新增页面 确认
     */
    private void clickButtonConfirmPrimary(){
        buttonConfirmPrimary.click();
    }




    // 规则集新增逻辑 FIXME: 缺少消息弹框的处理逻辑，待补充
    public RuleSetTestCase creatNewRuleSetTest(RuleSetTestCase ruleSetTestCase,WebDriver driver){
        ruleSetTestCase.setResult(true);
        // 判断列表是否已满
        if(!isNotFull()) {
            ruleSetTestCase.setMsg("无法创建更多规则！请清理清理。");
            // 可以删除 ，但是删除可能出现 被引用的规则集无法删除，然后逻辑就会复杂，因此不写自动删除的方法。
            return ruleSetTestCase;
        }
        // 点击新增   ---- 此处可能有弹窗
        this.clickButtonRulelistAddRule();
        // 填写名称
        this.enterInputRuleDialogName(ruleSetTestCase.getName());
        // 填写描述
        this.enterInputRuleDialogDesc(ruleSetTestCase.getDesc());
        // 确认创建   ---- 此处可能有弹窗
        this.clickButtonPrimaryNextstep();
        RuleSetTestCase ruleSetTestCase1 = popUpWindowSolution(ruleSetTestCase);
        if(!ruleSetTestCase1.getResult()){
            // 取消新建
            this.clickButtonDanger();
            return ruleSetTestCase1;
        }
        // ===============    此时进入 选择页面  ===========================
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // 填写 索引字段 并搜素哦
        if(!ruleSetTestCase.getSelectInf().isEmpty()){
            this.enterInputRuleFilterMacSearch(ruleSetTestCase.getSelectInf());
            this.clickButtonRuleFilterSearch();
        }
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // 选择 用例对应的类型
        if(!ruleSetTestCase.getType().isEmpty()){
            Select select = new Select(this.inputRuleDialogCategory);
            select.selectByVisibleText(ruleSetTestCase.getType());
        }
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // 全选
        this.clickChoiceAll();
        // 确定
        // 未找到，向下滚动250个单位 ,防止按钮被覆盖ElementClickInterceptedException
        ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,250);");
        this.clickButtonConfirmPrimary();
        ruleSetTestCase.setMsg("规则集创建成功！");
        return ruleSetTestCase;
    }


    @Deprecated
    // 规则删除逻辑  -- 全选删除  -- 因为最大支持数量为5个
    public void deleteAllRules(){
        // 全选
        this.clickSelectAll();
        // 删除
        this.clickButtonEnsureRuleDetail();
        // 确认删除
        while (this.checkDivLayerIsDisplayed()){
            if(this.getDivLayerText().contains("删除")) this.clickDivLayerEnsure();
            else if(this.getDivLayerText().contains("不允许")) this.clickDivLayerEnsure();
            this.clickDivLayerCancel();
        }
    }

    // 判断规则是否已满
    private boolean isNotFull(){
        List<WebElement> elements = this.tbodyIdsTest.findElements(By.tagName("tr"));
        return elements.size() != 5;
    }

    // 弹窗处理
    private RuleSetTestCase popUpWindowSolution(RuleSetTestCase ruleSetTestCase){
        // 判断弹窗是否出现
        if(this.checkDivLayerIsDisplayed()){
            String text = this.getDivLayerText();
            ruleSetTestCase.setResult(false);
            ruleSetTestCase.setMsg(text);
            // 关闭弹窗
            this.clickDivLayerEnsure();
        }
        return ruleSetTestCase;
    }

}
