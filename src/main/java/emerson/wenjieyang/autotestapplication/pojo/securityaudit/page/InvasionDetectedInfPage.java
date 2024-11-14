package emerson.wenjieyang.autotestapplication.pojo.securityaudit.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @className: InvasionDetectedInfPage
 * @author: WenjieYang
 * @date: 2024/11/5 10:51
 * @Version: 1.0
 * @description: IDS入侵日志页面实体类
 */

public class InvasionDetectedInfPage {
    @FindBy(css = "button[id='intrussion_log_btnRefresh']")
    public WebElement buttonIntrussionLogRefresh;

    @FindBy(css = "tbody")
    public WebElement tbodySessionSetupUnicodeAsn;


    // 构造函数
    public InvasionDetectedInfPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // TODO : IDS入侵日志页面方法需要进一步补充完善


}
