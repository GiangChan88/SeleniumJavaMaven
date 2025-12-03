package com.giangnth.testcases;


import com.giangnth.pages.DashboardPage;
import com.giangnth.pages.LoginPage;
import keywords.WebUI;
import com.giangnth.pages.LeadsPage;
import common.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestCaseLead extends BaseTest {

    String status = "";
    String source = "";
    String assigned = "";
    String tags = "";
    String leadName = "";
    String address = "";
    String position = "";
    String city = "";
    String emailAddress = "";
    String state = "";
    String website = "";
    String country = "";
    String phone = "";
    String zipcode = "";
    String leadValue = "";
    String language = "";
    String company = "";
    String description = "";
    String dateContacted = "";


    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private LeadsPage leadsPage;



    @Test(priority = 1)
    public void testAddNewLeadSuccess() throws InterruptedException {
        TestCaseLead lead = new TestCaseLead();

        lead.status = "Active";
        lead.source = "Facebook";
        lead.assigned = "Admin Anh Tester";
        lead.tags = "Giang12345";
        lead.leadName = "Giang Chan1";
        lead.address = "230 Mễ Trì, Hà Nội";
        lead.position = "Mễ Trì";
        lead.city = "Hà Nội";
        lead.emailAddress = "giang081@gmail.com";
        lead.state = "123";
        lead.website = "https://8080:21";
        lead.country = "Angola";
        lead.phone = "0772627627";
        lead.zipcode = "7789";
        lead.leadValue = "100000";
        lead.language = "English";
        lead.company = "ND";
        lead.description = "Không";
        lead.dateContacted = "05-11-2025 00:00:00";

        //click menu Lead
        loginPage = new LoginPage(driver);

        dashboardPage = loginPage.loginCRM();
        leadsPage = dashboardPage.clickMenuLead();
        leadsPage.verifyMenuLead();

        //click btn addnewLead
        leadsPage.clickBtnAddNewLead();
        leadsPage.verifyBtnAddNewLead();

        leadsPage.addAndEditLeadSuccess(lead.status, lead.source, lead.assigned, lead.tags, lead.leadName, lead.address, lead.position, lead.city, lead.emailAddress, lead.state, lead.website, lead.country, lead.phone, lead.zipcode, lead.leadValue, lead.language, lead.company, lead.description, lead.dateContacted, 0);
        Thread.sleep(1000);
        System.out.println("Tạo data thành công");

        leadsPage.closePopupDetail();
        Thread.sleep(2000);

        //verifyLeadAddNew
        leadsPage.searchLeadSuccess(lead.leadName);
        Thread.sleep(1000);
    }

    //Set Email đã tồn tại
    @Test(priority = 2)
    public void testAddNewLeadFailEmailAlreadyExists() throws InterruptedException {
        TestCaseLead lead = new TestCaseLead();
        lead.status = "Active";
        lead.source = "Facebook";
        lead.assigned = "Admin Anh Tester";
        lead.tags = "Giang12345";
        lead.leadName = "Giang Test EmailAlreadyExists";
        lead.address = "230 Mễ Trì, Hà Nội";
        lead.position = "Mễ Trì";
        lead.city = "Hà Nội";
        lead.emailAddress = "giang08@gmail.com";
        lead.state = "123";
        lead.website = "https://8080:21";
        lead.country = "Angola";
        lead.phone = "0772627627";
        lead.zipcode = "7789";
        lead.leadValue = "100000";
        lead.language = "English";
        lead.company = "ND";
        lead.description = "Không";
        lead.dateContacted = "05-11-2025 00:00:00";

        //click menu Lead
        loginPage = new LoginPage(driver);

        dashboardPage = loginPage.loginCRM();
        leadsPage = dashboardPage.clickMenuLead();
        leadsPage.verifyMenuLead();

        //click btn addnewLead
        leadsPage.clickBtnAddNewLead();
        leadsPage.verifyBtnAddNewLead();

        leadsPage.addAndEditLeadSuccess(lead.status, lead.source, lead.assigned, lead.tags, lead.leadName, lead.address, lead.position, lead.city, lead.emailAddress, lead.state, lead.website, lead.country, lead.phone, lead.zipcode, lead.leadValue, lead.language, lead.company, lead.description, lead.dateContacted, 0);
        Thread.sleep(1000);

        //verify lỗi
        List<WebElement> checkMessageErrorEmail = driver.findElements(By.xpath("//p[@id='email-error']"));
        Assert.assertTrue(checkMessageErrorEmail.size() > 0, "Check Message Error Email is not Displayed");

        //verify message
        String messageErrorEmail = driver.findElement(By.xpath("//p[@id='email-error']")).getText();
        softAssert.assertEquals(messageErrorEmail, "Email already exists", "Message Error Email is not correct");

        System.out.println("❌ Add Lead Failed as expected: Duplicate Email detected!");

        //close popup add
        leadsPage.clickBtnCloseAddLead();

        //Kiểm tra lại
        leadsPage.searchLeadSuccessNoData(lead.leadName);
    }

    @Test(priority = 3)
    public void testEditLeadSuccess() throws InterruptedException {
        //Data Add
        TestCaseLead lead = new TestCaseLead();
        lead.status = "Active";
        lead.source = "Facebook";
        lead.assigned = "Admin Anh Tester";
        lead.tags = "Giang12";
        lead.leadName = "Giang Test";
        lead.address = "230 Mễ Trì, Hà Nội";
        lead.position = "Mễ Trì";
        lead.city = "Hà Nội";
        lead.emailAddress = "giangtestedit08@gmail.com";
        lead.state = "123";
        lead.website = "https://8080:21";
        lead.country = "Angola";
        lead.phone = "0772627627";
        lead.zipcode = "7789";
        lead.leadValue = "100000";
        lead.language = "English";
        lead.company = "ND";
        lead.description = "Không";
        lead.dateContacted = "05-11-2025 00:00:00";

        //click menu Lead
        loginPage = new LoginPage(driver);

        dashboardPage = loginPage.loginCRM();
        leadsPage = dashboardPage.clickMenuLead();
        leadsPage.verifyMenuLead();

        //click btn addnewLead
        leadsPage.clickBtnAddNewLead();
        leadsPage.verifyBtnAddNewLead();

        //Tạo data
        leadsPage.addAndEditLeadSuccess(lead.status, lead.source, lead.assigned, lead.tags, lead.leadName, lead.address, lead.position, lead.city, lead.emailAddress, lead.state, lead.website, lead.country, lead.phone, lead.zipcode, lead.leadValue, lead.language, lead.company, lead.description, lead.dateContacted, 0);
        Thread.sleep(1000);

        leadsPage.closePopupDetail();
        Thread.sleep(2000);

        //verifyLeadAddNew
        leadsPage.searchLeadSuccess(lead.leadName);
        Thread.sleep(1000);

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
        Thread.sleep(1000);

        leadsPage.closePopupDetail();
        Thread.sleep(2000);

        //verifyLeadAddNew
        leadsPage.searchLeadSuccess(lead.leadName);
        Thread.sleep(2000);

        //verify edit
        leadsPage.clickBtnEdit(lead.leadName);
        leadsPage.viewEditLead(lead.status, lead.source, lead.assigned, lead.tags, lead.leadName, lead.address, lead.position, lead.city, lead.emailAddress, lead.state, lead.website, lead.country, lead.phone, lead.zipcode, lead.leadValue, lead.language, lead.company, lead.description, lead.dateContacted);
    }


    @Test(priority = 4)
    public void testViewEditLeadSuccess() throws InterruptedException {
        TestCaseLead lead = new TestCaseLead();
        lead.status = "Active";
        lead.source = "Facebook";
        lead.assigned = "Admin Anh Tester";
        lead.tags = "GTest123";
        lead.leadName = "Giang Test 001";
        lead.address = "230 Mễ Trì, Hà Nội";
        lead.position = "Mễ Trì";
        lead.city = "Hà Nội";
        lead.emailAddress = "giang001Nodo@gmail.com";
        lead.state = "123";
        lead.website = "https://8080:21";
        lead.country = "Angola";
        lead.phone = "0772627627";
        lead.zipcode = "7789";
        lead.leadValue = "100000";
        lead.language = "English";
        lead.company = "ND";
        lead.description = "Không";
        lead.dateContacted = "05-11-2025 00:00:00";

        //click menu Lead
        loginPage = new LoginPage(driver);

        dashboardPage = loginPage.loginCRM();
        leadsPage = dashboardPage.clickMenuLead();
        leadsPage.verifyMenuLead();

        //click btn addnewLead
        leadsPage.clickBtnAddNewLead();
        leadsPage.verifyBtnAddNewLead();

        //Tạo data
        leadsPage.addAndEditLeadSuccess(lead.status, lead.source, lead.assigned, lead.tags, lead.leadName, lead.address, lead.position, lead.city, lead.emailAddress, lead.state, lead.website, lead.country, lead.phone, lead.zipcode, lead.leadValue, lead.language, lead.company, lead.description, lead.dateContacted, 0);
        Thread.sleep(1000);

        leadsPage.closePopupDetail();
        Thread.sleep(2000);

        //verifyLeadAddNew
        leadsPage.searchLeadSuccess(lead.leadName);
        Thread.sleep(500);

        leadsPage.clickBtnEdit(lead.leadName);
        leadsPage.viewEditLead(lead.status, lead.source, lead.assigned, lead.tags, lead.leadName, lead.address, lead.position, lead.city, lead.emailAddress, lead.state, lead.website, lead.country, lead.phone, lead.zipcode, lead.leadValue, lead.language, lead.company, lead.description, lead.dateContacted);
        Thread.sleep(2000);
    }

    @Test(priority = 5)
    public void testDeleteLeadSuccess() throws InterruptedException {
        TestCaseLead lead = new TestCaseLead();
        lead.status = "Active";
        lead.source = "Facebook";
        lead.assigned = "Admin Anh Tester";
        lead.tags = "GTest123";
        lead.leadName = "Giang Test Deleted";
        lead.address = "230 Mễ Trì, Hà Nội";
        lead.position = "Mễ Trì";
        lead.city = "Hà Nội";
        lead.emailAddress = "giangtestdelete001@gmail.com";
        lead.state = "123";
        lead.website = "https://8080:21";
        lead.country = "Angola";
        lead.phone = "0772627627";
        lead.zipcode = "7789";
        lead.leadValue = "100000";
        lead.language = "English";
        lead.company = "ND";
        lead.description = "Không";
        lead.dateContacted = "05-11-2025 00:00:00";

        //click menu Lead
        loginPage = new LoginPage(driver);

        dashboardPage = loginPage.loginCRM();
        leadsPage = dashboardPage.clickMenuLead();
        leadsPage.verifyMenuLead();

        //click btn addnewLead
        leadsPage.clickBtnAddNewLead();
        leadsPage.verifyBtnAddNewLead();

        //Tạo data
        leadsPage.addAndEditLeadSuccess(lead.status, lead.source, lead.assigned, lead.tags, lead.leadName, lead.address, lead.position, lead.city, lead.emailAddress, lead.state, lead.website, lead.country, lead.phone, lead.zipcode, lead.leadValue, lead.language, lead.company, lead.description, lead.dateContacted, 0);
        Thread.sleep(1000);

        leadsPage.closePopupDetail();
        Thread.sleep(1000);

        //verifyLeadAddNew
        leadsPage.searchLeadSuccess(lead.leadName);
        Thread.sleep(500);

        //click btn delete
        leadsPage.deleteLeadSuccess(lead.leadName);
        leadsPage.confirmDeleteLeadSuccess(lead.leadName, 1); //1 là xóa

        //Verify Deleted
        leadsPage.searchLeadSuccessNoData(lead.leadName);
    }


}
