package emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol.baseInterface;

import java.util.Map;

/**
 * @className: protocolBaseInterface
 * @author: WenjieYang
 * @date: 2024/11/14 16:55
 * @Version: 1.0
 * @description: 协议底层基类 ， 实现动态反射
 */

public interface ProtocolBaseInterface {

    // 属性存储集合
    Map<String,Object> getProperties();

}
