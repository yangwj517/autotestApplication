package emerson.wenjieyang.autotestapplication.util;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @className: LogOutputUtil
 * @author: WenjieYang
 * @date: 2024/10/23 10:31
 * @Version: 1.0
 * @description: 日志工具类,输出操作日志到txt文件中 , 并返回一个布尔值表示是否成功
 */

public class LogOutputUtil {


    /*
    * @Author WenjieYang
    * @Description  日志文件父级目录创建
    * @Date 11:11 2024/10/23
    * @Param path ： 日志文件输出地址
    * @return  ： 返回 创建成功
    **/

    private static boolean createLogFile(String path) {
        File file1 = new File(path);
        File file = file1.getParentFile() ;
        if(!file.exists()){
          file.mkdirs();
        }        // 创建文件父级目录
        if(!file.exists()){
            try {
                return  file1.createNewFile();  // 创建文件
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return true;
    }


    /*
    * @Author WenjieYang
    * @Description  将生成的日志写入文件
    * @Date 11:30 2024/10/23
    * @Param path : 文件路径
    * @Param msg : 日志信息
    * @return
    **/
    public static boolean saveLog(String path , String msg){
        //创建文件
        boolean logFile = createLogFile(path);
        // 写入文件
        if(logFile){
            FileWriter fw = null;
            BufferedWriter bw = null;
            try {
                fw = new FileWriter(path , true);  // 开启追加模式
                bw = new BufferedWriter(fw);
                bw.write(msg);
                bw.newLine();
                // 返回成功
                return true;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }finally {
                // 关闭文件流
                if(bw!=null){
                    try {
                        bw.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                if(fw!=null){
                    try {
                        fw.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        // 返回结果
        return false ;
    }
}
