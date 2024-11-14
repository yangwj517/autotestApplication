package emerson.wenjieyang.autotestapplication;


import okhttp3.*;

import java.io.IOException;

/**
 * @className: RemontTest
 * @author: WenjieYang
 * @date: 2024/10/30 15:19
 * @Version: 1.0
 * @description: 远程获取测试
 */

public class RemoteTest {
    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder().url("http://192.168.102.201:8888/getFileList/dnp3").build();
        Call call = client.newCall(request);
        Response response = call.execute();
        System.out.println(response.body().string());
    }
}
