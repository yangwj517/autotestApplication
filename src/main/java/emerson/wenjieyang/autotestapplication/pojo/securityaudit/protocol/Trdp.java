package emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol;

/**
 * @className: Trdp
 * @author: WenjieYang
 * @date: 2024/11/14 15:24
 * @Version: 1.0
 * @description: 协议规则 TRDP
 */

public class Trdp {

    // 报文类型
    private String packetType ;

    // ETB拓扑计数器
    private String etbCount ;

    // 列车操作拓扑计数器
    private String count ;

    // 应答IP地址
    private String responseIp ;

    // 源URL
    private String sourceUrl ;

    // 目的URL
    private String targetUrl ;

    // 描述
    private String desc ;

    public Trdp(String packetType, String etbCount, String count, String responseIp, String sourceUrl, String targetUrl, String desc) {
        this.packetType = packetType;
        this.etbCount = etbCount;
        this.count = count;
        this.responseIp = responseIp;
        this.sourceUrl = sourceUrl;
        this.targetUrl = targetUrl;
        this.desc = desc;
    }


}
