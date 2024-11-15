package emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol;

import emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol.baseInterface.ProtocolBaseInterface;

import java.util.HashMap;
import java.util.Map;

/**
 * @className: Mqtt
 * @author: WenjieYang
 * @date: 2024/11/14 15:17
 * @Version: 1.0
 * @description: 协议规则MQTT
 */

public class Mqtt implements ProtocolBaseInterface {

    private Map<String,Object> properties = new HashMap<>();



    public Mqtt(String protocolType , String msgType, String topicName, String desc) {
        properties.put("protocolType", protocolType);
        properties.put("msgType", msgType);// 消息类型
        properties.put("topicName", topicName);// 主题名称
        properties.put("desc", desc); // 描述
    }

    @Override
    public Map<String, Object> getProperties() {
        return properties;
    }
    public void setProperties(String k , Object v){
        properties.put(k,v);
    }
}
