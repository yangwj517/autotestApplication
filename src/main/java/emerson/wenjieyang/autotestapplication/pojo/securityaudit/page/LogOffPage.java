package emerson.wenjieyang.autotestapplication.pojo.securityaudit.page;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @className: LogOff
 * @author: WenjieYang
 * @date: 2024/10/23 10:12
 * @Version: 1.0
 * @description: 实现登出页面实体类
 */

public class LogOffPage {

    // 登出控件
    @FindBy(xpath = "/html/body/div[2]/ul/li[3]/i")
    private WebElement logOffButton;

    public LogOffPage(WebDriver   driver) {
        PageFactory.initElements(driver, this);
    }

    // 点击登出控件
    public void clickLogOff() {
        logOffButton.click();
    }

    // 按钮存在
    public boolean isLogOff() {
        try{
            return logOffButton.isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }
        //return logOffButton != null && logOffButton.isDisplayed() && logOffButton.isEnabled();
    }


    // 登出
    public void logOff() {
        if(isLogOff()){
            clickLogOff();
        }
    }
}
