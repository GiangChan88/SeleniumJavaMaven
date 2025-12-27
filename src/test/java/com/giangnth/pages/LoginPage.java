package com.giangnth.pages;

import com.giangnth.common.BasePage;
import com.giangnth.helpers.CaptureHelper;
import com.giangnth.helpers.PropertiesHelper;
import com.giangnth.helpers.SystemHelper;
import com.giangnth.keywords.WebUI;
import com.giangnth.models.LoginDTO;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPage extends BasePage {

    public String url_login_admin = "https://crm.anhtester.com/admin/authentication";

    //khai báo đối tượng element thuộc về trang login
    //Locators Login
    private By headerLogin = By.xpath("//h1[normalize-space()='Login']");
    private By inputEmail = By.xpath("//input[@id='email']");
    private By inputPassword = By.xpath("//input[@id='password']");
    private By buttonLogin = By.xpath("//button[@type='submit']");
    private By checkboxRememberMe = By.xpath("//input[@id = 'remember']");
    private By linkForgotPassword = By.xpath("//a[normalize-space()='Forgot Password?']");
    private By errorMessageInvalidEmailorPassword = By.xpath("//div[@id='alerts']/div");
    private By errorMessageEmailRequired = By.xpath("//div[normalize-space() = 'The Email Address field is required.']");
    private By errorMessagePasswordRequired = By.xpath("//div[normalize-space() = 'The Password field is required.']");
    private By menuDashboard = By.xpath("//ul[@id='side-menu']//span[@class = 'menu-text' and normalize-space() = 'Dashboard']");
    //khai báo các hàm xử lý trong nội bộ trang login
    public void navigateToLoginPage() {
        WebUI.openURL(PropertiesHelper.getValue("url"));
        WebUI.waitForPageLoaded();
        CaptureHelper.takeScreenShot("navigateToLoginPage" + "_" + SystemHelper.getDateTimeNowFormat());
    }
    public void enterEmail(String email) {
        WebUI.setTextElement(inputEmail, email);
        CaptureHelper.takeScreenShot("enterEmail" + "_" + SystemHelper.getDateTimeNowFormat());
    }

    public void enterPassword(String password) {
        WebUI.setTextElement(inputPassword, password);
        CaptureHelper.takeScreenShot("enterPassword" + "_" + SystemHelper.getDateTimeNowFormat());
    }

    public void clickLogin() {
        WebUI.clickElement(buttonLogin);
    }

    public void verifyHeaderLogin(){
        CaptureHelper.takeScreenShot("verifyHeaderLogin" + "_" + SystemHelper.getDateTimeNowFormat());
        WebUI.threadSleep(1);
        boolean checkHeaderLogin = WebUI.checkExitsElement(headerLogin);
        Assert.assertTrue(checkHeaderLogin, "Check Header Login is not displayed");
    }

    public void loginCRM(LoginDTO loginData) {
        navigateToLoginPage();
        verifyHeaderLogin();
        enterEmail(loginData.getEmail());
        enterPassword(loginData.getPassword());
        clickLogin();
        WebUI.waitForPageLoaded();
    }

    public DashboardPage loginCRM() {
        navigateToLoginPage();
        verifyHeaderLogin();
        enterEmail(PropertiesHelper.getValue("email"));
        enterPassword(PropertiesHelper.getValue("password"));
        clickLogin();
        WebUI.waitForPageLoaded();
        verifyLoginSuccess();
        return new DashboardPage();
    }

    //dashboard
    public void verifyLoginSuccess() {
        CaptureHelper.takeScreenShot("verifyLoginSuccess" + "_" + SystemHelper.getDateTimeNowFormat());
        WebUI.threadSleep(1);
        boolean checkMenuDashboard = WebUI.checkExitsElement(menuDashboard);
//        boolean checkMenuDashboard = driver.findElements(By.xpath("//ul[@id='side-menu']//span[@class = 'menu-text' and normalize-space() = 'Dashboard']")).size()>0;
        Assert.assertTrue(checkMenuDashboard, "Login Failed or DashBoard not displayed");
    }

    public void verifyLoginFailureWithEmailOrPasswordInvalid()  {
        CaptureHelper.takeScreenShot("verifyLoginFailureWithEmailOrPasswordInvalid" + "_" + SystemHelper.getDateTimeNowFormat());
        WebUI.threadSleep(1);
        boolean isElementErrorMessage = WebUI.checkExitsElement(errorMessageInvalidEmailorPassword);
        Assert.assertTrue(isElementErrorMessage, "Error massage for invalid email not display");
    }

    public void verifyLoginFailureWithEmailNull()  {
        CaptureHelper.takeScreenShot("verifyLoginFailureWithEmailNull" + "_" + SystemHelper.getDateTimeNowFormat());
        WebUI.threadSleep(1);
        boolean isElementErrorMessage = WebUI.checkExitsElement(errorMessageEmailRequired);
        Assert.assertTrue(isElementErrorMessage, "Error massage for required password not display");
    }

    public void verifyLoginFailureWithPasswordNull()  {
        CaptureHelper.takeScreenShot("verifyLoginFailureWithPasswordNull" + "_" + SystemHelper.getDateTimeNowFormat());
        WebUI.threadSleep(1);
        boolean isElementErrorMessage = WebUI.checkExitsElement(errorMessagePasswordRequired);
        Assert.assertTrue(isElementErrorMessage, "Error massage for required password not display");
    }
}
