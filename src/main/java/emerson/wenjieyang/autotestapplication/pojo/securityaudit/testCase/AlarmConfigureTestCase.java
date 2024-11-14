package emerson.wenjieyang.autotestapplication.pojo.securityaudit.testCase;

import lombok.Data;

/**
 * @className: AlarmConfigureTestCase
 * @author: WenjieYang
 * @date: 2024/11/13 10:07
 * @Version: 1.0
 * @description: 告警配置测试用例
 */

@Data
public class AlarmConfigureTestCase {

    // 规则名称
    private String ruleName ;

    // 源地址
    private String sourceAddress ;

    // 源端口
    private String sourcePort ; // 0~255(案例来说应该 short ，测试，所以用String)。

    // 目的地址
    private String targetAddress ;

    // 目的端口
    private String targetPort ;

    // 时间间隔
    private String timeInterval ;

    // 关联事件级别
    private String eventLevel ;

    // 事件次数
    private String eventCount ;

    // 关联规则描述
    private String ruleDesc;

    // 测试信息
    private String msg ;

    // 预期结果
    private boolean expectedResult ;

    // 测试结果
    private boolean result ;

    public AlarmConfigureTestCase(String ruleName, String sourceAddress, String sourcePort, String targetAddress, String targetPort, String timeInterval, String eventLevel, String eventCount, String ruleDesc, boolean expectedResult) {
        this.ruleName = ruleName;
        this.sourceAddress = sourceAddress;
        this.sourcePort = sourcePort;
        this.targetAddress = targetAddress;
        this.targetPort = targetPort;
        this.timeInterval = timeInterval;
        this.eventLevel = eventLevel;
        this.eventCount = eventCount;
        this.ruleDesc = ruleDesc;
        this.expectedResult = expectedResult;
    }

    public AlarmConfigureTestCase() {
    }

    public String getRuleName() {
        return ruleName;
    }

    public String getSourceAddress() {
        return sourceAddress;
    }

    public String getSourcePort() {
        return sourcePort;
    }

    public String getTargetAddress() {
        return targetAddress;
    }

    public String getTargetPort() {
        return targetPort;
    }

    public String getTimeInterval() {
        return timeInterval;
    }

    public String getEventLevel() {
        return eventLevel;
    }

    public String getEventCount() {
        return eventCount;
    }

    public String getRuleDesc() {
        return ruleDesc;
    }

    public boolean getResult() {
        return result;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "AlarmConfigureTestCase{" +
                "规则名称='" + ruleName + '\'' +
                ", 源地址='" + sourceAddress + '\'' +
                ", 源端口='" + sourcePort + '\'' +
                ", 目的地址='" + targetAddress + '\'' +
                ", 目的端口='" + targetPort + '\'' +
                ", 时间间隔='" + timeInterval + '\'' +
                ", 事件等级='" + eventLevel + '\'' +
                ", 事件次数='" + eventCount + '\'' +
                ", 关联规则信息='" + ruleDesc + '\'' +
                ", 测试信息='" + msg + '\'' +
                ", 预期结果=" + expectedResult +
                ", 实际结果=" + result +
                '}';
    }
}
