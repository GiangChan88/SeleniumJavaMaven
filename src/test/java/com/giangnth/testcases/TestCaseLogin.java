package com.giangnth.testcases;

import com.giangnth.common.BaseTest;
import com.giangnth.helpers.ExcelHelper;
import org.testng.annotations.Test;
import com.giangnth.pages.LoginPage;

public class TestCaseLogin extends BaseTest {
    private LoginPage loginPage;


    @Test(priority = 1)
    public void testLoginSuccess() {
        loginPage = new LoginPage();
        loginPage.loginCRM();
        loginPage.verifyLoginSuccess();
    }

    @Test(priority = 2)
    public void testLoginFailureWithEmailInvalid() {
        loginPage = new LoginPage();
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/DataCRM.xlsx", "Login");
        loginPage.loginCRM(
                excelHelper.getCellData("EMAIL", 1),
                excelHelper.getCellData("PASSWORD", 1)
        );
        loginPage.verifyLoginFailureWithEmailOrPasswordInvalid();
        excelHelper.setCellData("PASS","TEST_RESULT", 1);
    }

    @Test(priority = 3)
    public void testLoginFailureWithPasswordInvalid() {
        loginPage = new LoginPage();
        loginPage.loginCRM("admin@example.com", "123456@@@");
        loginPage.verifyLoginFailureWithEmailOrPasswordInvalid();
    }

    @Test(priority = 4)
    public void testLoginFailureWithEmailRequired() {
        loginPage = new LoginPage();
        loginPage.loginCRM("", "123456@@@");
        loginPage.verifyLoginFailureWithEmailNull();
    }

    @Test(priority = 5)
    public void testLoginFailureWithPasswordRequired() {
        loginPage = new LoginPage();
        loginPage.loginCRM("admin@example.com", "");
        loginPage.verifyLoginFailureWithPasswordNull();
    }
}
