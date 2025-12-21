package com.giangnth.pages;

import com.giangnth.common.BasePage;
import com.giangnth.drivers.DriverManager;
import com.giangnth.keywords.WebUI;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class LeadsPage extends BasePage {
    private SoftAssert softAssert;

    public LeadsPage(SoftAssert softAssert) {
        this.softAssert = softAssert;
    }

    //pages for Leads Page
    private By buttonNewLead = By.xpath("//a[normalize-space()='New Lead']");
    private By buttonLeadsSummary = By.xpath("//a[@data-title='Leads Summary']");
    private By buttonKanban = By.xpath("//a[@data-title='Switch to Kanban']");
    private By buttonFilterBy = By.xpath("//div[@id='vueApp']//button[@type='button']");
    private By dropdownLeadLength = By.xpath("//select[@name ='leads_length']");
    private By buttonExport = By.xpath("//button[normalize-space() = 'Export']");
    private By buttonBulkActions = By.xpath("//button[normalize-space() = 'Bulk Actions']");
    private By buttonReload = By.xpath("//button[contains(@class, 'btn-dt-reload')]");
    private By inputSearch = By.xpath("//div[@id='leads_filter']//input[@type='search']");
    private By firstRowItem = By.xpath("//table[@id='leads']//tbody/tr[1]/td[3]/a");

    //header table
    private By checkboxAll = By.xpath("//input[@id='mass_select_all']");

    private By getCheckboxValue(String value) {
        By xpath = By.xpath("//a[normalize-space()='" + value + "']/parent::td/preceding-sibling::td//input[@type='checkbox']");
        return xpath;
    }

    private By headerNumber = By.xpath("//table[@id='leads']/thead//th[@id='th-number']");
    private By headerName = By.xpath("//table[@id='leads']/thead//th[@id='th-name']");
    private By headerCompany = By.xpath("//table[@id='leads']/thead//th[@id='th-company']");
    private By headerEmail = By.xpath("//table[@id='leads']/thead//th[@id='th-email']");
    private By headerPhone = By.xpath("//table[@id='leads']/thead//th[@id='th-phone']");
    private By headerValue = By.xpath("//table[@id='leads']/thead//th[@id='th-lead-value']");
    private By headerTags = By.xpath("//table[@id='leads']/thead//th[@id='th-tags']");
    private By headerAssigned = By.xpath("//table[@id='leads']/thead//th[@id='th-assigned']");
    private By headerStatus = By.xpath("//table[@id='leads']/thead//th[@id='th-status']");
    private By headerSource = By.xpath("//table[@id='leads']/thead//th[@id='th-source']");
    private By headerLastContact = By.xpath("//table[@id='leads']/thead//th[@id='th-last-contact']");
    private By headerCreated = By.xpath("//table[@id='leads']/thead//th[@id='th-date-created']");

    private By buttonView(String leadName) {
        By xpath = By.xpath("//td[./a[normalize-space()='" + leadName + "']]//a[normalize-space()='View']");
        return xpath;
    }

    private By buttonEdit(String leadName) {
        By xpath = By.xpath("//td[./a[normalize-space()='" + leadName + "']]//a[normalize-space()='Edit']");
        return xpath;
    }

    private By buttonDelete(String leadName) {
        By xpath = By.xpath("//td[./a[normalize-space()='" + leadName + "']]//a[normalize-space()='Delete']");
        return xpath;
    }

    private By buttonPrevious = By.xpath("//div[@id= 'leads_paginate']//a[text()='Previous']");
    private By buttonNumber = By.xpath("//div[@id='leads_paginate']//li[@class='paginate_button active']");//saiii
    private By buttonNext = By.xpath("//div[@id= 'leads_paginate']//a[text()='Next']");
    private By dropdownJumpLead = By.xpath("//select[@id= 'dt-page-jump-leads']");

    //leads summary
    //driver.findElement(By.xpath("//a[@data-title='Leads Summary']")).click();
    private By titleLeadsSummary = By.xpath("//h4[normalize-space()='Leads Summary']");

    private By stringValueActive = By.xpath("//div[contains(@class,'leads-overview')]//span[normalize-space() = 'Active']");
    private By numberValueActive = By.xpath("//div[contains(@class,'leads-overview')]//span[normalize-space() = 'Active']/preceding-sibling::span");

    private By stringValuejjjj = By.xpath("//div[contains(@class,'leads-overview')]//span[normalize-space() = 'jjjj']");
    private By numberValuejjjj = By.xpath("//div[contains(@class,'leads-overview')]//span[normalize-space() = 'jjjj']/preceding-sibling::span");

    private By stringValueCustomer = By.xpath("//div[contains(@class,'leads-overview')]//span[normalize-space() = 'Customer']");
    private By numberValueCustomer = By.xpath("//div[contains(@class,'leads-overview')]//span[normalize-space() = 'Customer']/preceding-sibling::span");

    private By stringValueLostLead = By.xpath("//div[contains(@class,'leads-overview')]//span[normalize-space() = 'Lost Leads']");
    private By numberValueLostLead = By.xpath("//div[contains(@class,'leads-overview')]//span[normalize-space() = 'Lost Leads']//preceding-sibling::span");


    //ADD NEW LEAD
    private By btnAddLead = By.xpath("//a[normalize-space()='New Lead']");
    private By titleAddNewLead = By.xpath("//h4[normalize-space() ='Add new lead']");
    //private By iconCloseAddNewLead = By.xpath("//div[@id='leads_bulk_actions']/descendant::button[@class='close']");
    private By iconCloseAddNewLead = By.xpath("//h4[@id='myModalLabel']/preceding-sibling::button[@class='close']");
    private By iconClosePopupDetail = By.xpath("//div[@id='lead-modal']//div[@class='modal-header']/button");

    private By labelStatus = By.xpath("//label[@for='status']");
    private By dropdownStatus = By.xpath("//button[@data-id='status']");
    private By inputSearchOfStatus = By.xpath("//button[@data-id='status']/following-sibling::div//input[@type='search']");

    private By getValueStatus(String value) {
        By xpath = By.xpath("//button[@data-id='status']/following-sibling::div//span[normalize-space()='" + value + "']");
        return xpath;
    }

    private By buttonAddStatus = By.xpath("//div[@app-field-wrapper='status']//div[@class= 'input-group-btn']");
    private By inputAddStatus = By.xpath("//input[@id='new_status_name']");


    private By dropdownSource = By.xpath("//button[@data-id='source']");
    private By inputSearchOfSource = By.xpath("//div[@app-field-wrapper='source']//input[@type='search']");

    private By getValueSource(String value) {
        By xpathListSource = By.xpath("//button[@data-id='source']/following-sibling::div//span[normalize-space()='" + value + "']");
        return xpathListSource;
    }

    private By buttonAddSource = By.xpath("//div[@app-field-wrapper='source']//div[@class= 'input-group-btn']");
    private By inputAddSource = By.xpath("//input[@id='new_source_name']");

    private By dropdownAssigned = By.xpath("//button[@data-id='assigned']");
    private By inputSearchOfAssigned = By.xpath("//div[@app-field-wrapper='assigned']//input[@type='search']");

    private By getValueAssigned(String value) {
        By xpathListAssignes = By.xpath("//button[@data-id='assigned']/following-sibling::div//span[normalize-space()='" + value + "']");
        return xpathListAssignes;
    }

    private By elementCloseTags = By.xpath("//div[@id='inputTagsWrapper']/ul//a[@class='tagit-close']/span[1]");
    private By inputAddTags = By.xpath("//div[@id='inputTagsWrapper']/ul/li[@class='tagit-new']/input");
    private By inputEditTags = By.xpath("(//input[@id='tags']/following-sibling::ul)/descendant::span[@class='tagit-label']");
    private By dropdownTags = By.xpath("//div[@id='inputTagsWrapper']//ul[@id='ui-id-2']");

    private By getValueTags(String value) {
        By xpathListTag = By.xpath("//div[@id='inputTagsWrapper']//div[normalize-space()='" + value + "']");
        return xpathListTag;
    }

    private By inputName = By.xpath("//div[@id ='tab_lead_profile']//input[@id='name']");
    private By inputAddress = By.xpath("//textarea[@id='address']");
    private By inputPosition = By.xpath("//input[@id='title']");
    private By inputCity = By.xpath("//input[@id='city']");
    private By inputEmailAddress = By.xpath("//input[@id='email']");
    private By inputState = By.xpath("//input[@id='state']");
    ;
    private By inputWebsite = By.xpath("//input[@id='website']");

    private By dropdownCountry = By.xpath("//button[@data-id='country']");
    private By inputSearchOfCountry = By.xpath("//div[@app-field-wrapper='country']//input[@type='search']");

    private By getValueCountry(String value) {
        By xpathListCountry = By.xpath("//button[@data-id='country']/following::span[@class='text' and normalize-space()='" + value + "']");
        return xpathListCountry;
    }

    private By inputPhone = By.xpath("//input[@id='phonenumber']");
    private By inputZipCode = By.xpath("//input[@id='zip']");
    private By inputLeadValue = By.xpath("//input[@name='lead_value']");
    private By iconLeadValue = By.xpath("//input[@name='lead_value']/following-sibling::div");

    private By dropdownLanguage = By.xpath("//button[@data-id='default_language']");
    private By inputSearchOfLanguage = By.xpath("//button[@data-id='default_language']/following-sibling::div//input[@type='search']");

    private By getValueLanguage(String value) {
        By xpathListDefaultLanguage = By.xpath("//button[@data-id='default_language']/following::span[@class='text' and normalize-space()='" + value + "']");
        return xpathListDefaultLanguage;
    }

    private By inputCompany = By.xpath("//input[@id='company']");
    private By inputDescription = By.xpath("//textarea[@id='description']");
    private By inputDateContacted = By.xpath("//input[@id='custom_contact_date']");
    private By calendarDateContacted = By.xpath("//div[@app-field-wrapper='custom_contact_date']//i[contains(@class,'fa-calendar')]");
    private By inputLastContact = By.xpath("//input[@id='lastcontact']");
    private By labelPublic = By.xpath("//label[@for='lead_public']");
    private By checkboxPublic = By.xpath("//input[@id='lead_public']");
    private By labelContactedToday = By.xpath("//label[@for='contacted_today']");
    private By checkboxContactedToday = By.xpath("//input[@id='contacted_today']");

    private By buttonClose = By.xpath("//div[@id ='tab_lead_profile']//button[normalize-space()='Close']");
    //private By buttonClose = By.xpath("//button[@id = 'lead-form-submit']/following-sibling::button[normalize-space()='Close']");
    private By buttonSave = By.xpath("//button[@id = 'lead-form-submit']");

    private By labelLeadActive = By.xpath("//h4[normalize-space()='Leads Summary']/following-sibling::div//span[normalize-space()='Active']//preceding-sibling::span");
    private By labelLeadCustomer = By.xpath("//h4[normalize-space()='Leads Summary']/following-sibling::div//span[normalize-space()='Customer']//preceding-sibling::span");
    private By labelActiveOfTable = By.xpath("//table[@id='leads']/tbody/tr/td/span[contains(text(), 'Active') and contains(@class, 'lead-status')]");

    private By getRows(String value) {
        return By.xpath("//table[@id='leads']//tbody/tr/td/a[normalize-space()='" + value + "']");
    }

    private String deleteLeadSuccessMessage = "Lead deleted";

    private By getDeleteLeadSuccessMessage() {
        String xpathDeleteLeadMessage = "//div[@id='alert_float_1']/descendant::span[@class='alert-title' and normalize-space()='" + deleteLeadSuccessMessage + "']";
        return By.xpath(xpathDeleteLeadMessage);
    }

    public String getTotalLeadActive() {
        return WebUI.getElementText(labelLeadActive);
    }

    public String getTotalLeadCustomers() {
        return WebUI.getElementText(labelLeadCustomer);
    }

    public int getTotalLeadConverted() {
        int totalLeadConverted = Integer.parseInt(getTotalLeadActive()) + Integer.parseInt(getTotalLeadCustomers());
        return totalLeadConverted;
    }

    public void verifyMenuLead() {
        WebUI.threadSleep(1);
        //do truyền text vào xpath nên là kh cần get text để so sánh nữa
        boolean checkHeaderLeadSummary = WebUI.checkExitsElement(titleLeadsSummary);
        Assert.assertTrue(checkHeaderLeadSummary, "FAILED!!! Không truy cập được vào trang Leads");
    }

    public void clickBtnLeadSumary(){
        WebUI.clickElement(buttonLeadsSummary);
    }

    public void clickBtnAddNewLead() {
        //click button New Lead
        WebUI.clickElement(btnAddLead);
        System.out.println("Click Button Add New Lead");
    }

    public void clickBtnCloseAddLead() {
        //click button New Lead
        WebUI.clickElement(buttonClose);
        System.out.println("Click Button Close popup Add New Lead");
    }

    public void verifyBtnAddNewLead() {
        WebUI.threadSleep(1);
        boolean checktitleAddNewLead = WebUI.checkExitsElement(titleAddNewLead);
        Assert.assertTrue(checktitleAddNewLead, "FAILED!!! Không mở được pop-up Add new lead");
        System.out.println("Verify: Mở pop-up Add new lead thành công");
    }

    //close Popup Detail
    public void closePopupDetail() {
        WebUI.clickElement(iconClosePopupDetail);
        WebUI.threadSleep(2);
    }

    //search Lead
    public void searchLeadSuccess(String expectedLeadName) {
        WebUI.clearElement(inputSearch);
        WebUI.setTextElement(inputSearch, expectedLeadName);
        WebUI.threadSleep(2);
        Assert.assertTrue(WebUI.checkExitsElement(getRows(expectedLeadName)), "Không tìm thấy Lead '" + expectedLeadName + "' sau khi search!");
        System.out.println("Tìm kiếm thành công Lead: " + expectedLeadName);
        WebUI.threadSleep(1);
    }

    public void searchLeadSuccessNoData(String expectedLeadName) {
        WebUI.clearElement(inputSearch);
        WebUI.setTextElement(inputSearch, expectedLeadName);
        WebUI.threadSleep(1);
        Assert.assertFalse(WebUI.checkExitsElement(getRows(expectedLeadName)), "Không mong muốn: vẫn còn bản ghi '" + expectedLeadName + "' trong bảng!");  // Test pass
        System.out.println("Tìm kiếm thành công: 0 bản ghi");
    }

    //Hàm so sánh giá trị đã thêm mới trong màn edit
    public void compareFieldAttribute(By xpathActual, String expectedValue, String attributeActual) {
        String actual = WebUI.getElementAttribute(xpathActual, attributeActual);
        Assert.assertEquals(actual.trim(), expectedValue.trim(), "FAIL: Giá trị mong muốn là: " + expectedValue + " nhưng giá trị thực tế là: " + actual);
    }

    public void compareFieldText(By xpathActual, String expectedValue) {
        String actual = WebUI.getElementText(xpathActual);
        Assert.assertEquals(actual.trim(), expectedValue.trim(), "FAIL: Giá trị mong muốn là: " + expectedValue + " nhưng giá trị thực tế là: " + actual);
    }

    public void verifyCheckboxSelected(By checkbox) {
        boolean checked = WebUI.checkSeletedElement(checkbox);
        Assert.assertTrue(checked, "Checkbox chưa được tích sau khi click");
    }

    public void clickBtnEdit(String leadName) {
        //Hover chuột vào dòng đầu tiên
        WebUI.moveToElement(firstRowItem);
        WebUI.clickElement(buttonEdit(leadName));
        System.out.println("Mở pop-up Edit Lead thành công");
    }

    public void addAndEditLeadSuccess(String status, String source, String assigned, String tags, String leadName, String address, String position, String city,
                                      String emailAddress, String state, String website, String country, String phone, String zipcode, String leadValue, String language,
                                      String company, String description, String dateContacted, int flagEdit) {

        //dropdown Status
        WebUI.clickElement(dropdownStatus);
        WebUI.setTextElement(inputSearchOfStatus, status);
        WebUI.clickElement(getValueStatus(status));

        //dropdown Source
        WebUI.clickElement(dropdownSource);
        WebUI.setTextElement(inputSearchOfSource, source);
        WebUI.clickElement(getValueSource(source));

        //dropdownAssigned
        WebUI.clickElement(dropdownAssigned);
        WebUI.setTextElement(inputSearchOfAssigned, assigned);
        WebUI.clickElement(getValueAssigned(assigned));

        //Clear
        if (flagEdit == 1) {
            WebUI.clickElement(elementCloseTags);

            WebUI.clearElement(inputName);
            WebUI.clearElement(inputAddress);
            WebUI.clearElement(inputPosition);
            WebUI.clearElement(inputCity);
            WebUI.clearElement(inputEmailAddress);
            WebUI.clearElement(inputState);
            WebUI.clearElement(inputWebsite);
            WebUI.clearElement(inputPhone);
            WebUI.clearElement(inputZipCode);
            WebUI.clearElement(inputLeadValue);
            WebUI.clearElement(inputCompany);
            WebUI.clearElement(inputDescription);

            WebUI.scrollAtTop(dropdownStatus);
            WebUI.clickElement(inputAddTags);
        }

        //Tag
        WebUI.setTextElement(inputAddTags, tags);

        //click ra input name để đóng tag
        WebUI.clickElement(labelStatus);
        WebUI.clickElement(labelStatus);

        //input
        WebUI.setTextElement(inputName, leadName);
        WebUI.setTextElement(inputAddress, address);
        WebUI.setTextElement(inputPosition, position);
        WebUI.setTextElement(inputCity, city);
        WebUI.setTextElement(inputEmailAddress, emailAddress);
        WebUI.setTextElement(inputState, state);
        WebUI.setTextElement(inputWebsite, website);

        //dropdown Country
        WebUI.clickElement(dropdownCountry);
        WebUI.setTextElement(inputSearchOfCountry, country);
        WebUI.clickElement(getValueCountry(country));

        //input
        WebUI.setTextElement(inputPhone, phone);
        WebUI.setTextElement(inputZipCode, zipcode);
        WebUI.setTextElement(inputLeadValue, leadValue);

        //scroll kéo xuống dưới
        WebUI.scrollAtBottom(buttonSave);

        //dropdown Language
        WebUI.clickElement(dropdownLanguage);
        WebUI.setTextElement(inputSearchOfLanguage, language);
        WebUI.clickElement(getValueLanguage(language));

        //input
        WebUI.setTextElement(inputCompany, company);
        WebUI.setTextElement(inputDescription, description);

        //checkbox contactedToday
        //flagEdit = 0 => Thêm mới
        if (flagEdit == 0) {
            //checkbox public
            WebUI.clickElement(labelPublic);
            WebUI.clickElement(labelContactedToday);
            WebUI.setTextElement(inputDateContacted, dateContacted);
        } else {
            WebUI.clearElement(inputLastContact);
            WebUI.setTextElement(inputLastContact, dateContacted);
        }

        //click btn Save
        WebUI.clickElement(buttonSave);
        WebUI.threadSleep(1);
    }

    public void viewEditLead(String status, String source, String assigned, String tags, String leadName, String address, String position, String city,
                             String emailAddress, String state, String website, String country, String phone, String zipcode, String leadValue, String language,
                             String company, String description, String dateContacted) {

        compareFieldText(dropdownStatus, status);
        compareFieldText(dropdownSource, source);
        compareFieldText(dropdownAssigned, assigned);
        compareFieldText(inputEditTags, tags);
        compareFieldAttribute(inputName, leadName, "value");
        compareFieldAttribute(inputAddress, address, "value");
        compareFieldAttribute(inputPosition, position, "value");
        compareFieldAttribute(inputCity, city, "value");
        compareFieldAttribute(inputEmailAddress, emailAddress, "value");
        compareFieldAttribute(inputState, state, "value");
        compareFieldAttribute(inputWebsite, website, "value");
        compareFieldText(dropdownCountry, country);
        compareFieldAttribute(inputPhone, phone, "value");
        compareFieldAttribute(inputZipCode, zipcode, "value");
        compareFieldAttribute(inputLeadValue, leadValue + ".00", "value");
        compareFieldText(dropdownLanguage, language);
        compareFieldAttribute(inputCompany, company, "value");
        compareFieldAttribute(inputDescription, description, "value");
        compareFieldAttribute(inputLastContact, dateContacted, "value"); //hệ thống bug
        verifyCheckboxSelected(checkboxPublic);
        System.out.println("Tất cả các trường dữ liệu Lead đã được Verify thành công");
    }

    public void clickBtnDeleteLead(String leadName) {
        //Hover chuột vào dòng đầu tiên
        WebUI.moveToElement(firstRowItem);
        WebUI.clickElement(buttonDelete(leadName));
    }

    public void confirmDeleteLead(int flag) {
        System.out.println("Confirm Delete Lead");
        WebUI.threadSleep(2);
        Alert alert = DriverManager.getDriver().switchTo().alert();
        //check text trên alert
        if (flag == 1) {
            //xóa
            WebUI.acceptAlert();
        } else {
            //hủy xóa
            WebUI.dismissAlert();
        }
    }

    public void verifyDeleteSuccessMessage(int flag){
        if (flag == 1) {
            Assert.assertTrue(WebUI.checkExitsElement(getDeleteLeadSuccessMessage()), "Không hiển thị message Xóa thành công sau khi Xóa");
        }else {
            Assert.assertFalse(WebUI.checkExitsElement(getDeleteLeadSuccessMessage()), "Hiển thị message Xóa thành công sau khi Hủy xóa");
        }
    }

    public void verifyAfterDeleteLead(String leadName, int flag) {
        WebUI.clearElement(inputSearch);
        WebUI.setTextElement(inputSearch, leadName);
        WebUI.threadSleep(1);
        if (flag == 1) {
            //xóa nhưng vẫn còn bản ghi
            Assert.assertFalse(WebUI.checkExitsElement(getRows(leadName)), "Xóa không thành công: vẫn còn bản ghi '" + leadName + "' trong bảng!");  // Test pass
            System.out.println("Tìm kiếm thành công: 0 bản ghi");
        }else {
            //Hủy xóa nhưng lại bị mất bản ghi
            Assert.assertTrue(WebUI.checkExitsElement(getRows(leadName)), "Hủy xóa Lead không thành công. Không tìm thấy Lead '" + leadName + "' sau khi search!");
            System.out.println("Tìm kiếm thành công Lead: " + leadName);
        }

    }

}
