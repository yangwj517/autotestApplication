package emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol;

import emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol.baseInterface.ProtocolBaseInterface;

import java.util.HashMap;
import java.util.Map;

/**
 * @className: Egd
 * @author: WenjieYang
 * @date: 2024/11/14 15:29
 * @Version: 1.0
 * @description: 协议规则EGD
 */

public class Egd implements ProtocolBaseInterface {
    private Map<String ,Object> properties = new HashMap<String ,Object>() ;

    // 状态码
    private String statusCode ;

    // 描述
    private String desc ;

    public Egd(String protocolType ,String statusCode, String desc) {
        properties.put("protocolType",protocolType);
        properties.put("statusCode",statusCode);
        properties.put("desc",desc);
    }

    @Override
    public Map<String, Object> getProperties() {
        return properties;
    }
    @Override
    public String toString() {
        return "Egd协议 {" +
                "协议类型='" + properties.get("protocolType") + '\'' +
                ", 状态码='" + properties.get("statusCode") + '\'' +
                ", 描述='" + properties.get("desc") + '\'' +
                '}';
    }
}
