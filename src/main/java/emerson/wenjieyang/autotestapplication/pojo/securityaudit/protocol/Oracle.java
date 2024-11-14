package emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol;

/**
 * @className: Oracle
 * @author: WenjieYang
 * @date: 2024/11/14 14:52
 * @Version: 1.0
 * @description: 协议规则ORACLE
 */

public class Oracle {

    // 操作指令
    private String order ;

    // 用户名
    private String  name ;

    // 描述
    private String desc ;

    public Oracle(String order, String name, String desc) {
        this.order = order;
        this.name = name;
        this.desc = desc;
    }
}
