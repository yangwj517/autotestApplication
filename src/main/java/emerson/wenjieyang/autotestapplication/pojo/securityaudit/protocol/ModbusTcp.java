package emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol;

import emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol.baseInterface.ProtocolBaseInterface;

import java.util.HashMap;
import java.util.Map;

/**
 * @className: ModbusTcp
 * @author: WenjieYang
 * @date: 2024/11/14 14:10
 * @Version: 1.0
 * @description: 协议规则ModbusTcp
 */

public class ModbusTcp implements ProtocolBaseInterface {

    private Map<String , Object> properties = new HashMap<String , Object>();


    public ModbusTcp(String protocolType , String stationAddress, String funCode , String beginRange ,String endRange , String valueType, String valueRange , String desc) {
        properties.put("protocolType", protocolType);
        // 从站地址
        properties.put("stationAddress", stationAddress);
        // 功能码
        properties.put("funCode", funCode);
        // 起始范围
        properties.put("beginRange", beginRange);
        // 结束地址范围
        properties.put("endRange", endRange);
        // 值类型
        properties.put("valueType", valueType);
        // 值范围
        properties.put("valueRange", valueRange);
        // 描述
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
        return "ModbusTcp协议 {" +
                "协议类型='" + properties.get("protocolType") + '\'' +
                ", 从站地址='" + properties.get("stationAddress") + '\'' +
                ", 功能码='" + properties.get("funCode") + '\'' +
                ", 起始地址='" + properties.get("beginRange") + '\'' +
                ", 结束地址='" + properties.get("endRange") + '\'' +
                ", 值类型='" + properties.get("valueType") + '\'' +
                ", 值范围='" + properties.get("valueRange") + '\'' +
                ", 描述='" + properties.get("desc") + '\'' +
                '}';
    }

}
