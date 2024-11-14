package emerson.wenjieyang.autotestapplication.controller.securityaudit;

import emerson.wenjieyang.autotestapplication.pojo.Response;
import emerson.wenjieyang.autotestapplication.service.securityaudit.InvasionDetectedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * @className: InvasionDetectedController
 * @author: WenjieYang
 * @date: 2024/11/5 10:45
 * @Version: 1.0
 * @description: TODO：IDS 入侵检测控制层
 */

@RestController
@RequestMapping("/security/ids")
public class InvasionDetectedController {

    @Autowired
    private InvasionDetectedService invasionDetectedService;

    /**
     * 时间对象添加测试
     * @return 测试过程是否顺利执行完成
     */
    @GetMapping("/addTimeObject")
    public Response<Object> addNewTimeObjectTest(){
        return  invasionDetectedService.addNewTimeObject();
    }

    /**
     * 地址对象添加测试
     * @return
     */
    @GetMapping("/addAddressObject")
    public Response<Object> addNewAddressObjectTest(){
        return invasionDetectedService.addNewAddressObject();
    }


    /**
     * 规则集添加测试
     * @return
     */
    @GetMapping("/addRuleSet")
    public Response<Object> addNewRuleSetTest(){
        return invasionDetectedService.addNewRuleSet();
    }


    /**
     * 检测策略添加测试
     * @return
     */
    @GetMapping("/addDetectionPolicy")
    public Response<Object> addNewDetectionPolicyTest(){
        return invasionDetectedService.addNewDetectionPolicy();
    }
}
