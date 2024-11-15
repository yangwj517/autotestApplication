package emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol;

import emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol.baseInterface.ProtocolBaseInterface;

import java.util.HashMap;
import java.util.Map;

/**
 * @className: Ftp
 * @author: WenjieYang
 * @date: 2024/11/14 14:53
 * @Version: 1.0
 * @description: 协议规则
 */

public class Ftp implements ProtocolBaseInterface {

    private Map<String , Object> properties = new HashMap<String , Object>();

    public Ftp(String protocolType , String order, String desc) {
        properties.put("protocolType", protocolType);
        properties.put("order", order);// 命令
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

    public void setProperties(String k , Object v) {
        properties.put(k , v);
    }
    @Override
    public String toString() {
        return "FTP协议 {" +
                "协议类型='" + properties.get("protocolType") + '\'' +
                ", 命令='" + properties.get("order") + '\'' +
                ", 描述='" + properties.get("desc") + '\'' +
                '}';
    }
}
