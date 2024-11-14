package emerson.wenjieyang.autotestapplication.pojo.securityaudit.page;

import emerson.wenjieyang.autotestapplication.pojo.securityaudit.testCase.AppWhiteListRuleTestCase;
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
 * @className: AppWhiteListRulePage
 * @author: WenjieYang
 * @date: 2024/11/13 16:32
 * @Version: 1.0
 * @description: 应用协议白名单规则
 */



public class AppWhiteListRulePage {
    
    // 新增按钮
    @FindBy(xpath = "//*[@id='netWhitelist_ind_btnAddShow']")
    private WebElement buttonNetWhitelistIndAdd;

    // 规则名称
    @FindBy(xpath = "/html/body/div[5]/div[2]/div/ul/li[1]/input")
    private WebElement ruleNameInput;

    // 描述
    @FindBy(xpath = "/html/body/div[5]/div[2]/div/ul/li[2]/input")
    private WebElement ruleDescInput;

    // 源IP地址
    @FindBy(xpath = "/html/body/div[5]/div[2]/div/ul/li[3]/input")
    private WebElement sourceIpInput;
    
    // 目的IP地址
    @FindBy(xpath = "/html/body/div[5]/div[2]/div/ul/li[4]/input")
    private WebElement targetIpInput;

    // 协议名称
    @FindBy(xpath = "//*[@id='protoList']")
    private WebElement protoList;

    // 新增
    @FindBy(xpath = "/html/body/div[5]/div[2]/div/div[1]/div[1]/button[1]")
    private WebElement addButton;

    // 删除
    @FindBy(xpath = "/html/body/div[5]/div[2]/div/div[1]/div[1]/button[2]")
    private WebElement delButton;

    // 创建
    @FindBy(xpath = "/html/body/div[5]/div[2]/div/div[2]/button[1]")
    private WebElement createButton;

    // 取消
    @FindBy(xpath = "//button[@class='btn btn-danger btn-sm']")
    private WebElement cancelButton;

    /*
    新增列表以 r_c 索引拼接格式作为新的一行 ， 比如第一行 第一个 0_0 , 第二行第一个 1_0
    所以不在外做出定义，直接在方法里操作。
     */



    public AppWhiteListRulePage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    /**
     * 此方法不仅需要接受用例，同时要知道这是第几个用例。还需要使用driver找到控件
     */
    private void setList1(Inf inf , int index,WebDriver driver) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // FIXME : 下拉框选择any时 ，程序会找不到。需要修复。
        // 仅需要知道是第几行就行了
        // 接口ID
        WebElement interfaceID = driver.findElement(By.cssSelector("select[data-idx='" + index + "_0']"));
        Select select = new Select(interfaceID);
        if(!inf.getInterfaceId().equals("any")&&!inf.getInterfaceId().isEmpty()){
            try{
                select.selectByVisibleText(inf.getInterfaceId());
            }catch (NoSuchElementException e){
            }
        }


        // 操作码
        WebElement actionCode = driver.findElement(By.cssSelector("select[data-idx='" + index + "_1']"));
        Select select1 = new Select(actionCode);
        if(!inf.getActionCode().equals("any")&&!inf.getActionCode().isEmpty()){
            try{
                select1.selectByVisibleText(inf.getActionCode());
            }catch (NoSuchElementException e){}
        }


        // 块类型
        WebElement partType = driver.findElement(By.cssSelector("select[data-idx='" + index + "_2']"));
        Select select2 = new Select(partType);
        if(!inf.getPartType().equals("any")&&!inf.getPartType().isEmpty()){
            try{
                select2.selectByVisibleText(inf.getPartType());
            }catch (NoSuchElementException e){}
        }


        // 描述
        WebElement desc = driver.findElement(By.cssSelector("select[data-idx='" + index + "_3']"));
        desc.sendKeys(inf.getDesc());

    } // PROFINET-IO
    private void setList2(Inf inf , int index,WebDriver driver) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // FIXME : 下拉框选择any时 ，程序会找不到。需要修复。
        // 仅需要知道是第几行就行了
        // 接口ID
        WebElement interfaceID = driver.findElement(By.cssSelector("select[data-idx='" + index + "_0']"));
        Select select = new Select(interfaceID);
        if(!inf.getInterfaceId().equals("any")&&!inf.getInterfaceId().isEmpty()){
            try{
                select.selectByVisibleText(inf.getInterfaceId());
            }catch (NoSuchElementException e){
            }
        }


        // 操作码
        WebElement actionCode = driver.findElement(By.cssSelector("select[data-idx='" + index + "_1']"));
        Select select1 = new Select(actionCode);
        if(!inf.getActionCode().equals("any")&&!inf.getActionCode().isEmpty()){
            try{
                select1.selectByVisibleText(inf.getActionCode());
            }catch (NoSuchElementException e){}
        }


        // 块类型
        WebElement partType = driver.findElement(By.cssSelector("select[data-idx='" + index + "_2']"));
        Select select2 = new Select(partType);
        if(!inf.getPartType().equals("any")&&!inf.getPartType().isEmpty()){
            try{
                select2.selectByVisibleText(inf.getPartType());
            }catch (NoSuchElementException e){}
        }


        // 描述
        WebElement desc = driver.findElement(By.cssSelector("select[data-idx='" + index + "_3']"));
        desc.sendKeys(inf.getDesc());

    } // Modbus-TCP


    /**
     * 创建确认
     */
    private void clickCreateButton() {
        createButton.click();
    }

    /**
     * 列表新增
     */
    private void clickAddButton() {
        addButton.click();
    }

    /**
     * 选择协议
     */
    private void selectProtocol(String protocol) {
        Select select = new Select(protoList);
        try{
            select.selectByVisibleText(protocol);
        }catch(Exception e){}// 报错跳过
    }
    
    /**
     * 目的IP
     */
    private void enterTargetIpInput(String ip){
        targetIpInput.sendKeys(ip);
    }

    /**
     * 输入源Ip
     */
    private void enterSourceIpInput(String ip) {
        sourceIpInput.sendKeys(ip);
    }

    /**
     * 输入描述
     */
    private void enterRuleDescInput(String ruleDesc) {
        ruleDescInput.sendKeys(ruleDesc);
    }

    /**
     * 输入规则名称
     */
    private void enterRuleNameInput(String ruleName) {
        ruleNameInput.sendKeys(ruleName);
    }

    /**
     * 点击新增按钮
     */
    private void clickButtonNetWhitelistIndAdd() {
        buttonNetWhitelistIndAdd.click();
    }

    /**
     * 新增测试用例  FIXME : 缺少弹窗处理，待添加
     * @param ruleTestCase
     * @return
     */
    public AppWhiteListRuleTestCase createNewAppWhiteListRuleTestCase(AppWhiteListRuleTestCase ruleTestCase,WebDriver driver) {
        clickButtonNetWhitelistIndAdd();
        enterRuleNameInput(ruleTestCase.getRuleName());
        enterRuleDescInput(ruleTestCase.getRuleDesc());
        enterSourceIpInput(ruleTestCase.getSourceIp());
        enterTargetIpInput(ruleTestCase.getTargetIp());
        selectProtocol(ruleTestCase.getProtocolName());
        List<Inf> list = ruleTestCase.getList();
        for (int i = 0; i <list.size() ; i++) {
            clickAddButton();
            // 填写表格内容
            setList1(list.get(i),i,driver);
        }
        return ruleTestCase;
    }



}
