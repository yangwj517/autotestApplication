package emerson.wenjieyang.autotestapplication.util;

import com.google.gson.Gson;
import okhttp3.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @className: RemoteSendPacketUtil
 * @author: WenjieYang
 * @date: 2024/10/31 11:03
 * @Version: 1.0
 * @description: 调用远程接口回访报文
 */

public class RemoteSendPacketUtil {

    public static Boolean remoteSendPacket(String url,String interfaceName ,String path){
        OkHttpClient client = new OkHttpClient().newBuilder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .callTimeout(120, TimeUnit.SECONDS)
                .pingInterval(5, TimeUnit.SECONDS)
                .build();
        HttpUrl httpUrl = HttpUrl.parse(url)
                .newBuilder()
                .addQueryParameter("filePath",path)
                .addQueryParameter("interfaceName",interfaceName)
                .build();
        Request request = new Request.Builder().url(httpUrl).build();
        Call call = client.newCall(request);
        Response response = null;
        Boolean result = false;
        try {
            response = call.execute();
            Gson gson = new Gson();
            //System.out.println(response.body().string());
            return gson.fromJson(response.body().string(), Boolean.class);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
