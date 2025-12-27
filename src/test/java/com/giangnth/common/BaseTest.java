package com.giangnth.common;

import com.giangnth.drivers.DriverManager;
import com.giangnth.helpers.CaptureHelper;
import com.giangnth.helpers.PropertiesHelper;
import com.giangnth.helpers.SystemHelper;
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
                System.out.println("Khoi tao trinh duyet chrome");

                ChromeOptions chromeOptions = new ChromeOptions();

                if (isHeadless) {
                    chromeOptions.addArguments("--headless=new");
                    chromeOptions.addArguments("--window-size=1920,1080");
                }

                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                System.out.println("Khoi tao trinh duyet FireFox");

                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (isHeadless) {
                    firefoxOptions.addArguments("--headless");
                }

                driver = new FirefoxDriver(firefoxOptions);
                break;
            case "edge":
                System.out.println("Khoi tao trinh duyet Edge");

                EdgeOptions edgeOptions = new EdgeOptions();
                if (isHeadless) {
                    edgeOptions.addArguments("--headless=new");
                    edgeOptions.addArguments("--window-size=1920,1080");
                }

                WebDriverManager.edgedriver().setup(); //tải msedgedriver.exe tương ứng vesion của trình duyệt đang dùng
                driver = new EdgeDriver(edgeOptions);
                break;
            default:
                System.out.println("Browser: " + browserName + " is invalid, Launching Chrome as browser of choice...");
                System.out.println("Khoi tao trinh duyet chrome");
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

        //chụp ảnh khi bị fail
        if (ITestResult.FAILURE == result.getStatus()) {
            CaptureHelper.takeScreenShot(
                    result.getName() + "_" + SystemHelper.getDateTimeNowFormat()
            );
        }

        CaptureHelper.stopRecord();

        if(DriverManager.getDriver() != null){
            DriverManager.quit();
            System.out.println("Đóng trình duyệt Chrome");
            System.out.println("__________________________________");
        }
        softAssert.assertAll();
    }

}
