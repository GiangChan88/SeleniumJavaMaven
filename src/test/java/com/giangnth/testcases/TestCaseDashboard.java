package com.giangnth.testcases;

import com.giangnth.pages.DashboardPage;
import com.giangnth.pages.LeadsPage;
import com.giangnth.pages.LoginPage;
import com.giangnth.common.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCaseDashboard extends BaseTest {
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private LeadsPage leadsPage;

    @Test
    public void testDashboardDisplayedSuccesAfterLogin() throws InterruptedException {
        loginPage = new LoginPage(driver);
        loginPage.loginCRM("admin@example.com", "123456");
        loginPage.verifyLoginSuccess();

        dashboardPage = new DashboardPage(driver);
        dashboardPage.verifyDashboardPageDisplayed();
    }

    @Test
    public void testVerifyTotalConvertedLead() throws InterruptedException {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM();
        leadsPage = dashboardPage.clickMenuLead();

        String getTotalLeadActive = leadsPage.getTotalLeadActive();
        String getTotalLeadConverted = String.valueOf(leadsPage.getTotalLeadConverted());

        dashboardPage = loginPage.clickMenuDashboard();

        dashboardPage.getTextTotalConvertedLeads();

        Assert.assertEquals(dashboardPage.getTextTotalConvertedLeads(), getTotalLeadActive + " / " + getTotalLeadConverted, "The number of “Active” statuses on the Dashboard does not match the number in the Lead menu");
    }
}
