package emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol;

import emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol.baseInterface.ProtocolBaseInterface;
import lombok.Data;


import java.util.HashMap;
import java.util.Map;

public class ProFinetIo implements ProtocolBaseInterface {

    private Map<String , Object> properties = new HashMap<String , Object>();

    // 构造函数
    public ProFinetIo(String protocolType , String interfaceId, String actionCode, String partType, String desc) {
        properties.put("protocolType", protocolType);
        properties.put("interfaceId", interfaceId);// 接口ID
        properties.put("actionCode", actionCode);// 操作码
        properties.put("partType", partType);// 块类型
        properties.put("desc", desc);// 描述
    }

    @Override
    public Map<String, Object> getProperties() {
        return properties;
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

    public void setProperties(String k , Object v){
        properties.put(k , v);
    }
    @Override
    public String toString() {
        return "ProInf协议 {" +
                "协议类型='" + properties.get("protocolType") + '\'' +
                ", 接口ID='" + properties.get("interfaceId") + '\'' +
                ", 操作码='" + properties.get("actionCode") + '\'' +
                ", 块类型='" + properties.get("partType") + '\'' +
                ", 描述='" + properties.get("desc") + '\'' +
                '}';
    }

}