package emerson.wenjieyang.autotestapplication.controller.securityaudit;

import emerson.wenjieyang.autotestapplication.pojo.Response;
import emerson.wenjieyang.autotestapplication.service.securityaudit.AuditService;
import emerson.wenjieyang.autotestapplication.service.securityaudit.RemoteAuditService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * @className: ProtocolAuditController
 * @author: WenjieYang
 * @date: 2024/10/29 13:57
 * @Version: 1.0
 * @description: 协议审计控制层
 */

@RestController
@RequestMapping("/remote")
@Tag(name = "远程审计接口")
public class ProtocolAuditController {

    @Autowired
    private AuditService auditService;

    @Autowired
    private RemoteAuditService remoteAuditService;

    /**
     * 《已废弃》 根据协议名称和网卡接口，测试审计功能-- 应该仅按照网卡接口来进行审计，所有的协议，能一次过。
     */
    @Deprecated
    @GetMapping("/local/{protocol}/{interfaceName}")
    @Operation(summary = "根据协议名称和网卡接口，测试审计功能")
    @Parameter(name = "protocol", description = "协议名称")
    @Parameter(name = "interfaceName", description = "网卡接口名称")
    public Response<Object> protocolAudit(@PathVariable("protocol") String protocol,@PathVariable("interfaceName") String interfaceName) {
        // 从这里调用service
        return auditService.accessAuditPage(protocol,interfaceName);
    }


    /**
     * 调用远程接口，实现使用另一台设备回放报文
     */
    @GetMapping("/sendPacket/{interfaceName}")
    @Operation(summary = "调用远程接口，实现使用另一台设备回放报文")
    @Parameter(name = "interfaceName", description = "网卡接口名称")
    public Response<Object> remoteSendProtocolPacket(@PathVariable("interfaceName") String interfaceName)  {
        return remoteAuditService.RemoteSendPackets(interfaceName);
    }


    /**
     * 远程主机网卡名称列表获取
     * @return
     */
    @GetMapping("/getInterfaceNamesList")
    @Operation(summary = "远程主机网卡名称列表获取")
    public Response<Object> getRemoteInterfaceName()  {
        return remoteAuditService.getRemoteInterfaceName() ;
    }
}
