package emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol;

import emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol.baseInterface.ProtocolBaseInterface;

import java.util.HashMap;
import java.util.Map;

/**
 * @className: FinsTcp
 * @author: WenjieYang
 * @date: 2024/11/14 15:32
 * @Version: 1.0
 * @description: 协议规则 FinsTcp
 */

public class FinsTcp implements ProtocolBaseInterface {

    private Map<String,Object> properties = new HashMap<String,Object>();


    public FinsTcp(String protocolType , String funCode, String diskNum, String desc) {
        properties.put("protocolType", protocolType);
        properties.put("funCode", funCode);// 功能码
        properties.put("diskNum", diskNum);// 磁盘号
        properties.put("desc", desc);  // 描述
    }


    @Override
    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(String k , String v) {
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
        return "FinsTcp协议 {" +
                "协议类型='" + properties.get("protocolType") + '\'' +
                ", 功能码='" + properties.get("funCode") + '\'' +
                ", 磁盘号='" + properties.get("diskNum") + '\'' +
                ", 描述='" + properties.get("desc") + '\'' +
                '}';
    }
}
