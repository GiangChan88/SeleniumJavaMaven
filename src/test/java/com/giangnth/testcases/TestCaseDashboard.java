package com.giangnth.testcases;

import com.giangnth.pages.DashboardPage;
import com.giangnth.pages.LoginPage;
import common.BaseTest;
import org.testng.annotations.Test;

public class TestCaseDashboard extends BaseTest {
    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    @Test
    public void testDashboardDisplayedSuccesAfterLogin(){
        loginPage = new LoginPage(driver);
        loginPage.loginCRM("admin@example.com", "123456");
        loginPage.verifyLoginSuccess();

        dashboardPage = new DashboardPage(driver);
        dashboardPage.verifyDashboardPageDisplayed();
    }
}
