package emerson.wenjieyang.autotestapplication.pojo.securityaudit.testCase;

import emerson.wenjieyang.autotestapplication.pojo.securityaudit.page.Inf;
import lombok.Data;

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

    // 操作码啥啥 ，看不懂是什么。
    private List<Inf> list ;

    // 测试信息
    private String msg ;

    // 预期结果
    private boolean expectedResult ;

    // 测试结果
    private boolean result ;

    /*
    class Inf{
        // 接口ID
        private String interfaceId ;

        // 操作码
        private String actionCode ;

        // 块类型
        private String partType ;

        // 描述
        private String desc ;

        // 构造函数
        public Inf(String interfaceId, String actionCode, String partType, String desc) {
            this.interfaceId = interfaceId;
            this.actionCode = actionCode;
            this.partType = partType;
            this.desc = desc;
        }
        public Inf(String interfaceId, String actionCode, String partType) {
            this.interfaceId = interfaceId;
            this.actionCode = actionCode;
            this.partType = partType;
        }
        public Inf() {
        }

        // Getter

        public String getInterfaceId() {
            return interfaceId;
        }

        public String getActionCode() {
            return actionCode;
        }

        public String getPartType() {
            return partType;
        }

        public String getDesc() {
            return desc;
        }

        @Override
        public String toString() {
            return "Inf{" +
                    "接口ID='" + interfaceId + '\'' +
                    ", 操作码='" + actionCode + '\'' +
                    ", 块类型='" + partType + '\'' +
                    ", 描述='" + desc + '\'' +
                    '}';
        }
    }
     */

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

    public List<Inf> getList() {
        return list;
    }

    public AppWhiteListRuleTestCase(String ruleName, String ruleDesc, String sourceIp, String targetIp, String protocolName, List<Inf> list, boolean expectedResult) {
        this.ruleName = ruleName;
        this.ruleDesc = ruleDesc;
        this.sourceIp = sourceIp;
        this.targetIp = targetIp;
        this.protocolName = protocolName;
        this.list = list;
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
                ", list=" + list +
                ", 测试信息='" + msg + '\'' +
                ", 预期结果=" + expectedResult +
                ", 测试结果=" + result +
                '}';
    }
}
