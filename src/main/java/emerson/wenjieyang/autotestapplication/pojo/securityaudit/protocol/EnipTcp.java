package emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol;

import emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol.baseInterface.ProtocolBaseInterface;

import java.util.HashMap;
import java.util.Map;

/**
 * @className: EnipTcp
 * @author: WenjieYang
 * @date: 2024/11/14 14:32
 * @Version: 1.0
 * @description: 协议规则 ENIP-TCP
 */

public class EnipTcp implements ProtocolBaseInterface {

    Map<String,Object> properties =  new HashMap<String, Object>();

    public EnipTcp(String protocolType ,String order, String addressType, String dataType, String cipDataSegment, String desc) {
      properties.put("protocolType",protocolType);
      properties.put("order",order);// 指令
      properties.put("addressType",addressType);// 地址类型
      properties.put("dataType",dataType);// 数据类型
      properties.put("cipDataSegment",cipDataSegment);// CIP数据段
      properties.put("desc",desc);// 描述
    }

    @Override
    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(String k , Object v) {
        properties.put(k,v);
    }
    @Override
    public String getInterfaceId() {
        return (String) properties.get("interfaceId");
    }

    @Override
    public String getActionCode() {
        return (String) properties.get("actionCode");
    }

    @Override
    public String getPartType() {
        return (String) properties.get("partType");
    }

    @Override
    public String getDesc() {
        return (String) properties.get("desc");
    }
    @Override
    public String toString() {
        return "EnipTcp协议 {" +
                "协议类型='" + properties.get("protocolType") + '\'' +
                ", 指令='" + properties.get("order") + '\'' +
                ", 地址类型='" + properties.get("addressType") + '\'' +
                ", 数据类型='" + properties.get("dataType") + '\'' +
                ", CIP数据段='" + properties.get("cipDataSegment") + '\'' +
                ", 描述='" + properties.get("desc") + '\'' +
                '}';
    }
}
