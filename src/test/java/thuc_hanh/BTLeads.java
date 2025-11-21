package thuc_hanh;


import bt_locator.LocatorsLeads;
import common.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class BTLeads extends BaseTest {

    public void clickMenuLead() throws InterruptedException {
        //click menu Lead
        driver.findElement(By.xpath(LocatorsLeads.menuLeads)).click();
        Thread.sleep(2000);
        List<WebElement> checkHeaderLeadSummary = driver.findElements(By.xpath(LocatorsLeads.headerLeadsSummary));
        Assert.assertTrue(checkHeaderLeadSummary.size() > 0, "FAILED!!! Không truy cập được vào trang Leads");
        System.out.println("Đã tới Leads");
    }

    public void clickBtnAddNewLead() throws InterruptedException {
        //click button New Lead
        driver.findElement(By.xpath(LocatorsLeads.btnAddLead)).click();
        Thread.sleep(1000);
        List<WebElement> checktitleAddNewLead = driver.findElements(By.xpath(LocatorsLeads.titleAddNewLead));
        Assert.assertTrue(checktitleAddNewLead.size() > 0, "FAILED!!! Không mở được pop-up Add new lead");
        System.out.println("Mở pop-up Add new lead thành công");
    }

    //add Lead
    public void addNewLead(String status, String source, String assigned, String tags, String leadName, String address, String position, String city,
                                  String emailAddress, String state, String website, String country, String phone, String zipcode, String leadValue, String language,
                                  String company, String description, String dateContacted) throws InterruptedException {

        //dropdown Status
        driver.findElement(By.xpath(LocatorsLeads.dropdownStatus)).click();
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorsLeads.inputSearchOfStatus)).sendKeys(status);
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorsLeads.getValueStatus(status))).click();
        Thread.sleep(500);

        //dropdown Source
        driver.findElement(By.xpath(LocatorsLeads.dropdownSource)).click();
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorsLeads.inputSearchOfSource)).sendKeys(source);
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorsLeads.getValueSource(source))).click();
        Thread.sleep(500);

        //dropdownAssigned
        driver.findElement(By.xpath(LocatorsLeads.dropdownAssigned)).click();
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorsLeads.inputSearchOfAssigned)).sendKeys(assigned);
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorsLeads.getValueAssigned(assigned))).click();
        Thread.sleep(500);

        //input
        driver.findElement(By.xpath(LocatorsLeads.inputAddTags)).sendKeys(tags);
        //click ra input name để input tag nhận giá trị mới
        driver.findElement(By.xpath(LocatorsLeads.labelStatus)).click();
        driver.findElement(By.xpath(LocatorsLeads.inputName)).sendKeys(leadName); //truyền name
        driver.findElement(By.xpath(LocatorsLeads.inputAddress)).sendKeys(address);
        driver.findElement(By.xpath(LocatorsLeads.inputPosition)).sendKeys(position);
        driver.findElement(By.xpath(LocatorsLeads.inputCity)).sendKeys(city);
        driver.findElement(By.xpath(LocatorsLeads.inputEmailAddress)).sendKeys(emailAddress);
        driver.findElement(By.xpath(LocatorsLeads.inputState)).sendKeys(state);
        driver.findElement(By.xpath(LocatorsLeads.inputWebsite)).sendKeys(website);

        //dropdown Country
        driver.findElement(By.xpath(LocatorsLeads.dropdownCountry)).click();
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorsLeads.inputSearchOfCountry)).sendKeys(country);
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorsLeads.getValueCountry(country))).click();
        Thread.sleep(500);

        //input
        driver.findElement(By.xpath(LocatorsLeads.inputPhone)).sendKeys(phone);
        driver.findElement(By.xpath(LocatorsLeads.inputZipCode)).sendKeys(zipcode);
        driver.findElement(By.xpath(LocatorsLeads.inputLeadValue)).sendKeys(leadValue);

        //scroll kéo xuống dưới
        WebElement elementBtnSave = driver.findElement(By.xpath(LocatorsLeads.buttonSave)); //trỏ tới element
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", elementBtnSave); //true là cuộn xuống dưới, false là cuộn lên trên

        //dropdown Language
        driver.findElement(By.xpath(LocatorsLeads.dropdownLanguage)).click();
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorsLeads.inputSearchOfLanguage)).sendKeys(language);
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorsLeads.getValueLanguage(language))).click();
        Thread.sleep(500);

        //input
        driver.findElement(By.xpath(LocatorsLeads.inputCompany)).sendKeys(company);
        driver.findElement(By.xpath(LocatorsLeads.inputDescription)).sendKeys(description);

        //checkbox public
        WebElement checkboxPublic = driver.findElement(By.xpath(LocatorsLeads.checkboxPublic));
        if (!checkboxPublic.isSelected()) {
            checkboxPublic.click();
        }
        //verify
        softAssert.assertTrue(checkboxPublic.isSelected(), "Checkbox Public chưa được tích sau khi click");

        //checkbox Contacted Today and input Date Contacted
        //click checkbox Contacted today > bỏ chọn
        driver.findElement(By.xpath(LocatorsLeads.checkboxContactedToday)).click();
        Thread.sleep(500);
        //Kiểm tra sau khi bỏ chọn checkbox thì input có hiển thị và cho phép thao tác nhập không
        WebElement inputDateContacted = driver.findElement(By.xpath(LocatorsLeads.inputDateContacted));
        if (inputDateContacted.isDisplayed() && inputDateContacted.isEnabled()) {
            inputDateContacted.sendKeys(dateContacted);
        }

        //click btn Save
        driver.findElement(By.xpath(LocatorsLeads.buttonSave)).click();
    }

    //close Popup Detail
    public void closePopupDetail() {
        driver.findElement(By.xpath("//div[@id='lead-modal']//div[@class='modal-header']/button")).click();
    }

    //search Lead
    public void searchLeadSuccess(String expectedLeadName) throws InterruptedException {
        driver.findElement(By.xpath(LocatorsLeads.inputSearch)).clear();
        driver.findElement(By.xpath(LocatorsLeads.inputSearch)).sendKeys(expectedLeadName);
        Thread.sleep(2000);

        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='leads']//tbody/tr/td/a[normalize-space()='"+expectedLeadName+"']"));
        //Kiểm tra xem bảng trả về rỗng hay không
        if (rows.size() == 0) {
            System.out.println("Tìm kiếm thành công: 0 bản ghi");
            Assert.assertTrue(true, "Còn dữ liệu");  // Test pass
        } else {
            String actualLeadName = driver.findElement(By.xpath(LocatorsLeads.firstRowItem)).getText().trim();
            Assert.assertEquals(actualLeadName.trim(), expectedLeadName.trim(), "Name Lead hiển thị sau khi tìm kiếm không khớp với Leads vừa thêm");
            System.out.println("Tìm kiếm thành công Lead: " + actualLeadName);
        }
    }

    //Hàm so sánh giá trị đã thêm mới trong màn edit
    public void compareFieldAttribute(String xpathActual, String expectedValue, String attributeActual) {
        String expected = expectedValue;
        String actual = driver.findElement(By.xpath(xpathActual)).getAttribute(attributeActual);
        Assert.assertEquals(actual.trim(), expected.trim(), "FAIL: Giá trị mong muốn là: " + expected + " nhưng giá trị thực tế là: " + actual);
    }

    public void verifyCheckboxSelected(String checkbox) {
        boolean checked = driver.findElement(By.xpath(checkbox)).isSelected();
        Assert.assertTrue(checked, "Checkbox chưa được tích sau khi click");
    }

    public void editLeadSuccess(String leadName, String source, String tags, String phone) throws InterruptedException {
        WebElement firstRow = driver.findElement(By.xpath(LocatorsLeads.firstRowItem));

        //Hover chuột vào dòng đầu tiên
        Actions actions = new Actions(driver);
        actions.moveToElement(firstRow).perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath(LocatorsLeads.buttonEdit(leadName))).click();
        Thread.sleep(2000);

        //dropdown Source
        driver.findElement(By.xpath(LocatorsLeads.dropdownSource)).click();
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorsLeads.inputSearchOfSource)).sendKeys(source);
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorsLeads.getValueSource(source))).click();
        Thread.sleep(500);

        //Tag
        Thread.sleep(1000);
        WebElement elementCloseTags = driver.findElement(By.xpath("//div[@id='inputTagsWrapper']/ul//a[@class='tagit-close']/span[1]"));
        elementCloseTags.click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsLeads.inputAddTags)).sendKeys(tags);
        Thread.sleep(1000);

        //click ra input name để đóng tag
        WebElement labelStatus = driver.findElement(By.xpath(LocatorsLeads.labelStatus));
        actions.doubleClick(labelStatus).perform();

        //input
        WebElement inputPhone = driver.findElement(By.xpath(LocatorsLeads.inputPhone));
        inputPhone.clear();
        inputPhone.sendKeys(phone);

        //click btn Save
        driver.findElement(By.xpath(LocatorsLeads.buttonSave)).click();
        System.out.println("Sửa Lead thành công");
    }

    public void viewEditLead(String status, String source, String assigned, String tags, String leadName, String address, String position, String city,
                                String emailAddress, String state, String website, String country, String phone, String zipcode, String leadValue, String language,
                                String company, String description, String dateContacted) throws InterruptedException {

        WebElement firstRow = driver.findElement(By.xpath(LocatorsLeads.firstRowItem));

        //Hover chuột vào dòng đầu tiên
        Actions actions = new Actions(driver);
        actions.moveToElement(firstRow).perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath(LocatorsLeads.buttonEdit(leadName))).click();

        compareFieldAttribute(LocatorsLeads.dropdownStatus, status, "title");
        compareFieldAttribute(LocatorsLeads.dropdownSource, source, "title");
        compareFieldAttribute(LocatorsLeads.dropdownAssigned, assigned, "title");
        compareFieldAttribute(LocatorsLeads.inputEditTags, tags, "value");
        compareFieldAttribute(LocatorsLeads.inputName, leadName, "value");
        compareFieldAttribute(LocatorsLeads.inputAddress, address, "value");
        compareFieldAttribute(LocatorsLeads.inputPosition, position, "value");
        compareFieldAttribute(LocatorsLeads.inputCity, city, "value");
        compareFieldAttribute(LocatorsLeads.inputEmailAddress, emailAddress, "value");
        compareFieldAttribute(LocatorsLeads.inputState, state, "value");
        compareFieldAttribute(LocatorsLeads.inputWebsite, website, "value");
        compareFieldAttribute(LocatorsLeads.dropdownCountry, country, "title");
        compareFieldAttribute(LocatorsLeads.inputPhone, phone, "value");
        compareFieldAttribute(LocatorsLeads.inputZipCode, zipcode, "value");
        compareFieldAttribute(LocatorsLeads.inputLeadValue, leadValue + ".00", "value");
        compareFieldAttribute(LocatorsLeads.dropdownLanguage, language, "title");
        compareFieldAttribute(LocatorsLeads.inputCompany, company, "value");
        compareFieldAttribute(LocatorsLeads.inputDescription, description, "value");
        compareFieldAttribute(LocatorsLeads.inputLastContact, dateContacted, "value"); //hệ thống bug
        verifyCheckboxSelected(LocatorsLeads.checkboxPublic);
        System.out.println("Tất cả các trường dữ liệu Lead đã được Verify thành công");
    }

    public void deleteLeadSuccess(String leadName) throws InterruptedException {
        WebElement firstRow = driver.findElement(By.xpath(LocatorsLeads.firstRowItem));

        //Hover chuột vào dòng đầu tiên
        Actions actions = new Actions(driver);
        actions.moveToElement(firstRow).perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath(LocatorsLeads.buttonDelete(leadName))).click();

        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        System.out.println("Xóa thành công");
    }

    @Test(priority = 1)
    public void testAddNewLeadSuccess() throws InterruptedException {
        String status = "Active";
        String source = "Facebook";
        String assigned = "Admin Anh Tester";
        String tags = "Giang12345";
        String leadName = "Giang Chan";
        String address = "230 Mễ Trì, Hà Nội";
        String position = "Mễ Trì";
        String city = "Hà Nội";
        String emailAddress = "giang08@gmail.com";
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

        //click menu Lead
        clickMenuLead();

        //click btn addnewLead
        clickBtnAddNewLead();

        addNewLead(status, source, assigned, tags, leadName, address, position, city, emailAddress, state, website, country, phone, zipcode, leadValue, language, company, description, dateContacted);
        Thread.sleep(1000);
        System.out.println("Tạo data thành công");

        closePopupDetail();
        Thread.sleep(2000);

        //verifyLeadAddNew
        searchLeadSuccess(leadName);
        Thread.sleep(500);
    }

    //Set Email đã tồn tại
    @Test(priority = 2)
    public void testAddNewLeadFailEmailAlreadyExists() throws InterruptedException {
        String status = "Active";
        String source = "Facebook";
        String assigned = "Admin Anh Tester";
        String tags = "Giang12345";
        String leadName = "Giang Test EmailAlreadyExists";
        String address = "230 Mễ Trì, Hà Nội";
        String position = "Mễ Trì";
        String city = "Hà Nội";
        String emailAddress = "giang08@gmail.com";
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

        //click menu Lead
        clickMenuLead();

        //click btn addnewLead
        clickBtnAddNewLead();

        addNewLead(status, source, assigned, tags, leadName, address, position, city, emailAddress, state, website, country, phone, zipcode, leadValue, language, company, description, dateContacted);
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
        driver.findElement(By.xpath(LocatorsLeads.buttonClose)).click();
        Thread.sleep(2000);

        //Kiểm tra lại
        searchLeadSuccess(leadName);
    }

    @Test(priority = 3)
    public void testViewEditLeadSuccess() throws InterruptedException {
        String status = "Active";
        String source = "Facebook";
        String assigned = "Admin Anh Tester";
        String tags = "GTest123";
        String leadName = "Giang Test 001";
        String address = "230 Mễ Trì, Hà Nội";
        String position = "Mễ Trì";
        String city = "Hà Nội";
        String emailAddress = "giang001Nodo@gmail.com";
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

        //click menu Lead
        clickMenuLead();

        //click btn addnewLead
        clickBtnAddNewLead();

        //Tạo data
        addNewLead(status, source, assigned, tags, leadName, address, position, city, emailAddress, state, website, country, phone, zipcode, leadValue, language, company, description, dateContacted);
        Thread.sleep(1000);

        closePopupDetail();
        Thread.sleep(2000);

        //verifyLeadAddNew
        searchLeadSuccess(leadName);
        Thread.sleep(500);

        viewEditLead(status, source, assigned, tags, leadName, address, position, city, emailAddress, state, website, country, phone, zipcode, leadValue, language, company, description, dateContacted);
        Thread.sleep(2000);
    }

    @Test(priority = 4)
    public void testDeleteLeadSuccess() throws InterruptedException {
        String status = "Active";
        String source = "Facebook";
        String assigned = "Admin Anh Tester";
        String tags = "GTest123";
        String leadName = "Giang Test ND01";
        String address = "230 Mễ Trì, Hà Nội";
        String position = "Mễ Trì";
        String city = "Hà Nội";
        String emailAddress = "giangND01@gmail.com";
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

        //click menu Lead
        clickMenuLead();

        //click btn addnewLead
        clickBtnAddNewLead();

        //Tạo data
        addNewLead(status, source, assigned, tags, leadName, address, position, city, emailAddress, state, website, country, phone, zipcode, leadValue, language, company, description, dateContacted);
        Thread.sleep(1000);

        closePopupDetail();
        Thread.sleep(2000);

        //verifyLeadAddNew
        searchLeadSuccess(leadName);
        Thread.sleep(500);

        deleteLeadSuccess(leadName);

        //Verify Deleted
        searchLeadSuccess(leadName);
    }

    @Test(priority = 5)
    public void testEditLeadSuccess() throws InterruptedException {
        //Data Add
        String status = "Active";
        String source = "Facebook";
        String assigned = "Admin Anh Tester";
        String tags = "Giang12";
        String leadName = "Giang Test Edit";
        String address = "230 Mễ Trì, Hà Nội";
        String position = "Mễ Trì";
        String city = "Hà Nội";
        String emailAddress = "giangtestedit08@gmail.com";
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

        //Data Update
        String sourceUpdate = "Google";
        String tagsUpdate = "Giang12345";
        String phoneUpdate = "090000282";

        //click menu Lead
        clickMenuLead();

        //click btn addnewLead
        clickBtnAddNewLead();

        //Tạo data
        addNewLead(status, source, assigned, tags, leadName, address, position, city, emailAddress, state, website, country, phone, zipcode, leadValue, language, company, description, dateContacted);
        Thread.sleep(1000);

        closePopupDetail();
        Thread.sleep(2000);

        //verifyLeadAddNew
        searchLeadSuccess(leadName);
        Thread.sleep(1000);

        //Edit Lead
        editLeadSuccess(leadName, sourceUpdate, tagsUpdate, phoneUpdate);
        Thread.sleep(1000);

        closePopupDetail();
        Thread.sleep(2000);

        //verifyLeadAddNew
        searchLeadSuccess(leadName);
        Thread.sleep(2000);

        //verify edit
        viewEditLead(status, sourceUpdate, assigned, tagsUpdate, leadName, address, position, city, emailAddress, state, website, country, phoneUpdate, zipcode, leadValue, language, company, description, dateContacted);
    }

}
