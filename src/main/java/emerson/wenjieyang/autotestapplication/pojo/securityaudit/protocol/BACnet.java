package emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol;

import emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol.baseInterface.ProtocolBaseInterface;

import java.util.HashMap;
import java.util.Map;

/**
 * @className: BACnet
 * @author: WenjieYang
 * @date: 2024/11/14 15:22
 * @Version: 1.0
 * @description: 协议规则 BACnet  示例 ： 每一个都需添加 “protocolType”属性，用来对应是哪一个类。
 */

public class BACnet implements ProtocolBaseInterface {

    private Map<String, Object> properties = new HashMap<>();


    public BACnet(String protocolType , String dataCellType, String serveSelect, String desc) {
        properties.put("protocolType", protocolType);
        properties.put("dataCellType", dataCellType);// 数据单元类型
        properties.put("serveSelect", serveSelect);// 服务选择
        properties.put("desc", desc); // 描述
    }

    @Override
    public Map<String, Object> getProperties() {
        return properties ;
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
        return "BACent协议 {" +
                "协议类型='" + properties.get("protocolType") + '\'' +
                ", 数据单元类型='" + properties.get("dataCellTyp") + '\'' +
                ", 服务选择='" + properties.get("serveSelect") + '\'' +
                ", 描述='" + properties.get("desc") + '\'' +
                '}';
    }
}
