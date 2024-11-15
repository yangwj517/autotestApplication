package emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol;

import emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol.baseInterface.ProtocolBaseInterface;

import java.util.HashMap;
import java.util.Map;

/**
 * @className: Focas
 * @author: WenjieYang
 * @date: 2024/11/14 14:55
 * @Version: 1.0
 * @description: 协议规则 FOCAS
 */

public class Focas implements ProtocolBaseInterface {

    private Map<String,Object> properties = new HashMap<String,Object>();


    public Focas(String protocolType , String order, String type, String keyBroad, String funCode, String sunFunCode, String desc) {
        properties.put("protocolType", protocolType);
        properties.put("order", order); // 命令
        properties.put("type", type);// 类型
        properties.put("keyBroad", keyBroad);// 按键
        properties.put("funCode", funCode);// 功能码
        properties.put("sunFunCode", sunFunCode); // 子功能码
        properties.put("desc", desc);// 描述
    }

    @Override
    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(String k , Object v ) {
        properties.put(k,v);
    }
    @Override
    public String toString() {
        return "Focas协议 {" +
                "协议类型='" + properties.get("protocolType") + '\'' +
                ", 命令='" + properties.get("order") + '\'' +
                ", 类型='" + properties.get("type") + '\'' +
                ", 按键='" + properties.get("keyBroad") + '\'' +
                ", 功能码='" + properties.get("funCode") + '\'' +
                ", 子功能码='" + properties.get("sunFunCode") + '\'' +
                ", 描述='" + properties.get("desc") + '\'' +
                '}';
    }
}
