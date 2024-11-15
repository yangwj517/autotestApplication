package emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol;

import emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol.baseInterface.ProtocolBaseInterface;

import java.util.HashMap;
import java.util.Map;

/**
 * @className: FinsTcp
 * @author: WenjieYang
 * @date: 2024/11/14 15:32
 * @Version: 1.0
 * @description: 协议规则 FinsTcp
 */

public class FinsTcp implements ProtocolBaseInterface {

    private Map<String,Object> properties = new HashMap<String,Object>();


    public FinsTcp(String protocolType , String funCode, String diskNum, String desc) {
        properties.put("protocolType", protocolType);
        properties.put("funCode", funCode);// 功能码
        properties.put("diskNum", diskNum);// 磁盘号
        properties.put("desc", desc);  // 描述
    }


    @Override
    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(String k , String v) {
        properties.put(k,v);
    }
}
