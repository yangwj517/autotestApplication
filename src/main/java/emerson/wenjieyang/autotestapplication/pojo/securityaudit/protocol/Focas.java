package emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol;

/**
 * @className: Focas
 * @author: WenjieYang
 * @date: 2024/11/14 14:55
 * @Version: 1.0
 * @description: 协议规则 FOCAS
 */

public class Focas {

    // 命令
    private String order ;

    // 类型
    private String type ;

    // 按键
    private String keyBroad ;

    // 功能码
    private String funCode ;

    // 子功能码
    private String sunFunCode ;

    // 描述
    private String Desc ;

    public Focas(String order, String type, String keyBroad, String funCode, String sunFunCode, String desc) {
        this.order = order;
        this.type = type;
        this.keyBroad = keyBroad;
        this.funCode = funCode;
        this.sunFunCode = sunFunCode;
        Desc = desc;
    }
}
