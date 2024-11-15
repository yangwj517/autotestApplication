package emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol;

import emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol.baseInterface.ProtocolBaseInterface;

import java.util.HashMap;
import java.util.Map;

public class ProFinetIo implements ProtocolBaseInterface {

    private Map<String , Object> properties = new HashMap<String , Object>();

    // 构造函数
    public ProFinetIo(String protocolType , String interfaceId, String actionCode, String partType, String desc) {
        properties.put("protocolType", protocolType);
        properties.put("interfaceId", interfaceId);// 接口ID
        properties.put("actionCode", actionCode);// 操作码
        properties.put("partType", partType);// 块类型
        properties.put("desc", desc);// 描述
    }

    @Override
    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(String k , Object v){
        properties.put(k , v);
    }

}