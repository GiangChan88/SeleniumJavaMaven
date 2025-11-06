package bt_locator;

public class LocatorsLogin {
    public String url = "https://crm.anhtester.com/admin/authentication";

    //Locators Login
    public static String headerLogin = "//h1[normalize-space()='Login']";
    public static String inputEmail = "//input[@id='email']";
    public static String inputPassword = "//input[@id='password']";
    public static String buttonLogin = "//button[@type='submit']";
    public static String checkboxRememberMe = "//input[@id = 'remember']";
    public static String linkForgotPassword = "//a[normalize-space()='Forgot Password?']";
    public static String errorMessageInvalidEmailorPassword = "//div[@id='alerts']/div";
    public static String errorEmailRequired = "//div[normalize-space() = 'The Email Address field is required.']";
    public static String errorPasswordRequired = "//div[normalize-space() = 'The Password field is required.']";

    //menu Dashboard
    public static String menuDashboard = "//ul[@id='side-menu']//span[@class = 'menu-text' and normalize-space() = 'Dashboard']";
}
