package com.giangnth.testcases;

import com.giangnth.common.BaseTest;
import com.giangnth.pages.CustomerPage;
import com.giangnth.pages.DashboardPage;
import com.giangnth.pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

@Epic("CRM version 1.0")
@Feature("Customer feature")
public class TestCaseCustomer extends BaseTest {
    String customerName = "";

    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private CustomerPage customerPage;

    @Description("Verify menuCustomer")
    @Test(priority = 1, description = "TC_testDeleteCustomer_01")
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
