package emerson.wenjieyang.autotestapplication.pojo.securityaudit.testCase;

import emerson.wenjieyang.autotestapplication.pojo.securityaudit.page.Inf;
import lombok.Data;
import emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol.Ftp;
import emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol.ProFinetIo;
import emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol.baseInterface.ProtocolBaseInterface;

import java.util.List;

/**
 * @className: AppWhiteListRuleTestCase
 * @author: WenjieYang
 * @date: 2024/11/13 15:34
 * @Version: 1.0
 * @description: 应用白名单实体类
 */

@Data
public class AppWhiteListRuleTestCase {

    // 规则名
    private String ruleName ;

    // 描述
    private String ruleDesc ;

    // 源ip
    private String sourceIp ;

    // 目的ip
    private String targetIp ;

    // 协议名
    private String protocolName ;

    // 协议规则列表
    private List<ProtocolBaseInterface> protocolList ;

    // 测试信息
    private String msg ;

    // 预期结果
    private boolean expectedResult ;

    // 测试结果
    private boolean result ;


    public AppWhiteListRuleTestCase() {
    }

    public String getRuleName() {
        return ruleName;
    }

    public String getRuleDesc() {
        return ruleDesc;
    }

    public String getTargetIp() {
        return targetIp;
    }

    public String getSourceIp() {
        return sourceIp;
    }

    public String getProtocolName() {
        return protocolName;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<ProtocolBaseInterface> getProtocolList() {
        return protocolList;
    }

    public void setProtocolList(List<ProtocolBaseInterface> protocolList) {
        this.protocolList = protocolList;
    }



    public AppWhiteListRuleTestCase(String ruleName, String ruleDesc, String sourceIp, String targetIp, String protocolName, List<ProtocolBaseInterface> list, boolean expectedResult) {
        this.ruleName = ruleName;
        this.ruleDesc = ruleDesc;
        this.sourceIp = sourceIp;
        this.targetIp = targetIp;
        this.protocolName = protocolName;
        this.protocolList = list;
        this.expectedResult = expectedResult;
    }


    @Override
    public String toString() {
        return "AppWhiteListRuleTestCase{" +
                "规则名称='" + ruleName + '\'' +
                ", 规则描述='" + ruleDesc + '\'' +
                ", 源IP='" + sourceIp + '\'' +
                ", 目的IP='" + targetIp + '\'' +
                ", 协议名称='" + protocolName + '\'' +
                ", list=" + protocolList +
                ", 测试信息='" + msg + '\'' +
                ", 预期结果=" + expectedResult +
                ", 测试结果=" + result +
                '}';
    }
}
