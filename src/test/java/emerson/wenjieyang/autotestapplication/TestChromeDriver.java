package emerson.wenjieyang.autotestapplication;

import org.openqa.selenium.WebDriver;
   import org.openqa.selenium.chrome.ChromeDriver;

   public class TestChromeDriver {
       public static void main(String[] args) {
           System.setProperty("webdriver.chrome.driver", "C:\\chromeDriver\\chromedriver.exe");
           WebDriver driver = new ChromeDriver();
           driver.get("http://www.baidu.com");
           driver.quit();
       }
   }
   