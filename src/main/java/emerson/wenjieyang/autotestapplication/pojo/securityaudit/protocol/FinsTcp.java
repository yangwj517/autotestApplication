package emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol;

/**
 * @className: FinsTcp
 * @author: WenjieYang
 * @date: 2024/11/14 15:32
 * @Version: 1.0
 * @description: 协议规则 FinsTcp
 */

public class FinsTcp {

    // 功能码
    private String funCode ;

    // 磁盘号
    private String diskNum ;

    // 描述
    private String desc ;

    public FinsTcp(String funCode, String diskNum, String desc) {
        this.funCode = funCode;
        this.diskNum = diskNum;
        this.desc = desc;
    }
}
