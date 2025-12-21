package com.giangnth.testcases;


import com.giangnth.drivers.DriverManager;
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

    String status = "Active";
    String source = "Facebook";
    String assigned = "Admin Anh Tester";
    String tags = "Giang12";
    String leadName = "GiangTest";
    String address = "230 Mễ Trì, Hà Nội";
    String position = "Mễ Trì";
    String city = "Hà Nội";
    String emailAddress = "giangtest08@gmail.com";
    String state = "123";
    String website = "https://8080:21";
    String country = "Angola";
    String phone = "0772627627";
    String zipcode = "7789";
    String leadValue = "100000";
    String language = "English";
    String company = "ND";
    String description = "Không";
    String dateContacted = "05-11-2025 00:00:00";


    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private LeadsPage leadsPage;

    @Test(priority = 1)
    public void testAddNewLeadSuccess() {
        TestCaseLead lead = new TestCaseLead();

        lead.leadName = "Giang Test AddNewLead";
        lead.emailAddress = "giang@gmail.com";

        //click menu Lead
        loginPage = new LoginPage();

        dashboardPage = loginPage.loginCRM();
        leadsPage = dashboardPage.clickMenuLead();
        leadsPage.verifyMenuLead();

        //click btn addnewLead
        leadsPage.clickBtnAddNewLead();
        leadsPage.verifyBtnAddNewLead();

        leadsPage.addAndEditLeadSuccess(lead.status, lead.source, lead.assigned, lead.tags, lead.leadName, lead.address, lead.position, lead.city, lead.emailAddress, lead.state, lead.website, lead.country, lead.phone, lead.zipcode, lead.leadValue, lead.language, lead.company, lead.description, lead.dateContacted, 0);

        leadsPage.closePopupDetail();

        //verifyLeadAddNew
        leadsPage.searchLeadSuccess(lead.leadName);
        System.out.println("Tạo data thành công");
    }

    //Set Email đã tồn tại
    @Test(priority = 2)
    public void testAddNewLeadFailEmailAlreadyExists() {
        TestCaseLead lead = new TestCaseLead();
        lead.leadName = "Giang Test EmailAlreadyExists";
        lead.emailAddress = "giangtestEmailAlreadyExists@gmail.com";

        //click menu Lead
        loginPage = new LoginPage();

        dashboardPage = loginPage.loginCRM();
        leadsPage = dashboardPage.clickMenuLead();
        leadsPage.verifyMenuLead();

        //click btn addnewLead
        leadsPage.clickBtnAddNewLead();
        leadsPage.verifyBtnAddNewLead();

        leadsPage.addAndEditLeadSuccess(lead.status, lead.source, lead.assigned, lead.tags, lead.leadName, lead.address, lead.position, lead.city, lead.emailAddress, lead.state, lead.website, lead.country, lead.phone, lead.zipcode, lead.leadValue, lead.language, lead.company, lead.description, lead.dateContacted, 0);

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
        leadsPage.searchLeadSuccessNoData(lead.leadName);
    }

    @Test(priority = 3)
    public void testEditLeadSuccess() {
        //Data Add
        TestCaseLead lead = new TestCaseLead();
        lead.leadName = "Giang Test Edit";
        lead.emailAddress = "giangadd08@gmail.com";

        //click menu Lead
        loginPage = new LoginPage();

        dashboardPage = loginPage.loginCRM();
        leadsPage = dashboardPage.clickMenuLead();
        leadsPage.verifyMenuLead();

        //click btn addnewLead
        leadsPage.clickBtnAddNewLead();
        leadsPage.verifyBtnAddNewLead();

        //Tạo data
        leadsPage.addAndEditLeadSuccess(lead.status, lead.source, lead.assigned, lead.tags, lead.leadName, lead.address, lead.position, lead.city, lead.emailAddress, lead.state, lead.website, lead.country, lead.phone, lead.zipcode, lead.leadValue, lead.language, lead.company, lead.description, lead.dateContacted, 0);

        leadsPage.closePopupDetail();

        //verifyLeadAddNew
        leadsPage.searchLeadSuccess(lead.leadName);

        //click btn edit
        leadsPage.clickBtnEdit(lead.leadName);

        //Data Update
        lead.address = "231 Hoonag Mai, Hà Nội";
        lead.position = "Hoàng Mai";
        lead.city = "Hà Nội";
        lead.emailAddress = "giangedit08@gmail.com";
        lead.company = "VN";

        //Edit Lead
        leadsPage.addAndEditLeadSuccess(lead.status, lead.source, lead.assigned, lead.tags, lead.leadName, lead.address, lead.position, lead.city, lead.emailAddress, lead.state, lead.website, lead.country, lead.phone, lead.zipcode, lead.leadValue, lead.language, lead.company, lead.description, lead.dateContacted, 1);

        leadsPage.closePopupDetail();

        //verifyLeadAddNew
        leadsPage.searchLeadSuccess(lead.leadName);

        //verify edit
        leadsPage.clickBtnEdit(lead.leadName);
        leadsPage.viewEditLead(lead.status, lead.source, lead.assigned, lead.tags, lead.leadName, lead.address, lead.position, lead.city, lead.emailAddress, lead.state, lead.website, lead.country, lead.phone, lead.zipcode, lead.leadValue, lead.language, lead.company, lead.description, lead.dateContacted);
    }


    @Test(priority = 4)
    public void testViewEditLeadSuccess() {
        TestCaseLead lead = new TestCaseLead();
        lead.leadName = "Giang Test 001";
        lead.emailAddress = "giang001Nodo@gmail.com";

        //click menu Lead
        loginPage = new LoginPage();

        dashboardPage = loginPage.loginCRM();
        leadsPage = dashboardPage.clickMenuLead();
        leadsPage.verifyMenuLead();

        //click btn addnewLead
        leadsPage.clickBtnAddNewLead();
        leadsPage.verifyBtnAddNewLead();

        //Tạo data
        leadsPage.addAndEditLeadSuccess(lead.status, lead.source, lead.assigned, lead.tags, lead.leadName, lead.address, lead.position, lead.city, lead.emailAddress, lead.state, lead.website, lead.country, lead.phone, lead.zipcode, lead.leadValue, lead.language, lead.company, lead.description, lead.dateContacted, 0);

        leadsPage.closePopupDetail();

        //verifyLeadAddNew
        leadsPage.searchLeadSuccess(lead.leadName);

        leadsPage.clickBtnEdit(lead.leadName);
        leadsPage.viewEditLead(lead.status, lead.source, lead.assigned, lead.tags, lead.leadName, lead.address, lead.position, lead.city, lead.emailAddress, lead.state, lead.website, lead.country, lead.phone, lead.zipcode, lead.leadValue, lead.language, lead.company, lead.description, lead.dateContacted);
    }

    @Test(priority = 5)
    public void testDeleteLeadSuccess() {
        TestCaseLead lead = new TestCaseLead();
        lead.leadName = "Giang Test Deleted";
        lead.emailAddress = "giangtestdelete001@gmail.com";

        //click menu Lead
        loginPage = new LoginPage();

        dashboardPage = loginPage.loginCRM();
        leadsPage = dashboardPage.clickMenuLead();
        leadsPage.verifyMenuLead();
        //click btn addnewLead
        leadsPage.clickBtnAddNewLead();
        leadsPage.verifyBtnAddNewLead();

        //Tạo data
        leadsPage.addAndEditLeadSuccess(lead.status, lead.source, lead.assigned, lead.tags, lead.leadName, lead.address, lead.position, lead.city, lead.emailAddress, lead.state, lead.website, lead.country, lead.phone, lead.zipcode, lead.leadValue, lead.language, lead.company, lead.description, lead.dateContacted, 0);

        leadsPage.closePopupDetail();

        //verifyLeadAddNew
        leadsPage.searchLeadSuccess(lead.leadName);

        //click btn delete
        leadsPage.clickBtnDeleteLead(lead.leadName);
        leadsPage.confirmDeleteLead(1); //1 là xóa

        //Verify Deleted
        leadsPage.verifyDeleteSuccessMessage(1); //1 là hiển thị message xóa thành công
        leadsPage.verifyAfterDeleteLead(lead.leadName, 1); //tìm kiếm lại sau khi xóa
    }

    @Test
    public void verifyLeadActive(){
        TestCaseLead lead = new TestCaseLead();
        lead.status = "Active";
        lead.leadName = "Giang Test Active";
        lead.emailAddress = "giangtestactive001@gmail.com";

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
        leadsPage.addAndEditLeadSuccess(lead.status, lead.source, lead.assigned, lead.tags, lead.leadName, lead.address, lead.position, lead.city, lead.emailAddress, lead.state, lead.website, lead.country, lead.phone, lead.zipcode, lead.leadValue, lead.language, lead.company, lead.description, lead.dateContacted, 0);

        leadsPage.closePopupDetail();

        //verifyLeadAddNew
        leadsPage.searchLeadSuccess(lead.leadName);

        DriverManager.getDriver().navigate().refresh();

        leadsPage.clickBtnLeadSumary();
        String totalLeadActiveAfterAdd = leadsPage.getTotalLeadActive();
        Assert.assertEquals(totalLeadActiveBeforeAdd + 1, totalLeadActiveAfterAdd, "Active không tăng sau khi add");
    }
}
