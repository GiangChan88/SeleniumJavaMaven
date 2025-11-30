package locator;

import org.openqa.selenium.By;

public class LocatorsLogin {
    public static By url = By.xpath("https://crm.anhtester.com/admin/authentication");

    //Locators Login
    public static By headerLogin = By.xpath("//h1[normalize-space()='Login']");
    public static By inputEmail = By.xpath("//input[@id='email']");
    public static By inputPassword = By.xpath("//input[@id='password']");
    public static By buttonLogin = By.xpath("//button[@type='submit']");
    public static By checkboxRememberMe = By.xpath("//input[@id = 'remember']");
    public static By linkForgotPassword = By.xpath("//a[normalize-space()='Forgot Password?']");
    public static By errorMessageInvalidEmailorPassword = By.xpath("//div[@id='alerts']/div");
    public static By errorEmailRequired = By.xpath("//div[normalize-space() = 'The Email Address field is required.']");
    public static By errorPasswordRequired = By.xpath("//div[normalize-space() = 'The Password field is required.']");

    //menu Dashboard
    public static By menuDashboard = By.xpath("//ul[@id='side-menu']//span[@class = 'menu-text' and normalize-space() = 'Dashboard']");
}
