package emerson.wenjieyang.autotestapplication.pojo.securityaudit.testCase;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import lombok.Data;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @className: DetectionPolicyTestCase
 * @author: WenjieYang
 * @date: 2024/11/12 14:16
 * @Version: 1.0
 * @description: TODO：入侵检测检测策略
 */

@Data
public class DetectionPolicyTestCase {

    // 名称
    private String name ;

    // 描述
    private String desc ;

    // 时间对象
    private String timeName ;

    // 源地址地址对象
    private String sourceAddressName ;

    // 目的地址地址对象
    private String targetAddressName ;

    // 规则集
    private String ruleName ;

    // 预期结果
    private boolean expectedResult ;

    // 测试信息
    private String msg ;

    // 测试结果
    private boolean result ;

    // 构造函数
    public DetectionPolicyTestCase() {

    }

    public DetectionPolicyTestCase(String name, String desc, String timeName, String sourceAddressName, String targetAddressName, String ruleName, boolean expectedResult) {
        this.name = name;
        this.desc = desc;
        this.timeName = timeName;
        this.sourceAddressName = sourceAddressName;
        this.targetAddressName = targetAddressName;
        this.ruleName = ruleName;
        this.expectedResult = expectedResult;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getTimeName() {
        return timeName;
    }

    public String getSourceAddressName() {
        return sourceAddressName;
    }

    public String getTargetAddressName() {
        return targetAddressName;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public boolean getResult() {
        return result;
    }

    // toString

    @Override
    public String toString() {
        return "DetectionPolicyTestCase{" +
                "名称='" + name + '\'' +
                ", 描述='" + desc + '\'' +
                ", 时间名称='" + timeName + '\'' +
                ", 源地址='" + sourceAddressName + '\'' +
                ", 目的地址='" + targetAddressName + '\'' +
                ", 规则集名称='" + ruleName + '\'' +
                ", 预期结果=" + expectedResult +
                ", 测试信息'" + msg + '\'' +
                ", 测试结果=" + result +
                '}';
    }

}
