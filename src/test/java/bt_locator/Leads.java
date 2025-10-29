package bt_locator;

public class Leads {
    public String url = "https://crm.anhtester.com/admin/authentication";

    //Locators Login
    public String headerLogin = "//h1[normalize-space()='Login']";
    public String inputEmail = "//input[@id='email']";
    public String inputPassword = "//input[@id='password']";
    public String buttonLogin = "//button[@type='submit']";
    public String checkboxRememberMe = "//input[@id = 'remember']";
    public String labelRememberMe = "//label[@for='remember']";
    public String linkForgotPassword = "//a[normalize-space()='Forgot Password?']";
    public String alertErrorMessage = "//div[contains(@class, 'alert-danger')]";
    public String alertErrorEmailRequired = "//div[normalize-space() = 'The Email Address field is required.']";
    public String alertErrorPasswordRequired = "//div[normalize-space() = 'The Password field is required.']";

    //locators menu Leads
    public String menuLeads = "//span[@class = 'menu-text' and normalize-space() = 'Leads']";

    //locator for Leads Page
    public String buttonNewLead = "//a[normalize-space()='New Lead']";
    public String buttonLeadsSummary = "//a[@data-title='Leads Summary']";
    public String buttonKanban = "//a[@data-title='Switch to Kanban']";
    public String buttonFilterBy = "//div[@id='vueApp']//button[@type='button']";
    public String dropdownLeadLength = "//select[@name ='leads_length']";
    public String buttonExport = "//button[normalize-space() = 'Export']";
    public String buttonBulkActions = "//button[normalize-space() = 'Bulk Actions']";
    public String buttonReload = "//button[contains(@class, 'btn-dt-reload')]";
    public String buttonSearch = "//div[@id='leads_filter']//input[@type='search']";

    //header
    public String checkboxAll = "//input[@id='mass_select_all']";
    public String headerNumber = "//th[@id='th-number']";
    public String headerName = "//th[@id='th-name']";
    public String headerCompany = "//th[@id='th-company']";
    public String headerEmail = "//th[@id='th-email']";
    public String headerPhone = "//th[@id='th-phone']";
    public String headerValue = "//th[@id='th-lead-value']";
    public String headerTags = "//th[@id='th-tags']";
    public String headerAssigned = "//th[@id='th-assigned']";
    public String headerStatus = "//th[@id='th-status']";
    public String headerSource = "//th[@id='th-source']";
    public String headerLastContact = "//th[@id='th-last-contact']";
    public String headerCreated = "//th[@id='th-date-created']";

    //button View, Edit, Delete
    public String linkView = "//td[./a[normalize-space()='TestCTT']]//a[normalize-space()='View']";
    public String linkEdit = "//td[./a[normalize-space()='TestCTT']]//a[normalize-space()='Edit']";
    public String linkDelete = "//td[./a[normalize-space()='TestCTT']]//a[normalize-space()='Delete']";

    public String buttonPrevious = "//div[@id= 'leads_paginate']//a[text()='Previous']";
    public String buttonNumber = "/html/body/div[3]/div/div/div/div[2]/div/div/div/div/div[2]/div/div/div[5]/div[2]/div[3]/ul/li[2]/a";
    public String buttonNext = "//div[@id= 'leads_paginate']//a[text()='Next']";
    public String dropdownJumpLead = "//select[@id= 'dt-page-jump-leads']";

    //leads summary
    //driver.findElement(By.xpath("//a[@data-title='Leads Summary']")).click();
    public String titleLeadsSummary = "//h4[normalize-space()='Leads Summary']";

    public String numberValueActive = "/html/body/div[3]/div/div/div/div[1]/div[3]/div/div[1]/span[1]";
    public String stringValueActive = "//div[contains(@class,'leads-overview')]//span[normalize-space() = 'Active']";

    public String numberValuejjjj = "/html/body/div[3]/div/div/div/div[1]/div[3]/div/div[2]/span[1]";
    public String stringValuejjjj = "//div[contains(@class,'leads-overview')]//span[normalize-space() = 'jjjj']";

    public String numberValueCustomer = "/html/body/div[3]/div/div/div/div[1]/div[3]/div/div[2]/span[1]";
    public String stringValueCustomer = "//div[contains(@class,'leads-overview')]//span[normalize-space() = 'Customer']";

    public String numberValueLostLead = "/html/body/div[3]/div/div/div/div[1]/div[3]/div/div[4]/span[1]/span";
    public String stringValueLostLead = "//div[contains(@class,'leads-overview')]//span[normalize-space() = 'Lost Leads']";


    //ADD NEW LEAD
    public String titleAddNewLead = "//h4[normalize-space() ='Add new lead']";
    //public String reqAll = "//div[@id ='tab_lead_profile']//small[normalize-space()='*']";

    public String labelStatus = "//label[@for='status']";
    public String reqStatus = "//label[@for='status']//small[normalize-space()='*']";
    public String dropdownStatus = "//button[@data-id='status']";
    public String inputSearchOfStatus = "//div[@app-field-wrapper='status']//input[@type='search']";
    public String dropdownListStatus = "//div[@app-field-wrapper='status']//a[@id='bs-select-5-1']";
    public String buttonAddStatus = "//div[@app-field-wrapper='status']//div[@class= 'input-group-btn']";
    public String inputAddStatus = "//input[@id='new_status_name']";

    public String labelSource = "//label[@for='source']";
    public String reqSource = "//label[@for='source']//small[normalize-space()='*']";
    public String dropdownSource = "//button[@data-id='source']";
    public String inputSearchOfSource = "//div[@app-field-wrapper='source']//input[@type='search']";
    public String dropdownListSource = "//div[@app-field-wrapper='source']//a[@id='bs-select-6-1']";
    public String buttonAddSource = "//div[@app-field-wrapper='source']//div[@class= 'input-group-btn']";
    public String inputAddSource = "//input[@id='new_source_name']";

    public String labelAssigned = "//label[@for='assigned']";
    public String dropdownAssigned = "//button[@data-id='assigned']";
    public String inputSearchOfAssigned = "//div[@app-field-wrapper='assigned']//input[@type='search']";
    public String dropdownListAssigned = "//div[@app-field-wrapper='assigned']//a[@id='bs-select-7-2']";

    public String labelTags = "//label[@for='tags']";
    public String inputAddTags = "//div[@id='inputTagsWrapper']//input[@placeholder='Tag']";
    public String dropdownTags = "//div[@id='inputTagsWrapper']//ul[@id='ui-id-2']";

    public String labelName = "//div[@id ='tab_lead_profile']//label[@for='name']";
    public String reqName = "//div[@id ='tab_lead_profile']//label[@for='name']//small[normalize-space()='*']";
    public String inputName = "//div[@id ='tab_lead_profile']//input[@id='name']";

    public String labelAddress = "//label[@for='address']";
    public String inputAddress = "//textarea[@id='address']";

    public String labelPosition = "//label[@for='title']";
    public String inputPosition = "//input[@id='title']";

    public String labelCity = "//label[@for='city']";
    public String inputCity = "//input[@id='city']";

    public String labelEmailAddress = "//label[@for='email']";
    public String inputEmailAddress = "//input[@id='email']";

    public String labelState = "//label[@for='state']";
    public String inputState = "//input[@id='state']";

    public String labelWebsite = "//label[@for='website']";
    public String inputWebsite = "//input[@id='website']";

    public String labelCountry = "//label[@for='country']";
    public String dropdownCountry = "//button[@data-id='country']";
    public String inputSearchOfCountry = "//div[@app-field-wrapper='country']//input[@type='search']";
    public String dropdownListCountry = "//div[@id='bs-select-8']//a[@id='bs-select-8-2']";

    public String labelPhone = "//label[@for='phonenumber']";
    public String inputPhone = "//input[@id='phonenumber']";

    public String labelZipCode = "//label[@for='zip']";
    public String inputZipCode = "//input[@id='zip']";

    public String labelLeadValue = "//label[@for='lead_value']";
    public String inputLeadValue = "//input[@name='lead_value']";
    public String iconLeadValue = "/html/body/div[11]/div/div/div[2]/div/div/div[2]/div/div/form/div[1]/div[3]/div[7]/div[6]/div/div";

    public String labelDefaultLanguage = "//label[@for='default_language']";
    public String dropdownDefaultLanguage = "//button[@data-id='default_language']";
    public String inputSearchOfDefaultLanguage = "//div[contains(@class,'bs3 dropup open')]//input[@type='search']";
    public String dropdownListDefaultLanguage = "//div[@id='bs-select-9']//a[@id='bs-select-9-0']";

    public String labelCompany = "//label[@for='company']";
    public String inputCompany = "//textarea[@id='company']";

    public String labelDescription = "//label[@for='description']";
    public String inputDescription = "//input[@id='description']";

    public String labelPublic = "//label[@for='lead_public']";
    public String checkboxPublic = "//input[@id='lead_public']";

    public String labelDateContacted = "//label[@for='custom_contact_date']";
    public String inputDateContacted = "//input[@id='custom_contact_date']";
    public String calendarDateContacted = "//div[@app-field-wrapper='custom_contact_date']//i[contains(@class,'fa-calendar')]";

    public String labelContactedToday= "//label[@for='contacted_today']";
    public String inputContactedToday = "//input[@id='contacted_today']";

    public String buttonClose= "//div[@id ='tab_lead_profile']//button[normalize-space()='Close']";
    public String buttonSave = "//button[@id = 'lead-form-submit']";


}
