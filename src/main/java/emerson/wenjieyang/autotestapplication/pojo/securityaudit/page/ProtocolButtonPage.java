package emerson.wenjieyang.autotestapplication.pojo.securityaudit.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @className: ProtocolButtonPage
 * @author: WenjieYang
 * @date: 2024/10/25 14:49
 * @Version: 1.0
 * @description: 协议开关   4中情况 ， 全开 -- 全关  -- 单开 -- 开一部分包含 -- 开一部分不包含
 */

public class ProtocolButtonPage {

    /**
     * 发现所有开关的都有公共前缀，比如http ==》 rabhttp ， ftp == 》 rabftp
     * 鉴于，后期协议增多，以及本身个数就很多，
     * 所以，编写了一个支持所有协议按钮点击的函数，只需要知道协议名称即可。
     */

    // 协议开关的公共前缀
    private final  String PRE_STR = "rab" ;

    // 支持的协议集合
    private  List<String> PROTOCOL_LIST;
    
    // 启动所有按钮
    @FindBy(css = "button[id='auditstrategy_manage_btnEnableAll']")
    public WebElement buttonAuditstrategyManageEnableAll;

    // 禁止所有按钮
    @FindBy(css = "button[id='auditstrategy_manage_btnDisableAll']")
    public WebElement buttonAuditstrategyManageDisableAll;

    // 协议审计开关设置 -- 设置
    @FindBy(css = "button[id='auditstrategy_manage_btnSave']")
    public WebElement buttonAuditstrategyManageSave;

    // 协议审计开关设置 -- 重置
    @FindBy(css = "button[id='auditstrategy_manage_btnReset']")
    public WebElement buttonAuditstrategyManageReset;

    // 全流量审计开关
    @FindBy(css = "label[for='rabunknown_proto']")
    public WebElement allAudit;

    // 协议审计开关
    @FindBy(css = "li[data-id='auditstrategy_tabProtocol']")
    public WebElement liActive;

    // 点击后的确定
    @FindBy(css = "a[class='layui-layer-btn0']")
    public WebElement linkLayer;
    



    // 获取指定名称的标签
    public WebElement findByName(String name , WebDriver driver) {
        return driver.findElement(By.cssSelector(PRE_STR+name));
    }

    // 随机5分之一个开关打开 -- 通过if判断，跳过对待测协议开关的随机开
    // 加 try ,跳过找不到的 , 额外设置一个参数作为 元素个数的标记，找不到，就重新找一个。
    public void protocolRandomOn(String name,WebDriver driver) {
        int size = PROTOCOL_LIST.size();
        size /= 5 ;
        Collections.shuffle(PROTOCOL_LIST);  // 元素洗牌操作
        List<String> list = PROTOCOL_LIST.subList(0, size);
        // 这里需要滑动页面，以便元素被正确查找到
        for (int i = 0; i < list.size(); i++) {
            // 如果是被测协议，直接跳过
            if(list.get(i).equals(name)) continue;
            // 首先回到页面顶端
            ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,0)");
            WebElement element = null ;
            while (element == null) {
               try{
                   // 查找 目标元素
                   element = driver.findElement(By.cssSelector("label[for='"  + PRE_STR+list.get(i)+ "']"));
                   // 如果找到 -- 滚动到该元素，
                   ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(false);", element);
               }
               catch (Exception e) {
                   // 未找到，向下滚动250个单位
                   ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,250);");
                   //等待小短时间页面加载
                   try {
                       Thread.sleep(1000);
                   } catch (InterruptedException ex) {
                       throw new RuntimeException(ex);
                   }
               }

            }
            // 找到元素后 -- 点击按钮
            element.click();
        }
        // 需要将滚动条移动至页面顶端，否则可能导致《设置》按钮不可见 --- 所以单个打开其实也有可能有问题
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);",buttonAuditstrategyManageSave);
        setButtonAuditstrategyManageSave();
        linkLayer.click();
    }


    // 协议审计开关点击
    public void liActive(){
        liActive.click();
    }

    //FIXME： 被测协议开关点击 ， 暂时还未报错  -- 按理来说应该改成和上面随机开的一样，没出问题就不改
    public void protocolOn(String name ,WebDriver driver) {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> {
            WebElement element = d.findElement(By.cssSelector("label[for='" + PRE_STR + name + "']"));
            element.click();
            return true;
        });
        //driver.findElement(By.cssSelector("label[for='"  + PRE_STR+name+ "']")).click();
    }

    // <启用所有> 开关点击
    public void setButtonAuditstrategyManageEnableAll(){
        buttonAuditstrategyManageEnableAll.click();
        linkLayer.click();
    }

    // <禁用所有> 开关点击
    public void setButtonAuditstrategyManageDisableAll(){
        buttonAuditstrategyManageDisableAll.click();
        linkLayer.click();
    }

    // <设置> 按钮点击
    public void setButtonAuditstrategyManageSave(){
        buttonAuditstrategyManageSave.click();
    }

    // <重置> 按钮点击
    public void setButtonAuditstrategyManageReset(){
        buttonAuditstrategyManageReset.click();
    }

    // <全流量> 审计按钮点击
    public void setAllAudit (){
        allAudit.click();
    }


//    // 被测协议关闭  ---  无法判断按钮是否打开 ，
//    public void protocolOff(){
//
//    }

    public void setPROTOCOL_LIST (List<String> list){
        PROTOCOL_LIST = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            PROTOCOL_LIST.add(list.get(i));
        }
    }


    // 构造函数 : 在这里初始化支持的所有协议，写入list
    public ProtocolButtonPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
