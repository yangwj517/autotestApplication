package emerson.wenjieyang.autotestapplication.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol.*;
import emerson.wenjieyang.autotestapplication.pojo.securityaudit.protocol.baseInterface.ProtocolBaseInterface;
import emerson.wenjieyang.autotestapplication.pojo.securityaudit.testCase.*;
import lombok.extern.slf4j.Slf4j;

import java.io.FileReader;
import java.io.IOException;
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
@Slf4j
public class GetTestcaseListUtil {

    private static final Gson GSON = new Gson();
    private static final Gson PROTOCOL_GSON = new GsonBuilder()
            .registerTypeAdapter(ProtocolBaseInterface.class, new ProtocolItemDeserializer())
            .create();

    /**
     * 通用方法，用于从JSON文件中读取测试用例列表
     *
     * @param filePath 文件路径
     * @param type     泛型类型
     * @param <T>      泛型类型参数
     * @return 测试用例列表
     */
    private static <T> List<T> readTestCases(String filePath, Type type) {
        try (FileReader reader = new FileReader(filePath)) {
            return GSON.fromJson(reader, type);
        } catch (IOException e) {
            log.error("测试用例文件加载失败: {}", e.getMessage(), e);
            return new ArrayList<>();
        }
    }

    public static List<TimeObjectTestCase> getTimeObjectTestCaseList(String filePath) {
        Type type = new TypeToken<List<TimeObjectTestCase>>() {}.getType();
        return readTestCases(filePath, type);
    }

    public static List<AddressObjectTestCase> getAddressObjectTestCaseList(String filePath) {
        Type type = new TypeToken<List<AddressObjectTestCase>>() {}.getType();
        return readTestCases(filePath, type);
    }

    public static List<RuleSetTestCase> getRuleSetTestCaseList(String filePath) {
        Type type = new TypeToken<List<RuleSetTestCase>>() {}.getType();
        return readTestCases(filePath, type);
    }

    public static List<DetectionPolicyTestCase> getDetectionPolicyTestCaseList(String filePath) {
        Type type = new TypeToken<List<DetectionPolicyTestCase>>() {}.getType();
        return readTestCases(filePath, type);
    }

    public static List<AlarmConfigureTestCase> getAlarmConfigureTestCaseList(String filePath) {
        Type type = new TypeToken<List<AlarmConfigureTestCase>>() {}.getType();
        return readTestCases(filePath, type);
    }

    public static List<AppWhiteListRuleTestCase> getAppWhiteListRuleTestCaseList(String filePath) {
        Type type = new TypeToken<List<AppWhiteListRuleTestCase>>() {}.getType();
        try (FileReader reader = new FileReader(filePath)) {
            return PROTOCOL_GSON.fromJson(reader, type);
        } catch (IOException e) {
            log.error("测试用例文件加载失败: {}", e.getMessage(), e);
            return new ArrayList<>();
        }
    }

    private static class ProtocolItemDeserializer implements JsonDeserializer<ProtocolBaseInterface> {
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
                    return null;
            }
        }
    }
}
