package thuc_hanh;


import keywords.WebUI;
import locator.LocatorsLeads;
import common.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class BTLeads extends BaseTest {

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

    public void clickMenuLead() {
        //click menu Lead
        WebUI.clickElement(driver, LocatorsLeads.menuLeads);
        System.out.println("Click Lead Menu");
    }

    public void verifyMenuLead() throws InterruptedException {
        Thread.sleep(1000);
        //do truyền text vào xpath nên là kh cần get text để so sánh nữa
        boolean checkHeaderLeadSummary = WebUI.checkExitsElement(driver, LocatorsLeads.titleLeadsSummary);
        Assert.assertTrue(checkHeaderLeadSummary, "FAILED!!! Không truy cập được vào trang Leads");
    }

    public void clickBtnAddNewLead() {
        //click button New Lead
        WebUI.clickElement(driver, LocatorsLeads.btnAddLead);
        System.out.println("Click Button Add New Lead");
    }

    public void verifyBtnAddNewLead() throws InterruptedException {
        Thread.sleep(1000);
        boolean checktitleAddNewLead = WebUI.checkExitsElement(driver, LocatorsLeads.titleAddNewLead);
        Assert.assertTrue(checktitleAddNewLead, "FAILED!!! Không mở được pop-up Add new lead");
        System.out.println("Verify: Mở pop-up Add new lead thành công");
    }

    //close Popup Detail
    public void closePopupDetail() {
        WebUI.clickElement(driver, LocatorsLeads.iconClosePopupDetail);
    }

    //search Lead
    public void searchLeadSuccess(String expectedLeadName) throws InterruptedException {
        WebUI.clearElement(driver, LocatorsLeads.inputSearch);
        WebUI.setTextElement(driver, LocatorsLeads.inputSearch, expectedLeadName);
        Thread.sleep(2000);

        boolean rows = WebUI.checkExitsElement(driver, LocatorsLeads.getRows(expectedLeadName));
        //Sai khi không có bản ghi (không mong muốn rows.size() == 0 => đúng)
        //Assert.assertFalse(rows.size() == 0, "Không tìm thấy Lead '" + expectedLeadName + "' sau khi search!");

        //Mong muốn rows.size() > 0 => đúng, nếu rows.size() == 0 thì hiển thị message kia
        Assert.assertTrue(rows, "Không tìm thấy Lead '" + expectedLeadName + "' sau khi search!");
        System.out.println("Tìm kiếm thành công Lead: " + expectedLeadName);
    }

    public void searchLeadSuccessNoData(String expectedLeadName) throws InterruptedException {
        WebUI.clearElement(driver, LocatorsLeads.inputSearch);
        WebUI.setTextElement(driver, LocatorsLeads.inputSearch, expectedLeadName);
        Thread.sleep(2000);

//        List<WebElement> actualLeadName = driver.findElements("//table[@id='leads']//tbody/tr[text()='"+expectedLeadName+"']");
//        Assert.assertTrue(actualLeadName.size() == 0, "Còn dữ liệu");
        //hoặc
        boolean rows = WebUI.checkExitsElement(driver, LocatorsLeads.getRows(expectedLeadName));
        //Sai khi có bản ghi (không mong muốn rows.size() > 0 => đúng)
        Assert.assertFalse(rows, "Không mong muốn: vẫn còn bản ghi '" + expectedLeadName + "' trong bảng!");  // Test pass
        System.out.println("Tìm kiếm thành công: 0 bản ghi");
    }

    //Hàm so sánh giá trị đã thêm mới trong màn edit
    public void compareFieldAttribute(By xpathActual, String expectedValue, String attributeActual) {
        String actual = WebUI.getElementAttribute(driver, xpathActual, attributeActual);
        Assert.assertEquals(actual.trim(), expectedValue.trim(), "FAIL: Giá trị mong muốn là: " + expectedValue + " nhưng giá trị thực tế là: " + actual);
    }

    public void compareFieldText(By xpathActual, String expectedValue) {
        String actual = WebUI.getElementText(driver, xpathActual);
        Assert.assertEquals(actual.trim(), expectedValue.trim(), "FAIL: Giá trị mong muốn là: " + expectedValue + " nhưng giá trị thực tế là: " + actual);
    }

    public void verifyCheckboxSelected(By checkbox) {
        boolean checked = driver.findElement(checkbox).isSelected();
        Assert.assertTrue(checked, "Checkbox chưa được tích sau khi click");
    }

    public void clickBtnEdit(String leadName) {
        WebElement firstRow = driver.findElement(LocatorsLeads.firstRowItem);

        //Hover chuột vào dòng đầu tiên
        Actions actions = new Actions(driver);
        actions.moveToElement(firstRow).perform();
        WebUI.clickElement(driver, LocatorsLeads.buttonEdit(leadName));
        System.out.println("Mở pop-up Edit Lead thành công");
    }

    public void addAndEditLeadSuccess(String status, String source, String assigned, String tags, String leadName, String address, String position, String city,
                                String emailAddress, String state, String website, String country, String phone, String zipcode, String leadValue, String language,
                                String company, String description, String dateContacted, int flagEdit) throws InterruptedException {


        //dropdown Status
        WebUI.clickElement(driver, LocatorsLeads.dropdownStatus);
        WebUI.setTextElement(driver, LocatorsLeads.inputSearchOfStatus, status);
        WebUI.clickElement(driver, LocatorsLeads.getValueStatus(status));

        //dropdown Source
        WebUI.clickElement(driver, LocatorsLeads.dropdownSource);
        WebUI.setTextElement(driver, LocatorsLeads.inputSearchOfSource, source);
        WebUI.clickElement(driver, LocatorsLeads.getValueSource(source));

        //dropdownAssigned
        WebUI.clickElement(driver, LocatorsLeads.dropdownAssigned);
        WebUI.setTextElement(driver, LocatorsLeads.inputSearchOfAssigned, assigned);
        WebUI.clickElement(driver, LocatorsLeads.getValueAssigned(assigned));

        //Clear
        if (flagEdit == 1) {
            WebUI.clickElement(driver, LocatorsLeads.elementCloseTags);

            WebUI.clearElement(driver, LocatorsLeads.inputName);
            WebUI.clearElement(driver, LocatorsLeads.inputAddress);
            WebUI.clearElement(driver, LocatorsLeads.inputPosition);
            WebUI.clearElement(driver, LocatorsLeads.inputCity);
            WebUI.clearElement(driver, LocatorsLeads.inputEmailAddress);
            WebUI.clearElement(driver, LocatorsLeads.inputState);
            WebUI.clearElement(driver, LocatorsLeads.inputWebsite);
            WebUI.clearElement(driver, LocatorsLeads.inputPhone);
            WebUI.clearElement(driver, LocatorsLeads.inputZipCode);
            WebUI.clearElement(driver, LocatorsLeads.inputLeadValue);
            WebUI.clearElement(driver, LocatorsLeads.inputCompany);
            WebUI.clearElement(driver, LocatorsLeads.inputDescription);

            WebUI.scrollAtTop(driver, LocatorsLeads.dropdownStatus);
            WebUI.clickElement(driver, LocatorsLeads.inputAddTags);
        }

        //Tag
        WebUI.setTextElement(driver, LocatorsLeads.inputAddTags, tags);

        //click ra input name để đóng tag
        WebUI.clickElement(driver, LocatorsLeads.labelStatus);
        WebUI.clickElement(driver, LocatorsLeads.labelStatus);

        //input
        WebUI.setTextElement(driver, LocatorsLeads.inputName, leadName);
        WebUI.setTextElement(driver, LocatorsLeads.inputAddress, address);
        WebUI.setTextElement(driver, LocatorsLeads.inputPosition, position);
        WebUI.setTextElement(driver, LocatorsLeads.inputCity, city);
        WebUI.setTextElement(driver, LocatorsLeads.inputEmailAddress, emailAddress);
        WebUI.setTextElement(driver, LocatorsLeads.inputState, state);
        WebUI.setTextElement(driver, LocatorsLeads.inputWebsite, website);

        //dropdown Country
        WebUI.clickElement(driver, LocatorsLeads.dropdownCountry);
        WebUI.setTextElement(driver, LocatorsLeads.inputSearchOfCountry, country);
        WebUI.clickElement(driver, LocatorsLeads.getValueCountry(country));

        //input
        WebUI.setTextElement(driver, LocatorsLeads.inputPhone, phone);
        WebUI.setTextElement(driver, LocatorsLeads.inputZipCode, zipcode);
        WebUI.setTextElement(driver, LocatorsLeads.inputLeadValue, leadValue);

        //scroll kéo xuống dưới
        WebUI.scrollAtBottom(driver, LocatorsLeads.buttonSave);

        //dropdown Language
        WebUI.clickElement(driver, LocatorsLeads.dropdownLanguage);
        WebUI.setTextElement(driver, LocatorsLeads.inputSearchOfLanguage, language);
        WebUI.clickElement(driver, LocatorsLeads.getValueLanguage(language));

        //input
        WebUI.setTextElement(driver, LocatorsLeads.inputCompany, company);
        WebUI.setTextElement(driver, LocatorsLeads.inputDescription, description);

        //checkbox public
        WebUI.clickElement(driver, LocatorsLeads.labelPublic);

        //checkbox contactedToday
        //flagEdit = 0 => Thêm mới
        if (flagEdit == 0){
            WebUI.clickElement(driver, LocatorsLeads.labelContactedToday);
            WebUI.setTextElement(driver, LocatorsLeads.inputDateContacted, dateContacted);
        }else {
            WebUI.clearElement(driver, LocatorsLeads.inputLastContact);
            WebUI.setTextElement(driver, LocatorsLeads.inputLastContact, dateContacted);
        }

        //click btn Save
        WebUI.clickElement(driver, LocatorsLeads.buttonSave);
    }

    public void viewEditLead(String status, String source, String assigned, String tags, String leadName, String address, String position, String city,
                                String emailAddress, String state, String website, String country, String phone, String zipcode, String leadValue, String language,
                                String company, String description, String dateContacted) {

        compareFieldText(LocatorsLeads.dropdownStatus, status);
        compareFieldText(LocatorsLeads.dropdownSource, source);
        compareFieldText(LocatorsLeads.dropdownAssigned, assigned);
        compareFieldText(LocatorsLeads.inputEditTags, tags);
        compareFieldAttribute(LocatorsLeads.inputName, leadName, "value");
        compareFieldAttribute(LocatorsLeads.inputAddress, address, "value");
        compareFieldAttribute(LocatorsLeads.inputPosition, position, "value");
        compareFieldAttribute(LocatorsLeads.inputCity, city, "value");
        compareFieldAttribute(LocatorsLeads.inputEmailAddress, emailAddress, "value");
        compareFieldAttribute(LocatorsLeads.inputState, state, "value");
        compareFieldAttribute(LocatorsLeads.inputWebsite, website, "value");
        compareFieldText(LocatorsLeads.dropdownCountry, country);
        compareFieldAttribute(LocatorsLeads.inputPhone, phone, "value");
        compareFieldAttribute(LocatorsLeads.inputZipCode, zipcode, "value");
        compareFieldAttribute(LocatorsLeads.inputLeadValue, leadValue + ".00", "value");
        compareFieldText(LocatorsLeads.dropdownLanguage, language);
        compareFieldAttribute(LocatorsLeads.inputCompany, company, "value");
        compareFieldAttribute(LocatorsLeads.inputDescription, description, "value");
        compareFieldAttribute(LocatorsLeads.inputLastContact, dateContacted, "value"); //hệ thống bug
        verifyCheckboxSelected(LocatorsLeads.checkboxPublic);
        System.out.println("Tất cả các trường dữ liệu Lead đã được Verify thành công");
    }

    public void deleteLeadSuccess(String leadName) {
        WebElement firstRow = driver.findElement(LocatorsLeads.firstRowItem);

        //Hover chuột vào dòng đầu tiên
        Actions actions = new Actions(driver);
        actions.moveToElement(firstRow).perform();
        WebUI.clickElement(driver, LocatorsLeads.buttonDelete(leadName));
    }

    public void confirmDeleteLeadSuccess(String leadName, int flag) throws InterruptedException {
        System.out.println("Confirm Delete Lead Success");
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        softAssert.assertEquals(alertText, "Are you sure you want to perform this action?", "Nội dung trong alert Delete không đúng");
        System.out.println("Nội dung trong alert Delete hợp lệ");
        //check text trên alert
        if (flag == 1) {
            alert.accept();
            System.out.println("Xóa thành công");
        }else {
            alert.dismiss();
            System.out.println("Bỏ xóa thành công");
        }
    }

    @Test(priority = 1)
    public void testAddNewLeadSuccess() throws InterruptedException {
        BTLeads lead = new BTLeads();
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
        clickMenuLead();
        verifyMenuLead();

        //click btn addnewLead
        clickBtnAddNewLead();
        verifyBtnAddNewLead();

        addAndEditLeadSuccess(lead.status, lead.source, lead.assigned, lead.tags, lead.leadName, lead.address, lead.position, lead.city, lead.emailAddress, lead.state, lead.website, lead.country, lead.phone, lead.zipcode, lead.leadValue, lead.language, lead.company, lead.description, lead.dateContacted, 0);
        Thread.sleep(1000);
        System.out.println("Tạo data thành công");

        closePopupDetail();
        Thread.sleep(2000);

        //verifyLeadAddNew
        searchLeadSuccess(lead.leadName);
        Thread.sleep(500);
    }

    //Set Email đã tồn tại
    @Test(priority = 2)
    public void testAddNewLeadFailEmailAlreadyExists() throws InterruptedException {
        BTLeads lead = new BTLeads();
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
        clickMenuLead();
        verifyMenuLead();

        //click btn addnewLead
        clickBtnAddNewLead();
        verifyBtnAddNewLead();

        addAndEditLeadSuccess(lead.status, lead.source, lead.assigned, lead.tags, lead.leadName, lead.address, lead.position, lead.city, lead.emailAddress, lead.state, lead.website, lead.country, lead.phone, lead.zipcode, lead.leadValue, lead.language, lead.company, lead.description, lead.dateContacted, 0);
        Thread.sleep(1000);

        //verify lỗi
        List<WebElement> checkMessageErrorEmail = driver.findElements(By.xpath("//p[@id='email-error']"));
        Assert.assertTrue(checkMessageErrorEmail.size() > 0, "Check Message Error Email is not Displayed");

        //verify message
        String messageErrorEmail = driver.findElement(By.xpath("//p[@id='email-error']")).getText();
        softAssert.assertEquals(messageErrorEmail, "Email already exists", "Message Error Email is not correct");

        System.out.println("❌ Add Lead Failed as expected: Duplicate Email detected!");

        //close popup add
        Thread.sleep(1000);
        driver.findElement(LocatorsLeads.buttonClose).click();
        Thread.sleep(2000);

        //Kiểm tra lại
        searchLeadSuccessNoData(lead.leadName);
    }

    @Test(priority = 3)
    public void testEditLeadSuccess() throws InterruptedException {
        //Data Add
        BTLeads lead = new BTLeads();
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
        clickMenuLead();
        verifyMenuLead();

        //click btn addnewLead
        clickBtnAddNewLead();
        verifyBtnAddNewLead();

        //Tạo data
        addAndEditLeadSuccess(lead.status, lead.source, lead.assigned, lead.tags, lead.leadName, lead.address, lead.position, lead.city, lead.emailAddress, lead.state, lead.website, lead.country, lead.phone, lead.zipcode, lead.leadValue, lead.language, lead.company, lead.description, lead.dateContacted, 0);
        Thread.sleep(1000);

        closePopupDetail();
        Thread.sleep(2000);

        //verifyLeadAddNew
        searchLeadSuccess(lead.leadName);
        Thread.sleep(1000);

        //click btn edit
        clickBtnEdit(lead.leadName);

        //Data Update
        lead.address = "231 Hoonag Mai, Hà Nội";
        lead.position = "Hoàng Mai";
        lead.city = "Hà Nội";
        lead.emailAddress = "giangedit08@gmail.com";
        lead.company = "VN";

        //Edit Lead
        addAndEditLeadSuccess(lead.status, lead.source, lead.assigned, lead.tags, lead.leadName, lead.address, lead.position, lead.city, lead.emailAddress, lead.state, lead.website, lead.country, lead.phone, lead.zipcode, lead.leadValue, lead.language, lead.company, lead.description, lead.dateContacted, 1);
        Thread.sleep(1000);

        closePopupDetail();
        Thread.sleep(2000);

        //verifyLeadAddNew
        searchLeadSuccess(lead.leadName);
        Thread.sleep(2000);

        //verify edit
        clickBtnEdit(lead.leadName);
        viewEditLead(lead.status, lead.source, lead.assigned, lead.tags, lead.leadName, lead.address, lead.position, lead.city, lead.emailAddress, lead.state, lead.website, lead.country, lead.phone, lead.zipcode, lead.leadValue, lead.language, lead.company, lead.description, lead.dateContacted);
    }


    @Test(priority = 4)
    public void testViewEditLeadSuccess() throws InterruptedException {
        BTLeads lead = new BTLeads();
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
        clickMenuLead();
        verifyMenuLead();

        //click btn addnewLead
        clickBtnAddNewLead();
        verifyBtnAddNewLead();

        //Tạo data
        addAndEditLeadSuccess(lead.status, lead.source, lead.assigned, lead.tags, lead.leadName, lead.address, lead.position, lead.city, lead.emailAddress, lead.state, lead.website, lead.country, lead.phone, lead.zipcode, lead.leadValue, lead.language, lead.company, lead.description, lead.dateContacted, 0);
        Thread.sleep(1000);

        closePopupDetail();
        Thread.sleep(2000);

        //verifyLeadAddNew
        searchLeadSuccess(lead.leadName);
        Thread.sleep(500);

        clickBtnEdit(lead.leadName);
        viewEditLead(lead.status, lead.source, lead.assigned, lead.tags, lead.leadName, lead.address, lead.position, lead.city, lead.emailAddress, lead.state, lead.website, lead.country, lead.phone, lead.zipcode, lead.leadValue, lead.language, lead.company, lead.description, lead.dateContacted);
        Thread.sleep(2000);
    }

    @Test(priority = 5)
    public void testDeleteLeadSuccess() throws InterruptedException {
        BTLeads lead = new BTLeads();
        lead.status = "Active";
        lead.source = "Facebook";
        lead.assigned = "Admin Anh Tester";
        lead.tags = "GTest123";
        lead.leadName = "Giang Test ND01";
        lead.address = "230 Mễ Trì, Hà Nội";
        lead.position = "Mễ Trì";
        lead.city = "Hà Nội";
        lead.emailAddress = "giangND01@gmail.com";
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
        clickMenuLead();
        verifyMenuLead();

        //click btn addnewLead
        clickBtnAddNewLead();
        verifyBtnAddNewLead();

        //Tạo data
        addAndEditLeadSuccess(lead.status, lead.source, lead.assigned, lead.tags, lead.leadName, lead.address, lead.position, lead.city, lead.emailAddress, lead.state, lead.website, lead.country, lead.phone, lead.zipcode, lead.leadValue, lead.language, lead.company, lead.description, lead.dateContacted, 0);
        Thread.sleep(1000);

        closePopupDetail();
        Thread.sleep(2000);

        //verifyLeadAddNew
        searchLeadSuccess(lead.leadName);
        Thread.sleep(500);

        //click btn delete
        deleteLeadSuccess(lead.leadName);
        confirmDeleteLeadSuccess(lead.leadName, 1); //1 là xóa

        //Verify Deleted
        searchLeadSuccessNoData(lead.leadName);
    }


}
