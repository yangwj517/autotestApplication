package emerson.wenjieyang.autotestapplication.util;

import com.google.gson.Gson;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.List;

/**
 * @className: GetRemoteFileListUtil
 * @author: WenjieYang
 * @date: 2024/10/31 10:50
 * @Version: 1.0
 * @description:  获取远程报文文件列表
 */

public class GetRemoteFileListUtil {

    public static List<String> getRemoteFileList(String url) {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder().url(url).build();
        Call call = client.newCall(request);
        Response response = null ;
        List<String> list = null ;
        try{
            response = call.execute();
            Gson gson = new Gson();
            list = gson.fromJson(response.body().string(), List.class);
            return list;
        } catch (IOException e) {
            return null ;
        }
    }
}
