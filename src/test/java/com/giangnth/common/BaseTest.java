package com.giangnth.common;

import com.giangnth.drivers.DriverManager;
import com.giangnth.helpers.CaptureHelper;
import com.giangnth.helpers.PropertiesHelper;
import com.giangnth.helpers.SystemHelper;
import com.giangnth.listeners.TestListener;
import com.giangnth.utils.LogUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

@Listeners(TestListener.class) //Nếu chạy listener trong XML thì phải bỏ đi @Listeners(TestListener.class) trong BaseTest và ngược lại
public class BaseTest {
    public static SoftAssert softAssert;

    @BeforeSuite
    public void setupBeforeSuite() {
        //chạy trước 1 lần, đọc file properties đầu tiên
        PropertiesHelper.loadAllFiles();
    }

    @BeforeMethod
    @Parameters({"browser"})
    public void creatDriver(@Optional("chrome") String browserName){
        WebDriver driver;

        if (PropertiesHelper.getValue("browser") != null && !PropertiesHelper.getValue("browser").isBlank()) {
            browserName = PropertiesHelper.getValue("browser");
        }

        boolean isHeadless = PropertiesHelper.getValue("headless").equalsIgnoreCase("true");

        switch (browserName.trim().toLowerCase()) {
            case "chrome":
                LogUtils.info("Khởi tạo trình duyệt chrome");
                ChromeOptions chromeOptions = new ChromeOptions();

                if (isHeadless) {
                    chromeOptions.addArguments("--headless=new");
                    chromeOptions.addArguments("--window-size=1920,1080");
                }

                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                LogUtils.info("Khởi tạo trình duyệt FireFox");

                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (isHeadless) {
                    firefoxOptions.addArguments("--headless");
                }

                driver = new FirefoxDriver(firefoxOptions);
                break;
            case "edge":
                LogUtils.info("Khởi tạo trình duyệt Edge");

                EdgeOptions edgeOptions = new EdgeOptions();
                if (isHeadless) {
                    edgeOptions.addArguments("--headless=new");
                    edgeOptions.addArguments("--window-size=1920,1080");
                }

                WebDriverManager.edgedriver().setup(); //tải msedgedriver.exe tương ứng vesion của trình duyệt đang dùng
                driver = new EdgeDriver(edgeOptions);
                break;
            default:
                LogUtils.info("Browser: " + browserName + " is invalid, Launching Chrome as browser of choice...");
                LogUtils.info("Khởi tạo trình duyệt chrome");
                driver = new ChromeDriver();
        }
        DriverManager.setDriver(driver);

        if (!isHeadless) {
            DriverManager.getDriver().manage().window().maximize();
        }

        softAssert = new SoftAssert();
    }

    @AfterMethod
    public void closeDriver(ITestResult result) {

        if(DriverManager.getDriver() != null){
            DriverManager.quit();
            System.out.println("Đóng trình duyệt Chrome");
            System.out.println("__________________________________");
        }
        softAssert.assertAll();
    }

}
