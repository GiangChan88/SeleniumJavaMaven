package common;

import bt_locator.LocatorsLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    public static void createDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Create Chrome Driver");
    }

    public static void closeDriver() {
        if(driver != null){
            driver.quit();
            System.out.println("Closed Chrome driver");
        }
    }

    public static void loginCRM(){
        driver.get("https://crm.anhtester.com/admin/authentication");
        driver.findElement(By.xpath(LocatorsLogin.inputEmail)).clear();
        driver.findElement(By.xpath(LocatorsLogin.inputPassword)).clear();
        driver.findElement(By.xpath(LocatorsLogin.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorsLogin.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorsLogin.buttonLogin)).click();
    }
}
