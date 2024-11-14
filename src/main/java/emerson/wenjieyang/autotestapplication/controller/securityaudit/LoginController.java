package emerson.wenjieyang.autotestapplication.controller.securityaudit;

import emerson.wenjieyang.autotestapplication.config.securityaudit.FilePathConfig;
import emerson.wenjieyang.autotestapplication.pojo.Response;
import emerson.wenjieyang.autotestapplication.service.securityaudit.LoginService;
import emerson.wenjieyang.autotestapplication.util.RespondUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject : autotestApplication
 * @BelongsPackage : emerson.wenjieyang.autotestapplication.securityaudit.controller
 * @Author : YWJ
 * @CreateTime : 2024-10-22  18:57
 * @Description : //
 * @Version : 1.0
 */


@RestController
@RequestMapping("/securityaudit")
@Tag(name = "登录接口")
public class LoginController {

    @Autowired
    private LoginService loginService;


    @Autowired
    private FilePathConfig filePathConfig;

    /**
     * 系统登录测试
     * @return
     */
    @GetMapping("/logintest")
    @Operation(summary = "系统登录测试")
    public Response<Object> logintest() {
        // 测试用例地址
        String loginCasePath = filePathConfig.getLoginCasePath();
        // 日志生成地址
        String securityAuditLogoutPath = filePathConfig.getLogOutPath();
        // 调用测试接口
        loginService.loginTest(loginCasePath, securityAuditLogoutPath);
        return RespondUtil.success() ;
    }
}
