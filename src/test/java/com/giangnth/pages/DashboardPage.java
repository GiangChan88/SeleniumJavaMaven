package com.giangnth.pages;

import common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DashboardPage extends BasePage {
    private WebDriver driver;

    public DashboardPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private By btnDashboardOption = By.xpath("//dic[@class='screen-options-btn']");

    public void verifyDashboardPageDisplayed(){
        boolean checkMenuDashboard = driver.findElements(btnDashboardOption).size()>0;
        Assert.assertTrue(checkMenuDashboard, "Login Failed or DashBoard not displayed");
    }
}
