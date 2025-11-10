package thuc_hanh;


import bt_locator.LocatorsLeads;
import common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BTLeads extends BaseTest {

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
            driver.findElement(By.xpath(LocatorsLeads.checkboxPublic)).click();
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
        dropdownSearch(
                LocatorsLeads.dropdownStatus,
                LocatorsLeads.inputSearchOfStatus,
                "Active",
                LocatorsLeads.getValueStatus("Active")
        );
        //dropdown Source
        dropdownSearch(
                LocatorsLeads.dropdownSource,
                LocatorsLeads.inputSearchOfSource,
                "Face",
                LocatorsLeads.getValueSource("Facebook")
        );
        //dropdownAssigned
        dropdownSearch(
                LocatorsLeads.dropdownAssigned,
                LocatorsLeads.inputSearchOfAssigned,
                "Admin Anh",
                LocatorsLeads.getValueAssigned("Admin Anh Tester")
        );

        //Tags
        driver.findElement(By.xpath(LocatorsLeads.inputAddTags)).sendKeys("Giang12345");
        //click ra input name để input tag nhận giá trị mới
        driver.findElement(By.xpath(LocatorsLeads.inputName)).click();

        //input
        driver.findElement(By.xpath(LocatorsLeads.inputName)).sendKeys(leadName); //truyền name
        driver.findElement(By.xpath(LocatorsLeads.inputAddress)).sendKeys("230 Mễ Trì, Hà Nội");
        driver.findElement(By.xpath(LocatorsLeads.inputPosition)).sendKeys("Mễ Trì");
        driver.findElement(By.xpath(LocatorsLeads.inputCity)).sendKeys("Hà Nội");
        driver.findElement(By.xpath(LocatorsLeads.inputEmailAddress)).sendKeys("giang23456@gmail.com");
        driver.findElement(By.xpath(LocatorsLeads.inputState)).sendKeys("123");
        driver.findElement(By.xpath(LocatorsLeads.inputWebsite)).sendKeys("https://8080:21");

        //dropdown Country
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
    public static void detailAddCheck(String leadName) {
        String text = driver.findElement(By.xpath("//div[@id='leadViewWrapper']//dd[contains(@class,'lead-name')]")).getText();
        if (text.equalsIgnoreCase(leadName)) {
            System.out.println("Add correct");
        }
        driver.findElement(By.xpath("//div[@id='lead-modal']//div[@class='modal-header']/button")).click();
    }

    //search Lead vừa mới add
    public static void searchLead(String leadName) throws InterruptedException {
        driver.findElement(By.xpath(LocatorsLeads.inputSearch)).clear();
        driver.findElement(By.xpath(LocatorsLeads.inputSearch)).sendKeys(leadName);
        Thread.sleep(2000);

        String firstRowLead = driver.findElement(By.xpath(LocatorsLeads.firstRowItem)).getText();
        System.out.println("First row lead: " + firstRowLead);
    }

    //Hàm so sánh giá trị đã thêm mới trong màn edit
    public static void verifyElementValue(String expectedValue, String xpathActual, String attributeActual){
        String expected = expectedValue;
        String actual = driver.findElement(By.xpath(xpathActual)).getAttribute(attributeActual);
        if (actual.trim().equalsIgnoreCase(expected.trim())) {
            System.out.println("Giá trị hiển thị đúng: " + actual);
        } else {
            System.out.println("FAIL: Giá trị mong muốn là: " + expected + " nhưng giá trị thực tế là: " + actual);
        }
    }

    public static void editLead(String leadName) throws InterruptedException {
        searchLead(leadName);
        WebElement firstRow = driver.findElement(By.xpath(LocatorsLeads.firstRowItem));
        // B2: Hover chuột vào dòng đầu tiên
        Actions actions = new Actions(driver);
        actions.moveToElement(firstRow).perform();
        Thread.sleep(3000);
        driver.findElement(By.xpath(LocatorsLeads.buttonEdit(leadName))).click();

        //Kiểm tra dropdown Status
        verifyElementValue("Active", LocatorsLeads.dropdownStatus, "title");
        //Kiểm tra dropdown Source
        verifyElementValue("Facebook", LocatorsLeads.dropdownSource, "title");
        //Kiểm tra dropdown Assigned
        verifyElementValue("Admin Anh Tester", LocatorsLeads.dropdownAssigned, "title");
        //Kiểm tra input Tags
        verifyElementValue("Giang12345", LocatorsLeads.inputEditTags, "value");
        //Kiểm tra input Name
        verifyElementValue("GiangTest02", LocatorsLeads.inputName, "value");
        //Kiểm tra input Address
        verifyElementValue("230 Mễ Trì, Hà Nội", LocatorsLeads.inputAddress, "value");
        //Kiểm tra input Position
        verifyElementValue("Mễ Trì", LocatorsLeads.inputPosition, "value");
        //Kiểm tra input City
        verifyElementValue("Hà Nội", LocatorsLeads.inputCity, "value");
        //Kiểm tra input Email Address
        verifyElementValue("giang23456@gmail.com", LocatorsLeads.inputEmailAddress, "value");
        //Kiểm tra input State
        verifyElementValue("123", LocatorsLeads.inputState, "value");
        //Kiểm tra input Website
        verifyElementValue("https://8080:21", LocatorsLeads.inputWebsite, "value");
        //Kiểm tra dropdown Country
        verifyElementValue("Angola", LocatorsLeads.dropdownCountry, "title");
        //Kiểm tra input Phone
        verifyElementValue("0772627627", LocatorsLeads.inputPhone, "value");
        //Kiểm tra input Zip Code
        verifyElementValue("7789", LocatorsLeads.inputZipCode, "value");
        //Kiểm tra input Lead value
        verifyElementValue("100000.00", LocatorsLeads.inputLeadValue, "value");
        //Kiểm tra dropdown Default Language
        verifyElementValue("English", LocatorsLeads.dropdownLanguage, "title");
        //Kiểm tra input Company
        verifyElementValue("ND", LocatorsLeads.inputCompany, "value");
        //Kiểm tra input Description
        verifyElementValue("không", LocatorsLeads.inputDescription, "value");
        //Kiểm tra input Date Contacted
        verifyElementValue("05-11-2025 00:00:00", LocatorsLeads.inputLastContact, "value"); //hệ thống bug
        //Kiểm tra checkbox public
        boolean expectedCheckboxPublic = true;
        boolean actualCheckboxPublic = driver.findElement(By.xpath(LocatorsLeads.checkboxPublic)).isSelected();
        if (actualCheckboxPublic == expectedCheckboxPublic){
            System.out.println("Checkbox public hiển thị đúng: "+actualCheckboxPublic);
        }else {
            System.out.println("FAIL: Kết quả mong muốn là: " +expectedCheckboxPublic +" nhưng kết quả thực tế là: "+actualCheckboxPublic);
        }

    }


    public static void main(String[] args) throws InterruptedException {
        createDriver();
        loginCRM();
        Thread.sleep(1000);

        driver.findElement(By.xpath(LocatorsLeads.menuLeads)).click();

        driver.findElement(By.xpath(LocatorsLeads.btnAddLead)).click();
        Thread.sleep(1000);

        addNewLead("GiangTest03");
        Thread.sleep(1000);

        detailAddCheck("GiangTest03");
        Thread.sleep(1000);

        editLead("GiangTest03");
        Thread.sleep(2000);

        closeDriver();
    }
}
