package emerson.wenjieyang.autotestapplication.controller;

import emerson.wenjieyang.autotestapplication.pojo.Response;
import emerson.wenjieyang.autotestapplication.service.CleanDpiService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: CleanDpiController
 * @author: WenjieYang
 * @date: 2024/11/5 15:36
 * @Version: 1.0
 * @description: 控制层 与设备建立ssh链接，清理dpi，避免协议审计不到的情况
 */

@RestController
@Tag(name = "设备DPI清理接口")
public class CleanDpiController {

    @Autowired
    CleanDpiService cleanDpiService;

    /**
     * 设备DPI清理接口
     * @return
     */
    @GetMapping("/cleanDpiForSecurityAudit")
    @Operation(summary = "设备DPI清理接口")
    public Response<Object> cleanDpi() {
        return cleanDpiService.cleanDpiForSecurityAudit() ;
    }

    // FIXME : 如有需要，请添加其他设备的控制方法，对应的service , 并配置各自的ssh配置。
}
