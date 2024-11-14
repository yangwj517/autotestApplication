package emerson.wenjieyang.autotestapplication.service;

import emerson.wenjieyang.autotestapplication.config.BaseConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;

/**
 * @className: CreateNewWebDriverService
 * @author: WenjieYang
 * @date: 2024/11/7 11:17
 * @Version: 1.0
 * @description: 注入此类 获取新的webdriver
 */
@Component
public class CreateNewWebDriverComponent {

    @Autowired
    private BaseConfig baseConfig;

    public WebDriver createNewWebDriver(int sleepTime) {
        ChromeOptions chromeOptions = new ChromeOptions();
        // 设置页面缩放比例为80%
        chromeOptions.addArguments("--force-device-scale-factor=0.7");
        System.setProperty("webdriver.chrome.driver", baseConfig.getChromeDriverPath());
        // 创建新的driver
        WebDriver driver = new ChromeDriver(chromeOptions);
        // 设置隐式等待
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sleepTime));
        driver.manage().window().maximize();
        return driver;
    }
}
