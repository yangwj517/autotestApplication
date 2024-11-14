package emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol;

/**
 * @className: BACnet
 * @author: WenjieYang
 * @date: 2024/11/14 15:22
 * @Version: 1.0
 * @description: 协议规则 BACnet
 */

public class BACnet {

    // 数据单元类型
    private String dataCellType ;

    // 服务选择
    private String serveSelect ;

    // 描述
    private String desc ;

    public BACnet(String dataCellType, String serveSelect, String desc) {
        this.dataCellType = dataCellType;
        this.serveSelect = serveSelect;
        this.desc = desc;
    }
}
