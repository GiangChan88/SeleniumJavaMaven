package com.giangnth.pages;

import common.BasePage;
import keywords.WebUI;
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
    private By convertedLeads = By.xpath("(//span[normalize-space()='Converted Leads']/parent::div)/following-sibling::span");

    private LeadsPage leadsPage;

    public String getTextTotalConvertedLeads() {
        String totalConvertedLeadsText = WebUI.getElementText(driver, convertedLeads);
        return totalConvertedLeadsText;
    }

    public void verifyDashboardPageDisplayed(){
        boolean checkMenuDashboard = driver.findElements(btnDashboardOption).size()>0;
        Assert.assertTrue(checkMenuDashboard, "Login Failed or DashBoard not displayed");
    }
}
