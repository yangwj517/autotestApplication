package emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol;

import emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol.baseInterface.ProtocolBaseInterface;

import java.util.HashMap;
import java.util.Map;

/**
 * @className: S7Plus
 * @author: WenjieYang
 * @date: 2024/11/14 14:58
 * @Version: 1.0
 * @description: 规则协议S7-PLUS
 */

public class S7Plus implements ProtocolBaseInterface {
    private Map<String ,Object> properties = new HashMap<String ,Object>();


    public S7Plus(String protocolType , String controlCode, String funCode, String desc) {
        properties.put("protocolType", protocolType);// 操作码
        properties.put("controlCode", controlCode);// 功能码
        properties.put("funCode", funCode);// 描述
        properties.put("desc", desc);
    }

    @Override
    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(String k , Object v){
        properties.put(k , v);
    }
    @Override
    public String toString() {
        return "S7Plus协议 {" +
                "协议类型='" + properties.get("protocolType") + '\'' +
                ", 控制码='" + properties.get("controlCode") + '\'' +
                ", 功能码='" + properties.get("funCode") + '\'' +
                ", 描述='" + properties.get("desc") + '\'' +
                '}';
    }
}
