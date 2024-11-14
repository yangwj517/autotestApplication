package emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol;

/**
 * @className: Hexagon
 * @author: WenjieYang
 * @date: 2024/11/14 14:49
 * @Version: 1.0
 * @description: 协议规则 Hexagon
 */

public class Hexagon {

    // 功能码
    private String funCode ;

    // 子功能码
    private String sunCode ;

    // 描述
    private String desc ;

    public Hexagon(String funCode, String sunCode, String desc) {
        this.funCode = funCode;
        this.sunCode = sunCode;
        this.desc = desc;
    }
}
