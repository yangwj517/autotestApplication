package emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol;

import emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol.baseInterface.ProtocolBaseInterface;

import java.util.HashMap;
import java.util.Map;

/**
 * @className: S7
 * @author: WenjieYang
 * @date: 2024/11/14 14:41
 * @Version: 1.0
 * @description: 协议规则S7
 */

public class S7 implements ProtocolBaseInterface {

    private Map<String ,Object> properties = new HashMap<String ,Object>();

    public S7(String protocolType , String controlType, String ioDomain, String dataNum, String beginAddress, String dataType, String dataLength, String dataRange, String desc) {
       properties.put("protocolType", protocolType);
       properties.put("controlType", controlType);// 操作类型
       properties.put("ioDomain", ioDomain);// 读、写 域
       properties.put("dataNum", dataNum);// 数据块编号
       properties.put("beginAddress", beginAddress); // 起始地址
       properties.put("dataType", dataType);// 数据类型
       properties.put("dataLength", dataLength);// 数据类型长度
       properties.put("dataRange", dataRange);// 数据值范围
       properties.put("desc", desc); // 描述
    }

    @Override
    public Map<String, Object> getProperties() {

        return properties;
    }

    public void setProperties(String k , Object v) {
        properties.put(k , v);
    }
}
