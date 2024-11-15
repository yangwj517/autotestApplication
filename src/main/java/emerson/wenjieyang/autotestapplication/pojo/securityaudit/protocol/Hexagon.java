package emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol;

import emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol.baseInterface.ProtocolBaseInterface;

import java.util.HashMap;
import java.util.Map;

/**
 * @className: Hexagon
 * @author: WenjieYang
 * @date: 2024/11/14 14:49
 * @Version: 1.0
 * @description: 协议规则 Hexagon
 */

public class Hexagon implements ProtocolBaseInterface{


    private Map<String ,Object> properties = new HashMap<String ,Object>();

    public Hexagon(String  protocolType , String funCode, String sunCode, String desc) {
        properties.put("protocolType", protocolType);
        properties.put("funCode", funCode);// 功能码
        properties.put("sunCode", sunCode);// 子功能码
        properties.put("desc", desc); // 描述
    }

    @Override
    public Map<String, Object> getProperties() {
        return properties ;
    }

    public void setProperties(String k , String v) {
        properties.put(k , v);
    }
}
