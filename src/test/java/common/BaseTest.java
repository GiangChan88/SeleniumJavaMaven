package common;

import bt_locator.LocatorsLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    @BeforeMethod
    public static void createDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Mở trình duyệt Chrome");
    }

    @AfterMethod
    public static void closeDriver() {
        if(driver != null){
            driver.quit();
            System.out.println("Đóng trình duyệt Chrome");
        }
    }

    public static void loginCRM() throws InterruptedException {
        driver.get("https://crm.anhtester.com/admin/authentication");
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
    }
}
