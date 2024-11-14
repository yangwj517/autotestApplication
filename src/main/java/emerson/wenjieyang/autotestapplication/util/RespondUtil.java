package emerson.wenjieyang.autotestapplication.util;

import emerson.wenjieyang.autotestapplication.enums.Result;
import emerson.wenjieyang.autotestapplication.pojo.Response;


/**
 * @className: RespondUtil
 * @author: WenjieYang
 * @date: 2024/10/21 13:29
 * @Version: 1.0
 * @description:  响应生成工具类 , 所有的Controller都应调用此接口进行返回 Response
 */
public class RespondUtil {

    public static <T> Response<T> success() {
        return new Response<>(Result.SUCCESS.getCode(), Result.SUCCESS.getMsg(), null);
    }

    public static <T> Response<T> success(T data){
        return new Response<>(Result.SUCCESS.getCode(),Result.SUCCESS.getMsg(),data);
    }
    public static <T> Response<T> success(String msg){
        return new Response<>(Result.SUCCESS.getCode(),msg,null);
    }

    public static <T> Response<T> success(String msg, T data){
        return new Response<>(Result.SUCCESS.getCode(),msg,data);
    }

    public static <T> Response<T> error(){
        return new Response<>(Result.FILED.getCode(), Result.FILED.getMsg(), null);
    }

    public static <T> Response<T> error(String msg){
        return new Response<>(Result.FILED.getCode(), msg, null);
    }

}
