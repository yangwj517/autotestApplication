package emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol;

/**
 * @className: EnipTcp
 * @author: WenjieYang
 * @date: 2024/11/14 14:32
 * @Version: 1.0
 * @description: 协议规则 ENIP-TCP
 */

public class EnipTcp {

    // 指令
    private String order ;

    // 地址类型
    private String addressType ;

    // 数据类型
    private String dataType ;

    // CIP数据段
    private String cipDataSegment ;

    // 描述
    private String desc ;

    public EnipTcp(String order, String addressType, String dataType, String cipDataSegment, String desc) {
        this.order = order;
        this.addressType = addressType;
        this.dataType = dataType;
        this.cipDataSegment = cipDataSegment;
        this.desc = desc;
    }
}
