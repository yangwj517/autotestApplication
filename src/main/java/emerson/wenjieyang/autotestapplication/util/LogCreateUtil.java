package emerson.wenjieyang.autotestapplication.util;

import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @className: LogCreateUtil
 * @author: WenjieYang
 * @date: 2024/10/23 11:36
 * @Version: 1.0
 * @description: 日志生成工具类  日志格式 [YYYY - MM - DD hh：mm：ss] : [SUCCESS/Filed]  {{具体的MSG}}
 */

public class LogCreateUtil {

    public static String createLog(String msg){

        // 获取当前的日期和时间
        LocalDateTime now = LocalDateTime.now();

        // 创建一个日期时间格式化器，指定模式为 "yyyy-MM-dd HH:mm:ss"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // 使用格式化器来格式化 LocalDateTime 对象
        String formattedDateTime = now.format(formatter);

        StringBuilder sb = new StringBuilder();
        sb.append("[ ")
                .append(formattedDateTime)
                .append(" ] ")
                .append("--")
                .append(msg) ;

        return sb.toString() ;
    }
}
