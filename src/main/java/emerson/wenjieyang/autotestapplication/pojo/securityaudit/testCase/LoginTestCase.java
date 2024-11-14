package emerson.wenjieyang.autotestapplication.pojo.securityaudit.testCase;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @className: LoginTestCase
 * @author: WenjieYang
 * @date: 2024/10/23 13:19
 * @Version: 1.0
 * @description:  登录测试用例对象
 */


public class LoginTestCase {

    // 用户名
    private String loginName;

    // 密码
    private String password;

    // 页面信息
    private String actionMsg ;

    // 预期结果
    private boolean expectedResult ;

    // 实际结果
    private String result ;

    // 结果与预期是否相符
    private boolean flag ;

    // 测试用例存储列表
    private List<LoginTestCase> loginTestCaseList ;

    public LoginTestCase(String loginName, String password, boolean expectedResult) {
        this.loginName = loginName;
        this.password = password;
        this.expectedResult = expectedResult;
    }
    public LoginTestCase(){}

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getActionMsg() {
        return actionMsg;
    }

    public void setActionMsg(String actionMsg) {
        this.actionMsg = actionMsg;
    }

    public boolean getExpectedResult() {
        return expectedResult;
    }

    public void setExpectedResult(boolean expectedResult) {
        this.expectedResult = expectedResult;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    /**
     * 测试用例加载方法提供
     * @return 返回从json文件中加载到的测试用例对象列表
     */
    public List<LoginTestCase> getLoginTestCaseList(String testCaseFilePath) {
        this.loginTestCaseList = new ArrayList<LoginTestCase>();
        Gson gson = new Gson();
        try(Reader r = new FileReader(testCaseFilePath)){
            // 定义typeToken
            Type typeToken = new TypeToken<List<LoginTestCase>>(){}.getType();
            // 直接解析成list
            loginTestCaseList = gson.fromJson(r,typeToken);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return loginTestCaseList;
    }

    @Override
    public String toString() {
        return "LoginTestCase{" +
                "用户名= '" + loginName + '\'' +
                ", 密码= '" + password + '\'' +
                ", 提示文本信息= '" + actionMsg + '\'' +
                ", 预期结果= '" + expectedResult + '\'' +
                ", 测试结果= '" + result + '\'' +
                ", 预期与结果是否相符= " + flag +
                '}';
    }
}
