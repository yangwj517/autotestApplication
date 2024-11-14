package emerson.wenjieyang.autotestapplication;

import emerson.wenjieyang.autotestapplication.util.GetProtocolFileListUtil;

/**
 * @className: GetFileListTest
 * @author: WenjieYang
 * @date: 2024/10/29 13:27
 * @Version: 1.0
 * @description: 测试协议文件查找
 */

public class GetFileListTest {

    public static void main(String[] args) {
        GetProtocolFileListUtil.getFileNameList("C:\\workstation\\protocol");
    }
}
