package emerson.wenjieyang.autotestapplication.util;

import com.jcraft.jsch.ChannelShell;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import java.io.*;
import java.util.List;

/**
 * @className: CleanDPIUtil
 * @author: WenjieYang
 * @date: 2024/11/6 14:10
 * @Version: 1.0
 * @description: dpi清理工具类
 */

public class CleanDPIUtil {


    /**
     * 创建ssh远程连接会话session
     * @param username  用户名
     * @param host 远程主机地址
     * @param port ssh链接端口
     * @param password 密码
     * @return session会话对象
     */
    public static Session createSession(String username , String host , int port , String password) {
        JSch jsch = new JSch();
        Session session = null;
        try {
            session= jsch.getSession(username, host, port);
            session.setPassword(password);
            // 处理主机安全验证
            session.setConfig("StrictHostKeyChecking", "no");
        } catch (JSchException e) {
            throw new RuntimeException(e);
        }
        // 返回会话
        return  session ;
    }

    /**
     * 以此发送 command 到 session
     * @param session ssh会话对象
     * @param commands 命令数组 必须 以执行顺序存储
     * @return 是否执行成功
     */
    public static boolean cleanDpi(Session session, List<String> commands)  {
        boolean result = false;
        InputStream is = null;
        OutputStream os = null;
        PrintWriter pw = null;
        BufferedReader br = null;
        // 建立连接
        try {
            session.connect();
            // 建立 通讯 通道
            ChannelShell shell = (ChannelShell) session.openChannel("shell");

            // 创建输入流，读取远程shell输出
            is = shell.getInputStream();
            shell.setPty(true);
            shell.connect();

            // 创建输出流，将命令写入远端shell
            os = shell.getOutputStream();

            // 使用《PrintWrite》，直接将命令写入
            pw = new PrintWriter(os);

            // 创建字符缓冲流，读取远端输出
            br = new BufferedReader(new InputStreamReader(is));

            for (int i = 0; i < commands.size(); i++) {
                pw.println(commands.get(i));
                pw.flush();
                // 检测是否执行结束
                expectPrompt(br);
            }
            shell.disconnect();
            result = true;
        } catch (JSchException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            // 释放创建所有的流
            if (pw != null) {
                pw.close();
            }
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            session.disconnect();
        }
        return result ;
    }

    private static void expectPrompt(BufferedReader br) throws IOException, InterruptedException {
        String prompt = "# ";
        String line = null;
        while((line=br.readLine())!=null){
            if(line.endsWith(prompt)) break;
        }
    }
}
