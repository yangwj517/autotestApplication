package emerson.wenjieyang.autotestapplication.pojo.securityaudit.page;

import emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol.ProFinetIo;
import emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol.baseInterface.ProtocolBaseInterface;
import emerson.wenjieyang.autotestapplication.pojo.securityaudit.testCase.AppWhiteListRuleTestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    private static final Logger logger = LoggerFactory.getLogger(AppWhiteListRulePage.class);

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

    public AppWhiteListRulePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    /**
     * 设置列表项
     */
    private void setListItem(ProFinetIo proFinetIo, int index, WebDriver driver) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // 接口ID
        setSelectValue(driver, "select[data-idx='" + index + "_0']", proFinetIo.getInterfaceId());

        // 操作码
        setSelectValue(driver, "select[data-idx='" + index + "_1']", proFinetIo.getActionCode());

        // 块类型
        setSelectValue(driver, "select[data-idx='" + index + "_2']", proFinetIo.getPartType());

        // 描述
        sendKeysToElement(driver, "select[data-idx='" + index + "_3']", proFinetIo.getDesc());
    }

    /**
     * 设置下拉框值
     */
    private void setSelectValue(WebDriver driver, String cssSelector, String value) {
        if (!value.equals("any") && !value.isEmpty()) {
            try {
                WebElement element = driver.findElement(By.cssSelector(cssSelector));
                Select select = new Select(element);
                select.selectByVisibleText(value);
            } catch (NoSuchElementException e) {
                logger.warn("Element not found for selector: {}", cssSelector);
            }
        }
    }

    /**
     * 发送文本到元素
     */
    private void sendKeysToElement(WebDriver driver, String cssSelector, String value) {
        try {
            WebElement element = driver.findElement(By.cssSelector(cssSelector));
            element.sendKeys(value);
        } catch (NoSuchElementException e) {
            logger.warn("Element not found for selector: {}", cssSelector);
        }
    }

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
        try {
            select.selectByVisibleText(protocol);
        } catch (Exception e) {
            logger.warn("Protocol not found: {}", protocol);
        }
    }

    /**
     * 目的IP
     */
    private void enterTargetIpInput(String ip) {
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
     * 新增测试用例
     * @param ruleTestCase
     * @param driver
     * @return
     */
    public AppWhiteListRuleTestCase createNewAppWhiteListRuleTestCase(AppWhiteListRuleTestCase ruleTestCase, WebDriver driver) {
        clickButtonNetWhitelistIndAdd();
        enterRuleNameInput(ruleTestCase.getRuleName());
        enterRuleDescInput(ruleTestCase.getRuleDesc());
        enterSourceIpInput(ruleTestCase.getSourceIp());
        enterTargetIpInput(ruleTestCase.getTargetIp());
        selectProtocol(ruleTestCase.getProtocolName());
        List<ProtocolBaseInterface> list = ruleTestCase.getProtocolList();
        for (int i = 0; i < list.size(); i++) {
            clickAddButton();
            // 填写表格内容
            setListItem((ProFinetIo) list.get(i), i, driver);
        }
        return ruleTestCase;
    }
}
