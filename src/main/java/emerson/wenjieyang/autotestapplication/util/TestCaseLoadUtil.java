package emerson.wenjieyang.autotestapplication.util;

/**
 * @className: TestExpectedLoadUtil
 * @author: WenjieYang
 * @date: 2024/10/23 13:35
 * @Version: 1.0
 * @description:  测试用例加载工具类
 */

/*
@Deprecated
public class TestCaseLoadUtil {

    /**
    * @Author WenjieYang
    * @Description 加载测试用例
    * @Date 13:41 2024/10/23
    * @param: filePath 用例文件地址
    * @return: java.util.List<emerson.wenjieyang.autotestapplication.pojo.securityaudit.test.LoginTestCase>
    * 用例对象列表
    **/
    /*

    public static List<LoginTestCase> loginTestCaseLoad(String filePath){
        // 创建列表存储文件
        List<LoginTestCase> list = new ArrayList<>();
        // 创建XSSF对象 -- 用于读取 .xlsx 用例文件
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(new File(filePath));
            XSSFSheet sheet = workbook.getSheetAt(0);
            int lastRowNum = sheet.getLastRowNum();
            for (int i = 1; i <=  lastRowNum ; i++) {
                Row row = sheet.getRow(i);
                short lastCellNum = row.getLastCellNum();
                if(lastCellNum == (short)3){
                    // 没有大问题
                    list.add(new LoginTestCase(
                            getCellValueAsString(row.getCell(0)),
                            getCellValueAsString(row.getCell(1)),
                            getCellValueAsString(row.getCell(2))
                    ) );
                    continue;
                }
                return null ;
            }
        } catch (IOException | InvalidFormatException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return list ;
    }


    // excel文件单元格数据格式化处理, 解决会把整数读成浮点数的问题
    private static String getCellValueAsString(Cell cell) {
        Object result;
        switch (cell.getCellType()) {
            case STRING:
                result = cell.getStringCellValue();
                break;
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    result = cell.getDateCellValue().toString();
                } else {
                    // 检查是否为整数
                    double numericValue = cell.getNumericCellValue();
                    if ((numericValue - (int) numericValue) == 0) {
                        result = String.valueOf((int) numericValue);
                    } else {
                        result = String.valueOf(numericValue);
                    }
                }
                break;
            case BOOLEAN:
                result = cell.getBooleanCellValue();
                break;
            case FORMULA:
                // 处理公式单元格，可能需要评估公式
                CellType evaluatedType = cell.getCachedFormulaResultType();
                if (evaluatedType == CellType.NUMERIC) {
                    double numericValue = cell.getNumericCellValue();
                    if ((numericValue - (int) numericValue) == 0) {
                        result = String.valueOf((int) numericValue);
                    } else {
                        result = String.valueOf(numericValue);
                    }
                } else if (evaluatedType == CellType.STRING) {
                    result = cell.getStringCellValue();
                } else if (evaluatedType == CellType.BOOLEAN) {
                    result = cell.getBooleanCellValue();
                } else {
                    result = cell.toString(); // 未知类型，使用默认 toString()
                }
                break;
            case BLANK:
                result = "";
                break;
            case ERROR:
                result = String.valueOf(cell.getErrorCellValue());
                break;
            default:
                result = cell.toString();
                break;
        }
        return result.toString();
    }
}

*/