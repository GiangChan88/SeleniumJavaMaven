package thuc_hanh;


import bt_locator.LocatorsLeads;
import common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BTLeads extends BaseTest {

    public static void verifyDisplay(String field, String messageTrue, String messageFalse) {
        boolean check = driver.findElement(By.xpath(field)).isDisplayed();
        if (check) {
            System.out.println(messageTrue);
        } else {
            System.out.println(messageFalse);
        }
    }

    public static void verifyMenuLead() throws InterruptedException {
        //click menu Lead
        driver.findElement(By.xpath(LocatorsLeads.menuLeads)).click();
        Thread.sleep(2000);
        verifyDisplay(LocatorsLeads.headerLeadsSummary, "Đã tới trang Leads", "FAILED!!! Không truy cập được vào trang Leads");

    }

    public static void verifyBtnAddNewLead() throws InterruptedException {
        //click button New Lead
        driver.findElement(By.xpath(LocatorsLeads.btnAddLead)).click();
        Thread.sleep(1000);
        verifyDisplay(LocatorsLeads.titleAddNewLead, "Mở pop-up Add new lead thành công", "FAILED!!! Không mở được pop-up Add new lead");

    }

    //add Lead
    public static void addNewLead(String status, String source, String assigned, String tags, String leadName, String address, String position, String city,
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
        WebElement element = driver.findElement(By.xpath("//label[@for='lead_value']")); //trỏ tới element
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element); //true là cuộn xuống dưới, false là cuộn lên trên
        Thread.sleep(1000);

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
        boolean isSelectedPublic = driver.findElement(By.xpath(LocatorsLeads.checkboxPublic)).isSelected();
        if (!isSelectedPublic) {
            driver.findElement(By.xpath(LocatorsLeads.checkboxPublic)).click();
        }

        //checkbox Contacted Today and input Date Contacted
        //click checkbox Contacted today > bỏ chọn
        driver.findElement(By.xpath(LocatorsLeads.checkboxContactedToday)).click();
        Thread.sleep(500);
        //Kiểm tra sau khi bỏ chọn checkbox thì input có hiển thị và cho phép thao tác nhập không
        WebElement inputDateContacted = driver.findElement(By.xpath(LocatorsLeads.inputDateContacted));
        if (inputDateContacted.isDisplayed() && inputDateContacted.isEnabled()) {
            inputDateContacted.sendKeys(dateContacted);
        }
        Thread.sleep(1000);

        //click btn Save
        driver.findElement(By.xpath(LocatorsLeads.buttonSave)).click();
    }

    //close Popup Detail
    public static void closePopupDetail() {
        driver.findElement(By.xpath("//div[@id='lead-modal']//div[@class='modal-header']/button")).click();
    }

    //search Lead vừa mới add
    public static void searchLead(String leadName) throws InterruptedException {
        driver.findElement(By.xpath(LocatorsLeads.inputSearch)).clear();
        driver.findElement(By.xpath(LocatorsLeads.inputSearch)).sendKeys(leadName);
        Thread.sleep(2000);
        String firstRowLead = driver.findElement(By.xpath(LocatorsLeads.firstRowItem)).getText();
        System.out.println("Tìm kiếm thành công Lead vừa thêm mới: " + firstRowLead);
    }

    //Hàm so sánh giá trị đã thêm mới trong màn edit
    public static void compareFieldAttribute(String expectedValue, String xpathActual, String attributeActual) {
        String expected = expectedValue;
        String actual = driver.findElement(By.xpath(xpathActual)).getAttribute(attributeActual);
        if (actual.trim().equalsIgnoreCase(expected.trim())) {
            System.out.println("Giá trị hiển thị đúng: " + actual);
        } else {
            System.out.println("FAIL: Giá trị mong muốn là: " + expected + " nhưng giá trị thực tế là: " + actual);
        }
    }

    public static void verifyCheckboxSelected(String checkbox) {
        boolean checked = driver.findElement(By.xpath(checkbox)).isSelected();
        if (checked) {
            System.out.println("Checkbox is selected: " + checked);
        } else {
            System.out.println("Checkbox is selected: " + checked);

        }
    }

    public static void editLead(String status, String source, String assigned, String tags, String leadName, String address, String position, String city,
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
    }


    @Test(priority = 1)
    public void testAddNewLead() throws InterruptedException {
        String status = "Active";
        String source = "Facebook";
        String assigned = "Admin Anh Tester";
        String tags = "Giang12345";
        String leadName = "Giang Test 04";
        String address = "230 Mễ Trì, Hà Nội";
        String position = "Mễ Trì";
        String city = "Hà Nội";
        String emailAddress = "giang09@gmail.com";
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
        verifyMenuLead();

        //click btn addnewLead
        verifyBtnAddNewLead();

        addNewLead(status, source, assigned, tags, leadName, address, position, city, emailAddress, state, website, country, phone, zipcode, leadValue, language, company, description, dateContacted);
        Thread.sleep(1000);

        closePopupDetail();
        Thread.sleep(1000);

        //verifyLeadAddNew
        searchLead(leadName);
        Thread.sleep(500);

    }

    @Test(priority = 2)
    public void testEditLead() throws InterruptedException {
        String status = "Active";
        String source = "Facebook";
        String assigned = "Admin Anh Tester";
        String tags = "Giang12345";
        String leadName = "Giang Test 04";
        String address = "230 Mễ Trì, Hà Nội";
        String position = "Mễ Trì";
        String city = "Hà Nội";
        String emailAddress = "giang09@gmail.com";
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
        Thread.sleep(1000);

        //click menu Lead
        verifyMenuLead();

        searchLead(leadName);
        Thread.sleep(500);

        editLead(status, source, assigned, tags, leadName, address, position, city, emailAddress, state, website, country, phone, zipcode, leadValue, language, company, description, dateContacted);
        Thread.sleep(2000);

    }
}
