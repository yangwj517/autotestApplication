package emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol;

/**
 * @className: Mqtt
 * @author: WenjieYang
 * @date: 2024/11/14 15:17
 * @Version: 1.0
 * @description: 协议规则MQTT
 */

public class Mqtt {

    // 消息类型
    private String msgType ;

    // 主题名称
    private String topicName ;

    // 描述
    private String desc ;

    public Mqtt(String msgType, String topicName, String desc) {
        this.msgType = msgType;
        this.topicName = topicName;
        this.desc = desc;
    }
}
