package emerson.wenjieyang.autotestapplication;

import emerson.wenjieyang.autotestapplication.util.GetInterfaceAndSendPacketsUtil;

import java.util.List;

/**
 * @className: GetInterfaceTest
 * @author: WenjieYang
 * @date: 2024/10/25 10:21
 * @Version: 1.0
 * @description: 测试工具类获取 本地网口名称的功能 我也搞不懂，重启电脑它又好了
 */

public class GetInterfaceTest {

    public static void main(String[] args) {
        List<String> list = GetInterfaceAndSendPacketsUtil.interfaceNames("C:\\workstation\\pythonProject\\getNetworkName.py");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }
}
