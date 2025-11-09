package thuc_hanh;

import bt_locator.LocatorsTasks;
import common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BTTasks extends BaseTest {
    public static void handleCheckbox(String xpathInput) throws InterruptedException {
        //kiểm tra giá trị mặc định
        boolean isSelectedCheckbox = driver.findElement(By.xpath(xpathInput)).isSelected();
        System.out.println("Checkbox được chọn: "+isSelectedCheckbox);
        Thread.sleep(500);

        if(!isSelectedCheckbox){
            driver.findElement(By.xpath(xpathInput)).click();
            System.out.println("Checkbox đã được chọn");
        }
    }

    public static void chkDisplayAttachfile() throws InterruptedException {
        WebElement attachfile = driver.findElement(By.xpath(LocatorsTasks.linkAttachFile));
        //Kểm tra giá trị mặc định
        boolean chkDisplay = driver.findElement(By.xpath(LocatorsTasks.inputFileAttachment)).isDisplayed();
        System.out.println("Trạng thái ban đầu của input Attachment: "+chkDisplay);

        //click element Attachfile
        attachfile.click();
        Thread.sleep(500);

        //Kiểm tra sau khi click lần 1 element Attachfile
        boolean chkDisplayFirstClick = driver.findElement(By.xpath(LocatorsTasks.inputFileAttachment)).isDisplayed();
        System.out.println("Trạng thái sau click lần 1 của input Attachment: "+chkDisplayFirstClick);

        attachfile.click();
        Thread.sleep(500);
        //Kiểm tra sau khi click lần 2 element Attachfile
        boolean chkDisplaySecondClick = driver.findElement(By.xpath(LocatorsTasks.inputFileAttachment)).isDisplayed();
        System.out.println("Trạng thái sau click lần 2 của input Attachment: "+chkDisplaySecondClick);

    }

    public static void dropdownNoSearch(
            String xpathDropdown,
            String xpathGetValue) throws InterruptedException {
        //Kiểm tra giá mặc định
        WebElement selected = driver.findElement(By.xpath(xpathDropdown)); //LocatorsTasks.dropdown
        String currentValue = selected.getAttribute("title");
        System.out.println("Giá trị mặc định là: "+currentValue);

        driver.findElement(By.xpath(xpathDropdown)).click();
        Thread.sleep(500);

        driver.findElement(By.xpath(xpathGetValue)).click();
        Thread.sleep(500);

        //Kiểm tra giá mặc định
        WebElement selectedNew = driver.findElement(By.xpath(xpathDropdown)); //LocatorsTasks.dropdown
        String newValue = selectedNew.getAttribute("title");
        System.out.println("Giá trị mới là: "+newValue);
    }

    //Thiếu kiểm tra cho chọn nhiều và chọn nhiều (chọn nhiều là click ->
        // sendkey, tìm -> chọn giá trị -> clear tìm kiếm -> sendkey, tìm -> chọn giá trị )
    public static void dropdownSearchMuti(
            String xpathDropdown,
            String xpathSearch,
            String keySearch,
            String xpathGetValue,
            String xpathSearch2,
            String keySearch2,
            String xpathGetValue2) throws InterruptedException {
        //Kiểm tra giá mặc định
        WebElement selected = driver.findElement(By.xpath(xpathDropdown)); //LocatorsTasks.dropdown
        String currentValue = selected.getAttribute("title");
        System.out.println("Giá trị mặc định là: "+currentValue);

        driver.findElement(By.xpath(xpathDropdown)).click();
        Thread.sleep(500);

        driver.findElement(By.xpath(xpathSearch)).sendKeys(keySearch);

        driver.findElement(By.xpath(xpathGetValue)).click();
        Thread.sleep(500);

        driver.findElement(By.xpath(xpathSearch2)).clear();

        driver.findElement(By.xpath(xpathSearch2)).sendKeys(keySearch2);

        driver.findElement(By.xpath(xpathGetValue2)).click();
        Thread.sleep(500);

        //Kiểm tra giá mặc định
        WebElement selectedNew = driver.findElement(By.xpath(xpathDropdown)); //LocatorsTasks.dropdown
        String newValue = selectedNew.getAttribute("title");
        System.out.println("Giá trị mới là: "+newValue);
    }

    public static void dropdownSearch(
            String xpathDropdown,
            String xpathSearch,
            String keySearch,
            String xpathGetValue) throws InterruptedException {
        //Kiểm tra giá mặc định
        WebElement selected = driver.findElement(By.xpath(xpathDropdown)); //LocatorsTasks.dropdown
        String currentValue = selected.getAttribute("title");
        System.out.println("Giá trị mặc định là: "+currentValue);

        driver.findElement(By.xpath(xpathDropdown)).click();
        Thread.sleep(500);

        driver.findElement(By.xpath(xpathSearch)).sendKeys(keySearch);

        driver.findElement(By.xpath(xpathGetValue)).click();
        Thread.sleep(500);

        //Kiểm tra giá mặc định
        WebElement selectedNew = driver.findElement(By.xpath(xpathDropdown)); //LocatorsTasks.dropdown
        String newValue = selectedNew.getAttribute("title");
        System.out.println("Giá trị mới là: "+newValue);
    }

    public static void chkDropdownRepeatAndTotalCycles() throws InterruptedException {
        WebElement inputTotalCycles = driver.findElement(By.xpath(LocatorsTasks.inputTotalCycles));
        WebElement labelInfinity = driver.findElement(By.xpath(LocatorsTasks.labelCheckboxInfinity));
        WebElement chbInfinity = driver.findElement(By.xpath(LocatorsTasks.checkboxInfinity));

        //kiểm tra giá tri mặc định của input
        boolean isDisplayedInputCurrent = inputTotalCycles.isDisplayed();
        System.out.println("Input được hiển thị (Mặc định): "+isDisplayedInputCurrent);

        //gọi hàm dropdown no search
        dropdownNoSearch(LocatorsTasks.dropdownRepeatEvery, LocatorsTasks.getValueRepeatEvery("Week"));
        Thread.sleep(500);

        //kiểm tra lại nếu dropdown đấy đã chọn dữ liệu thì input ẩn kia có hiện lên và thao tác được không
        boolean isDisplayedInputNow = inputTotalCycles.isDisplayed();
        System.out.println("Input được hiển thị: "+isDisplayedInputNow);

        //Kiểm tra giá trị mặc định của checkbox infinity
        boolean isSelectedInfinity = chbInfinity.isSelected();
        System.out.println("Checkbox Infinity đuợc chọn (mặc định): " + isSelectedInfinity);

        //Kiểm tra input Total thao tác được
        if (isSelectedInfinity){
            boolean isEnableInputCurrent = inputTotalCycles.isEnabled();
            System.out.println("Input cho phép thao tác: "+isEnableInputCurrent);
        }

        //click lần 2 (bỏ chọn)
        chbInfinity.click();

        //Kiểm tra sau khi bỏ chọn checkbox thì cho phép thao tác nhập không
        boolean isEnableInputNow = inputTotalCycles.isEnabled();
        System.out.println("Input cho phép thao tác: "+isEnableInputNow);
        if (isEnableInputNow) {
            inputTotalCycles.clear();
            inputTotalCycles.sendKeys("100000"); //kh biết nhập số 0
        }
        Thread.sleep(500);
    }

    //dropdown Related To and dropdown value of Related to
    public static void dropdownRelatedToAndDropdownValue() throws InterruptedException {
        //Kiểm tra hiển thị mặc định
        boolean isDisplayDropdownValue = driver.findElement(By.xpath(LocatorsTasks.dropdownForRelatedTo)).isDisplayed();
        System.out.println("Dropdown value RelatedTo hiển thị (Mặc định): "+isDisplayDropdownValue);

        //Click vô hàm RelatedTo chọn giá trị
        dropdownNoSearch(LocatorsTasks.dropdownRelatedTo, LocatorsTasks.getValueRelatedTo("Lead"));

        //Kiểm tra hiển thị sau khi chọn Related to
        boolean isDisplayDropdownValueNew = driver.findElement(By.xpath(LocatorsTasks.dropdownForRelatedTo)).isDisplayed();
        System.out.println("Dropdown value RelatedTo hiển thị: "+isDisplayDropdownValueNew);

        //dropdown valueDropdown Related to
        dropdownSearch(LocatorsTasks.dropdownForRelatedTo, LocatorsTasks.inputSearchOfForRelatedTo, "Giang", LocatorsTasks.getValueForRelatedTo("GiangTest 02 - giang12345@gmail.com"));

    }

    public static void addNewTask(String taskName) throws InterruptedException {
        //Checkbox public
        handleCheckbox(LocatorsTasks.checkboxPublic);
        //Checkbox Billsble
        handleCheckbox(LocatorsTasks.checkboxBillsble);
        //check attachment
        chkDisplayAttachfile();
        //sendKeys input
        driver.findElement(By.xpath(LocatorsTasks.inputSubject)).sendKeys(taskName);
        driver.findElement(By.xpath(LocatorsTasks.inputHourlyRate)).clear();
        driver.findElement(By.xpath(LocatorsTasks.inputHourlyRate)).sendKeys("24");
        driver.findElement(By.xpath(LocatorsTasks.inputStartDate)).clear();
        driver.findElement(By.xpath(LocatorsTasks.inputStartDate)).sendKeys("20-10-2025");
        driver.findElement(By.xpath(LocatorsTasks.inputStartDate)).click();
        Thread.sleep(500);
        driver.findElement(By.xpath(LocatorsTasks.inputDuaDate)).sendKeys("05-11-2025");
        driver.findElement(By.xpath(LocatorsTasks.inputDuaDate)).click();

        //dropdown Priority
        dropdownNoSearch(LocatorsTasks.dropdownPriority, LocatorsTasks.getValuePriority("High"));

        //dropdown Repeat every and input Total cycle
        chkDropdownRepeatAndTotalCycles();

        //dropdown Related to and dropdown value related to
        dropdownRelatedToAndDropdownValue();

        //dropdown Assignees
        dropdownSearchMuti(
                LocatorsTasks.dropdownAssignees,
                LocatorsTasks.inputSearchOffAssignees,
                "Admin Anh",
                LocatorsTasks.getValueAssignees("Admin Anh Tester"),
                LocatorsTasks.inputSearchOffAssignees,
                "Admin Ex",
                LocatorsTasks.getValueAssignees("Admin Example")
        );

        //dropdown Followers
        dropdownSearchMuti(
                LocatorsTasks.dropdownFollowers,
                LocatorsTasks.inputSearchOffFollowers,
                "Admin Ex",
                LocatorsTasks.getValueFollowers("Admin Example"),
                LocatorsTasks.inputSearchOffFollowers,
                "Admin Anh",
                LocatorsTasks.getValueFollowers("Admin Anh Tester")
        );

        //Tags
        driver.findElement(By.xpath(LocatorsTasks.inputAddTags)).sendKeys("Giangh");
        driver.findElement(By.xpath(LocatorsTasks.labelTags)).click();

//        driver.findElement(By.xpath(LocatorsTasks.textareaTaskDescription)).click();
//        driver.findElement(By.xpath(LocatorsTasks.textareaTaskDescription)).sendKeys("Giang");
        driver.findElement(By.xpath(LocatorsTasks.btnSave)).click();
        Thread.sleep(1000);
    }


    public static void main(String[] args) throws InterruptedException {
        createDriver();
        loginCRM();
        Thread.sleep(1000);

        driver.findElement(By.xpath(LocatorsTasks.menuTasks)).click();
        driver.findElement(By.xpath(LocatorsTasks.btnAddTasks)).click();
        Thread.sleep(1000);

        addNewTask("GTest1");
        Thread.sleep(1000);

        closeDriver();
    }

}
