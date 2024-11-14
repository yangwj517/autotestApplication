package emerson.wenjieyang.autotestapplication;

import emerson.wenjieyang.autotestapplication.pojo.securityaudit.page.LeftMenuPage;
import emerson.wenjieyang.autotestapplication.pojo.securityaudit.page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

/**
 * @className: FindByTest
 * @author: WenjieYang
 * @date: 2024/10/25 14:09
 * @Version: 1.0
 * @description:
 */

public class FindByTest {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\software\\chromeDriver\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // 设置隐式等待
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        LeftMenuPage auditPage = PageFactory.initElements(driver, LeftMenuPage.class);
        driver.get("http://192.168.102.150");
        boolean atAlarm = loginPage.isAtAlarm(driver);
        if(atAlarm){
            loginPage.securityAlarm();
            //登录
            loginPage.enterUserName("ywj1");
            loginPage.enterPassword("020517ywJ@");
            loginPage.clickLoginButton();
            //auditPage.test();
            Thread.sleep(2);
        }
       driver.quit();
    }
}
