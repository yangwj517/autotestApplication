package emerson.wenjieyang.autotestapplication;

import emerson.wenjieyang.autotestapplication.util.GetInterfaceAndSendPacketsUtil;
import org.junit.jupiter.api.Test;

/**
 * @className: SendPacketsTest
 * @author: WenjieYang
 * @date: 2024/10/25 10:55
 * @Version: 1.0
 * @description: 流量数据包回放测试
 */

public class SendPacketsTest {

    public static void main(String[] args) {
        // 定义 python 脚本地址 ，网口名称 ，数据包文件地址
        String pythonFilePath = "C:\\workstation\\pythonProject\\sendPacket.py";
        String networkName = "2" ;
        String pcapFilePath = "3";
        String s = GetInterfaceAndSendPacketsUtil.sendPackets(pythonFilePath, networkName, pcapFilePath);
        System.out.println(s);

    }
}
