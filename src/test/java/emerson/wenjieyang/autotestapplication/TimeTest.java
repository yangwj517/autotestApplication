package emerson.wenjieyang.autotestapplication;

import emerson.wenjieyang.autotestapplication.util.LogCreateUtil;

/**
 * @className: TimeTest
 * @author: WenjieYang
 * @date: 2024/10/23 11:41
 * @Version: 1.0
 * @description: 日志时间属性测试
 */

public class TimeTest {
    public static void main(String[] args) {
        String log = LogCreateUtil.createLog( "nihao");
        System.out.println(log);
    }
}
