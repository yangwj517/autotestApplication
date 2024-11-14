package emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol;

/**
 * @className: S7
 * @author: WenjieYang
 * @date: 2024/11/14 14:41
 * @Version: 1.0
 * @description: 协议规则S7
 */

public class S7 {

    // 操作类型
    private String controlType ;

    // 读、写 域
    private String ioDomain ;

    // 数据块编号
    private String dataNum ;

    // 起始地址
    private String beginAddress ;

    // 数据类型
    private String dataType ;

    // 数据类型长度
    private String dataLength ;

    // 数据值范围
    private String dataRange ;

    // 描述
    private String desc ;

    public S7(String controlType, String ioDomain, String dataNum, String beginAddress, String dataType, String dataLength, String dataRange, String desc) {
        this.controlType = controlType;
        this.ioDomain = ioDomain;
        this.dataNum = dataNum;
        this.beginAddress = beginAddress;
        this.dataType = dataType;
        this.dataLength = dataLength;
        this.dataRange = dataRange;
        this.desc = desc;
    }
}
