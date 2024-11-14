package emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol;

/**
 * @className: EnipIo
 * @author: WenjieYang
 * @date: 2024/11/14 14:48
 * @Version: 1.0
 * @description: 协议规则 ENIP-IO
 */

public class EnipIo {

    // 地址类型
    private String addressType ;

    // 数据类型
    private String dataAddress ;

    // 描述
    private String desc ;

    public EnipIo(String addressType, String dataAddress, String desc) {
        this.addressType = addressType;
        this.dataAddress = dataAddress;
        this.desc = desc;
    }
}
