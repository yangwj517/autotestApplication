package emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol;

import emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol.baseInterface.ProtocolBaseInterface;

import java.util.HashMap;
import java.util.Map;

/**
 * @className: SIP
 * @author: WenjieYang
 * @date: 2024/11/14 14:07
 * @Version: 1.0
 * @description: 协议规则SIP
 */

public class SIP implements ProtocolBaseInterface {

    private Map<String,Object> properties = new HashMap<String,Object>();


    public SIP(String protocolType , String funName, String desc) {
        properties.put("protocolType", protocolType);
        properties.put("funName", funName); // 方法名
        properties.put("desc", desc); // 描述
    }

    @Override
    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(String k , Object v){
        properties.put(k,v);
    }
}
