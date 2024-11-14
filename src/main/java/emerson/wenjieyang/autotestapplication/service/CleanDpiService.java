package emerson.wenjieyang.autotestapplication.service;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import emerson.wenjieyang.autotestapplication.config.securityaudit.DpiCleanConfig;
import emerson.wenjieyang.autotestapplication.pojo.Response;
import emerson.wenjieyang.autotestapplication.util.CleanDPIUtil;
import emerson.wenjieyang.autotestapplication.util.RespondUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @className: CleanDpiService
 * @author: WenjieYang
 * @date: 2024/11/5 15:38
 * @Version: 1.0
 * @description: dpi 清理服务层
 */

@Service
public class CleanDpiService {

    @Autowired
    DpiCleanConfig dpiCleanConfig;


    //  此方法是否需要写成公用的方法？-- 考虑后将每个设备的单独写一个方法
    /**
     * 建立ssh链接
     * @return
     */
    public Response<Object> cleanDpiForSecurityAudit() {
        Session session = CleanDPIUtil.createSession(dpiCleanConfig.getUsername(),dpiCleanConfig.getHost(),dpiCleanConfig.getPort(),dpiCleanConfig.getPassword());
        boolean b = CleanDPIUtil.cleanDpi(session, dpiCleanConfig.getCommands());

        return b?RespondUtil.success("dpi清理成功！"):RespondUtil.error("dpi清理失败！");
    }

    // TODO : 如有需要请补充其他设备的对应方法


}
