package com.giangnth.testcases;

import com.giangnth.common.BaseTest;
import org.testng.annotations.Test;
import com.giangnth.pages.LoginPage;

public class TestCaseLogin extends BaseTest {
    private LoginPage loginPage;


    @Test(priority = 1)
    public void testLoginSuccess() {
        loginPage = new LoginPage(driver);
        loginPage.loginCRM();
        loginPage.verifyLoginSuccess();
    }

    @Test(priority = 2)
    public void testLoginFailureWithEmailInvalid() {
        loginPage = new LoginPage(driver);
        loginPage.loginCRM("admin234@example.com", "123456");
        loginPage.verifyLoginFailureWithEmailOrPasswordInvalid();
    }

    @Test(priority = 3)
    public void testLoginFailureWithPasswordInvalid() {
        loginPage = new LoginPage(driver);
        loginPage.loginCRM("admin@example.com", "123456@@@");
        loginPage.verifyLoginFailureWithEmailOrPasswordInvalid();
    }

    @Test(priority = 4)
    public void testLoginFailureWithEmailRequired() {
        loginPage = new LoginPage(driver);
        loginPage.loginCRM("", "123456@@@");
        loginPage.verifyLoginFailureWithEmailNull();
    }

    @Test(priority = 5)
    public void testLoginFailureWithPasswordRequired() {
        loginPage = new LoginPage(driver);
        loginPage.loginCRM("admin@example.com", "");
        loginPage.verifyLoginFailureWithPasswordNull();
    }
}
