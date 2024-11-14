package emerson.wenjieyang.autotestapplication.service.securityaudit;

import emerson.wenjieyang.autotestapplication.config.BaseConfig;
import emerson.wenjieyang.autotestapplication.pojo.Response;
import emerson.wenjieyang.autotestapplication.pojo.securityaudit.page.LogOffPage;
import emerson.wenjieyang.autotestapplication.pojo.securityaudit.page.LoginPage;
import emerson.wenjieyang.autotestapplication.pojo.securityaudit.testCase.LoginTestCase;
import emerson.wenjieyang.autotestapplication.util.LogCreateUtil;
import emerson.wenjieyang.autotestapplication.util.LogOutputUtil;
import emerson.wenjieyang.autotestapplication.util.RespondUtil;
//import emerson.wenjieyang.autotestapplication.util.TestCaseLoadUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;

/**
 * @BelongsProject : autotestApplication
 * @BelongsPackage : emerson.wenjieyang.autotestapplication.securityaudit.service
 * @Author : YWJ
 * @CreateTime : 2024-10-22  19:08
 * @Description : 可行性测试服务层
 * @Version : 1.0
 */

// 账号已经被锁定，请稍后再试    --  判断是否被冻结

@Service
public class LoginService {


    @Autowired
    private BaseConfig config;


    // 创建Driver
    private WebDriver createNewDriver(){
        System.setProperty("webdriver.chrome.driver", config.getChromeDriverPath());
        // 创建新的driver
        WebDriver driver = new ChromeDriver();
        // 设置隐式等待
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        return driver;
    }

    // 登录功能测试
    public void loginTest(String testCasePath,String logOutPath){
        WebDriver driver = createNewDriver();
        List<LoginTestCase> list = new LoginTestCase().getLoginTestCaseList(testCasePath);
        for (int i = 0; i < list.size(); i++) {
            boolean flag = false; // 页面跳转标识
            // 获取用例对象
            LoginTestCase loginTestCase = list.get(i);
            // 清除所有cookies
            driver.manage().deleteAllCookies();
            // 访问安全审计
            driver.get(config.getSecurityAuditUrl());
            // 拿到登陆页面对象
            LoginPage loginPage = new LoginPage(driver);
            // 拿到首页页面对象
            LogOffPage logOffPage = new LogOffPage(driver);
            // 处理安全警告页面
            if(loginPage.isAtAlarm(driver)){
                loginPage.securityAlarm();
            }
            // 账号输入
            loginPage.enterUserName(loginTestCase.getLoginName());
            // 密码输入
            loginPage.enterPassword(loginTestCase.getPassword());
            // 点击登录
            loginPage.clickLoginButton();
            // 如果隐藏提示框出现
            if(loginPage.logTextIsDisplayed()){
                loginTestCase.setActionMsg(loginPage.getLogText()) ;
            }
            // 此处需要判断是否登录成功，并将结果写入到日志文件中
            String log ;
            // 判断是否已经跳转到首页
            try {
                if (logOffPage.isLogOff()) {
                    // 下线控件存在，则设定页面跳转标识为true
                    flag = true;
                }
            }catch (Exception e){
                //e.printStackTrace();
                System.out.println("没找到下线控件，没登陆成功！");
            }
            if(flag){
                //此时登录成功，写入日志并登出
                loginTestCase.setResult("登录成功！");
                if(!loginTestCase.getExpectedResult()) loginTestCase.setFlag(false);
                else loginTestCase.setFlag(true);
                log = LogCreateUtil.createLog(loginTestCase.toString()) ;
                LogOutputUtil.saveLog(logOutPath,log) ;
                logOffPage.logOff();
            }else {
                loginTestCase.setResult("登录失败！");
                if(loginTestCase.getExpectedResult()) loginTestCase.setFlag(false);
                else loginTestCase.setFlag(true);
                log = LogCreateUtil.createLog(loginTestCase.toString()) ;
                LogOutputUtil.saveLog(logOutPath,log) ;
            }
        }
        try {
            Thread.sleep(2);
            // 强制等两秒 关闭驱动,释放所有资源
            driver.quit();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 调用此方法登入系统
     * @param loginName 用户名
     * @param password 密码
     * @param driver 驱动
     * @return 是否登录成功
     */
    public Response<Object> loginSystem(String loginName,String password,WebDriver driver){
        // 拿到登录页面对象
        LoginPage loginPage = new LoginPage(driver);

        // 处理安全警告页面
        if(loginPage.isAtAlarm(driver)){
            loginPage.securityAlarm();
        }

        // 输入用户名密码 -- 点击登录
        loginPage.enterUserName(loginName);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
        // 拿到登出按钮页面对象 -- 借此判断是否成功登录
        LogOffPage logOffPage = new LogOffPage(driver);

        try {
            if (logOffPage.isLogOff()) {
                // 下线控件存在，则设定页面跳转标识为true
                return RespondUtil.success("登陆成功！");
            }
            return RespondUtil.error("登录失败！");
        }catch (Exception e){
            //e.printStackTrace();
           // System.out.println("没找到下线控件，没登陆成功！");
            return RespondUtil.error("登录失败！");
        }
    }
}
