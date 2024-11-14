package emerson.wenjieyang.autotestapplication.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @className: GetInterfaceNameUtil
 * @author: WenjieYang
 * @date: 2024/10/25 10:07
 * @Version: 1.0
 * @description:  工具类，返回本机的网口名称列表，供使用者选择 , 使用规定好的接口回访报文
 */

public class GetInterfaceAndSendPacketsUtil {

    /**
    * @Author WenjieYang
    * @Description  返回网口列表
    * @Date 10:11 2024/10/25
    * @param: pythonFilePath  python 脚本地址
    * @return: java.util.List<java.lang.String>  网口名称存储列表
    **/

    public static List<String> interfaceNames(String pythonFilePath){
        // 存储列表，返回对象
        List<String> list = new ArrayList<String>();
        // 构建进程对象，执行python脚本  , 参数是一个可变长的字符串  ,也就是脚本的执行命令
        String[] common = {"python",pythonFilePath};
        // 调用python脚本执行命令
        try {
            InputStream inputStream = Runtime.getRuntime().exec(common).getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }


    /**
    * @Author WenjieYang
    * @Description 使用用户指定的Interface回访指定的报文文件
    * @Date 10:48 2024/10/25
    * @param: pythonFilePath  python脚本地址
    * @param: interfaceName   使用接口名称
    * @param: pcapFilePath    数据包文件地址
    * @return: java.lang.String  脚本执行结果
    **/

    public static String sendPackets(String pythonFilePath , String interfaceName , String pcapFilePath){
        // 构建返回值
        StringBuilder resultMsg = new StringBuilder() ;
        // 构建执行命令
        String[] common = {"python",   pythonFilePath  , interfaceName , pcapFilePath};
        // 执行
        try {
            InputStream inputStream = Runtime.getRuntime().exec(common).getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                resultMsg.append(line).append("\n");
                System.out.println(resultMsg.toString());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return resultMsg.toString() ;
    }
}
