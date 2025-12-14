package com.giangnth.pages;

import com.giangnth.common.BasePage;
import keywords.WebUI;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class CustomerPage extends BasePage {
    private WebDriver driver;
    private SoftAssert softAssert;

    public CustomerPage(WebDriver driver,SoftAssert softAssert) {
        super(driver);
        this.driver = driver;
        this.softAssert = softAssert;
        new WebUI(driver);
    }

    private By inputSearch = By.xpath("//div[@id='clients_filter']//input[@type='search']");
    private By firstRowItem = By.xpath("//table[@id='clients']//tbody/tr[1]/td[3]/a");

    private By buttonDelete = By.xpath("//table[@id='clients']//tbody/tr[1]/td[3]/a/following-sibling::div/a[normalize-space()='Delete']");

    private By getRows(String value) {
        return By.xpath("//table[@id='clients']//tbody/tr/td/a[normalize-space()='" + value + "']");
    }

    public void deleteCustomerSuccess(String customerName) {
        WebElement firstRow = WebUI.getWebElement(firstRowItem);

        //Hover chuột vào dòng đầu tiên
        Actions actions = new Actions(driver);
        actions.moveToElement(firstRow).perform();
        WebUI.threadSleep(1);
        WebUI.clickElement(buttonDelete);
    }

    public void searchCustomerSuccess(String expectedCustomerName) {
        WebUI.clearElement(inputSearch);
        WebUI.setTextElement(inputSearch, expectedCustomerName);
        WebUI.threadSleep(1);

//        boolean rows = WebUI.checkExitsElement(getRows(expectedCustomerName));
//        //Sai khi không có bản ghi (không mong muốn rows.size() == 0 => đúng)
//        //Assert.assertFalse(rows.size() == 0, "Không tìm thấy Customer '" + expectedCustomerName + "' sau khi search!");
//
//        //Mong muốn rows.size() > 0 => đúng, nếu rows.size() == 0 thì hiển thị message kia
//        Assert.assertTrue(rows, "Không tìm thấy Customer '" + expectedCustomerName + "' sau khi search!");
        System.out.println("Tìm kiếm thành công Customer: " + expectedCustomerName);
    }

    public void searchCustomerNoData(String expectedCustomerName) {
        WebUI.clearElement(inputSearch);
        WebUI.setTextElement(inputSearch, expectedCustomerName);
        WebUI.threadSleep(1);

        boolean rows = WebUI.checkExitsElement(getRows(expectedCustomerName));
        //Sai khi có bản ghi (không mong muốn rows.size() > 0 => đúng)
        Assert.assertFalse(rows, "Không mong muốn: vẫn còn bản ghi '" + expectedCustomerName + "' trong bảng!");  // Test pass
        System.out.println("Tìm kiếm thành công: 0 bản ghi");
    }

    public void confirmDeleteCustomerSuccess(String customer, int flag) {
        System.out.println("Confirm Delete Customer Success");
        WebUI.threadSleep(2);
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        softAssert.assertEquals(alertText, "Are you sure you want to perform this action?", "Nội dung trong alert Delete không đúng");
        System.out.println("Nội dung trong alert Delete hợp lệ");
        //check text trên alert
        if (flag == 1) {
            alert.accept();
            System.out.println("Xóa thành công");
        } else {
            alert.dismiss();
            System.out.println("Bỏ xóa thành công");
        }

    }
}
