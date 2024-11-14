package emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol;

/**
 * @className: CoAp
 * @author: WenjieYang
 * @date: 2024/11/14 15:20
 * @Version: 1.0
 * @description: 协议规则CoAp
 */

public class CoAp {
    // 消息类型
    private String msgType ;

    // 功能码
    private String funCode ;

    // 描述
    private String desc ;

    public CoAp(String msgType, String funCode, String desc) {
        this.msgType = msgType;
        this.funCode = funCode;
        this.desc = desc;
    }
}
