package emerson.wenjieyang.autotestapplication.util;

import com.google.gson.Gson;
import emerson.wenjieyang.autotestapplication.pojo.securityaudit.testCase.*;
import org.openqa.selenium.json.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @className: GetTestcaseListUtil
 * @author: WenjieYang
 * @date: 2024/11/13 10:27
 * @Version: 1.0
 * @description: 通过此方法返回所有的测试用例
 */

public class GetTestcaseListUtil {
    // 登录系统 ==》 测试用例 FIXME : 写死了已经懒得改


    // 安全审计==》入侵检测 ==》 时间对象测试用例
    public static List<TimeObjectTestCase> getTimeObjectTestCaseList(String TimeObjectTestCaseFilePath) {
        List<TimeObjectTestCase> timeObjectTestCaseList ;
        timeObjectTestCaseList = new ArrayList<TimeObjectTestCase>();
        Gson gson = new Gson();
        try(Reader r = new FileReader(TimeObjectTestCaseFilePath)){
            // 设置TypeToken
            Type type = new TypeToken<List<TimeObjectTestCase>>(){}.getType();
            // 从json文件中读取测试用例
            timeObjectTestCaseList = gson.fromJson(r,type);
        } catch (IOException e) {
            System.out.println("测试用例文件加载失败： " + e.getMessage());
        }
        return  timeObjectTestCaseList ;
    }


    // 安全审计 ==》 入侵检测 ==》 地址对象测试用例
    public static List<AddressObjectTestCase> getAddressObjectTestCaseList(String testCaseFilePath) {
        List<AddressObjectTestCase> addressObjectTestCaseList ;
        addressObjectTestCaseList = new ArrayList<AddressObjectTestCase>();
        Gson gson = new Gson();
        try(Reader r = new FileReader(testCaseFilePath)){
            Type type = new com.google.common.reflect.TypeToken<List<AddressObjectTestCase>>(){}.getType();
            addressObjectTestCaseList = gson.fromJson(r,type);
        }catch (IOException e){
            System.out.println("测试用例文件加载失败： " + e.getMessage());
        }
        return addressObjectTestCaseList;
    }


    // 安全审计 ==》 入侵检测 ==》 规则集测试用例
    public static List<RuleSetTestCase> getRuleSetTestCaseList(String testCaseFilePath) {
        List<RuleSetTestCase> ruleSetTestCaseList ;
        ruleSetTestCaseList = new ArrayList<RuleSetTestCase>();
        Gson gson = new Gson();
        try(Reader r = new FileReader(testCaseFilePath)){
            Type type = new com.google.common.reflect.TypeToken<List<RuleSetTestCase>>() {}.getType();
            ruleSetTestCaseList = gson.fromJson(r,type);
        }catch (IOException e){
            System.out.println("测试用例文件加载失败： " + e.getMessage());
        }
        return ruleSetTestCaseList;
    }

    // 安全审计 ==》入侵检测 ==》 检测策略测试用例

    public static List<DetectionPolicyTestCase> getDetectionPolicyTestCaseList(String testCaseFilePath) {
        List<DetectionPolicyTestCase> detectionPolicyTestCaseList ;
        detectionPolicyTestCaseList = new ArrayList<DetectionPolicyTestCase>();
        Gson gson = new Gson();
        try(Reader r = new FileReader(testCaseFilePath)){
            Type type = new com.google.common.reflect.TypeToken<List<DetectionPolicyTestCase>>() {}.getType();
            detectionPolicyTestCaseList = gson.fromJson(r,type);
        }catch (IOException e){
            System.out.println("测试用例文件加载失败： " + e.getMessage());
        }
        return detectionPolicyTestCaseList;
    }

    // 安全审计 ==》 安全事件 ==》事件告警配置测试用例
    public static List<AlarmConfigureTestCase> getAlarmConfigureTestCaseList(String testCaseFilePath){
        List<AlarmConfigureTestCase> alarmConfigureTestCaseList ;
        alarmConfigureTestCaseList = new ArrayList<>();
        Gson gson = new Gson();
        try(Reader r = new FileReader(testCaseFilePath)){
            Type type = new TypeToken<List<AlarmConfigureTestCase>>() {}.getType();
            alarmConfigureTestCaseList = gson.fromJson(r,type);
        }catch (IOException e){
            System.out.println("测试用例文件加载失败： " + e.getMessage());
        }
        return alarmConfigureTestCaseList ;
    }

    //安全审计  ==》 规则管理 ==》白名单规则 ==》应用协议白名单
    public static List<AppWhiteListRuleTestCase> getAppWhiteListRuleTestCaseList(String testCaseFilePath){
        List<AppWhiteListRuleTestCase> appWhiteListRuleTestCaseList ;
        appWhiteListRuleTestCaseList = new ArrayList<>();
        Gson gson = new Gson();
        try(Reader r = new FileReader(testCaseFilePath)){
            Type type = new com.google.common.reflect.TypeToken<List<AppWhiteListRuleTestCase>>() {}.getType();
            appWhiteListRuleTestCaseList = gson.fromJson(r,type);
        }catch (IOException e){
            System.out.println("测试用例文件加载失败： " + e.getMessage());
        }
        return appWhiteListRuleTestCaseList ;
    }

}
