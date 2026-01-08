package com.giangnth.testcases;

import com.giangnth.data.LoginDataFactory;
import com.giangnth.models.LoginDTO;
import com.giangnth.pages.DashboardPage;
import com.giangnth.pages.LeadsPage;
import com.giangnth.pages.LoginPage;
import com.giangnth.common.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("CRM version 1.0")
@Feature("Dashboard feature")
public class TestCaseDashboard extends BaseTest {
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private LeadsPage leadsPage;

    @Description("Verify Dashboard Displayed Succes After Login")
    @Test(priority = 1)
    public void testDashboardDisplayedSuccesAfterLogin() throws InterruptedException {
        loginPage = new LoginPage();
        LoginDTO loginData = LoginDataFactory.getLoginDataFromExcel(1);
        loginPage.loginCRM(loginData);
        loginPage.verifyLoginSuccess();

        dashboardPage = new DashboardPage();
        dashboardPage.verifyDashboardPageDisplayed();
    }

    @Description("Verify Total Converted Lead")
    @Test(priority = 2)
    public void testVerifyTotalConvertedLead() throws InterruptedException {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM();
        leadsPage = dashboardPage.clickMenuLead();

        String getTotalLeadActive = leadsPage.getTotalLeadActive();
        String getTotalLeadConverted = String.valueOf(leadsPage.getTotalLeadConverted());

        dashboardPage = loginPage.clickMenuDashboard();

        dashboardPage.getTextTotalConvertedLeads();

        Assert.assertEquals(dashboardPage.getTextTotalConvertedLeads(), getTotalLeadActive + " / " + getTotalLeadConverted, "The number of “Active” statuses on the Dashboard does not match the number in the Lead menu");
    }
}
