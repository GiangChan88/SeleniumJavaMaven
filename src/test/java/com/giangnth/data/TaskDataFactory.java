package com.giangnth.data;

import com.giangnth.helpers.ExcelHelper;
import com.giangnth.models.LeadDTO;
import com.giangnth.models.TaskDTO;

public class TaskDataFactory {
    //Get 1 dòng data trong file excel được chỉ định
    public static TaskDTO getTaskDataFromExcel(int rowIndex) {

        ExcelHelper excel = new ExcelHelper();
        excel.setExcelFile("src/test/resources/testdata/DataCRM.xlsx", "Task");

        TaskDTO task = new TaskDTO();
        task.setTaskName(excel.getCellData("TaskName", rowIndex));
        task.setHourlyRate(excel.getCellData("HourlyRate", rowIndex));
        task.setStartDate(excel.getCellData("StartDate", rowIndex));
        task.setDuaDate(excel.getCellData("DuaDate", rowIndex));
        task.setTags(excel.getCellData("Tags", rowIndex));
        task.setPriority(excel.getCellData("Priority", rowIndex));
        task.setRepeatEvery(excel.getCellData("RepeatEvery", rowIndex));
        task.setTotalCycles(excel.getCellData("TotalCycles", rowIndex));
        task.setRelatedTo(excel.getCellData("RelatedTo", rowIndex));
        task.setSearchValueRelatedTo(excel.getCellData("SearchValueRelatedTo", rowIndex));
        task.setValueRelatedTo(excel.getCellData("ValueRelatedTo", rowIndex));
        task.setAssignees(excel.getCellData("Assignees", rowIndex));
        task.setAssignees2(excel.getCellData("Assignees2", rowIndex));
        task.setFollowers(excel.getCellData("Followers", rowIndex));
        task.setFollowers2(excel.getCellData("Followers2", rowIndex));
        task.setTags(excel.getCellData("Tags", rowIndex));
        task.setBodyIframeDescription(excel.getCellData("BodyIframeDescription", rowIndex));
        task.setTypeConfirm(Integer.parseInt(excel.getCellData("TypeConfirm", rowIndex)));

        return task;
    }
}
