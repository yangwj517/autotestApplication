package emerson.wenjieyang.autotestapplication.controller.securityaudit;

import emerson.wenjieyang.autotestapplication.pojo.Response;
import emerson.wenjieyang.autotestapplication.service.securityaudit.RuleManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: RuleManagerController
 * @author: WenjieYang
 * @date: 2024/11/13 15:22
 * @Version: 1.0
 * @description: 规则管理控制层
 */


@RestController
@RequestMapping("/security/ruleManage")
public class RuleManageController {


    @Autowired
    RuleManageService ruleManageService;


    /**
     * 手动 应用协议白名单规则添加
     * @return
     */
    @GetMapping("/addNewAppWhiteListRules")
    public Response<Object> addNewWhiteListRule(){
        return ruleManageService.addNewAppWhiteListRule() ;
    }
}
