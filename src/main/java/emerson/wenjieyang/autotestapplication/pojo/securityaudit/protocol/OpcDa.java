package emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol;

import emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol.baseInterface.ProtocolBaseInterface;

import java.util.HashMap;
import java.util.Map;

/**
 * @className: OpcDa
 * @author: WenjieYang
 * @date: 2024/11/14 14:16
 * @Version: 1.0
 * @description: 协议规则 OPCDA
 */

public class OpcDa implements ProtocolBaseInterface {
    private Map<String,Object> properties = new HashMap<>();

    public OpcDa(String protocolType , String uuid, String actionCode, String type, String name, String value, String desc) {
        properties.put("protocolType",protocolType);
        properties.put("uuid",uuid);// uuid
        properties.put("actionCode",actionCode);// 操作码
        properties.put("type",type);// 项类型
        properties.put("name",name);// 项名
        properties.put("value",value);// 项值
        properties.put("desc",desc);// 描述
    }

    @Override
    public Map<String, Object> getProperties() {
        return Map.of();
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
        return "OpcDa协议 {" +
                "协议类型='" + properties.get("protocolType") + '\'' +
                ", uuid='" + properties.get("uuid") + '\'' +
                ", 操作码='" + properties.get("actionCode") + '\'' +
                ", 项类型='" + properties.get("type") + '\'' +
                ", 项名='" + properties.get("name") + '\'' +
                ", 项值='" + properties.get("value") + '\'' +
                ", 描述='" + properties.get("desc") + '\'' +
                '}';
    }
}
