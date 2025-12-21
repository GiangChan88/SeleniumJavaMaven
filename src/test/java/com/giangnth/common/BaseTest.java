package com.giangnth.common;

import com.giangnth.drivers.DriverManager;
import com.giangnth.helpers.PropertiesHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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

        if(PropertiesHelper.getValue("browser").isEmpty() || PropertiesHelper.getValue("browser") == null){
            browserName = browserName;
        }else {
            browserName = PropertiesHelper.getValue("browser");
        }

        switch (browserName.trim().toLowerCase()) {
            case "chrome":
                System.out.println("Khoi tao trinh duyet chrome");

                //ChromeOptions options = new ChromeOptions();

                driver = new ChromeDriver();
                break;
            case "firefox":
                System.out.println("Khoi tao trinh duyet FireFox");
                driver = new FirefoxDriver();
                break;
            case "edge":
                System.out.println("Khoi tao trinh duyet Edge");
                WebDriverManager.edgedriver().setup(); //tải msedgedriver.exe tương ứng vesion của trình duyệt đang dùng
                driver = new EdgeDriver();
                break;
            default:
                System.out.println("Browser: " + browserName + " is invalid, Launching Chrome as browser of choice...");
                System.out.println("Khoi tao trinh duyet chrome");
                driver = new ChromeDriver();
        }
        DriverManager.setDriver(driver);
        //driver == DriverManager.getDriver
        DriverManager.getDriver().manage().window().maximize();
        softAssert = new SoftAssert();
    }

    @AfterMethod
    public void closeDriver() {
        if(DriverManager.getDriver() != null){
            DriverManager.quit();
            System.out.println("Đóng trình duyệt Chrome");
            System.out.println("__________________________________");
        }
        softAssert.assertAll();
    }
}
