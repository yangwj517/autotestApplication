package emerson.wenjieyang.autotestapplication.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

/**
 * @className: PageSizeUtil
 * @author: WenjieYang
 * @date: 2024/11/11 9:55
 * @Version: 1.0
 * @description:
 */
@Deprecated(since = "1.0")
public class PageSizeUtil {
    // 应用页面缩放
    public static void applyZoom(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // 添加 viewport meta 标签以支持缩放
        js.executeScript("document.body.style.zoom='70%'");
    }
}
