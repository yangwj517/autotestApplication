package emerson.wenjieyang.autotestapplication.pojo.securityaudit.page;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @BelongsProject : autotestApplication
 * @BelongsPackage : emerson.wenjieyang.autotestapplication.pojo.securityaudit
 * @Author : YWJ
 * @CreateTime : 2024-10-22  19:44
 * @Description : 安全审计登录实体类
 * @Version : 1.0
 */
public class LoginPage {

    // 安全警告页面
    // 高级
    private WebElement detailsButton;

    // 继续前往
    private WebElement proceedButton;

    // 用户名输入框
    @FindBy(id = "login_txtUserName")
    private WebElement nameInput;

    // 密码输入框
    @FindBy(id = "login_txtUserPassword")
    private WebElement passwordInput;

    // 登录按钮
    @FindBy(id = "login_btnLogin")
    private WebElement loginButton;

    // 隐藏的红色提示控件
    @FindBy(xpath = "/html/body/div/div[1]/div[1]/div[2]/div[4]")
    private WebElement logText;

    public boolean logTextIsDisplayed() {
        return logText.isDisplayed();
    }

    // 高级点击
    public void clickDetailsButton() {
        detailsButton.click();
    }

    // 继续前往点击
    public void clickProceedButton() {
        proceedButton.click();
    }

    // 按钮点击
    public void clickLoginButton() {
        loginButton.click();
    }


    // 用户名输入
    public void enterUserName(String userName) {
        nameInput.sendKeys(userName);
    }


    // 密码输入
    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public WebElement getDetailsButton() {
        return detailsButton;
    }

    // 安全警告页面处理
    public void securityAlarm() {
        clickDetailsButton();
        clickProceedButton();
    }


    // 判断是否存在安全警告页面
    public boolean isAtAlarm(WebDriver driver) {
        try {
            driver.findElement(By.id("details-button"));
            this.detailsButton = driver.findElement(By.id("details-button"));
            this.proceedButton = driver.findElement(By.id("proceed-link"));
            return true;
        } catch (NoSuchElementException e) {
            //e.printStackTrace();
            return false;
        }
    }

    public String getLogText() {
        return logText.getText();
    }

    /**
     * 构造函数
     */
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
