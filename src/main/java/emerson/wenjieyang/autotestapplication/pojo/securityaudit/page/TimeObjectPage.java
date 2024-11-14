package emerson.wenjieyang.autotestapplication.pojo.securityaudit.page;

import emerson.wenjieyang.autotestapplication.pojo.securityaudit.testCase.TimeObjectTestCase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * @className: TimeObjectPage
 * @author: WenjieYang
 * @date: 2024/11/5 11:16
 * @Version: 1.0
 * @description:  IDS 时间对象  页面实体类 FIXME：有待完善 具体方法
 */

public class TimeObjectPage {
    // 新增
    @FindBy(css = "button[id='timelist_addId']")
    public WebElement buttonTimelistAdd;

    // 删除
    @FindBy(css = "button[id='timelist_deleteIds']")
    public WebElement buttonTimelistDeleteIds;

    // 表头
    @FindBy(css = "thead")
    public WebElement thead;

    // 表body
    @FindBy(css = "tbody")
    public WebElement tbodyTestIdsTimesheet;

    // 时间表类型
    @FindBy(css = "select[id='timelist_dialog_type']")
    public WebElement selectTimelistDialogType;

    // 时间表名称
    @FindBy(css = "input[id='timelist_dialog_name']")
    public WebElement inputTimelistDialogName;

    // 日期label公共前缀 0-6 代表 周天 - 周六
    private  final String[] label = {"label[for='timelist_dialog_date0']",
            "label[for='timelist_dialog_date1']",
            "label[for='timelist_dialog_date2']",
            "label[for='timelist_dialog_date3']",
            "label[for='timelist_dialog_date4']",
            "label[for='timelist_dialog_date5']",
            "label[for='timelist_dialog_date6']"
    };

    // 循环时间表开始时间
    @FindBy(css = "input[id='timelist_dialog_txtStartDateTime']")
    public WebElement inputTimelistDialogStartDate;
    
    // 循环时间表停止时间
    @FindBy(css = "input[id='timelist_dialog_txtEndDateTime']")
    public WebElement inputTimelistDialogEndDate;

    // 确认
    @FindBy(css = "button[class='btn btn-primary']")
    public WebElement buttonPrimary;

    // 取消
    @FindBy(css = "button[class='btn btn-danger']")
    public WebElement buttonDanger;

    // 单次时间表开始时间
    @FindBy(css = "input[id='timelist_dialog_txtStartDateTime_1']")
    public WebElement inputTimelistDialogStartDate2;

    // 单次时间表结束时间
    @FindBy(css = "input[id='timelist_dialog_txtEndDateTime_1']")
    public WebElement inputTimelistDialogEndDate2;

    // 添加操作 提示页面确认按钮
    @FindBy(css = "a[class='layui-layer-btn0']")
    public WebElement linkLayer;

    // 添加操作 提示框文本信息
    @FindBy(css = "div[class^='layui-layer-content']")
    public WebElement msg;




    public TimeObjectPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    /**
     * 点击新增
     */
    public void clickButtonTimelistAdd(){
        buttonTimelistAdd.click();
    }

    // 默认打开的是循环时间表, but we also can create a selector to do that ;
    /**
     * 时间表名称输入
     */
    public void enterTimeName(String value){
        inputTimelistDialogName.sendKeys(value);
    }

    /**
     * 开始时间选择
     */
    public void enterInputTimelistDialogStartDate(String value){
        inputTimelistDialogStartDate.sendKeys(value);

    }

    /**
     * 结束时间选择
     */
    public void enterInputTimelistDialogEndDate(String value){
        inputTimelistDialogEndDate.sendKeys(value);
    }

    /**
     * 确定键按下
     */
    public void clickButtonPrimary(){
        buttonPrimary.click();
    }

    /**
     * 取消键按下
     */
    public void clickButtonDanger(){
        buttonDanger.click();
    }

    /**
     * 循环周期设置 , 勾选测试用例中配置的日期
     */
    public void setLoopDate(int[] date , WebDriver driver){
        // TODO : 因为星期一 是默认勾选的，所以为了方便，每次进来之前首先应该关掉星期一
        driver.findElement(By.cssSelector(label[1])).click();
        for (int i = 0; i < date.length; i++) {
            System.out.println(label[date[i]]);
            driver.findElement(By.cssSelector(label[date[i]])).click();
        }
    }

    /**
     * 获取 操作提示信息
     */
    public String getMsg(){
        return msg.getText();
    }

    /**
     *循环时间表创建  FIXME : 还需添加关于测试日志存储的代码
     */
    public TimeObjectTestCase  createLoopTimesheet(TimeObjectTestCase testCase , WebDriver driver){
        // 点击新增
        this.clickButtonTimelistAdd() ;
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // 默认为循环时间表，所以不需要选择
        // 填写名称
        this.enterTimeName(testCase.getName());
        // 选择循环日期
        setLoopDate(testCase.getDate(), driver);
        // 填写开始时间、结束时间。
        this.enterInputTimelistDialogStartDate(testCase.getBeginTime());
        this.enterInputTimelistDialogEndDate(testCase.getEndTime());
        // 点击确定。
        this.clickButtonPrimary();
        // 如果不等待，页面信息就会瞬间被更改。
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //System.out.println(this.getMsg()); // 输出提示框信息。
        testCase.setMsg(this.getMsg());
        // 点击弹出框确定
        this.clickLinkLayer();
        return testCase ;
    }

    // 单词时间表  开始时间
    public void enterInputTimelistDialogStartDate2(String value){
        this.inputTimelistDialogStartDate2.sendKeys(value);
    }

    // 结束时间  结束时间
    public void enterInputTimelistDialogEndDate2(String value){
        this.inputTimelistDialogEndDate2.sendKeys(value);
    }

    /**
     * TODO 单次时间表创建
     */
    public TimeObjectTestCase createOnceTimesheet(TimeObjectTestCase testCase,WebDriver driver){
        // 点击新增
        this.clickButtonTimelistAdd() ;
        // 时间表类型切换
        this.changeTimeObjectType();
        // 名称
        this.enterTimeName(testCase.getName());
        // 时间格式与循环时间表不一样开始时间结束时间  “YYYY-MM-DD HH:MM” ,且 begin can‘t > end time
        this.enterInputTimelistDialogStartDate2(testCase.getBeginTime());
        try{
            // 等待 alert 弹窗出现
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            wait.until(ExpectedConditions.alertIsPresent());
            // 切换到 alert
            Alert alert = driver.switchTo().alert();
            // 获取 alert 文本
            System.out.println("Alert text: " + alert.getText());
            // 接受 alert
            alert.accept();
            // 直接点击取消 ， 此时已经无法完成创建
            this.clickButtonDanger();
        }catch (Exception e){}
        this.enterInputTimelistDialogEndDate2(testCase.getEndTime());
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert text: " + alert.getText());
            alert.accept();
            this.clickButtonDanger();
        }catch (Exception e){}
        // 点击确认
        this.clickButtonPrimary();
        // 睡一秒 ， 等待获取操作提示框信息
        // 如果不等待，页面信息就会瞬间被更改。
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //System.out.println(this.getMsg()); // 输出提示框信息。
        // 点击弹出框确定
        this.clickLinkLayer();
        return testCase ;
    }

    /**
     * 添加成功--点击确定
     */
    public void  clickLinkLayer(){
        linkLayer.click();
    }


    /**
     * 新建时间表 类型切换 , 单向切换 ，只能从默认换成非默认《完全够用》
     */
    public void changeTimeObjectType(){
        Select select =new Select(this.selectTimelistDialogType);
        select.selectByIndex(1);
    }

}
