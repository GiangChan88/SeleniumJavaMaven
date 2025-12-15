package com.giangnth.pages;

import com.giangnth.common.BasePage;
import com.giangnth.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DashboardPage extends BasePage {
    private By btnDashboardOption = By.xpath("//div[@class='screen-options-btn']");
    private By convertedLeads = By.xpath("(//span[normalize-space()='Converted Leads']/parent::div)/following-sibling::span");

    private LeadsPage leadsPage;

    public String getTextTotalConvertedLeads() {
        String totalConvertedLeadsText = WebUI.getElementText(convertedLeads);
        return totalConvertedLeadsText;
    }

    public void verifyDashboardPageDisplayed(){
        WebUI.threadSleep(1);
        boolean checkMenuDashboard = WebUI.checkExitsElement(btnDashboardOption);;
        Assert.assertTrue(checkMenuDashboard, "Login Failed or DashBoard not displayed");
    }
}
