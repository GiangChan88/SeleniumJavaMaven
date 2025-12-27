package com.giangnth.testcases;


import com.giangnth.data.LeadDataFactory;
import com.giangnth.drivers.DriverManager;
import com.giangnth.helpers.ExcelHelper;
import com.giangnth.models.LeadDTO;
import com.giangnth.pages.DashboardPage;
import com.giangnth.pages.LoginPage;
import com.giangnth.keywords.WebUI;
import com.giangnth.pages.LeadsPage;
import com.giangnth.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestCaseLead extends BaseTest {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private LeadsPage leadsPage;

    @Test(priority = 1)
    public void testAddNewLeadSuccess() {
        TestCaseLead lead = new TestCaseLead();
        LeadDTO leadData = LeadDataFactory.getLeadDataFromExcel(1);
        leadData.setLeadName(leadData.getLeadName() + "_AddNewLead");

        //click menu Lead
        loginPage = new LoginPage();

        dashboardPage = loginPage.loginCRM();
        leadsPage = dashboardPage.clickMenuLead();
        leadsPage.verifyMenuLead();

        //click btn addnewLead
        leadsPage.clickBtnAddNewLead();
        leadsPage.verifyBtnAddNewLead();

        leadsPage.addAndEditLeadSuccess(leadData);

        leadsPage.closePopupDetail();

        //verifyLeadAddNew
        leadsPage.searchLeadSuccess(leadData.getLeadName());
        leadsPage.verifySearchLeadSuccess(leadData.getLeadName());
        System.out.println("Tạo data thành công");
    }

    //Set Email đã tồn tại
    @Test(priority = 2)
    public void testAddNewLeadFailEmailAlreadyExists() {
        TestCaseLead lead = new TestCaseLead();
        //Data test EmailAlreadyExists
        LeadDTO leadData = LeadDataFactory.getLeadDataFromExcel(2);

        //click menu Lead
        loginPage = new LoginPage();

        dashboardPage = loginPage.loginCRM();
        leadsPage = dashboardPage.clickMenuLead();
        leadsPage.verifyMenuLead();

        //click btn addnewLead
        leadsPage.clickBtnAddNewLead();
        leadsPage.verifyBtnAddNewLead();

        leadsPage.addAndEditLeadSuccess(leadData);

        //verify lỗi
        boolean checkMessageErrorEmail = WebUI.checkExitsElement(By.xpath("//p[@id='email-error']"));
        Assert.assertTrue(checkMessageErrorEmail, "Check Message Error Email is not Displayed");

        //verify message
        String messageErrorEmail = WebUI.getElementText(By.xpath("//p[@id='email-error']"));
        softAssert.assertEquals(messageErrorEmail, "Email already exists", "Message Error Email is not correct");

        System.out.println("❌ Add Lead Failed as expected: Duplicate Email detected!");

        //close popup add
        leadsPage.clickBtnCloseAddLead();

        //Kiểm tra lại
        leadsPage.searchLeadSuccessNoData(leadData.getLeadName());
        leadsPage.verifySearchLeadSuccessNoData(leadData.getLeadName());
    }

    @Test(priority = 3)
    public void testEditLeadSuccess() {
        //Data Add
        TestCaseLead lead = new TestCaseLead();
        LeadDTO leadDataAdd = LeadDataFactory.getLeadDataFromExcel(3);

        //click menu Lead
        loginPage = new LoginPage();

        dashboardPage = loginPage.loginCRM();
        leadsPage = dashboardPage.clickMenuLead();
        leadsPage.verifyMenuLead();

        //click btn addnewLead
        leadsPage.clickBtnAddNewLead();
        leadsPage.verifyBtnAddNewLead();

        //Tạo data
        leadsPage.addAndEditLeadSuccess(leadDataAdd);
        leadsPage.closePopupDetail();

        //verifyLeadAddNew
        leadsPage.searchLeadSuccess(leadDataAdd.getLeadName());
        leadsPage.verifySearchLeadSuccess(leadDataAdd.getLeadName());

        //click btn edit
        leadsPage.clickBtnEdit(leadDataAdd.getLeadName());

        LeadDTO leadDataEdit = LeadDataFactory.getLeadDataFromExcel(4);

        //Edit Lead
        leadsPage.addAndEditLeadSuccess(leadDataEdit);

        leadsPage.closePopupDetail();

        //verifyLeadAddNew
        leadsPage.searchLeadSuccess(leadDataEdit.getLeadName());
        leadsPage.verifySearchLeadSuccess(leadDataEdit.getLeadName());

        //verify edit
        leadsPage.clickBtnEdit(leadDataEdit.getLeadName());
        leadsPage.viewEditLead(leadDataEdit);
    }


    @Test(priority = 4)
    public void testViewEditLeadSuccess() {
        TestCaseLead lead = new TestCaseLead();
        LeadDTO leadDataAdd = LeadDataFactory.getLeadDataFromExcel(5);

        //click menu Lead
        loginPage = new LoginPage();

        dashboardPage = loginPage.loginCRM();
        leadsPage = dashboardPage.clickMenuLead();
        leadsPage.verifyMenuLead();

        //click btn addnewLead
        leadsPage.clickBtnAddNewLead();
        leadsPage.verifyBtnAddNewLead();

        //Tạo data
        leadsPage.addAndEditLeadSuccess(leadDataAdd);

        leadsPage.closePopupDetail();

        //verifyLeadAddNew
        leadsPage.searchLeadSuccess(leadDataAdd.getLeadName());
        leadsPage.verifySearchLeadSuccess(leadDataAdd.getLeadName());

        leadsPage.clickBtnEdit(leadDataAdd.getLeadName());
        leadsPage.viewEditLead(leadDataAdd);
    }

    @Test(priority = 5)
    public void testDeleteLeadSuccess() {
        TestCaseLead lead = new TestCaseLead();
        LeadDTO leadDataAdd = LeadDataFactory.getLeadDataFromExcel(6);

        //click menu Lead
        loginPage = new LoginPage();

        dashboardPage = loginPage.loginCRM();
        leadsPage = dashboardPage.clickMenuLead();
        leadsPage.verifyMenuLead();
        //click btn addnewLead
        leadsPage.clickBtnAddNewLead();
        leadsPage.verifyBtnAddNewLead();

        //Tạo data
        leadsPage.addAndEditLeadSuccess(leadDataAdd);

        leadsPage.closePopupDetail();

        //verifyLeadAddNew
        leadsPage.searchLeadSuccess(leadDataAdd.getLeadName());
        leadsPage.verifySearchLeadSuccess(leadDataAdd.getLeadName());

        //click btn delete
        leadsPage.clickBtnDeleteLead(leadDataAdd.getLeadName());
        leadsPage.confirmDeleteLead(leadDataAdd.getTypeConfirm()); //1 là xóa

        //Verify Deleted
        leadsPage.verifyDeleteSuccessMessage(leadDataAdd.getTypeConfirm()); //1 là hiển thị message xóa thành công
        leadsPage.verifyAfterDeleteLead(leadDataAdd.getLeadName(), leadDataAdd.getTypeConfirm()); //tìm kiếm lại sau khi xóa
    }

    @Test
    public void verifyLeadActive(){
        TestCaseLead lead = new TestCaseLead();
        LeadDTO leadDataAdd = LeadDataFactory.getLeadDataFromExcel(7);

        //click menu Lead
        loginPage = new LoginPage();

        dashboardPage = loginPage.loginCRM();
        leadsPage = dashboardPage.clickMenuLead();
        leadsPage.verifyMenuLead();

        //click btnleadsumary
        leadsPage.clickBtnLeadSumary();
        Integer totalLeadActiveBeforeAdd = Integer.parseInt(leadsPage.getTotalLeadActive());

        //click btn addnewLead
        leadsPage.clickBtnAddNewLead();
        leadsPage.verifyBtnAddNewLead();

        //Tạo data
        leadsPage.addAndEditLeadSuccess(leadDataAdd);
        leadsPage.closePopupDetail();

        //verifyLeadAddNew
        leadsPage.searchLeadSuccess(leadDataAdd.getLeadName());
        leadsPage.verifySearchLeadSuccess(leadDataAdd.getLeadName());

        DriverManager.getDriver().navigate().refresh();

        leadsPage.clickBtnLeadSumary();
        String totalLeadActiveAfterAdd = leadsPage.getTotalLeadActive();
        Assert.assertEquals(totalLeadActiveBeforeAdd + 1, totalLeadActiveAfterAdd, "Active không tăng sau khi add");
    }
}
