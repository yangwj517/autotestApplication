package emerson.wenjieyang.autotestapplication;

import ch.qos.logback.core.util.TimeUtil;
import com.jcraft.jsch.*;
import org.apache.commons.compress.utils.TimeUtils;
import org.checkerframework.checker.units.qual.C;

import java.io.*;

/**
 * @className: SSHCleanDPITest
 * @author: WenjieYang
 * @date: 2024/11/5 15:44
 * @Version: 1.0
 * @description: 测试ssh 清理dpi
 *
 * FIXME : 需要修改  在某些shell实现中，OUTPUT可能一直不会为空，所以导致程序无法正常停止。
 */


public class SSHCleanDPITest {
    public static void main(String[] args) {
       String host = "192.168.102.150";
       int port = 22;
       String username = "admin";
       String password = "tdhx@2017";
       try {
           JSch jsch = new JSch();
           Session session = jsch.getSession(username, host, port);
           session.setPassword(password);
           // 处理主机安全验证
           session.setConfig("StrictHostKeyChecking", "no");
           session.connect();

           ChannelShell shell =(ChannelShell) session.openChannel("shell");

           InputStream inputStream = shell.getInputStream();

           shell.setPty(true);

           shell.connect();

           OutputStream outputStream = shell.getOutputStream();

           PrintWriter printWriter = new PrintWriter(outputStream);
           BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

           // ...（之前的代码不变）

           printWriter.println("configure terminal");
           printWriter.flush();
           expectPrompt(bufferedReader); // 等待提示符

           printWriter.println("dpi");
           printWriter.flush();
           expectPrompt(bufferedReader); // 等待提示符

           printWriter.println("stop dpi");
           printWriter.flush();
           expectPrompt(bufferedReader); // 等待提示符

           printWriter.println("start dpi");
           printWriter.flush();
           expectPrompt(bufferedReader); // 等待提示符

            // ...（之后的代码不变）

            // 定义一个方法来等待提示符

          shell.disconnect();
          session.disconnect();
       } catch (JSchException e) {
           throw new RuntimeException(e);
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
    }

    private static void expectPrompt(BufferedReader reader) throws IOException {
        String prompt = "# "; // 根据你的设备提示符修改
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.endsWith(prompt)) {
                break;
            }
            System.out.println(line); // 打印输出，以便调试
        }
    }

}
