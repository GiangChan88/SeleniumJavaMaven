package common;

import com.giangnth.pages.DashboardPage;
import com.giangnth.pages.LeadsPage;
import com.giangnth.pages.TasksPage;
import keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class BasePage {
    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public By menuDashboard = By.xpath("//ul[@id='side-menu']//span[@class = 'menu-text' and normalize-space() = 'Dashboard']");
    public By menuProject = By.xpath("//ul[@id='side-menu']//span[@class = 'menu-text' and normalize-space() = 'Projects']");
    public By menuLeads = By.xpath("//span[@class = 'menu-text' and normalize-space() = 'Leads']");
    public By menuTasks = By.xpath("//span[normalize-space()='Tasks']");

    public DashboardPage clickMenuDashboard(){
        WebUI.clickElement(driver, menuDashboard);
        System.out.println("Click menu Dashboard");
        return new DashboardPage(driver);
    }

    public void clickMenuProjects(){
        WebUI.clickElement(driver, menuProject);
    }

    public LeadsPage clickMenuLead() {
        //click menu Lead
        WebUI.clickElement(driver, menuLeads);
        System.out.println("Click Lead Menu");
        return new LeadsPage(driver, BaseTest.softAssert);
    }

    public TasksPage clickMenuTask() {
        //click menu Lead
        WebUI.clickElement(driver, menuTasks);
        System.out.println("Click menu Task");
        return new TasksPage(driver, BaseTest.softAssert);
    }


}
