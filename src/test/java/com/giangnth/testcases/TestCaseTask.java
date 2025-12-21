package com.giangnth.testcases;

import com.giangnth.pages.DashboardPage;
import com.giangnth.pages.LeadsPage;
import com.giangnth.pages.LoginPage;
import com.giangnth.keywords.WebUI;
import com.giangnth.pages.TasksPage;
import com.giangnth.common.BaseTest;
import org.testng.annotations.Test;

public class TestCaseTask extends BaseTest {
    String taskName = "GiangTest";
    String hourlyRate = "24";
    String startDate = "20-10-2025";
    String duaDate = "05-11-2025";
    String priority = "High";
    String repeatEvery = "Week";
    String totalCycles = "100000";
    String relatedTo = "Lead";
    String searchValueRelatedTo = "Giang Chan";
    String valueRelatedTo = "Giang Chan - giang08@gmail.com";
    String assignees = "Admin Anh Tester";
    String assignees2 = "Admin Example";
    String followers = "Admin Example";
    String followers2 = "Admin Anh Tester";
    String tags = "Giang";
    String bodyIframeDescription = "Giang Add Tasks";

    private LoginPage loginPage;
    private TasksPage tasksPage;
    private DashboardPage dashboardPage;
    private LeadsPage leadsPage;


    @Test(priority = 1)
    public void testAddNewTask() {
        TestCaseTask tasks = new TestCaseTask();
        tasks.taskName = "GTest1";
        tasks.searchValueRelatedTo = "Giang Chan";
        tasks.valueRelatedTo = "Giang Chan - giang08@gmail.com";

        //click menu Task
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM();
        tasksPage = dashboardPage.clickMenuTask();
        tasksPage.verifyMenuTask();

        //click btn Add Task
        tasksPage.clickBtnAddTask();
        tasksPage.verifyBtnAddTask();

        tasksPage.addNewTask(tasks.taskName, tasks.hourlyRate, tasks.startDate, tasks.duaDate, tasks.priority, tasks.repeatEvery, tasks.totalCycles, tasks.relatedTo, tasks.searchValueRelatedTo, tasks.valueRelatedTo, tasks.assignees, tasks.assignees2, tasks.followers, tasks.followers2, tasks.tags, tasks.bodyIframeDescription);

        tasksPage.closePopupDetail();

        //verify
        tasksPage.searchTaskSuccess(tasks.taskName);
    }

    @Test(priority = 2)
    public void testViewEditTaskSuccess() {
        TestCaseTask tasks = new TestCaseTask();
        tasks.taskName = "GTestViewEdit";
        tasks.searchValueRelatedTo = "Giang Chan";
        tasks.valueRelatedTo = "Giang Chan - giang08@gmail.com";
        tasks.bodyIframeDescription = "Giang Add Tasks2";
        WebUI.threadSleep(1);

        //click menu Task
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM();
        tasksPage = dashboardPage.clickMenuTask();
        tasksPage.verifyMenuTask();

        //click btn Add Task
        tasksPage.clickBtnAddTask();
        tasksPage.verifyBtnAddTask();

        tasksPage.addNewTask(tasks.taskName, tasks.hourlyRate, tasks.startDate, tasks.duaDate, tasks.priority, tasks.repeatEvery, tasks.totalCycles, tasks.relatedTo, tasks.searchValueRelatedTo, tasks.valueRelatedTo, tasks.assignees, tasks.assignees2, tasks.followers, tasks.followers2, tasks.tags, tasks.bodyIframeDescription);

        tasksPage.closePopupDetail();

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
        tasks.taskName = "GTestEdit";
        tasks.searchValueRelatedTo = "Giang Chan";
        tasks.valueRelatedTo = "Giang Chan - giang08@gmail.com";

        //click menu Task
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM();
        tasksPage = dashboardPage.clickMenuTask();
        tasksPage.verifyMenuTask();

        //click btn Add Task
        tasksPage.clickBtnAddTask();
        tasksPage.verifyBtnAddTask();

        //Tạo data
        tasksPage.addNewTask(tasks.taskName, tasks.hourlyRate, tasks.startDate, tasks.duaDate, tasks.priority, tasks.repeatEvery, tasks.totalCycles, tasks.relatedTo, tasks.searchValueRelatedTo, tasks.valueRelatedTo, tasks.assignees, tasks.assignees2, tasks.followers, tasks.followers2, tasks.tags, tasks.bodyIframeDescription);

        tasksPage.closePopupDetail();

        //verify
        tasksPage.searchTaskSuccess(tasks.taskName);

        //Edit Lead
        tasksPage.clickBtnEdit(tasks.taskName);

        //Data Update
        tasks.duaDate = "21-12-2025";
        tasks.priority = "Low";
        tasks.totalCycles = "6666";
        tasks.tags = "Giang12";
        tasks.bodyIframeDescription = "Giang Update Tasks";

        tasksPage.editTaskSuccess(tasks.hourlyRate, tasks.startDate, tasks.duaDate, tasks.priority, tasks.repeatEvery, tasks.totalCycles, tasks.relatedTo, tasks.searchValueRelatedTo, tasks.valueRelatedTo, tasks.tags, tasks.bodyIframeDescription);

        tasksPage.closePopupDetail();

        //verifyLeadAddNew
        tasksPage.searchTaskSuccess(tasks.taskName);

        //verify edit
        tasksPage.clickBtnEdit(tasks.taskName);
        tasksPage.viewEditTaskSuccess(tasks.taskName, tasks.hourlyRate +".00", tasks.startDate, tasks.duaDate, tasks.priority, tasks.repeatEvery, tasks.totalCycles, tasks.relatedTo, tasks.valueRelatedTo, tasks.tags, tasks.bodyIframeDescription);
    }

    @Test
    public void testAddLeadAddTask() {
        //Data Add
        TestCaseLead lead = new TestCaseLead();

        lead.leadName = "Giang TestAddTask";
        lead.emailAddress = "giangtestaddtask@gmail.com";

        //click menu Lead
        loginPage = new LoginPage();

        dashboardPage = loginPage.loginCRM();
        leadsPage = dashboardPage.clickMenuLead();
        leadsPage.verifyMenuLead();

        //click btn addnewLead
        leadsPage.clickBtnAddNewLead();
        leadsPage.verifyBtnAddNewLead();

        //Tạo data
        leadsPage.addAndEditLeadSuccess(lead.status, lead.source, lead.assigned, lead.tags, lead.leadName, lead.address, lead.position, lead.city, lead.emailAddress, lead.state, lead.website, lead.country, lead.phone, lead.zipcode, lead.leadValue, lead.language, lead.company, lead.description, lead.dateContacted, 0);

        leadsPage.closePopupDetail();

        //verifyLeadAddNew
        leadsPage.searchLeadSuccess(lead.leadName);

        //click btn edit
        leadsPage.clickBtnEdit(lead.leadName);

        //Data Update
        lead.address = "231 Hoonag Mai, Hà Nội";
        lead.position = "Hoàng Mai";
        lead.city = "Hà Nội";
        lead.emailAddress = "giangestaddtaskEdit@gmail.com";
        lead.company = "VN";

        //Edit Lead
        leadsPage.addAndEditLeadSuccess(lead.status, lead.source, lead.assigned, lead.tags, lead.leadName, lead.address, lead.position, lead.city, lead.emailAddress, lead.state, lead.website, lead.country, lead.phone, lead.zipcode, lead.leadValue, lead.language, lead.company, lead.description, lead.dateContacted, 1);

        leadsPage.closePopupDetail();

        //verifyLeadAddNew
        leadsPage.searchLeadSuccess(lead.leadName);

        //verify edit
        leadsPage.clickBtnEdit(lead.leadName);
        leadsPage.viewEditLead(lead.status, lead.source, lead.assigned, lead.tags, lead.leadName, lead.address, lead.position, lead.city, lead.emailAddress, lead.state, lead.website, lead.country, lead.phone, lead.zipcode, lead.leadValue, lead.language, lead.company, lead.description, lead.dateContacted);

        leadsPage.closePopupDetail();

        //click menuTask
        tasksPage = leadsPage.clickMenuTask();
        tasksPage.verifyMenuTask();

        //click btn Add Task
        tasksPage.clickBtnAddTask();
        tasksPage.verifyBtnAddTask();

        //data add task
        TestCaseTask tasks = new TestCaseTask();
        tasks.taskName = "GTestAddLeadAddTask";
        tasks.bodyIframeDescription = "Giang Add Tasks2";
        tasks.searchValueRelatedTo = lead.leadName;
        tasks.valueRelatedTo = lead.leadName + " - " + lead.emailAddress;

        //add task
        tasksPage.addNewTask(tasks.taskName, tasks.hourlyRate, tasks.startDate, tasks.duaDate, tasks.priority, tasks.repeatEvery, tasks.totalCycles, tasks.relatedTo, tasks.searchValueRelatedTo, tasks.valueRelatedTo, tasks.assignees, tasks.assignees2, tasks.followers, tasks.followers2, tasks.tags, tasks.bodyIframeDescription);

        tasksPage.closePopupDetail();

        //verify
        tasksPage.searchTaskSuccess(tasks.taskName);

        //Edit Lead
        tasksPage.clickBtnEdit(tasks.taskName);

        //Data Update
        tasks.duaDate = "21-12-2025";
        tasks.priority = "Low";
        tasks.totalCycles = "6666";
        tasks.tags = "Giang12";
        tasks.bodyIframeDescription = "Giang Update Tasks";

        tasksPage.editTaskSuccess(tasks.hourlyRate, tasks.startDate, tasks.duaDate, tasks.priority, tasks.repeatEvery, tasks.totalCycles, tasks.relatedTo, tasks.searchValueRelatedTo, tasks.valueRelatedTo, tasks.tags, tasks.bodyIframeDescription);

        tasksPage.closePopupDetail();

        //verifyLeadAddNew
        tasksPage.searchTaskSuccess(tasks.taskName);

        //verify edit
        tasksPage.clickBtnEdit(tasks.taskName);
        tasksPage.viewEditTaskSuccess(tasks.taskName, tasks.hourlyRate +".00", tasks.startDate, tasks.duaDate, tasks.priority, tasks.repeatEvery, tasks.totalCycles, tasks.relatedTo, tasks.valueRelatedTo, tasks.tags, tasks.bodyIframeDescription);

    }

}
