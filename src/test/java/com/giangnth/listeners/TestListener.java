package com.giangnth.listeners;

import com.aventstack.extentreports.Status;
import com.giangnth.helpers.CaptureHelper;
import com.giangnth.report.ExtentReportManager;
import com.giangnth.report.ExtentTestManager;
import com.giangnth.utils.LogUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    public String getTestName(ITestResult result) {
        return result.getTestName() != null ? result.getTestName() : result.getMethod().getConstructorOrMethod().getName();
    }

    public String getTestDescription(ITestResult result) {
        return result.getMethod().getDescription() != null ? result.getMethod().getDescription() : getTestName(result);
    }

    //Chạy 1 lần
    @Override
    public void onStart(ITestContext result) {
        LogUtils.info("Setup môi trường onStart: " + result.getStartDate());
        //Initialize report
        //connect to database
        //call api get token
    }

    //Chạy 1 lần
    @Override
    public void onFinish(ITestContext result) {
        LogUtils.info("Kết thúc bộ test: " + result.getEndDate());

        //Kết thúc và thực thi Extents report
        ExtentReportManager.getExtentReports().flush();
    }

    //Chạy tương ứng với 1 testcase được gọi
    @Override
    public void onTestStart(ITestResult result) {
        LogUtils.info("Bắt đầu chạy test case: " + result.getName());

        //Bắt đầu ghi 1 TCs mới vào Extent Report
        ExtentTestManager.saveToReport(getTestName(result), getTestDescription(result));

        //CaptureHelper.startRecord(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LogUtils.info("Test case " + result.getName() + " is passed.");
        LogUtils.info("==> Status: " + result.getStatus());

        //Extent Report
        ExtentTestManager.logMessage(Status.PASS, result.getName() + " is passed.");

        //CaptureHelper.stopRecord();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LogUtils.error("Test case " + result.getName() + " is failed.");
        LogUtils.error("==> Lý do lỗi: " + result.getThrowable());
        //chụp ảnh khi case fail
        CaptureHelper.takeScreenShot(result.getName());
        //create ticket on Jira

        //Extent Report
        ExtentTestManager.addScreenshot(result.getName());
        ExtentTestManager.logMessage(Status.FAIL, result.getThrowable().toString());
        ExtentTestManager.logMessage(Status.FAIL, result.getName() + " is failed.");

        //CaptureHelper.stopRecord();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LogUtils.warn("Test case " + result.getName() + " is skipped.");

        //Extent Report
        ExtentTestManager.logMessage(Status.SKIP, result.getThrowable().toString());
        ExtentTestManager.logMessage(Status.SKIP, result.getName() + " is skipped.");

        //CaptureHelper.stopRecord();
    }
}
