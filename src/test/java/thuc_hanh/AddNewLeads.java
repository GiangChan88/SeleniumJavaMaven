package thuc_hanh;


import bt_locator.LocatorsLeads;
import common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class AddNewLeads extends BaseTest {
//    public static void dropdownStatus(String keySearch, String exactValue) throws InterruptedException {
//        //dropdown Status
//        WebElement selectedStatus = driver.findElement(By.xpath("//button[@data-id='status']//div"));
//        String currentValueStatus = selectedStatus.getText();
//        System.out.println("Giá trị mặc định Status là: " + currentValueStatus);
//        driver.findElement(By.xpath(LocatorsLeads.dropdownStatus)).click();
//        Thread.sleep(500);
//        driver.findElement(By.xpath(LocatorsLeads.inputSearchOfStatus)).sendKeys(keySearch);
//        Thread.sleep(500);
//        driver.findElement(By.xpath(LocatorsLeads.getValueStatus(exactValue))).click();
//        WebElement selectedStatusNew = driver.findElement(By.xpath("//button[@data-id='status']//div"));
//        String currentValueStatusNew = selectedStatusNew.getText();
//        System.out.println("Giá trị Status mới là: " + currentValueStatusNew);
//    }
//
//    public static void dropdownSource(String keySearch, String exactValue) throws InterruptedException {
//        //dropdown Source
//        WebElement selectedSource = driver.findElement(By.xpath("//button[@data-id='source']//div"));
//        String currentValueSource = selectedSource.getText();
//        System.out.println("Giá trị mặc định Source là: " + currentValueSource);
//        driver.findElement(By.xpath(LocatorsLeads.dropdownSource)).click();
//        Thread.sleep(500);
//        driver.findElement(By.xpath(LocatorsLeads.inputSearchOfSource)).sendKeys(keySearch);
//        Thread.sleep(500);
//        driver.findElement(By.xpath(LocatorsLeads.getValueSource(exactValue))).click();
//        WebElement selectedSourceNew = driver.findElement(By.xpath("//button[@data-id='source']//div"));
//        String currentValueSourceNew = selectedSourceNew.getText();
//        System.out.println("Giá trị Source mới là: " + currentValueSourceNew);
//    }
//
//    public static void dropdownAssigned(String keySearch, String exactValue) throws InterruptedException {
//        //dropdown Assigned
//        WebElement selectedAssigned = driver.findElement(By.xpath("//button[@data-id='assigned']//div"));
//        String currentValueAssigned = selectedAssigned.getText();
//        System.out.println("Giá trị mặc định Assigned là: " + currentValueAssigned);
//        driver.findElement(By.xpath(LocatorsLeads.dropdownAssigned)).click();
//        Thread.sleep(500);
//        driver.findElement(By.xpath(LocatorsLeads.inputSearchOfAssigned)).sendKeys(keySearch);
//        Thread.sleep(500);
//        driver.findElement(By.xpath(LocatorsLeads.getValueAssigned(exactValue))).click();
//        WebElement selectedAssignedNew = driver.findElement(By.xpath("//button[@data-id='assigned']//div"));
//        String currentValueAssignedNew = selectedAssignedNew.getText();
//        System.out.println("Giá trị Assigned mới là: " + currentValueAssignedNew);
//    }
//
//    public static void dropdownCountry(String keySearch, String exactValue) throws InterruptedException {
//        //dropdown Country
//        WebElement selectedCountry = driver.findElement(By.xpath("//button[@data-id='country']//div"));
//        String currentValueCountry = selectedCountry.getText();
//        System.out.println("Giá trị mặc định Country là: " + currentValueCountry);
//        driver.findElement(By.xpath(LocatorsLeads.dropdownCountry)).click();
//        Thread.sleep(500);
//        driver.findElement(By.xpath(LocatorsLeads.inputSearchOfCountry)).sendKeys(keySearch);
//        Thread.sleep(500);
//        driver.findElement(By.xpath(LocatorsLeads.getValueCountry(exactValue))).click();
//        WebElement selectedCountryNew = driver.findElement(By.xpath("//button[@data-id='country']//div"));
//        String currentValueCountryNew = selectedCountryNew.getText();
//        System.out.println("Giá trị Country mới là: " + currentValueCountryNew);
//    }
//
//    public static void dropdownLanguage(String keySearch, String exactValue) throws InterruptedException {
//        //dropdown Language
//        WebElement selectedLanguage = driver.findElement(By.xpath("//button[@data-id='default_language']//div"));
//        String currentValueLanguage = selectedLanguage.getText();
//        System.out.println("Giá trị mặc định Language là: " + currentValueLanguage);
//        driver.findElement(By.xpath(LocatorsLeads.dropdownDefaultLanguage)).click();
//        Thread.sleep(500);
//        driver.findElement(By.xpath(LocatorsLeads.inputSearchOfDefaultLanguage)).sendKeys(keySearch);
//        Thread.sleep(500);
//        driver.findElement(By.xpath(LocatorsLeads.getValueDefaultLanguage(exactValue))).click();
//        WebElement selectedLanguageNew = driver.findElement(By.xpath("//button[@data-id='default_language']//div"));
//        String currentValueLanguageNew = selectedLanguageNew.getText();
//        System.out.println("Giá trị Language mới là: " + currentValueLanguageNew);
//    }

    public static void checkboxPublic() throws InterruptedException {
        //Checkbox public
        //Kiểm tra giá trị mặc định
        boolean isSelectedPublic = driver.findElement(By.xpath(LocatorsLeads.checkboxPublic)).isSelected();
        System.out.println("Checkbox public được chọn: " + isSelectedPublic);
        Thread.sleep(500);

        if (!isSelectedPublic) {
            driver.findElement(By.xpath(LocatorsLeads.labelPublic)).click();
            System.out.println("Checkbox public đã được chọn");
        }
    }

    public static void chkbContactedTodayAndInputDateContacted() throws InterruptedException {
        //Checkbox Contacted today and input Date Contaced
        WebElement chkbContactedToday = driver.findElement(By.xpath(LocatorsLeads.checkboxContactedToday));
        WebElement inputDateContacted = driver.findElement(By.xpath(LocatorsLeads.inputDateContacted));

        //Kiểm tra checkbox giá trị mặc định
        boolean isSelectedContacted = chkbContactedToday.isSelected();
        System.out.println("Checkbox Contacted Today đuợc chọn: " + isSelectedContacted);
        Thread.sleep(500);

        //Kiểm tra input Date Contacted hiển thị
        if (isSelectedContacted) {
            boolean isDisplayedInputDateContacted = inputDateContacted.isDisplayed();
            System.out.println("Input Date Contacted được hiển thị: " + isDisplayedInputDateContacted);
        }

        //click checkbox Contacted today - (mặc định là đã chọn, click lần này là => bỏ chọn)
        chkbContactedToday.click();

        //Kiểm tra sau khi bỏ chọn checkbox thì input có hiển thị và cho phép thao tác nhập không
        if (inputDateContacted.isDisplayed() && inputDateContacted.isEnabled()) {
            inputDateContacted.sendKeys("05/11/2025");
        }
        Thread.sleep(1000);
    }

    public static void dropdownSearch(
            String dropdownXpath,
            String inputSearchXpath,
            String keySearch,
            String xpathGetValue) throws InterruptedException {

        //Kiểm tra giá trị mặc định
        WebElement selected = driver.findElement(By.xpath(dropdownXpath)); //truyền LocatorsLead.valueNowCountry
        String currentValue = selected.getAttribute("title");
        System.out.println("Giá trị mặc định là: " + currentValue);

        driver.findElement(By.xpath(dropdownXpath)).click(); //truyền LocatorsLead.dropdownCountry
        Thread.sleep(500);

        driver.findElement(By.xpath(inputSearchXpath)).sendKeys(keySearch); //input Xpath = inputSearchOfCountry //keySearch là key nhập
        Thread.sleep(500);

        driver.findElement(By.xpath(xpathGetValue)).click();
        Thread.sleep(500);

        //Kiểm tra giá trị sau khi chọn
        WebElement selectedNew = driver.findElement(By.xpath(dropdownXpath));
        String newValue = selectedNew.getAttribute("title");
        System.out.println("Giá trị mới là: " + newValue);
    }

    //add Lead
    public static void addNewLead(String leadName) throws InterruptedException {
        //dropdown Status
        //dropdownStatus("Active", "Active");
        dropdownSearch(
                LocatorsLeads.dropdownStatus,
                LocatorsLeads.inputSearchOfStatus,
                "Active",
                LocatorsLeads.getValueStatus("Active")
        );
        //dropdown Source
        //dropdownSource("Face","Facebook");
        dropdownSearch(
                LocatorsLeads.dropdownSource,
                LocatorsLeads.inputSearchOfSource,
                "Face",
                LocatorsLeads.getValueSource("Facebook")
        );
        //dropdownAssigned
        //dropdownAssigned("Admin Anh", "Admin Anh Tester");
        dropdownSearch(
                LocatorsLeads.dropdownAssigned,
                LocatorsLeads.inputSearchOfAssigned,
                "Admin Anh",
                LocatorsLeads.getValueAssigned("Admin Anh Tester")
        );

        //Tags
        driver.findElement(By.xpath(LocatorsLeads.inputAddTags)).sendKeys("GiangNTH");
        //click ra input name để input tag nhận giá trị mới
        driver.findElement(By.xpath(LocatorsLeads.inputName)).click();

        //input
        driver.findElement(By.xpath(LocatorsLeads.inputName)).sendKeys(leadName); //truyền name
        driver.findElement(By.xpath(LocatorsLeads.inputAddress)).sendKeys("230 Mễ Trì, Hà Nội");
        driver.findElement(By.xpath(LocatorsLeads.inputPosition)).sendKeys("Mễ Trì");
        driver.findElement(By.xpath(LocatorsLeads.inputCity)).sendKeys("Hà Nội");
        driver.findElement(By.xpath(LocatorsLeads.inputEmailAddress)).sendKeys("giang12345@gmail.com");
        driver.findElement(By.xpath(LocatorsLeads.inputState)).sendKeys("123");
        driver.findElement(By.xpath(LocatorsLeads.inputWebsite)).sendKeys("https://8080:21");

        //dropdown Country
        //dropdownCountry("Angola","Angola");
        dropdownSearch(
                LocatorsLeads.dropdownCountry,
                LocatorsLeads.inputSearchOfCountry,
                "Angola",
                LocatorsLeads.getValueCountry("Angola")
        );

        driver.findElement(By.xpath(LocatorsLeads.inputPhone)).sendKeys("0772627627");
        driver.findElement(By.xpath(LocatorsLeads.inputZipCode)).sendKeys("7789");

        //scroll kéo xuống dưới
        WebElement element = driver.findElement(By.xpath("//label[@for='lead_value']")); //trỏ tới element
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element); //true là cuộn xuống dưới, false là cuộn lên trên
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsLeads.inputLeadValue)).sendKeys("100000");

        //dropdown Language
        //dropdownLanguage("Eng", "English");
        dropdownSearch(
                LocatorsLeads.dropdownLanguage,
                LocatorsLeads.inputSearchOfLanguage,
                "Eng",
                LocatorsLeads.getValueLanguage("English"));

        driver.findElement(By.xpath(LocatorsLeads.inputCompany)).sendKeys("ND");
        driver.findElement(By.xpath(LocatorsLeads.inputDescription)).sendKeys("không");

        //checkbox public
        checkboxPublic();

        //checkbox Contacted Today and input Date Contacted
        chkbContactedTodayAndInputDateContacted();

        //click btn Save
        driver.findElement(By.xpath(LocatorsLeads.buttonSave)).click();
    }

    //chi tiết lead vừa add
    public static void detailAdd(String leadName) {
        String text = driver.findElement(By.xpath("//div[@id='leadViewWrapper']//dd[contains(@class,'lead-name')]")).getText();
        if (text.equalsIgnoreCase(leadName)) {
            System.out.println("Add correct");
        }
        driver.findElement(By.xpath("//div[@id='lead-modal']//div[@class='modal-header']/button")).click();
    }

    //search Lead vừa mới add
//    public static void searchLead(String leadName) throws InterruptedException {
//        driver.findElement(By.xpath(LocatorsLeads.inputSearch)).clear();
//        driver.findElement(By.xpath(LocatorsLeads.inputSearch)).sendKeys(leadName);
//        Thread.sleep(2000);
//
//        String firstRowLead = driver.findElement(By.xpath(LocatorsLeads.firstRowItem)).getText();
//        System.out.println("First row lead: "+firstRowLead);
//    }

    public static void main(String[] args) throws InterruptedException {
        createDriver();
        loginCRM();
        Thread.sleep(1000);

        driver.findElement(By.xpath(LocatorsLeads.menuLeads)).click();

        driver.findElement(By.xpath(LocatorsLeads.btnAddLead)).click();
        Thread.sleep(1000);

        addNewLead("GiangTest 02");
        Thread.sleep(1000);

        detailAdd("GiangTest 02");
        Thread.sleep(1000);

//        searchLead("GiangTest 02");
//        Thread.sleep(2000);

        closeDriver();
    }
}
