package emerson.wenjieyang.autotestapplication;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * @className: InterNetInterfaceTest
 * @author: WenjieYang
 * @date: 2024/10/24 16:56
 * @Version: 1.0
 * @description: 失败且无用的test
 */

public class InterNetInterfaceTest {
    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            int i = 1 ;
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                if(networkInterface.isLoopback() || networkInterface.isVirtual()){
                    continue;
                }
                System.out.println(networkInterface.getName());
                String displayName = networkInterface.getDisplayName();
                System.out.println(displayName);
                System.out.println(i ++ );
            }
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
    }
}
