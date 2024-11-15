package emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol;

import emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol.baseInterface.ProtocolBaseInterface;

import java.util.HashMap;
import java.util.Map;

/**
 * @className: EnipIo
 * @author: WenjieYang
 * @date: 2024/11/14 14:48
 * @Version: 1.0
 * @description: 协议规则 ENIP-IO
 */

public class EnipIo implements ProtocolBaseInterface {

    Map<String,Object> properties = new HashMap<String,Object>();


    public EnipIo(String protocolType ,String addressType, String dataAddress, String desc) {
        properties.put("protocolType",protocolType);
        properties.put("addressType",addressType);// 地址类型
        properties.put("dataAddress",dataAddress);// 数据类型
        properties.put("desc",desc); // 描述
    }

    @Override
    public Map<String, Object> getProperties() {
        return properties ;
    }

    public void setProperties(String k , Object v) {
        properties.put(k,v);
    }
    @Override
    public String toString() {
        return "Eniplo协议 {" +
                "协议类型='" + properties.get("protocolType") + '\'' +
                ", 地址类型='" + properties.get("addressType") + '\'' +
                ", 数据类型='" + properties.get("dataAddress") + '\'' +
                ", 描述='" + properties.get("desc") + '\'' +
                '}';
    }
}
