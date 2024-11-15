package emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol;

import emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol.baseInterface.ProtocolBaseInterface;

import java.util.HashMap;
import java.util.Map;

/**
 * @className: Trdp
 * @author: WenjieYang
 * @date: 2024/11/14 15:24
 * @Version: 1.0
 * @description: 协议规则 TRDP
 */

public class Trdp implements ProtocolBaseInterface {

    private Map<String,Object> properties = new HashMap<String,Object>();
    

    public Trdp(String protocolType , String packetType, String etbCount, String count, String responseIp, String sourceUrl, String targetUrl, String desc) {
        properties.put("protocolType", protocolType);// 报文类型
        properties.put("packetType", packetType);// ETB拓扑计数器
        properties.put("etbCount", etbCount);// 列车操作拓扑计数器
        properties.put("count", count);// 应答IP地址
        properties.put("responseIp", responseIp); // 源URL
        properties.put("sourceUrl", sourceUrl); // 目的URL
        properties.put("targetUrl", targetUrl); // 描述
        properties.put("desc", desc);
    }


    @Override
    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(String k , Object v){
        properties.put(k,v);
    }
}
