package emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol;

/**
 * @className: Egd
 * @author: WenjieYang
 * @date: 2024/11/14 15:29
 * @Version: 1.0
 * @description: 协议规则EGD
 */

public class Egd {

    // 状态码
    private String statusCode ;

    // 描述
    private String desc ;

    public Egd(String statusCode, String desc) {
        this.statusCode = statusCode;
        this.desc = desc;
    }
}
