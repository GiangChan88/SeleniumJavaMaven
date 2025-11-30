package locator;

import org.openqa.selenium.By;

public class LocatorsLeads {

    //locators menu Leads
    public static By menuLeads = By.xpath("//span[@class = 'menu-text' and normalize-space() = 'Leads']");

    //locator for Leads Page
    public static By buttonNewLead = By.xpath("//a[normalize-space()='New Lead']");
    public static By headerLeadsSummary = By.xpath("//a[@data-title='Leads Summary']");
    public static By buttonKanban = By.xpath("//a[@data-title='Switch to Kanban']");
    public static By buttonFilterBy = By.xpath("//div[@id='vueApp']//button[@type='button']");
    public static By dropdownLeadLength = By.xpath("//select[@name ='leads_length']");
    public static By buttonExport = By.xpath("//button[normalize-space() = 'Export']");
    public static By buttonBulkActions = By.xpath("//button[normalize-space() = 'Bulk Actions']");
    public static By buttonReload = By.xpath("//button[contains(@class, 'btn-dt-reload')]");
    public static By inputSearch = By.xpath("//div[@id='leads_filter']//input[@type='search']");
    public static By firstRowItem = By.xpath("//table[@id='leads']//tbody/tr[1]/td[3]/a");

    //header table
    public static By checkboxAll = By.xpath("//input[@id='mass_select_all']");

    public static By getCheckboxValue(String value) {
        By xpath = By.xpath("//a[normalize-space()='" + value + "']/parent::td/preceding-sibling::td//input[@type='checkbox']");
        return xpath;
    }

    public static By headerNumber = By.xpath("//table[@id='leads']/thead//th[@id='th-number']");
    public static By headerName = By.xpath("//table[@id='leads']/thead//th[@id='th-name']");
    public static By headerCompany = By.xpath("//table[@id='leads']/thead//th[@id='th-company']");
    public static By headerEmail = By.xpath("//table[@id='leads']/thead//th[@id='th-email']");
    public static By headerPhone = By.xpath("//table[@id='leads']/thead//th[@id='th-phone']");
    public static By headerValue = By.xpath("//table[@id='leads']/thead//th[@id='th-lead-value']");
    public static By headerTags = By.xpath("//table[@id='leads']/thead//th[@id='th-tags']");
    public static By headerAssigned = By.xpath("//table[@id='leads']/thead//th[@id='th-assigned']");
    public static By headerStatus = By.xpath("//table[@id='leads']/thead//th[@id='th-status']");
    public static By headerSource = By.xpath("//table[@id='leads']/thead//th[@id='th-source']");
    public static By headerLastContact = By.xpath("//table[@id='leads']/thead//th[@id='th-last-contact']");
    public static By headerCreated = By.xpath("//table[@id='leads']/thead//th[@id='th-date-created']");

    public static By buttonView(String leadName) {
        By xpath = By.xpath("//td[./a[normalize-space()='" + leadName + "']]//a[normalize-space()='View']");
        return xpath;
    }

    public static By buttonEdit(String leadName) {
        By xpath = By.xpath("//td[./a[normalize-space()='" + leadName + "']]//a[normalize-space()='Edit']");
        return xpath;
    }

    public static By buttonDelete(String leadName) {
        By xpath = By.xpath("//td[./a[normalize-space()='" + leadName + "']]//a[normalize-space()='Delete']");
        return xpath;
    }

    public static By buttonPrevious = By.xpath("//div[@id= 'leads_paginate']//a[text()='Previous']");
    public static By buttonNumber = By.xpath("//div[@id='leads_paginate']//li[@class='paginate_button active']");//saiii
    public static By buttonNext = By.xpath("//div[@id= 'leads_paginate']//a[text()='Next']");
    public static By dropdownJumpLead = By.xpath("//select[@id= 'dt-page-jump-leads']");

    //leads summary
    //driver.findElement(By.xpath("//a[@data-title='Leads Summary']")).click();
    public static By titleLeadsSummary = By.xpath("//h4[normalize-space()='Leads Summary']");

    public static By stringValueActive = By.xpath("//div[contains(@class,'leads-overview')]//span[normalize-space() = 'Active']");
    public static By numberValueActive = By.xpath("//div[contains(@class,'leads-overview')]//span[normalize-space() = 'Active']/preceding-sibling::span");

    public static By stringValuejjjj = By.xpath("//div[contains(@class,'leads-overview')]//span[normalize-space() = 'jjjj']");
    public static By numberValuejjjj = By.xpath("//div[contains(@class,'leads-overview')]//span[normalize-space() = 'jjjj']/preceding-sibling::span");

    public static By stringValueCustomer = By.xpath("//div[contains(@class,'leads-overview')]//span[normalize-space() = 'Customer']");
    public static By numberValueCustomer = By.xpath("//div[contains(@class,'leads-overview')]//span[normalize-space() = 'Customer']/preceding-sibling::span");

    public static By stringValueLostLead = By.xpath("//div[contains(@class,'leads-overview')]//span[normalize-space() = 'Lost Leads']");
    public static By numberValueLostLead = By.xpath("//div[contains(@class,'leads-overview')]//span[normalize-space() = 'Lost Leads']//preceding-sibling::span");


    //ADD NEW LEAD
    public static By btnAddLead = By.xpath("//a[normalize-space()='New Lead']");
    public static By titleAddNewLead = By.xpath("//h4[normalize-space() ='Add new lead']");
    //public static By iconCloseAddNewLead = By.xpath("//div[@id='leads_bulk_actions']/descendant::button[@class='close']");
    public static By iconCloseAddNewLead = By.xpath("//h4[@id='myModalLabel']/preceding-sibling::button[@class='close']");
    public static By iconClosePopupDetail = By.xpath("//div[@id='lead-modal']//div[@class='modal-header']/button");

    public static By labelStatus = By.xpath("//label[@for='status']");
    public static By dropdownStatus = By.xpath("//button[@data-id='status']");
    public static By inputSearchOfStatus = By.xpath("//button[@data-id='status']/following-sibling::div//input[@type='search']");

    public static By getValueStatus(String value) {
        By xpath = By.xpath("//button[@data-id='status']/following-sibling::div//span[normalize-space()='" + value + "']");
        return xpath;
    }

    public static By buttonAddStatus = By.xpath("//div[@app-field-wrapper='status']//div[@class= 'input-group-btn']");
    public static By inputAddStatus = By.xpath("//input[@id='new_status_name']");


    public static By dropdownSource = By.xpath("//button[@data-id='source']");
    public static By inputSearchOfSource = By.xpath("//div[@app-field-wrapper='source']//input[@type='search']");

    public static By getValueSource(String value) {
        By xpathListSource = By.xpath("//button[@data-id='source']/following-sibling::div//span[normalize-space()='" + value + "']");
        return xpathListSource;
    }

    public static By buttonAddSource = By.xpath("//div[@app-field-wrapper='source']//div[@class= 'input-group-btn']");
    public static By inputAddSource = By.xpath("//input[@id='new_source_name']");

    public static By dropdownAssigned = By.xpath("//button[@data-id='assigned']");
    public static By inputSearchOfAssigned = By.xpath("//div[@app-field-wrapper='assigned']//input[@type='search']");

    public static By getValueAssigned(String value) {
        By xpathListAssignes = By.xpath("//button[@data-id='assigned']/following-sibling::div//span[normalize-space()='" + value + "']");
        return xpathListAssignes;
    }

    public static By elementCloseTags = By.xpath("//div[@id='inputTagsWrapper']/ul//a[@class='tagit-close']/span[1]");
    public static By inputAddTags = By.xpath("//div[@id='inputTagsWrapper']/ul/li[@class='tagit-new']/input");
    public static By inputEditTags = By.xpath("(//input[@id='tags']/following-sibling::ul)/descendant::span[@class='tagit-label']");
    public static By dropdownTags = By.xpath("//div[@id='inputTagsWrapper']//ul[@id='ui-id-2']");

    public static By getValueTags(String value) {
        By xpathListTag = By.xpath("//div[@id='inputTagsWrapper']//div[normalize-space()='" + value + "']");
        return xpathListTag;
    }

    public static By inputName = By.xpath("//div[@id ='tab_lead_profile']//input[@id='name']");
    public static By inputAddress = By.xpath("//textarea[@id='address']");
    public static By inputPosition = By.xpath("//input[@id='title']");
    public static By inputCity = By.xpath("//input[@id='city']");
    public static By inputEmailAddress = By.xpath("//input[@id='email']");
    public static By inputState = By.xpath("//input[@id='state']");
    ;
    public static By inputWebsite = By.xpath("//input[@id='website']");

    public static By dropdownCountry = By.xpath("//button[@data-id='country']");
    public static By inputSearchOfCountry = By.xpath("//div[@app-field-wrapper='country']//input[@type='search']");

    public static By getValueCountry(String value) {
        By xpathListCountry = By.xpath("//button[@data-id='country']/following::span[@class='text' and normalize-space()='" + value + "']");
        return xpathListCountry;
    }

    public static By inputPhone = By.xpath("//input[@id='phonenumber']");
    public static By inputZipCode = By.xpath("//input[@id='zip']");
    public static By inputLeadValue = By.xpath("//input[@name='lead_value']");
    public static By iconLeadValue = By.xpath("//input[@name='lead_value']/following-sibling::div");

    public static By dropdownLanguage = By.xpath("//button[@data-id='default_language']");
    public static By inputSearchOfLanguage = By.xpath("//button[@data-id='default_language']/following-sibling::div//input[@type='search']");

    public static By getValueLanguage(String value) {
        By xpathListDefaultLanguage = By.xpath("//button[@data-id='default_language']/following::span[@class='text' and normalize-space()='" + value + "']");
        return xpathListDefaultLanguage;
    }

    public static By inputCompany = By.xpath("//input[@id='company']");
    public static By inputDescription = By.xpath("//textarea[@id='description']");
    public static By inputDateContacted = By.xpath("//input[@id='custom_contact_date']");
    public static By calendarDateContacted = By.xpath("//div[@app-field-wrapper='custom_contact_date']//i[contains(@class,'fa-calendar')]");
    public static By inputLastContact = By.xpath("//input[@id='lastcontact']");
    public static By labelPublic = By.xpath("//label[@for='lead_public']");
    public static By checkboxPublic = By.xpath("//input[@id='lead_public']");
    public static By labelContactedToday = By.xpath("//label[@for='contacted_today']");
    public static By checkboxContactedToday = By.xpath("//input[@id='contacted_today']");

    public static By buttonClose = By.xpath("//div[@id ='tab_lead_profile']//button[normalize-space()='Close']");
    //public static By buttonClose = By.xpath("//button[@id = 'lead-form-submit']/following-sibling::button[normalize-space()='Close']");
    public static By buttonSave = By.xpath("//button[@id = 'lead-form-submit']");

    public static By getRows(String value) {
        return By.xpath("//table[@id='leads']//tbody/tr/td/a[normalize-space()='" + value + "']");
    }
}
