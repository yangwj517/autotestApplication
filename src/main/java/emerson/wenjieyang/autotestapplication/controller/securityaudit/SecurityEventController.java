package emerson.wenjieyang.autotestapplication.controller.securityaudit;

import emerson.wenjieyang.autotestapplication.pojo.Response;
import emerson.wenjieyang.autotestapplication.service.securityaudit.SecurityEventService;
import emerson.wenjieyang.autotestapplication.util.RespondUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: SecurityEventController
 * @author: WenjieYang
 * @date: 2024/11/13 9:59
 * @Version: 1.0
 * @description: TODO：
 */

@RestController
@RequestMapping("/security/event")
@Tag(name = "安全事件页接口")
public class SecurityEventController {

    @Autowired
    private SecurityEventService securityEventService;

    /**
     * 安全事件页 新增事件告警配置 测试
     * @return
     */
    @GetMapping("/addAlarmConfiguration")
    @Operation(summary = "安全事件页 新增事件告警配置 测试")
    public Response<Object> addAlarmConfiguration(){
        return securityEventService.createNewAlarmConfigure();
    }


}
