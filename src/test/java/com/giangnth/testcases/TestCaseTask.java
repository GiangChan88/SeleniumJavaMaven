package com.giangnth.testcases;

import com.giangnth.pages.DashboardPage;
import com.giangnth.pages.LoginPage;
import keywords.WebUI;
import com.giangnth.pages.TasksPage;
import common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TestCaseTask extends BaseTest {
    String taskName = "";
    String hourlyRate = "";
    String startDate = "";
    String duaDate = "";
    String priority = "";
    String repeatEvery = "";
    String totalCycles = "";
    String relatedTo = "";
    String searchValueRelatedTo = "";
    String valueRelatedTo = "";
    String assignees = "";
    String assignees2 = "";
    String followers = "";
    String followers2 = "";
    String tags = "";
    String bodyIframeDescription = "";

    private LoginPage loginPage;
    private TasksPage tasksPage;
    private DashboardPage dashboardPage;


    @Test(priority = 1)
    public void testAddNewTask() {
        TestCaseTask tasks = new TestCaseTask();
        tasks.taskName = "GTest2111";
        tasks.hourlyRate = "24";
        tasks.startDate = "20-10-2025";
        tasks.duaDate = "05-11-2025";
        tasks.priority = "High";
        tasks.repeatEvery = "Week";
        tasks.totalCycles = "100000";
        tasks.relatedTo = "Lead";
        tasks.searchValueRelatedTo = "Giang Chan";
        tasks.valueRelatedTo = "Giang Chan - giang08@gmail.com";
        tasks.assignees = "Admin Anh Tester";
        tasks.assignees2 = "Admin Example";
        tasks.followers = "Admin Example";
        tasks.followers2 = "Admin Anh Tester";
        tasks.tags = "Giang";
        tasks.bodyIframeDescription = "Giang Add Tasks";
        WebUI.threadSleep(1);

        //click menu Task
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM();
        tasksPage = dashboardPage.clickMenuTask();
        tasksPage.verifyMenuTask();

        //click btn Add Task
        tasksPage.clickBtnAddTask();
        tasksPage.verifyBtnAddTask();

        tasksPage.addNewTask(tasks.taskName, tasks.hourlyRate, tasks.startDate, tasks.duaDate, tasks.priority, tasks.repeatEvery, tasks.totalCycles, tasks.relatedTo, tasks.searchValueRelatedTo, tasks.valueRelatedTo, tasks.assignees, tasks.assignees2, tasks.followers, tasks.followers2, tasks.tags, tasks.bodyIframeDescription);
        WebUI.threadSleep(2);

        tasksPage.closePopupDetail();
        WebUI.threadSleep(1);

        //verify
        tasksPage.searchTaskSuccess(tasks.taskName);
    }

    @Test(priority = 2)
    public void testViewEditTaskSuccess() {
        TestCaseTask tasks = new TestCaseTask();
        tasks.taskName = "GTest3";
        tasks.hourlyRate = "24";
        tasks.startDate = "20-10-2025";
        tasks.duaDate = "05-11-2025";
        tasks.priority = "High";
        tasks.repeatEvery = "Week";
        tasks.totalCycles = "100000";
        tasks.relatedTo = "Lead";
        tasks.searchValueRelatedTo = "Giang Chan";
        tasks.valueRelatedTo = "Giang Chan - giang08@gmail.com";
        tasks.assignees = "Admin Anh Tester";
        tasks.assignees2 = "Admin Example";
        tasks.followers = "Admin Example";
        tasks.followers2 = "Admin Anh Tester";
        tasks.tags = "Giang";
        tasks.bodyIframeDescription = "Giang Add Tasks2";
        WebUI.threadSleep(1);

        //click menu Task
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM();
        tasksPage = dashboardPage.clickMenuTask();
        tasksPage.verifyMenuTask();

        //click btn Add Task
        tasksPage.clickBtnAddTask();
        tasksPage.verifyBtnAddTask();

        tasksPage.addNewTask(tasks.taskName, tasks.hourlyRate, tasks.startDate, tasks.duaDate, tasks.priority, tasks.repeatEvery, tasks.totalCycles, tasks.relatedTo, tasks.searchValueRelatedTo, tasks.valueRelatedTo, tasks.assignees, tasks.assignees2, tasks.followers, tasks.followers2, tasks.tags, tasks.bodyIframeDescription);
        WebUI.threadSleep(2);

        tasksPage.closePopupDetail();
        WebUI.threadSleep(1);

        //verify
        tasksPage.searchTaskSuccess(tasks.taskName);

        //click btn edit
        tasksPage.clickBtnEdit(tasks.taskName);

        tasksPage.viewEditTaskSuccess(tasks.taskName, tasks.hourlyRate +".00", tasks.startDate, tasks.duaDate, tasks.priority, tasks.repeatEvery, tasks.totalCycles, tasks.relatedTo, tasks.valueRelatedTo, tasks.tags, tasks.bodyIframeDescription);
    }

    @Test(priority = 3)
    public void testEditTaskSuccess() {
        //Data Add
        TestCaseTask tasks = new TestCaseTask();
        tasks.taskName = "GTest111";
        tasks.hourlyRate = "24";
        tasks.startDate = "20-10-2025";
        tasks.duaDate = "05-11-2025";
        tasks.priority = "High";
        tasks.repeatEvery = "Week";
        tasks.totalCycles = "100000";
        tasks.relatedTo = "Lead";
        tasks.searchValueRelatedTo = "Giang Chan";
        tasks.valueRelatedTo = "Giang Chan - giang08@gmail.com";
        tasks.assignees = "Admin Anh Tester";
        tasks.assignees2 = "Admin Example";
        tasks.followers = "Admin Example";
        tasks.followers2 = "Admin Anh Tester";
        tasks.tags = "Giang";
        tasks.bodyIframeDescription = "Giang Add Tasks2";

        //click menu Task
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM();
        tasksPage = dashboardPage.clickMenuTask();
        tasksPage.verifyMenuTask();

        //click btn Add Task
        tasksPage.clickBtnAddTask();
        tasksPage.verifyBtnAddTask();

        //Tạo data
        tasksPage.addNewTask(tasks.taskName, tasks.hourlyRate, tasks.startDate, tasks.duaDate, tasks.priority, tasks.repeatEvery, tasks.totalCycles, tasks.relatedTo, tasks.searchValueRelatedTo, tasks.valueRelatedTo, tasks.assignees, tasks.assignees2, tasks.followers, tasks.followers2, tasks.tags, tasks.bodyIframeDescription);
        WebUI.threadSleep(2);

        tasksPage.closePopupDetail();
        WebUI.threadSleep(1);

        //verify
        tasksPage.searchTaskSuccess(tasks.taskName);
        WebUI.threadSleep(2);

        //Edit Lead
        tasksPage.clickBtnEdit(tasks.taskName);

        //Data Update
        tasks.duaDate = "21-12-2025";
        tasks.priority = "Low";
        tasks.totalCycles = "6666";
        tasks.tags = "Giang12";
        tasks.bodyIframeDescription = "Giang Update Tasks";

        tasksPage.editTaskSuccess(tasks.hourlyRate, tasks.startDate, tasks.duaDate, tasks.priority, tasks.repeatEvery, tasks.totalCycles, tasks.relatedTo, tasks.searchValueRelatedTo, tasks.valueRelatedTo, tasks.tags, tasks.bodyIframeDescription);
        WebUI.threadSleep(1);

        tasksPage.closePopupDetail();
        WebUI.threadSleep(1);

        //verifyLeadAddNew
        tasksPage.searchTaskSuccess(tasks.taskName);
        WebUI.threadSleep(1);

        //verify edit
        tasksPage.clickBtnEdit(tasks.taskName);
        tasksPage.viewEditTaskSuccess(tasks.taskName, tasks.hourlyRate +".00", tasks.startDate, tasks.duaDate, tasks.priority, tasks.repeatEvery, tasks.totalCycles, tasks.relatedTo, tasks.valueRelatedTo, tasks.tags, tasks.bodyIframeDescription);
    }

}
