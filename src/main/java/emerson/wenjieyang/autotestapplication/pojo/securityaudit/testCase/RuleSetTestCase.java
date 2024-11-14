package emerson.wenjieyang.autotestapplication.pojo.securityaudit.testCase;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @className: RuleSetTestCase
 * @author: WenjieYang
 * @date: 2024/11/11 16:16
 * @Version: 1.0
 * @description: 规则集测试用例
 */

public class RuleSetTestCase {

    // 规则集名称
    private String name ;

    // 规则集描述
    private String desc ;

    // 搜素字段
    private String selectInf ;

    // 类型
    private String type ;

    // 测试信息
    private String msg ;

    // 预期结果
    private boolean expectedResult ;

    // 测试结果
    private boolean result ;

    public RuleSetTestCase(String name, String desc, String selectInf, String type,boolean expectedResult) {
        this.name = name;
        this.desc = desc;
        this.selectInf = selectInf;
        this.type = type;
        this.expectedResult = expectedResult;
    }

    public RuleSetTestCase() {
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getSelectInf() {
        return selectInf;
    }

    public String getType() {
        return type;
    }

    public boolean getResult() {
        return result;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "RuleSetTestCase{" +
                "名称='" + name + '\'' +
                ", 描述='" + desc + '\'' +
                ", 索引关键字='" + selectInf + '\'' +
                ", 类型='" + type + '\'' +
                ", 测试信息='" + msg + '\'' +
                ", 预期结果=" + expectedResult +
                ", 测试结果=" + result +
                '}';
    }
}
