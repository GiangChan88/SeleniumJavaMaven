package com.giangnth.testcases;

import com.giangnth.common.BaseTest;
import com.giangnth.data.LoginDataFactory;
import com.giangnth.helpers.CaptureHelper;
import com.giangnth.helpers.ExcelHelper;
import com.giangnth.models.LoginDTO;
import org.testng.annotations.Test;
import com.giangnth.pages.LoginPage;

public class TestCaseLogin extends BaseTest {
    private LoginPage loginPage;


    @Test(priority = 1)
    public void testLoginSuccess() {
        loginPage = new LoginPage();
        LoginDTO loginData = LoginDataFactory.getLoginDataFromExcel(1);
        loginPage.loginCRM(loginData);
        loginPage.verifyLoginSuccess();
    }

    @Test(priority = 2)
    public void testLoginFailureWithEmailInvalid() {
        loginPage = new LoginPage();
        LoginDTO loginData = LoginDataFactory.getLoginDataFromExcel(2);
        loginPage.loginCRM(loginData);
        loginPage.verifyLoginFailureWithEmailOrPasswordInvalid();
    }

    @Test(priority = 3)
    public void testLoginFailureWithPasswordInvalid() {
        loginPage = new LoginPage();
        LoginDTO loginData = LoginDataFactory.getLoginDataFromExcel(3);
        loginPage.loginCRM(loginData);
        loginPage.verifyLoginFailureWithEmailOrPasswordInvalid();
    }

    @Test(priority = 4)
    public void testLoginFailureWithEmailRequired() {
        loginPage = new LoginPage();
        LoginDTO loginData = LoginDataFactory.getLoginDataFromExcel(4);
        loginPage.loginCRM(loginData);
        loginPage.verifyLoginFailureWithEmailNull();
    }

    @Test(priority = 5)
    public void testLoginFailureWithPasswordRequired()  {
        loginPage = new LoginPage();
        LoginDTO loginData = LoginDataFactory.getLoginDataFromExcel(5);
        loginPage.loginCRM(loginData);
        loginPage.verifyLoginFailureWithPasswordNull();
    }
}
