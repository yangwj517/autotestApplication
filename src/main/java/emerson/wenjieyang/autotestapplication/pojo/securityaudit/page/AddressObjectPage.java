package emerson.wenjieyang.autotestapplication.pojo.securityaudit.page;

import emerson.wenjieyang.autotestapplication.pojo.securityaudit.testCase.AddressObjectTestCase;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * @className: AddressObjectPage
 * @author: WenjieYang
 * @date: 2024/11/11 13:48
 * @Version: 1.0
 * @description: TODO：弹窗应该是js动态生成，所以导致每次访问的都不一样，因此重新完成此方法。
 */

public class AddressObjectPage {

    /**
     * 只需要完成添加操作后，刷新页面再次跳转即可  || 用js获取？ || 摒弃css定位, 采用更稳定的定位方式
     */


    // 新增
    @FindBy(css = "button[id='addresslist_addrlist_addAddrList']")
    private WebElement buttonAddresslistAddrlistAddAddr;
    public void clickButtonAddresslistAddrlistAddAddr() {
        buttonAddresslistAddrlistAddAddr.click();
    }


    // 地址名称
    @FindBy(xpath = "//*[@id=\"addresslist_addrlist_dialog_detailForm\"]/li[1]/input")
    private WebElement addressNameInput;
    public void enterAddressName(String addressName) {
        addressNameInput.sendKeys(addressName);
    }


    // 地址描述
    @FindBy(xpath = "//*[@id=\"addresslist_addrlist_dialog_detailForm\"]/li[2]/input")
    private WebElement addressIfnInput;
    public void enterAddressIfn(String addressIfn) {
        addressIfnInput.sendKeys(addressIfn);
    }


    // 地址项目
    @FindBy(xpath = "//*[@id=\"addresslist_addrlist_dialog_detailForm\"]/li[3]/input")
    private WebElement addressCityInput;
    public void enterAddressCity(String addressCity) {
        addressCityInput.sendKeys(addressCity);
    }


    // 地址项目 -- 新增
    @FindBy(xpath = "//*[@id=\"addresslist_addrlist_dialog_detailTable\"]/div[1]/button[1]")
    private WebElement buttonAddAddr;
    public void clickButtonAddAddr() {
        buttonAddAddr.click();
    }


    // 排除地址
    @FindBy(css = "li[class='formattip'] input[type='text']")
    private WebElement removeAddress;
    public void enterRemoveAddress(String removeAddress) {
        this.removeAddress.sendKeys(removeAddress);
    }


    // 排除地址 -- 新增
    @FindBy(xpath = "//*[@id=\"addresslist_addrlist_dialog_detailTable1\"]/div[1]/button[1]")
    private WebElement buttonAddAddress;
    public void clickButtonAddAddress() {
        this.buttonAddAddress.click();
    }


    // 确定
    @FindBy(xpath = "//*[@id=\"addresslist_addrlist_dialog_detailCtrlBtns\"]/button[1]")
    private WebElement buttonEnsure;
    public void clickButtonEnsure() {
        this.buttonEnsure.click();
    }


    // 取消
    @FindBy(xpath = "//*[@id=\"addresslist_addrlist_dialog_detailCtrlBtns\"]/button[2]")
    public WebElement buttonCancel;
    public void clickButtonCancel() {
        this.buttonCancel.click();
    }


    // 弹出框
    @FindBy(className = "layui-layer-dialog")
    private WebElement layer;

    // 弹出框文本
    @FindBy(xpath = "//div[contains(@class, 'layui-layer-padding')]")
    public WebElement layerText;

    // 弹出框确认按钮
    @FindBy(xpath = ".//a[contains(@class, 'layui-layer-btn0')]")
    private WebElement layerButtonEnsure;

    public boolean checkLayerIsDisplayed(){
        try{
            return this.layer.isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }
    }

    public String getLayerText(){
        return this.layerText.getText();
    }

    public void clickLayerButtonEnsure(){
        this.layerButtonEnsure.click();
    }


    // 地址对象 红色文本
    @FindBy(css = "#addresslist_addrlist_dialog_detailForm > li.inc_tip > span")
    private WebElement addressNameInputTip;

    public boolean checkAddressNameInputTipIsDisplayed(){
        try{
            return this.addressNameInputTip.isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }
    }

    public String getAddressNameInputTip(){
        return this.addressNameInputTip.getText();
    }

    // 排除地址 红色文本
    @FindBy(css = "#addresslist_addrlist_dialog_detailForm1 > li.exc_tip > span")
    private WebElement excludeAddressTip;


    public boolean checkExcludeAddressTipIsDisplayed(){
        try{
            return this.excludeAddressTip.isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }
    }

    public String getExcludeAddressTip(){
        return this.excludeAddressTip.getText();
    }


    // 构造函数
    public AddressObjectPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    // 新增逻辑
    public AddressObjectTestCase createNewAddressObject(AddressObjectTestCase addressObjectTestCase,WebDriver driver) {
        // 点击新增
        this.clickButtonAddresslistAddrlistAddAddr();
        // 填写名称
        this.enterAddressName(addressObjectTestCase.getName());
        // 填写描述
        this.enterAddressIfn(addressObjectTestCase.getDesc());
        for(String address : addressObjectTestCase.getAddressProjects()){
            // 添加地址项目
            this.enterAddressCity(address);
            // 点击新增地址项目
            this.clickButtonAddAddr();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(checkAddressNameInputTipIsDisplayed()){
                addressObjectTestCase.setMsg(getAddressNameInputTip());
                addressObjectTestCase.setResult(false);
                this.clickButtonCancel();
                return addressObjectTestCase;
            }
        }
        for(String excludeAddress : addressObjectTestCase.getExcludeAddressProjects()){
            // 填写排除地址
            this.enterRemoveAddress(excludeAddress);
            // 点击新增排除地址
            this.clickButtonAddAddress();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(checkExcludeAddressTipIsDisplayed()){
                addressObjectTestCase.setMsg(getExcludeAddressTip());
                addressObjectTestCase.setResult(false);
                this.clickButtonCancel();
                return addressObjectTestCase;
            }
        }
        // 点击 新增页面 确定按钮
        this.clickButtonEnsure();
        AddressObjectTestCase addressObjectTestCase1 = popUpWindowSolution(addressObjectTestCase);
        // 如果没成功 ，点击页面取消按键
        if(!addressObjectTestCase1.getResult()) this.clickButtonCancel();
        return addressObjectTestCase1;
    }

    // 弹框处理 以及 测试用例结果设置
    private AddressObjectTestCase popUpWindowSolution(AddressObjectTestCase addressObjectTestCase) {
        addressObjectTestCase.setResult(false);
        if(this.checkLayerIsDisplayed()){
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            String text = this.getLayerText();
            addressObjectTestCase.setMsg(text);
            if(text.contains("成功")) addressObjectTestCase.setResult(true);
            // 点击确弹窗定按钮
            //System.out.println("找到按钮");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.clickLayerButtonEnsure();
        }
        return addressObjectTestCase ;
    }

}
