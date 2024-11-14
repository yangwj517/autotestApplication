package emerson.wenjieyang.autotestapplication.pojo;


import lombok.Data;

/**
 * @BelongsProject : autotestApplication
 * @BelongsPackage : emerson.wenjieyang.autotestapplication.pojo
 * @Author : YWJ
 * @CreateTime : 2024-10-22  18:58
 * @Description : 请求响应实体类
 * @Version : 1.0
 */


@Data
public class Response <T> {

    private int code ;

    private String msg ;

    private T data ;

    public Response(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
