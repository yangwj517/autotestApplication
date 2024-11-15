package emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol;

import emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol.baseInterface.ProtocolBaseInterface;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @className: Mms
 * @author: WenjieYang
 * @date: 2024/11/14 14:29
 * @Version: 1.0
 * @description: 协议规则 MMS
 */

public class Mms implements ProtocolBaseInterface {

    private Map<String , Object> properties = new HashMap<String , Object>();



    public Mms(String protocolType , String type, String serve, String desc) {
       properties.put("protocolType", protocolType);
       properties.put("type", type);// 类型
       properties.put("serve", serve); // 服务
       properties.put("desc", desc);// 描述
    }

    @Override
    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(String k , Object v ){
        properties.put(k , v);
    }
}
