package common;

import keywords.WebUI;
import locator.LocatorsLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class BaseTest {
    public static WebDriver driver;
    public SoftAssert softAssert;

    @BeforeMethod
    public void createDriver() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Mở trình duyệt Chrome");
        softAssert = new SoftAssert();
        loginCRM();
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

    public void loginCRM() throws InterruptedException {
        driver.get("https://crm.anhtester.com/admin/authentication");
        //Verify header Login - vì truyền text vào xpath rồi nên không cần so sánh text
        boolean checkHeaderLogin = WebUI.checkExitsElement(driver, LocatorsLogin.headerLogin);
        Assert.assertTrue(checkHeaderLogin, "Check Header Login is not displayed");

        WebUI.clickElement(driver, LocatorsLogin.inputEmail);
        WebUI.clickElement(driver, LocatorsLogin.inputPassword);
        WebUI.setTextElement(driver, LocatorsLogin.inputEmail, "admin@example.com");
        WebUI.setTextElement(driver, LocatorsLogin.inputPassword, "123456");
        WebUI.clickElement(driver, LocatorsLogin.buttonLogin);
        System.out.println("Đăng nhập CRM thành công");

        //Verify header after Login
        Thread.sleep(1000);
        boolean checkMenuDashboard = WebUI.checkExitsElement(driver, LocatorsLogin.menuDashboard);
        Assert.assertTrue(checkMenuDashboard, "Check Menu DashBoard is not displayed after Login");
    }
}
