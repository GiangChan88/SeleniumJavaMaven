package com.giangnth.common;

import com.giangnth.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    public static SoftAssert softAssert;

    @BeforeMethod
    public void createDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("Mở trình duyệt Chrome");
        softAssert = new SoftAssert();
    }

    @AfterMethod
    public void closeDriver() {
        if(driver != null){
            driver.quit();
            System.out.println("Đóng trình duyệt Chrome");
            System.out.println("__________________________________");
        }
        softAssert.assertAll();
    }
}
