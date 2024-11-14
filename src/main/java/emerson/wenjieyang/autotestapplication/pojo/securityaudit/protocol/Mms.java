package emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol;

/**
 * @className: Mms
 * @author: WenjieYang
 * @date: 2024/11/14 14:29
 * @Version: 1.0
 * @description: 协议规则 MMS
 */

public class Mms {

    // 类型
    private String type ;

    // 服务
    private String serve ;

    // 描述
    private String desc ;

    public Mms(String type, String serve, String desc) {
        this.type = type;
        this.serve = serve;
        this.desc = desc;
    }
}
