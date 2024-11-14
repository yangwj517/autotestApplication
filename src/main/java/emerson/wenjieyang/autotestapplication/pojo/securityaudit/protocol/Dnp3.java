package emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol;

/**
 * @className: Dnp3
 * @author: WenjieYang
 * @date: 2024/11/14 14:19
 * @Version: 1.0
 * @description: 协议规则 DNP3
 */

public class Dnp3 {

    // 功能码
    private String code ;

    // 对象个数
    private String count ;

    // 描述
    private String desc ;

    public Dnp3(String code, String count, String desc) {
        this.code = code;
        this.count = count;
        this.desc = desc;
    }
}
