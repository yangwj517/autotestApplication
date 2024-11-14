package emerson.wenjieyang.autotestapplication.util;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * @className: GetProtocolFileListUtil
 * @author: WenjieYang
 * @date: 2024/10/29 13:21
 * @Version: 1.0
 * @description: 拿到指定目录下的文件名称列表
 */


public class GetProtocolFileListUtil {

    /*
    * @Author WenjieYang
    * @Description 根据地址获取目录文件名称列表
    * @Date 13:22 2024/10/29
    * @param: null
    * @return: null
    **/

    public static List<File> getFileNameList(String filepath){
        File file = new File(filepath);
        File[] files = file.listFiles();
        return Arrays.stream(files).toList() ;
    }
}
