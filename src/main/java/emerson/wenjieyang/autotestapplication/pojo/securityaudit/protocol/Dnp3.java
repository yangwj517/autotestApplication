package emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol;

import emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol.baseInterface.ProtocolBaseInterface;

import javax.management.ObjectName;
import java.util.HashMap;
import java.util.Map;

/**
 * @className: Dnp3
 * @author: WenjieYang
 * @date: 2024/11/14 14:19
 * @Version: 1.0
 * @description: 协议规则 DNP3
 */
public class Dnp3  implements ProtocolBaseInterface {
    private Map<String,Object> properties = new HashMap<String,Object>();

    // 功能码
    private String code ;

    // 对象个数
    private String count ;

    // 描述
    private String desc ;

    public Dnp3(String protocolType , String code, String count, String desc) {
        properties.put("protocolType", protocolType);
        properties.put("code",code);
        properties.put("count",count);
        properties.put("desc",desc);
    }


    @Override
    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(String k , Object v) {
        properties.put(k,v);
    }
}
