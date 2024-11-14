package emerson.wenjieyang.autotestapplication.enums;


/**
 * @className: ResultEnum
 * @author: WenjieYang
 * @date: 2024/10/21 10:09
 * @Version: 1.0
 * @description:  Response 返回状态 枚举
 */


public enum  Result {
    SUCCESS(666,"成功") ,
    FILED(444,"失败");

    // 状态返回值

    private final int code ;

    // 请求返回message ;

    private final String msg ;


    Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
