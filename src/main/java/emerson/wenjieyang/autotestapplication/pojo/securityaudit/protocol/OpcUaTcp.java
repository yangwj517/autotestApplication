package emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol;

/**
 * @className: OpcUaTcp
 * @author: WenjieYang
 * @date: 2024/11/14 14:31
 * @Version: 1.0
 * @description: 协议规则OPCUA-TCP
 */

public class OpcUaTcp {

    // 服务码
    private String serveCode ;

    // 描述
    private String desc ;

    public OpcUaTcp(String serveCode, String desc) {
        this.serveCode = serveCode;
        this.desc = desc;
    }
}
