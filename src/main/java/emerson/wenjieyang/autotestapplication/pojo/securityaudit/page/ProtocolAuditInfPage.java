package emerson.wenjieyang.autotestapplication.pojo.securityaudit.page;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @className: ProtocolAuditInfPage
 * @author: WenjieYang
 * @date: 2024/10/28 16:22
 * @Version: 1.0
 * @description:  协议审计信息页面
 */

public class ProtocolAuditInfPage {

    // 刷新按钮
    @FindBy(css = "button[data-id='protocol_btnRefresh']")
    public WebElement buttonProtocolRefresh;

    /**
     *  协议审计到的 并不一定是第一条 因此 修改以前的代码，拿到整个表格开始遍历查找
     *  依旧根据时间和协议名称判断是否审计到了新的协议内容
     *  协议审计信息列表
     */
    @FindBy(css = "tbody")
    public WebElement tbody;



//    // 协议类型
//    @FindBy(css = "html > body > div:nth-of-type(3) > div:nth-of-type(2) > div > div > div:nth-of-type(2) > div:nth-of-type(3) > table > tbody > tr:nth-of-type(1) > td:nth-of-type(8)")
//    public WebElement protocolType;
//
//    // 更新时间
//    @FindBy(css = "html > body > div:nth-of-type(3) > div:nth-of-type(2) > div > div > div:nth-of-type(2) > div:nth-of-type(3) > table > tbody > tr:nth-of-type(1) > td:nth-of-type(2)")
//    public WebElement updateTime;

    // 直接吧列表


    //  怎么判断审计信息是新生成的 ： 每一个报文回放前，都应该先获取当前第一条的时间，以此来判断是否审计到新的内容
    
    public String getUpdateTime(WebDriver driver) {
        WebElement element = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div[3]/table/tbody/tr[1]/td[2]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10),Duration.ofSeconds(1));
        try {
            wait.until(ExpectedConditions.visibilityOf(element)) ;
            return element.getText();
        }catch (StaleElementReferenceException e){
            return "null";
        }
//        try{
//            return updateTime.getText();
//        }catch (StaleElementReferenceException e) {
//            updateTime = driver.findElement(By.cssSelector("html > body > div:nth-of-type(3) > div:nth-of-type(2) > div > div > div:nth-of-type(2) > div:nth-of-type(3) > table > tbody > tr:nth-of-type(1) > td:nth-of-type(2)"));
//            return updateTime.getText();
//        }
    }

    // 返回是否是正在被测的协议
    public boolean isProtocolType(String type , WebDriver driver ) {
        WebElement element = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div[3]/table/tbody/tr[1]/td[8]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20),Duration.ofSeconds(1));
        try {
            wait.until(ExpectedConditions.visibilityOf(element)) ;
            return element.getText().equals(type);
        }catch (StaleElementReferenceException e){
            return false;
        }
//        try{
//            return protocolType.getText().equals(type);
//        }catch (StaleElementReferenceException e) {
//            protocolType = driver.findElement(By.cssSelector("html > body > div:nth-of-type(3) > div:nth-of-type(2) > div > div > div:nth-of-type(2) > div:nth-of-type(3) > table > tbody > tr:nth-of-type(1) > td:nth-of-type(8)"));
//            return protocolType.getText().equals(type);
//        }
    }

    public ProtocolAuditInfPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickProtocolRefresh() {
        buttonProtocolRefresh.click();
        //this.protocolType = driver.findElement(By.cssSelector("html > body > div:nth-of-type(3) > div:nth-of-type(2) > div > div > div:nth-of-type(2) > div:nth-of-type(3) > table > tbody > tr:nth-of-type(1) > td:nth-of-type(8)"));
        //this.updateTime = driver.findElement(By.cssSelector("html > body > div:nth-of-type(3) > div:nth-of-type(2) > div > div > div:nth-of-type(2) > div:nth-of-type(3) > table > tbody > tr:nth-of-type(1) > td:nth-of-type(2)"));
    }



    // 查找列表首行的时间
    public String findFirstNewestTime() {
        List< WebElement > rows = tbody.findElements(By.tagName("tr"));
        for(WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            return cells.get(1).getText();
        }
        return "null";
    }


    /**
     * 根据传入的协议和测试类型，审计是否执行正确
     * @param protocol  协议类型
     * @param type  测试类型
     * @return  boolean
     */
    // 查找新的协议
    public boolean findProtocol(String protocol , String type , String lastTime , WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10),Duration.ofSeconds(1));
        wait.until(ExpectedConditions.visibilityOf(tbody));
        // 显示等待，等待表格元素出现
        List<WebElement> rows = tbody.findElements(By.tagName("tr"));
        for(WebElement row : rows) {
            // 读取每行地N个 , 判断是否存在，并根据新的时间去判断是否是新审计到的
            wait.until(ExpectedConditions.visibilityOf(row));
            List<WebElement> cells = row.findElements(By.tagName("td"));
            // 第 7 个单元格是 协议  ， 第 1个单元格是时间
            String text = cells.get(7).getText();
            if(isNewProtocol(text,protocol)){
                // 判断时间是否是新的，如果是 return true ， 如果不是  return false
                if(isNewTime(lastTime,cells.get(1).getText())) {
                    if(type.equals("全开") || type.equals("单开") || type.equals("随机开包含")) return true ;
                    return false ;
                }
                if(type.equals("全关") || type.equals("随机开不包含") ) return true ;
                return false ;
            }
        }
        if(type.equals("全关") || type.equals("随机开不包含")) return true ;
        return false ;
    }


    /**
     * 拿到单元格显示的协议名称，并且判断该名称是否和正在回放的协议报文名称一致
     * @param text  单元格文本
     * @param protocol  协议名称
     * @return  boolean
     */

    public boolean isNewProtocol(String text , String protocol){
        // -- 大部分 都是直接小写 , 所以，直接low，对特殊的重新加判断
        if(text.contains("-")) {
            // FIXME : 特殊情况  等待处理
            return false ;
        }
        text = text.toLowerCase();
        return text.equals(protocol);
    }


    /**
     * 时间比较,判断是否读取协议的时间，比回放前最新的时间要更新
     * @return  返回第一次获取的时间是否在报文回放后新获取时间之前。
     */
    private boolean isNewTime(String oldTime , String newTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime oldClock = LocalDateTime.parse(oldTime, formatter);
        LocalDateTime newClock = LocalDateTime.parse(newTime, formatter);
        return oldClock.isBefore(newClock)&& ! oldClock.isEqual(newClock);
    }


}
