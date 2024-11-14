package emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol;

/**
 * @className: S7Plus
 * @author: WenjieYang
 * @date: 2024/11/14 14:58
 * @Version: 1.0
 * @description: 规则协议S7-PLUS
 */

public class S7Plus {

    // 操作码
    private String controlCode ;

    // 功能码
    private String funCode ;

    // 描述
    private String desc ;

    public S7Plus(String controlCode, String funCode, String desc) {
        this.controlCode = controlCode;
        this.funCode = funCode;
        this.desc = desc;
    }

}
