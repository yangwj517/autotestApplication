package emerson.wenjieyang.autotestapplication.pojo.securityaudit.page;

import emerson.wenjieyang.autotestapplication.pojo.securityaudit.testCase.AddressObjectTestCase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * @className: AddressObjectPage
 * @author: WenjieYang
 * @date: 2024/11/5 11:17
 * @Version: 1.0
 * @description:  地址对象页面实体类
 */

@Deprecated
public class AddressObjectPageDeprecated {

    // FIXME : 新增页面《地址表》未定义 ，后期需要可继续补充

    // 新增
    @FindBy(css = "button[id='addresslist_addrlist_addAddrList']")
    public WebElement buttonAddresslistAddrlistAddAddr;

    // 删除
    @FindBy(css = "button[id='addresslist_addrlist_deleteAddrList']")
    public WebElement buttonAddresslistAddrlistDeleteAddr;

    // 地址表头
    @FindBy(css = "thead")
    public WebElement thead;

    // 地址表body
    @FindBy(css = "tbody")
    public WebElement tbodyAddressTest;

    // 地址名称
    @FindBy(xpath = "//*[@id=\"addresslist_addrlist_dialog_detailForm\"]/li[1]/input")
    public WebElement addressNameInput;

    // 地址描述
    @FindBy(xpath = "//*[@id=\"addresslist_addrlist_dialog_detailForm\"]/li[2]/input")
    public WebElement addressIfnInput;

    // 地址项目
    @FindBy(xpath = "//*[@id=\"addresslist_addrlist_dialog_detailForm\"]/li[3]/input")
    public WebElement addressCityInput;



    // 地址项目 -- 新增
    @FindBy(xpath = "//*[@id=\"addresslist_addrlist_dialog_detailTable\"]/div[1]/button[1]")
    public WebElement buttonAddAddr;

    // 地址项目 -- 删除
    @FindBy(xpath = "//*[@id=\"addresslist_addrlist_dialog_detailTable\"]/div[1]/button[2]")
    public WebElement buttonDelAddr;

    // 排除地址
    @FindBy(css = "li[class='formattip'] input[type='text']")
    public WebElement removeAddress;

    // 排除地址 -- 新增
    @FindBy(xpath = "//*[@id=\"addresslist_addrlist_dialog_detailTable1\"]/div[1]/button[1]")
    public WebElement buttonAddAddr1;

    // 排除地址  -- 删除
    @FindBy(xpath = "//*[@id=\"addresslist_addrlist_dialog_detailTable1\"]/div[1]/button[2]")
    public WebElement buttonDelAddr1;

    // 确定
    @FindBy(xpath = "//*[@id=\"addresslist_addrlist_dialog_detailCtrlBtns\"]/button[1]")
    public WebElement buttonEnsure;

    // 取消
    @FindBy(xpath = "//*[@id=\"addresslist_addrlist_dialog_detailCtrlBtns\"]/button[2]")
    public WebElement buttonCancel;


    // =========================================== 地址项目不合规下方可能出现红色文本===========================================================
    @FindBy(css = "li[class^='inc'] span")//地址项目提示
    public WebElement span;

    public boolean checkSpanISDisPlay(){ // 地址项目提示 《下方红色文本》 是否存在
        try{
            return this.span.isDisplayed() ;
        }catch (NoSuchElementException e){
            return false;
        }
    }

    public String getSpanMsg(){ // 获取对应的信息
        return this.span.getText();
    }
    // =================================================================================================================================




    // ============================================点击  新增确认  后可能出现如下弹出框======================================================
    @FindBy(css = "#layui-layer3") //容器
    private WebElement layuiLayer3 ;

    @FindBy(css = "#layui-layer3 > div.layui-layer-content.layui-layer-padding")// 弹窗文本信息
    private WebElement layuiLayer3Text;

    @FindBy(css = "#layui-layer3 > div.layui-layer-btn > a")// 弹出框确认按钮
    private WebElement buttonLayer3;

    private boolean checkLayuiLayer3IsDisplay(){  // 点击确认新增后，是否出现报错弹窗
        try{
            return this.layuiLayer3.isDisplayed() ;
        }catch(NoSuchElementException e){
            return false;
        }
    }

    private String getLayuiLayer3Text(){ //获取弹出框信息
        return this.layuiLayer3Text.getText();
    }

    private void clickButtonLayer3(){ // 点击弹出框确认按钮
        buttonLayer3.click();
    }
    //====================================================================================================================================





    // =======================================如果 排除地址和地址项目完全一致 会出现如下弹出框 ======================================================
    @FindBy(css = "#layui-layer4") // 容器
    private WebElement layuiLayer4;

    @FindBy(css = "#layui-layer4 > div.layui-layer-content.layui-layer-padding") // 弹出框提示信息
    private WebElement layuiLayer4Text;

    @FindBy(css = "#layui-layer4 > div.layui-layer-btn > a") // 弹出框确认信息
    private WebElement buttonLayer4;

    public boolean checkLayuiLayer4IsDisplayed() { // 该弹窗是否出现
        try{
            return layuiLayer4.isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }
    }

    public String getLayuiLayer4Text() { // 该弹窗提示信息
        return layuiLayer4Text.getText();
    }

    public void clickButtonLayer4(){ // 弹出框确认按钮点击
        buttonLayer4.click();
    }
    // =================================================================================================================



    // ========================================= 操作成功时的 弹出框 =======================================================
    @FindBy(css = "#layui-layer8")
    private WebElement layuiLayer8;

    @FindBy(css = "#layui-layer8 > div.layui-layer-content.layui-layer-padding")
    private WebElement layuiLayer8Text;

    @FindBy(css = "#layui-layer8 > div.layui-layer-btn > a")
    private WebElement buttonLayer8;

    public boolean checkLayuiLayer8IsDisplayed() { // 容器是否存在
        try{
            return layuiLayer8.isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }
    }

    public String getLayuiLayer8Text() { // 获取提示框信息
        return layuiLayer8Text.getText();
    }

    public void clickButtonLayer8(){// 确认点击
        buttonLayer8.click();
    }
    // =================================================================================================================


    // =============================================  名称与地址列表中的重复时 ==============================================
    @FindBy(css = "#layui-layer7")
    private WebElement layuiLayer7;

    @FindBy(css = "#layui-layer7 > div.layui-layer-content.layui-layer-padding")
    private WebElement layuiLayer7Text;

    @FindBy(css = "#layui-layer7 > div.layui-layer-btn > a")
    private WebElement buttonLayer7;

    public boolean checkLayuiLayer7IsDisplayed() {
        try{
            return layuiLayer7.isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }
    }

    public String getLayuiLayer7Text() {
        return layuiLayer7Text.getText();
    }

    public void clickButtonLayer7(){
        buttonLayer7.click();
    }
    // =================================================================================================================


    // ======================================== 名称与地址列表重复时可能出现 =================================================
    @FindBy(css = "#layui-layer10")
    private WebElement layuiLayer10;

    @FindBy(css = "#layui-layer10 > div.layui-layer-content.layui-layer-padding")
    private WebElement layuiLayer10Text;


    // 构造函数
    public AddressObjectPageDeprecated(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // TODO : 地址对象相关方法待补充

    /**
     * 点击新增按钮
     */
    public void clickButtonAddresslistAddrlistAddAddr(){
        buttonAddresslistAddrlistAddAddr.click();
    }

    /**
     *  填写名称
     */
    public void enterAddressNameInput(String addressName){
        addressNameInput.sendKeys(addressName);
    }

    /**
     *  填写地址描述
     */
    public void enterAddressIfnInput(String addressIfn){
        addressIfnInput.sendKeys(addressIfn);
    }

    /**
     *  填写地址项目
     */
    public void enterAddressCityInput(String addressCity){
        addressCityInput.sendKeys(addressCity);
    }

    /**
     * 点击新增
     */
    public void clickButtonAddAddr(){
        buttonAddAddr.click();
    }



    /**
     * 填写地址排除项
     */
    public void enterRemoveAddress(String value){
        removeAddress.sendKeys(value);
    }

    /**
     * 点击排除地址新增按钮
     */
    public void clickButtonAddAddr1(){
        buttonAddAddr1.click();
    }


    /**
     * 点击 确定按钮
     */
    public void clickButtonEnsure(){
        buttonEnsure.click();
    }

    /**
     * 新增页 取消 按钮
     */
    public void clickButtonCancel(){
        buttonCancel.click();
    }


    public AddressObjectTestCase createNewAddressObject(AddressObjectTestCase addressObjectTestCase,WebDriver driver){
        // 点击新增
        this.clickButtonAddresslistAddrlistAddAddr();
        // 填写名称
        this.enterAddressNameInput(addressObjectTestCase.getName());
        // 填写描述
        this.enterAddressIfnInput(addressObjectTestCase.getDesc());
        // 拿到地址项目列表
        String[] addressProjectList = addressObjectTestCase.getAddressProjects();

        // 循环添加新的地址项目
        for(String address : addressProjectList){
            // 填写地址
            this.enterAddressCityInput(address);
            // 点击新增
            this.clickButtonAddAddr();
            // 停顿 1 秒 获取 弹出框文本信息
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        // 循环添加排除地址段
        for(String s : addressObjectTestCase.getExcludeAddressProjects()){
            // 填写地址段
            this.enterRemoveAddress(s);
            // 点击新增
            this.clickButtonAddAddr1();
            // 停顿 1 秒 获取 弹出框文本信息
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        // 需要将滚动条移动至页面顶端，否则可能导致《设置》按钮不可见 --- 所以单个打开其实也有可能有问题
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);",buttonEnsure);
        // 点击 确定按钮
        this.clickButtonEnsure();
        // 停顿 1 秒 获取 弹出框文本信息
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // 处理各种弹窗信息
        AddressObjectTestCase addressObjectTestCase1 = popUpWindowsSolution(addressObjectTestCase);
        this.clickButtonCancel();
        return addressObjectTestCase1 ;
    }





    /**
     * 此方法处理 神他妈 好几种 弹窗 ， 这前端 写的就是 ： 依托答辩
     * 还有两个隐藏文本框
     */
    private AddressObjectTestCase popUpWindowsSolution(AddressObjectTestCase addressObjectTestCase){
        // 首先设置为true
        addressObjectTestCase.setResult(true);

        // 第一种弹窗 ： 新增页点击确认后 可能出现
        if (checkLayuiLayer3IsDisplay()) {
            addressObjectTestCase.setMsg(this.getLayuiLayer3Text());
            addressObjectTestCase.setResult(false);
            this.clickButtonLayer3();
        }

        // 第二种弹窗 ： 排除地址段 和 地址项目 相同的时候 可能出现
        if(checkLayuiLayer4IsDisplayed()){
            addressObjectTestCase.setMsg(this.getLayuiLayer4Text());
            addressObjectTestCase.setResult(false);
            this.clickButtonLayer4();
        }

        // 第三种情况 ：成功创建的弹出框
        if(checkLayuiLayer8IsDisplayed()){
            System.out.println("确认框");
            addressObjectTestCase.setMsg(this.getLayuiLayer8Text());
            // 此时不需要将result 设为false
            this.clickButtonLayer8();
        }

        // 第四种情况 名称与地址列表一致会出现弹框
        if(checkLayuiLayer7IsDisplayed()){
            addressObjectTestCase.setMsg(this.getLayuiLayer7Text());
            addressObjectTestCase.setResult(false);
            this.clickButtonLayer7();
        }

        return addressObjectTestCase;
    }

}
