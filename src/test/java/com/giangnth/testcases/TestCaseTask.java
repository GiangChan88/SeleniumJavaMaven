package com.giangnth.testcases;

import com.giangnth.data.LeadDataFactory;
import com.giangnth.data.TaskDataFactory;
import com.giangnth.models.LeadDTO;
import com.giangnth.models.TaskDTO;
import com.giangnth.pages.DashboardPage;
import com.giangnth.pages.LeadsPage;
import com.giangnth.pages.LoginPage;
import com.giangnth.keywords.WebUI;
import com.giangnth.pages.TasksPage;
import com.giangnth.common.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

@Epic("CRM version 1.0")
@Feature("Task feature")
public class TestCaseTask extends BaseTest {

    private LoginPage loginPage;
    private TasksPage tasksPage;
    private DashboardPage dashboardPage;
    private LeadsPage leadsPage;

    @Test(priority = 1)
    public void testAddNewTask() {
        TestCaseTask tasks = new TestCaseTask();
        TaskDTO taskDataAdd = TaskDataFactory.getTaskDataFromExcel(1);

        //click menu Task
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM();
        tasksPage = dashboardPage.clickMenuTask();
        tasksPage.verifyMenuTask();

        //click btn Add Task
        tasksPage.clickBtnAddTask();
        tasksPage.verifyBtnAddTask();

        tasksPage.addNewTask(taskDataAdd);
        tasksPage.closePopupDetail();

        //verify
        tasksPage.searchTaskSuccess(taskDataAdd.getTaskName());
        tasksPage.verifySearchTaskSuccess(taskDataAdd.getTaskName());
    }

    @Test(priority = 2)
    public void testViewEditTaskSuccess() {
        TestCaseTask tasks = new TestCaseTask();
        TaskDTO taskDataAdd = TaskDataFactory.getTaskDataFromExcel(2);

        //click menu Task
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM();
        tasksPage = dashboardPage.clickMenuTask();
        tasksPage.verifyMenuTask();

        //click btn Add Task
        tasksPage.clickBtnAddTask();
        tasksPage.verifyBtnAddTask();

        tasksPage.addNewTask(taskDataAdd);

        tasksPage.closePopupDetail();

        //verify
        tasksPage.searchTaskSuccess(taskDataAdd.getTaskName());
        tasksPage.verifySearchTaskSuccess(taskDataAdd.getTaskName());

        //click btn edit
        tasksPage.clickBtnEdit(taskDataAdd.getTaskName());
        tasksPage.verifyClickBtnEdit(taskDataAdd.getTaskName());

        tasksPage.viewEditTaskSuccess(taskDataAdd);
    }

    @Test(priority = 3)
    public void testEditTaskSuccess() {
        //Data Add
        TestCaseTask tasks = new TestCaseTask();
        TaskDTO taskDataAdd = TaskDataFactory.getTaskDataFromExcel(3);

        //click menu Task
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM();
        tasksPage = dashboardPage.clickMenuTask();
        tasksPage.verifyMenuTask();

        //click btn Add Task
        tasksPage.clickBtnAddTask();
        tasksPage.verifyBtnAddTask();

        //Tạo data
        tasksPage.addNewTask(taskDataAdd);

        tasksPage.closePopupDetail();

        //verify
        tasksPage.searchTaskSuccess(taskDataAdd.getTaskName());
        tasksPage.verifySearchTaskSuccess(taskDataAdd.getTaskName());

        //Edit Lead
        tasksPage.clickBtnEdit(taskDataAdd.getTaskName());
        tasksPage.verifyClickBtnEdit(taskDataAdd.getTaskName());

        TaskDTO taskDataEdit = TaskDataFactory.getTaskDataFromExcel(4);

        tasksPage.editTaskSuccess(taskDataEdit);

        tasksPage.closePopupDetail();

        //verifyLeadAddNew
        tasksPage.searchTaskSuccess(taskDataEdit.getTaskName());
        tasksPage.verifySearchTaskSuccess(taskDataEdit.getTaskName());

        //verify edit
        tasksPage.clickBtnEdit(taskDataEdit.getTaskName());
        tasksPage.verifyClickBtnEdit(taskDataEdit.getTaskName());

        tasksPage.viewEditTaskSuccess(taskDataEdit);
    }

    @Test(priority = 1)
    public void testDeleteSuccessTask() {
        TestCaseTask tasks = new TestCaseTask();
        TaskDTO taskDataAdd = TaskDataFactory.getTaskDataFromExcel(5);

        //click menu Task
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM();
        tasksPage = dashboardPage.clickMenuTask();
        tasksPage.verifyMenuTask();

        //click btn Add Task
        tasksPage.clickBtnAddTask();
        tasksPage.verifyBtnAddTask();

        tasksPage.addNewTask(taskDataAdd);

        tasksPage.closePopupDetail();

        //verify
        tasksPage.searchTaskSuccess(taskDataAdd.getTaskName());
        tasksPage.verifySearchTaskSuccess(taskDataAdd.getTaskName());

        //click btn delete
        tasksPage.clickBtnDeleteTask(taskDataAdd.getTaskName());
        tasksPage.confirmDeleteTask(taskDataAdd.getTypeConfirm());//1 là xóa

        //Verify Deleted
        tasksPage.verifyDeleteSuccessMessage(taskDataAdd.getTypeConfirm());//1 là hiển thị message xóa thành công
        tasksPage.verifyAfterDeleteTask(taskDataAdd.getTaskName(), taskDataAdd.getTypeConfirm()); //tìm kiếm lại sau khi xóa
    }

    @Test
    public void testAddLeadAddTask() {
        //Data Add
        TestCaseLead lead = new TestCaseLead();
        LeadDTO leadDataAdd = LeadDataFactory.getLeadDataFromExcel(8);

        //click menu Lead
        loginPage = new LoginPage();

        dashboardPage = loginPage.loginCRM();
        leadsPage = dashboardPage.clickMenuLead();
        leadsPage.verifyMenuLead();

        //click btn addnewLead
        leadsPage.clickBtnAddNewLead();
        leadsPage.verifyBtnAddNewLead();

        //Tạo data
        leadsPage.addAndEditLeadSuccess(leadDataAdd);

        leadsPage.closePopupDetail();

        //verifyLeadAddNew
        leadsPage.searchLeadSuccess(leadDataAdd.getLeadName());
        leadsPage.verifySearchLeadSuccess(leadDataAdd.getLeadName());

        //click btn edit
        leadsPage.clickBtnEdit(leadDataAdd.getLeadName());

        LeadDTO leadDataEdit = LeadDataFactory.getLeadDataFromExcel(9);
        //Edit Lead
        leadsPage.addAndEditLeadSuccess(leadDataEdit);
        leadsPage.closePopupDetail();

        //verifyLeadAddNew
        leadsPage.searchLeadSuccess(leadDataEdit.getLeadName());
        leadsPage.verifySearchLeadSuccess(leadDataEdit.getLeadName());

        //verify edit
        leadsPage.clickBtnEdit(leadDataEdit.getLeadName());
        leadsPage.viewEditLead(leadDataEdit);
        leadsPage.closePopupDetail();

        //click menuTask
        tasksPage = leadsPage.clickMenuTask();
        tasksPage.verifyMenuTask();

        //click btn Add Task
        tasksPage.clickBtnAddTask();
        tasksPage.verifyBtnAddTask();

        //data add task
        TestCaseTask tasks = new TestCaseTask();
        TaskDTO taskDataAdd = TaskDataFactory.getTaskDataFromExcel(6);

        taskDataAdd.setSearchValueRelatedTo(leadDataEdit.getLeadName());
        taskDataAdd.setValueRelatedTo(leadDataEdit.getLeadName() + " - " + leadDataEdit.getEmailAddress());

        //add task
        tasksPage.addNewTask(taskDataAdd);

        tasksPage.closePopupDetail();

        //verify
        tasksPage.searchTaskSuccess(taskDataAdd.getTaskName());
        tasksPage.verifySearchTaskSuccess(taskDataAdd.getTaskName());

        //Edit Lead
        tasksPage.clickBtnEdit(taskDataAdd.getTaskName());
        tasksPage.verifyClickBtnEdit(taskDataAdd.getTaskName());

        TaskDTO taskDataEdit = TaskDataFactory.getTaskDataFromExcel(7);

        tasksPage.editTaskSuccess(taskDataEdit);

        tasksPage.closePopupDetail();

        //verifyLeadAddNew
        tasksPage.searchTaskSuccess(taskDataEdit.getTaskName());
        tasksPage.verifySearchTaskSuccess(taskDataEdit.getTaskName());

        //verify edit
        tasksPage.clickBtnEdit(taskDataEdit.getTaskName());
        tasksPage.verifyClickBtnEdit(taskDataEdit.getTaskName());

        tasksPage.viewEditTaskSuccess(taskDataEdit);
    }

}
