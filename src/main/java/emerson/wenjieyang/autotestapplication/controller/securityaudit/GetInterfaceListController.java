package emerson.wenjieyang.autotestapplication.controller.securityaudit;

import emerson.wenjieyang.autotestapplication.pojo.Response;
import emerson.wenjieyang.autotestapplication.service.securityaudit.GetInterfaceListService;
import emerson.wenjieyang.autotestapplication.util.RespondUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: GetInterfaceListController
 * @author: WenjieYang
 * @date: 2024/10/25 13:31
 * @Version: 1.0
 * @description: 获取本地网卡地址
 */

@RestController
@RequestMapping("/local")
@Tag(name = "获取本地网卡名称列表接口")
public class GetInterfaceListController {

    @Autowired
    private GetInterfaceListService getInterfaceListService;

    /**
     * 获取本地网卡名称列表
     * @return
     */
    @GetMapping("/interfaceNames")
    @Operation(summary = "获取本地网卡名称列表")
    public Response<Object> interfaceNames(){
        return RespondUtil.success(getInterfaceListService.getInterfaceName());
    }
}
