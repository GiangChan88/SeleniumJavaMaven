package thuc_hanh;


import bt_locator.LocatorsLeads;
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

    public void clickMenuLead() throws InterruptedException {
        //click menu Lead
        driver.findElement(By.xpath(LocatorsLeads.menuLeads)).click();
        Thread.sleep(2000);
        List<WebElement> checkHeaderLeadSummary = driver.findElements(By.xpath(LocatorsLeads.headerLeadsSummary));
        Assert.assertTrue(checkHeaderLeadSummary.size() > 0, "FAILED!!! Không truy cập được vào trang Leads");
    }

    public void clickBtnAddNewLead() throws InterruptedException {
        //click button New Lead
        driver.findElement(By.xpath(LocatorsLeads.btnAddLead)).click();
        Thread.sleep(1000);
        List<WebElement> checktitleAddNewLead = driver.findElements(By.xpath(LocatorsLeads.titleAddNewLead));
        Assert.assertTrue(checktitleAddNewLead.size() > 0, "FAILED!!! Không mở được pop-up Add new lead");
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
        driver.findElement(By.xpath(LocatorsLeads.inputName)).click();
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

    public void addNewLeadDuplicateEmail(String status, String source, String leadName, String emailAddress) throws InterruptedException {
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

        //input
        driver.findElement(By.xpath(LocatorsLeads.inputName)).sendKeys(leadName); //truyền name
        driver.findElement(By.xpath(LocatorsLeads.inputEmailAddress)).sendKeys(emailAddress);
        driver.findElement(By.xpath(LocatorsLeads.inputName)).click();

        //click btn Save
        driver.findElement(By.xpath(LocatorsLeads.buttonSave)).click();
        Thread.sleep(2000);
    }

    //close Popup Detail
    public void closePopupDetail() {
        driver.findElement(By.xpath("//div[@id='lead-modal']//div[@class='modal-header']/button")).click();
    }

    //search Lead vừa mới add
    public void searchLeadSuccess(String expectedLeadName) throws InterruptedException {
        driver.findElement(By.xpath(LocatorsLeads.inputSearch)).clear();
        driver.findElement(By.xpath(LocatorsLeads.inputSearch)).sendKeys(expectedLeadName);
        Thread.sleep(2000);
        String actualLeadName = driver.findElement(By.xpath(LocatorsLeads.firstRowItem)).getText();
        Assert.assertEquals(actualLeadName.trim(), expectedLeadName.trim(), "Name Lead hiển thị sau khi tìm kiếm không khớp với Leads vừa thêm");
        System.out.println("Tìm kiếm thành công Lead vừa thêm mới: " + actualLeadName);
    }

    //truyền dữ liệu không tồn tại
    public void searchLeadSuccessNoData(String expectedLeadName) throws InterruptedException {
        driver.findElement(By.xpath(LocatorsLeads.inputSearch)).clear();
        driver.findElement(By.xpath(LocatorsLeads.inputSearch)).sendKeys(expectedLeadName);
        Thread.sleep(2000);

        List<WebElement> actualLeadName = driver.findElements(By.xpath("//table[@id='leads']//tbody/tr[text()='"+expectedLeadName+"']"));
        Assert.assertTrue(actualLeadName.size() == 0, "Còn dữ liệu");
    }

    //Hàm so sánh giá trị đã thêm mới trong màn edit
    public void compareFieldAttribute(String expectedValue, String xpathActual, String attributeActual) {
        String expected = expectedValue;
        String actual = driver.findElement(By.xpath(xpathActual)).getAttribute(attributeActual);
        Assert.assertEquals(actual.trim(), expected.trim(), "FAIL: Giá trị mong muốn là: " + expected + " nhưng giá trị thực tế là: " + actual);
    }

    public void verifyCheckboxSelected(String checkbox) {
        boolean checked = driver.findElement(By.xpath(checkbox)).isSelected();
        Assert.assertTrue(checked, "Checkbox chưa được tích sau khi click");
    }

    public void editLead(String status, String source, String assigned, String tags, String leadName, String address, String position, String city,
                                String emailAddress, String state, String website, String country, String phone, String zipcode, String leadValue, String language,
                                String company, String description, String dateContacted) throws InterruptedException {

        WebElement firstRow = driver.findElement(By.xpath(LocatorsLeads.firstRowItem));

        //Hover chuột vào dòng đầu tiên
        Actions actions = new Actions(driver);
        actions.moveToElement(firstRow).perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath(LocatorsLeads.buttonEdit(leadName))).click();

        compareFieldAttribute(status, LocatorsLeads.dropdownStatus, "title");
        compareFieldAttribute(source, LocatorsLeads.dropdownSource, "title");
        compareFieldAttribute(assigned, LocatorsLeads.dropdownAssigned, "title");
        compareFieldAttribute(tags, LocatorsLeads.inputEditTags, "value");
        compareFieldAttribute(leadName, LocatorsLeads.inputName, "value");
        compareFieldAttribute(address, LocatorsLeads.inputAddress, "value");
        compareFieldAttribute(position, LocatorsLeads.inputPosition, "value");
        compareFieldAttribute(city, LocatorsLeads.inputCity, "value");
        compareFieldAttribute(emailAddress, LocatorsLeads.inputEmailAddress, "value");
        compareFieldAttribute(state, LocatorsLeads.inputState, "value");
        compareFieldAttribute(website, LocatorsLeads.inputWebsite, "value");
        compareFieldAttribute(country, LocatorsLeads.dropdownCountry, "title");
        compareFieldAttribute(phone, LocatorsLeads.inputPhone, "value");
        compareFieldAttribute(zipcode, LocatorsLeads.inputZipCode, "value");
        compareFieldAttribute(leadValue + ".00", LocatorsLeads.inputLeadValue, "value");
        compareFieldAttribute(language, LocatorsLeads.dropdownLanguage, "title");
        compareFieldAttribute(company, LocatorsLeads.inputCompany, "value");
        compareFieldAttribute(description, LocatorsLeads.inputDescription, "value");
        compareFieldAttribute(dateContacted, LocatorsLeads.inputLastContact, "value"); //hệ thống bug
        verifyCheckboxSelected(LocatorsLeads.checkboxPublic);

        System.out.println("Tất cả các trường dữ liệu Lead đã được Verify thành công trong Edit Popup.");
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
        String leadName = "Giang Test 19";
        String address = "230 Mễ Trì, Hà Nội";
        String position = "Mễ Trì";
        String city = "Hà Nội";
        String emailAddress = "giang19@gmail.com";
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

        //login
        loginCRM();

        //click menu Lead
        clickMenuLead();

        //click btn addnewLead
        clickBtnAddNewLead();

        addNewLead(status, source, assigned, tags, leadName, address, position, city, emailAddress, state, website, country, phone, zipcode, leadValue, language, company, description, dateContacted);
        Thread.sleep(1000);

        closePopupDetail();
        Thread.sleep(1000);

        //verifyLeadAddNew
        searchLeadSuccess(leadName);
        Thread.sleep(500);

    }

    @Test(priority = 4)
    public void testAddNewLeadFailDuplicateEmail() throws InterruptedException {
        String status = "Active";
        String source = "Facebook";
        String leadName = "Giang Test 20";
        String emailAddress = "giang08@gmail.com";

        loginCRM();

        //click menu Lead
        clickMenuLead();

        //click btn addnewLead
        clickBtnAddNewLead();

        addNewLeadDuplicateEmail(status,source,leadName,emailAddress);

        //verify lỗi
        List<WebElement> checkMessageErrorEmail = driver.findElements(By.xpath("//p[@id='email-error']"));
        Assert.assertTrue(checkMessageErrorEmail.size() > 0, "Check Message Error Email is not Displayed");

        //verifyLeadAddNew
        String messageErrorEmail = driver.findElement(By.xpath("//p[@id='email-error']")).getText();
        softAssert.assertEquals(messageErrorEmail, "Email already exists", "Message Error Email is not correct");

        //close popup add
        driver.findElement(By.xpath(LocatorsLeads.buttonClose)).click();
        Thread.sleep(1000);

        //Kiểm tra lại
        searchLeadSuccessNoData(leadName);
    }

    @Test(priority = 2)
    public void testEditLead() throws InterruptedException {
        String status = "Active";
        String source = "Facebook";
        String assigned = "Admin Anh Tester";
        String tags = "GTest123";
        String leadName = "Giang Test 07";
        String address = "230 Mễ Trì, Hà Nội";
        String position = "Mễ Trì";
        String city = "Hà Nội";
        String emailAddress = "giang11@gmail.com";
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

        loginCRM();

        //click menu Lead
        clickMenuLead();

        //click btn addnewLead
        clickBtnAddNewLead();

        //Tạo data
        addNewLead(status, source, assigned, tags, leadName, address, position, city, emailAddress, state, website, country, phone, zipcode, leadValue, language, company, description, dateContacted);
        Thread.sleep(1000);

        closePopupDetail();
        Thread.sleep(1000);

        //verifyLeadAddNew
        searchLeadSuccess(leadName);
        Thread.sleep(500);

        editLead(status, source, assigned, tags, leadName, address, position, city, emailAddress, state, website, country, phone, zipcode, leadValue, language, company, description, dateContacted);
        Thread.sleep(2000);

    }

    @Test(priority = 3)
    public void testDeleteLeadSuccess() throws InterruptedException {
        String status = "Active";
        String source = "Facebook";
        String assigned = "Admin Anh Tester";
        String tags = "GTest123";
        String leadName = "Giang Test 001";
        String address = "230 Mễ Trì, Hà Nội";
        String position = "Mễ Trì";
        String city = "Hà Nội";
        String emailAddress = "giang113@gmail.com";
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

        loginCRM();

        //click menu Lead
        clickMenuLead();

        //click btn addnewLead
        clickBtnAddNewLead();

        //Tạo data
        addNewLead(status, source, assigned, tags, leadName, address, position, city, emailAddress, state, website, country, phone, zipcode, leadValue, language, company, description, dateContacted);
        Thread.sleep(1000);

        closePopupDetail();
        Thread.sleep(1000);

        //verifyLeadAddNew
        searchLeadSuccess(leadName);
        Thread.sleep(500);

        deleteLeadSuccess(leadName);

        //Verify Deleted
        searchLeadSuccessNoData(leadName);

    }



}
