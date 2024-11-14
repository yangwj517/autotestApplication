package emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol;

/**
 * @className: Ftp
 * @author: WenjieYang
 * @date: 2024/11/14 14:53
 * @Version: 1.0
 * @description: 协议规则
 */

public class Ftp {

    // 命令
    private String order ;

    // 描述
    private String desc ;

    public Ftp(String order, String desc) {
        this.order = order;
        this.desc = desc;
    }
}
