package emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol;

import com.fasterxml.jackson.databind.util.ObjectBuffer;
import emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol.baseInterface.ProtocolBaseInterface;

import java.util.HashMap;
import java.util.Map;

/**
 * @className: Iec104
 * @author: WenjieYang
 * @date: 2024/11/14 14:22
 * @Version: 1.0
 * @description: 协议规则IEC104
 */

public class Iec104 implements ProtocolBaseInterface {

    private Map<String , Object> properties = new HashMap<String , Object>();


    public Iec104(String protocolType , String type, String typeFlag, String transferReason, String publicAddress, String infAddress, String infParam, String desc) {
        properties.put("protocolType", protocolType);
        properties.put("type", type);// 帧类型
        properties.put("typeFlag", typeFlag);// 类型标识
        properties.put("transferReason", transferReason);// 传输原因
        properties.put("publicAddress", publicAddress);// 公共地址
        properties.put("infAddress", infAddress);// 信息体地址
        properties.put("infParam", infParam); // 信息体参数
        properties.put("desc", desc);// 描述
    }

    @Override
    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(String k , Object v) {
        properties.put(k , v);
    }
    @Override
    public String toString() {
        return "Iec04协议 {" +
                "协议类型='" + properties.get("protocolType") + '\'' +
                ", 帧类型='" + properties.get("type") + '\'' +
                ", 类型标识='" + properties.get("typeFlag") + '\'' +
                ", 传输原因='" + properties.get("transferReason") + '\'' +
                ", 公共地址='" + properties.get("publicAddress") + '\'' +
                ", 信息体地址='" + properties.get("infAddress") + '\'' +
                ", 信息体参数='" + properties.get("infParam") + '\'' +
                ", 描述='" + properties.get("desc") + '\'' +
                '}';
    }

}
