package thuc_hanh;


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

    public void clickMenuLead() throws InterruptedException {
        //click menu Lead
        driver.findElement(By.xpath(LocatorsLeads.menuLeads)).click();
        Thread.sleep(2000);
        System.out.println("Click Lead Menu");
    }

    public void verifyMenuLead() throws InterruptedException {
        List<WebElement> checkHeaderLeadSummary = driver.findElements(By.xpath(LocatorsLeads.titleLeadsSummary));
        Assert.assertTrue(checkHeaderLeadSummary.size() > 0, "FAILED!!! Không truy cập được vào trang Leads");
        //check text
        String menuLeadText = driver.findElement(By.xpath(LocatorsLeads.titleLeadsSummary)).getText();
        softAssert.assertEquals(menuLeadText, "Leads Summary", "Title Leads Summary is not correct");
        System.out.println("Verify: Đã tới Leads");
    }

    public void clickBtnAddNewLead() throws InterruptedException {
        //click button New Lead
        driver.findElement(By.xpath(LocatorsLeads.btnAddLead)).click();
        Thread.sleep(1000);
        System.out.println("Click Button Add New Lead");
    }

    public void verifyBtnAddNewLead() throws InterruptedException {
        List<WebElement> checktitleAddNewLead = driver.findElements(By.xpath(LocatorsLeads.titleAddNewLead));
        Assert.assertTrue(checktitleAddNewLead.size() > 0, "FAILED!!! Không mở được pop-up Add new lead");
        //check text
        String titleAddNewLead = driver.findElement(By.xpath(LocatorsLeads.titleAddNewLead)).getText();
        softAssert.assertEquals(titleAddNewLead, "Add new lead", "Title Add new lead is not correct");
        System.out.println("Verify: Mở pop-up Add new lead thành công");
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

        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='leads']//tbody/tr/td/a[normalize-space()='" + expectedLeadName + "']"));
        //Sai khi không có bản ghi (không mong muốn rows.size() == 0 => đúng)
        //Assert.assertFalse(rows.size() == 0, "Không tìm thấy Lead '" + expectedLeadName + "' sau khi search!");

        //Mong muốn rows.size() > 0 => đúng, nếu rows.size() == 0 thì hiển thị message kia
        Assert.assertTrue(rows.size() > 0, "Không tìm thấy Lead '" + expectedLeadName + "' sau khi search!");

        String actualLeadName = rows.get(0).getText();
        Assert.assertEquals(actualLeadName.trim(), expectedLeadName.trim(), "Name Lead hiển thị sau khi tìm kiếm không khớp với Leads vừa thêm");
        System.out.println("Tìm kiếm thành công Lead: " + actualLeadName);
    }

    public void searchLeadSuccessNoData(String expectedLeadName) throws InterruptedException {
        driver.findElement(By.xpath(LocatorsLeads.inputSearch)).clear();
        driver.findElement(By.xpath(LocatorsLeads.inputSearch)).sendKeys(expectedLeadName);
        Thread.sleep(2000);

//        List<WebElement> actualLeadName = driver.findElements(By.xpath("//table[@id='leads']//tbody/tr[text()='"+expectedLeadName+"']"));
//        Assert.assertTrue(actualLeadName.size() == 0, "Còn dữ liệu");
        //hoặc
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='leads']//tbody/tr/td/a[normalize-space()='"+expectedLeadName+"']"));
        //Sai khi có bản ghi (không mong muốn rows.size() > 0 => đúng)
        Assert.assertFalse(rows.size() > 0 , "Không mong muốn: vẫn còn bản ghi '" + expectedLeadName + "' trong bảng!");  // Test pass
        System.out.println("Tìm kiếm thành công: 0 bản ghi");
    }

    //Hàm so sánh giá trị đã thêm mới trong màn edit
    public void compareFieldAttribute(String xpathActual, String expectedValue, String attributeActual) {
        String expected = expectedValue;
        String actual = driver.findElement(By.xpath(xpathActual)).getAttribute(attributeActual);
        Assert.assertEquals(actual.trim(), expected.trim(), "FAIL: Giá trị mong muốn là: " + expected + " nhưng giá trị thực tế là: " + actual);
    }

    public void compareFieldText(String xpathActual, String expectedValue) {
        String expected = expectedValue;
        String actual = driver.findElement(By.xpath(xpathActual)).getText();
        Assert.assertEquals(actual.trim(), expected.trim(), "FAIL: Giá trị mong muốn là: " + expected + " nhưng giá trị thực tế là: " + actual);
    }

    public void verifyCheckboxSelected(String checkbox) {
        boolean checked = driver.findElement(By.xpath(checkbox)).isSelected();
        Assert.assertTrue(checked, "Checkbox chưa được tích sau khi click");
    }

    public void clickBtnEdit(String leadName) throws InterruptedException {
        WebElement firstRow = driver.findElement(By.xpath(LocatorsLeads.firstRowItem));

        //Hover chuột vào dòng đầu tiên
        Actions actions = new Actions(driver);
        actions.moveToElement(firstRow).perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath(LocatorsLeads.buttonEdit(leadName))).click();
        Thread.sleep(2000);
        System.out.println("Mở pop-up Edit Lead thành công");
    }

    public void addAndEditLeadSuccess(String status, String source, String assigned, String tags, String leadName, String address, String position, String city,
                                String emailAddress, String state, String website, String country, String phone, String zipcode, String leadValue, String language,
                                String company, String description, String dateContacted, int flagEdit) throws InterruptedException {

        WebElement inputDateContacted = driver.findElement(By.xpath(LocatorsLeads.inputDateContacted));
        WebElement inputName = driver.findElement(By.xpath(LocatorsLeads.inputName));
        WebElement inputAddress = driver.findElement(By.xpath(LocatorsLeads.inputAddress));
        WebElement inputPosition = driver.findElement(By.xpath(LocatorsLeads.inputPosition));
        WebElement inputCity = driver.findElement(By.xpath(LocatorsLeads.inputCity));
        WebElement inputEmailAddress = driver.findElement(By.xpath(LocatorsLeads.inputEmailAddress));
        WebElement inputState = driver.findElement(By.xpath(LocatorsLeads.inputState));
        WebElement inputWebsite = driver.findElement(By.xpath(LocatorsLeads.inputWebsite));
        WebElement inputPhone = driver.findElement(By.xpath(LocatorsLeads.inputPhone));
        WebElement inputZipCode = driver.findElement(By.xpath(LocatorsLeads.inputZipCode));
        WebElement inputLeadValue = driver.findElement(By.xpath(LocatorsLeads.inputLeadValue));
        WebElement inputCompany = driver.findElement(By.xpath(LocatorsLeads.inputCompany));
        WebElement inputDescription = driver.findElement(By.xpath(LocatorsLeads.inputDescription));


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

        //Clear
        if (flagEdit == 1) {
            Thread.sleep(1000);
            WebElement elementCloseTags = driver.findElement(By.xpath("//div[@id='inputTagsWrapper']/ul//a[@class='tagit-close']/span[1]"));
            elementCloseTags.click();
            inputName.clear();
            inputAddress.clear();
            inputPosition.clear();
            inputCity.clear();
            inputEmailAddress.clear();
            inputState.clear();
            inputWebsite.clear();
            inputPhone.clear();
            inputZipCode.clear();
            inputLeadValue.clear();
            inputCompany.clear();
            inputDescription.clear();
            Thread.sleep(1000);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(false);", driver.findElement(By.xpath(LocatorsLeads.dropdownStatus)));
            Thread.sleep(1000);
            driver.findElement(By.xpath(LocatorsLeads.inputAddTags)).click();
        }

        //Tag
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsLeads.inputAddTags)).sendKeys(tags);
        Thread.sleep(1000);

        //click ra input name để đóng tag
        WebElement labelStatus = driver.findElement(By.xpath(LocatorsLeads.labelStatus));
        labelStatus.click();
        Thread.sleep(500);
        labelStatus.click();

        //input
        inputName.sendKeys(leadName);
        inputAddress.sendKeys(address);
        inputPosition.sendKeys(position);
        inputCity.sendKeys(city);
        inputEmailAddress.sendKeys(emailAddress);
        inputState.sendKeys(state);
        inputWebsite.sendKeys(website);

        //dropdown Country
        driver.findElement(By.xpath(LocatorsLeads.dropdownCountry)).click();
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorsLeads.inputSearchOfCountry)).sendKeys(country);
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorsLeads.getValueCountry(country))).click();
        Thread.sleep(500);

        //input
        inputPhone.sendKeys(phone);
        inputZipCode.sendKeys(zipcode);
        inputLeadValue.sendKeys(leadValue);

        //scroll kéo xuống dưới
        WebElement elementBtnSave = driver.findElement(By.xpath(LocatorsLeads.buttonSave)); //trỏ tới element
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(false);", elementBtnSave); //true là cuộn hiển thị ở top trang, false là cuộn hiển thị ở bottom trang

        //dropdown Language
        driver.findElement(By.xpath(LocatorsLeads.dropdownLanguage)).click();
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorsLeads.inputSearchOfLanguage)).sendKeys(language);
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorsLeads.getValueLanguage(language))).click();
        Thread.sleep(500);

        //input
        inputCompany.sendKeys(company);
        inputDescription.sendKeys(description);

        //checkbox public
        driver.findElement(By.xpath(LocatorsLeads.checkboxPublic)).click();
        Thread.sleep(500);

        //checkbox contactedToday
        //flagEdit = 0 => Thêm mới
        if (flagEdit == 0){
            driver.findElement(By.xpath(LocatorsLeads.checkboxContactedToday)).click();
            Thread.sleep(500);
            inputDateContacted.sendKeys(dateContacted);
            Thread.sleep(500);
        }else {
            WebElement inputLastContacted = driver.findElement(By.xpath(LocatorsLeads.inputLastContact));
            inputLastContacted.clear();
            Thread.sleep(500);
            inputLastContacted.sendKeys(dateContacted);
        }

        //click btn Save
        driver.findElement(By.xpath(LocatorsLeads.buttonSave)).click();
    }

    public void viewEditLead(String status, String source, String assigned, String tags, String leadName, String address, String position, String city,
                                String emailAddress, String state, String website, String country, String phone, String zipcode, String leadValue, String language,
                                String company, String description, String dateContacted) throws InterruptedException {

        compareFieldText(LocatorsLeads.dropdownStatus, status);
        compareFieldText(LocatorsLeads.dropdownSource, source);
        compareFieldText(LocatorsLeads.dropdownAssigned, assigned);
        compareFieldAttribute(LocatorsLeads.inputEditTags, tags, "value");
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

    public void deleteLeadSuccess(String leadName) throws InterruptedException {
        WebElement firstRow = driver.findElement(By.xpath(LocatorsLeads.firstRowItem));

        //Hover chuột vào dòng đầu tiên
        Actions actions = new Actions(driver);
        actions.moveToElement(firstRow).perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath(LocatorsLeads.buttonDelete(leadName))).click();
        System.out.println("Click button Delete");
    }

    public void confirmDeleteLeadSuccess(String leadName, int flag) throws InterruptedException {
        System.out.println("Confirm Delete Lead Success");
        Thread.sleep(2000);
        if (flag == 1) {
            Alert alert = driver.switchTo().alert();
            alert.accept();
            System.out.println("Xóa thành công");
        }else {
            Alert alert = driver.switchTo().alert();
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
        lead.leadName = "Giang Chan";
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
        driver.findElement(By.xpath(LocatorsLeads.buttonClose)).click();
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
