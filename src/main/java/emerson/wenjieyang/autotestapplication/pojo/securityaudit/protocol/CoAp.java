package emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol;

import emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol.baseInterface.ProtocolBaseInterface;

import java.util.HashMap;
import java.util.Map;

/**
 * @className: CoAp
 * @author: WenjieYang
 * @date: 2024/11/14 15:20
 * @Version: 1.0
 * @description: 协议规则CoAp
 */

public class CoAp implements ProtocolBaseInterface {

    private Map<String,Object> properties = new HashMap<String,Object>();

    public CoAp(String protocolType , String msgType, String funCode, String desc) {
        properties.put("protocolType",protocolType);
        properties.put("msgType",msgType);// 消息类型
        properties.put("funCode",funCode);// 功能码
        properties.put("desc",desc);// 描述
    }

    @Override
    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(String k , Object v) {
        properties.put(k,v);
    }
}
