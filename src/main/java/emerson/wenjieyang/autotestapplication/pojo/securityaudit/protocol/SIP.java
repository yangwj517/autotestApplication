package emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol;

/**
 * @className: SIP
 * @author: WenjieYang
 * @date: 2024/11/14 14:07
 * @Version: 1.0
 * @description: 协议规则SIP
 */

public class SIP {

    // 方法名
    private String funName ;
    // 描述
    private String desc ;

    public SIP(String funName, String desc) {
        this.funName = funName;
        this.desc = desc;
    }

    public SIP() {
    }
}
