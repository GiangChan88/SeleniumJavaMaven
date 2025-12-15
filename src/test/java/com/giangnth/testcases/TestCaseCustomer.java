package com.giangnth.testcases;

import com.giangnth.common.BaseTest;
import com.giangnth.pages.CustomerPage;
import com.giangnth.pages.DashboardPage;
import com.giangnth.pages.LoginPage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class TestCaseCustomer extends BaseTest {
    String customerName = "";

    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private CustomerPage customerPage;

    @Test
    public void testDeleteCustomer(){
        TestCaseCustomer tc = new TestCaseCustomer();
        tc.customerName = "test";

        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM();
        customerPage = dashboardPage.clickMenuCustomer();
        //Verify menuCustomer

        for(int i = 0; i < 100; i++) {
            customerPage.searchCustomerSuccess(tc.customerName);
            customerPage.deleteCustomerSuccess(tc.customerName);
            customerPage.confirmDeleteCustomerSuccess(tc.customerName, 1);
        }

        customerPage.searchCustomerNoData(tc.customerName);
    }

}
