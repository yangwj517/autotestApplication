package emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol;

import emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol.baseInterface.ProtocolBaseInterface;

import java.util.HashMap;
import java.util.Map;

/**
 * @className: Oracle
 * @author: WenjieYang
 * @date: 2024/11/14 14:52
 * @Version: 1.0
 * @description: 协议规则ORACLE
 */

public class Oracle implements ProtocolBaseInterface {

    private Map<String,Object> properties = new HashMap<String,Object>();

    public Oracle(String protocolType , String order, String name, String desc) {
        properties.put("protocolType", protocolType);
        properties.put("order", order);// 操作指令
        properties.put("name", name);// 用户名
        properties.put("desc", desc); // 描述
    }

    @Override
    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(String k ,Object v){
        properties.put(k,v);
    }
    @Override
    public String toString() {
        return "Oracle协议 {" +
                "协议类型='" + properties.get("protocolType") + '\'' +
                ", 操作指令='" + properties.get("order") + '\'' +
                ", 用户名='" + properties.get("name") + '\'' +
                ", 描述='" + properties.get("desc") + '\'' +
                '}';
    }
}
