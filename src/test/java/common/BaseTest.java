package common;

import bt_locator.LocatorsLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class BaseTest {
    public static WebDriver driver;
    public SoftAssert softAssert;

    @BeforeMethod
    public void createDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Mở trình duyệt Chrome");
        softAssert = new SoftAssert();
    }

    @AfterMethod
    public void closeDriver() {
        if(driver != null){
            driver.quit();
            System.out.println("Đóng trình duyệt Chrome");
            System.out.println("__________________________________");
            softAssert.assertAll();
        }
    }

    public void loginCRM() throws InterruptedException {
        driver.get("https://crm.anhtester.com/admin/authentication");
        //Verify header Login
        List<WebElement> checkHeaderLogin = driver.findElements(By.xpath(LocatorsLogin.headerLogin));
        Assert.assertTrue(checkHeaderLogin.size() > 0, "Check Header Login is not displayed");

        String headerLoginText = driver.findElement(By.xpath(LocatorsLogin.headerLogin)).getText();
        softAssert.assertEquals(headerLoginText, "Login", "Header Login is not correct");

        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsLogin.inputEmail)).clear();
        driver.findElement(By.xpath(LocatorsLogin.inputPassword)).clear();
        driver.findElement(By.xpath(LocatorsLogin.inputEmail)).sendKeys("admin@example.com");
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsLogin.inputPassword)).sendKeys("123456");
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsLogin.buttonLogin)).click();
        Thread.sleep(1000);
        System.out.println("Đăng nhập CRM thành công");

        //Verify header after Login
        List<WebElement> checkMenuDashboard = driver.findElements(By.xpath(LocatorsLogin.menuDashboard));
        Assert.assertTrue(checkMenuDashboard.size() > 0, "Check Menu DashBoard is not displayed after Login");
    }
}
