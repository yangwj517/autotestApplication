package emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol;

/**
 * @className: Iec104
 * @author: WenjieYang
 * @date: 2024/11/14 14:22
 * @Version: 1.0
 * @description: 协议规则IEC104
 */

public class Iec104 {
    // 帧类型
    private String type ;

    // 类型标识
    private String typeFlag ;

    // 传输原因
    private String transferReason ;

    // 公共地址
    private String publicAddress ;

    // 信息体地址
    private String infAddress ;

    // 信息体参数
    private String infParam ;

    // 描述
    private String desc ;

    public Iec104(String type, String typeFlag, String transferReason, String publicAddress, String infAddress, String infParam, String desc) {
        this.type = type;
        this.typeFlag = typeFlag;
        this.transferReason = transferReason;
        this.publicAddress = publicAddress;
        this.infAddress = infAddress;
        this.infParam = infParam;
        this.desc = desc;
    }
}
