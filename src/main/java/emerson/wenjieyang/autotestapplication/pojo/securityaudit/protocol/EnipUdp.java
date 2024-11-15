package emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol;

import emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol.baseInterface.ProtocolBaseInterface;

import java.util.HashMap;
import java.util.Map;

/**
 * @className: EnipUdp
 * @author: WenjieYang
 * @date: 2024/11/14 14:39
 * @Version: 1.0
 * @description: TODO：
 */

public class EnipUdp implements ProtocolBaseInterface {

    private Map<String,Object> properties = new HashMap<String,Object>();


    public EnipUdp(String protocolType , String order, String desc) {
        properties.put("protocolType", protocolType);
        properties.put("order", order);// 指令
        properties.put("desc", desc);// 描述
    }

    @Override
    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(String k , Object v) {
        properties.put(k,v);
    }
}
