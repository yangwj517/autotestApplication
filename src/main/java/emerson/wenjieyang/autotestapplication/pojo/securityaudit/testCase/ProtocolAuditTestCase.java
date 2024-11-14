package emerson.wenjieyang.autotestapplication.pojo.securityaudit.testCase;

/**
 * @className: ProtocolAuditTestCase
 * @author: WenjieYang
 * @date: 2024/10/28 11:09
 * @Version: 1.0
 * @description: 协议审计测试用例
 */

public class ProtocolAuditTestCase {

    // 协议名称
    private String protocolName ;

    // 测试类型  -- 全开 -- 单开  -- 随机开包含 -- 随即开不包含
    private String testType ;

    // 测试数据包文件名称
    private String protocolFileName ;

    // 协议审计结果
    private boolean protocolResult ;

    public ProtocolAuditTestCase(String protocolName) {
        this.protocolName = protocolName;
    }


    public void setProtocolName(String protocolName) {
        this.protocolName = protocolName;
    }

    public void setProtocolFileName(String protocolFileName) {
        this.protocolFileName = protocolFileName;
    }

    public void setProtocolResult(boolean protocolResult) {
        this.protocolResult = protocolResult;
    }

    public void setTestType(String testType) {
        this.testType = testType;
    }
    public String getProtocolName(){
        return protocolName;
    }

    @Override
    public String toString() {
        return "ProtocolAuditTestCase{" +
                "协议名称 ='" + protocolName + '\'' +
                ", 测试类型 ='" + testType + '\'' +
                ", 报文文件名称 ='" + protocolFileName + '\'' +
                ", 测试结果 =" + protocolResult +
                '}';
    }
}
