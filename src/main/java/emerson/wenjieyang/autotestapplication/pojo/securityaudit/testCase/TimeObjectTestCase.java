package emerson.wenjieyang.autotestapplication.pojo.securityaudit.testCase;

import com.google.gson.Gson;
import lombok.Data;
import org.openqa.selenium.json.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @className: TimeObjectTestCase
 * @author: WenjieYang
 * @date: 2024/11/7 14:34
 * @Version: 1.0
 * @description: TODO：时间对象测试用例实体类
 */

@Data
public class TimeObjectTestCase {

    // 时间表类型  -- 循环 、单次
    private String type ;

    // 名称
    private String name ;

    // 日期
    private int[] date ;

    // 开始时间
    private String beginTime ;

    // 结束时间
    private String endTime ;

    // 创建提示信息
    private String msg ;

    // 测试结果
    private boolean result ;

    // 无参构造函数
    public TimeObjectTestCase(){}

    // 循环时间表 对象，构造参数
    public TimeObjectTestCase(String type,String name ,int[] date ,String beginTime,String endTime){
        this.type = type;
        this.name = name;
        this.date = date;
        this.beginTime = beginTime;
        this.endTime = endTime;
    }

    // 单词时间表 对象， 构造函数
    public TimeObjectTestCase(String type,String name ,String beginTime,String endTime){
        this.type = type;
        this.name = name;
        this.beginTime = beginTime;
        this.endTime = endTime;
    }

    // msg 和  结果的 set方法
    public void setMsg(String msg){
        this.msg = msg;
        if(msg.contains("成功")){
            this.result = true;
            return;
        }
        this.result = false;
    }

    // 属性get方法
    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int[] getDate() {
        return date;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public String getEndTime() {
        return endTime;
    }


    @Override
    public String toString() {
        return "TimeObjectTestCase{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", date=" + Arrays.toString(date) +
                ", beginTime='" + beginTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", msg='" + msg + '\'' +
                ", result=" + result +
                '}';
    }
}
