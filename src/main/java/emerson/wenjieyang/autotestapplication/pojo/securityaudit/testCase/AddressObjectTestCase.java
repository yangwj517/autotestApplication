package emerson.wenjieyang.autotestapplication.pojo.securityaudit.testCase;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @className: AddressObjectTestCase
 * @author: WenjieYang
 * @date: 2024/11/8 10:34
 * @Version: 1.0
 * @description: FIXME : 实际上 不是每一个地址项目都有 名称和描述的 ，做出修改
 */

public class AddressObjectTestCase {
    // 名称
    private String name ;

    // 描述
    private String desc ;

    // 地址项目
    private String[] addressProjects;

    // 排除地址
    private String[] excludeAddressProjects;

    // 测试提示信息
    private String msg ;

    // 预期结果
    private boolean expectedResult ;

    // 测试结果
    private boolean result ;


    // 测试用例发序列化构造函数
    public AddressObjectTestCase(String name, String desc, String[] addressProjects, String[] excludeAddressProjects,boolean expectedResult) {
        this.name = name;
        this.desc = desc;
        this.addressProjects = addressProjects;
        this.excludeAddressProjects = excludeAddressProjects;
        this.expectedResult = expectedResult;
    }

    // 无参构造函数
    public AddressObjectTestCase(){}

    //Getter

    public boolean getResult(){
        return result;
    }


    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String[] getAddressProjects() {
        return addressProjects;
    }

    public String[] getExcludeAddressProjects() {
        return excludeAddressProjects;
    }

    // Setter

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    // toString


    @Override
    public String toString() {
        return "AddressObjectTestCase{" +
                "名称='" + name + '\'' +
                ", 描述='" + desc + '\'' +
                ", 地址项目=" + Arrays.toString(addressProjects) +
                ", 排除地址=" + Arrays.toString(excludeAddressProjects) +
                ", 测试信息='" + msg + '\'' +
                ", 预期结果=" + expectedResult +
                ", 测试结果=" + result +
                '}';
    }


}
