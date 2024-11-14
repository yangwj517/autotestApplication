package emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol;

/**
 * @className: OpcDa
 * @author: WenjieYang
 * @date: 2024/11/14 14:16
 * @Version: 1.0
 * @description: 协议规则 OPCDA
 */

public class OpcDa {
    // uuid
    private String uuid ;

    // 操作码
    private String actionCode ;

    // 项类型
    private String type ;

    // 项名
    private String name ;

    // 项值
    private String value ;

    // 描述
    private String desc ;

    public OpcDa(String uuid, String actionCode, String type, String name, String value, String desc) {
        this.uuid = uuid;
        this.actionCode = actionCode;
        this.type = type;
        this.name = name;
        this.value = value;
        this.desc = desc;
    }
}
