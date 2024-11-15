package emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol;

import emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol.baseInterface.ProtocolBaseInterface;

import java.util.HashMap;
import java.util.Map;

/**
 * @className: OpcUaTcp
 * @author: WenjieYang
 * @date: 2024/11/14 14:31
 * @Version: 1.0
 * @description: 协议规则OPCUA-TCP
 */

public class OpcUaTcp implements ProtocolBaseInterface {

    private Map<String , Object> properties = new HashMap<String , Object>();

    public OpcUaTcp(String protocolType , String serveCode, String desc) {
        properties.put("protocolType", protocolType);
        properties.put("serveCode", serveCode);// 服务码
        properties.put("desc", desc); // 描述

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
        return "OpcUaTcp协议 {" +
                "协议类型='" + properties.get("protocolType") + '\'' +
                ", 服务码='" + properties.get("serveCode") + '\'' +
                ", 描述='" + properties.get("desc") + '\'' +
                '}';
    }
}
