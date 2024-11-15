package emerson.wenjieyang.autotestapplication.util;

import com.google.common.reflect.TypeToken;
import com.google.gson.*;
import emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol.*;
import emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol.baseInterface.ProtocolBaseInterface;
import emerson.wenjieyang.autotestapplication.pojo.securityaudit.testCase.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @className: GetTestcaseListUtil
 * @author: WenjieYang
 * @date: 2024/11/13 10:27
 * @Version: 1.0
 * @description: 通过此方法返回所有的测试用例
 */
public class GetTestcaseListUtil {

    private static final Logger logger = LoggerFactory.getLogger(GetTestcaseListUtil.class);

    // 泛型方法，用于读取不同类型的测试用例
    public static <T> List<T> getTestCaseList(String filePath, Type type) {
        List<T> testCaseList = new ArrayList<>();
        Gson gson = new Gson();
        try (Reader reader = new FileReader(filePath)) {
            testCaseList = gson.fromJson(reader, type);
        } catch (IOException e) {
            logger.error("测试用例文件加载失败： {}", e.getMessage(), e);
        }
        return testCaseList;
    }

    // 安全审计==》入侵检测 ==》 时间对象测试用例
    public static List<TimeObjectTestCase> getTimeObjectTestCaseList(String filePath) {
        Type type = new TypeToken<List<TimeObjectTestCase>>() {}.getType();
        return getTestCaseList(filePath, type);
    }

    // 安全审计==》入侵检测 ==》 地址对象测试用例
    public static List<AddressObjectTestCase> getAddressObjectTestCaseList(String filePath) {
        Type type = new TypeToken<List<AddressObjectTestCase>>() {}.getType();
        return getTestCaseList(filePath, type);
    }

    // 安全审计==》入侵检测 ==》 规则集测试用例
    public static List<RuleSetTestCase> getRuleSetTestCaseList(String filePath) {
        Type type = new TypeToken<List<RuleSetTestCase>>() {}.getType();
        return getTestCaseList(filePath, type);
    }

    // 安全审计==》入侵检测 ==》 检测策略测试用例
    public static List<DetectionPolicyTestCase> getDetectionPolicyTestCaseList(String filePath) {
        Type type = new TypeToken<List<DetectionPolicyTestCase>>() {}.getType();
        return getTestCaseList(filePath, type);
    }

    // 安全审计==》安全事件==》事件告警配置测试用例
    public static List<AlarmConfigureTestCase> getAlarmConfigureTestCaseList(String filePath) {
        Type type = new TypeToken<List<AlarmConfigureTestCase>>() {}.getType();
        return getTestCaseList(filePath, type);
    }

    // 安全审计==》规则管理==》白名单规则==》应用协议白名单
    public static List<AppWhiteListRuleTestCase> getAppWhiteListRuleTestCaseList(String filePath) throws IOException {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(ProtocolBaseInterface.class, new ProtocolItemDeserializer());
        Gson gson = gsonBuilder.create();
        Type type = new TypeToken<List<AppWhiteListRuleTestCase>>() {}.getType();
        try (Reader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, type);
        } catch (IOException e) {
            logger.error("测试用例文件加载失败： {}", e.getMessage(), e);
            throw e;
        }
    }

    public static class ProtocolItemDeserializer implements JsonDeserializer<ProtocolBaseInterface> {

        @Override
        public ProtocolBaseInterface deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            String protocolType = jsonObject.get("protocol").getAsString();

            switch (protocolType) {
                case "ftp":
                    return context.deserialize(jsonObject, Ftp.class);
                case "bacnet":
                    return context.deserialize(jsonObject, BACnet.class);
                case "coap":
                    return context.deserialize(jsonObject, CoAp.class);
                case "dnp3":
                    return context.deserialize(jsonObject, Dnp3.class);
                case "egd":
                    return context.deserialize(jsonObject, Egd.class);
                case "enipio":
                    return context.deserialize(jsonObject, EnipIo.class);
                case "eniptcp":
                    return context.deserialize(jsonObject, EnipTcp.class);
                case "enipudp":
                    return context.deserialize(jsonObject, EnipUdp.class);
                case "finstcp":
                    return context.deserialize(jsonObject, FinsTcp.class);
                case "focas":
                    return context.deserialize(jsonObject, Focas.class);
                case "hexagon":
                    return context.deserialize(jsonObject, Hexagon.class);
                case "iec104":
                    return context.deserialize(jsonObject, Iec104.class);
                case "mms":
                    return context.deserialize(jsonObject, Mms.class);
                case "modbustcp":
                    return context.deserialize(jsonObject, ModbusTcp.class);
                case "mqtt":
                    return context.deserialize(jsonObject, Mqtt.class);
                case "opcda":
                    return context.deserialize(jsonObject, OpcDa.class);
                case "opcuatcp":
                    return context.deserialize(jsonObject, OpcUaTcp.class);
                case "oracle":
                    return context.deserialize(jsonObject, Oracle.class);
                case "profinetio":
                    return context.deserialize(jsonObject, ProFinetIo.class);
                case "s7":
                    return context.deserialize(jsonObject, S7.class);
                case "s7plus":
                    return context.deserialize(jsonObject, S7Plus.class);
                case "sip":
                    return context.deserialize(jsonObject, SIP.class);
                case "snmp":
                    return context.deserialize(jsonObject, SNMP.class);
                case "trdp":
                    return context.deserialize(jsonObject, Trdp.class);
                default:
                    throw new JsonParseException("Unknown protocol type: " + protocolType);
            }
        }
    }
}
