package com.giangnth.listeners;

import com.giangnth.helpers.CaptureHelper;
import com.giangnth.utils.LogUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

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
        //generate report
        //send email
    }

    //Chạy tương ứng với 1 testcase được gọi
    @Override
    public void onTestStart(ITestResult result) {
        LogUtils.info("Bắt đầu chạy test case: " + result.getName());
        //count_total++;
        //Write log to file

        //CaptureHelper.startRecord(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LogUtils.info("Test case " + result.getName() + " is passed.");
        LogUtils.info("==> Status: " + result.getStatus());
        //count_passed++;
        //Write log to file
        //Write status to report

        //CaptureHelper.stopRecord();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LogUtils.error("Test case " + result.getName() + " is failed.");
        //count_failed++;
        LogUtils.error("==> Lý do lỗi: " + result.getThrowable());
        //chụp ảnh khi case fail
        CaptureHelper.takeScreenShot(result.getName());
        //create ticket on Jira
        //Write log to file
        //Write status to report

        //CaptureHelper.stopRecord();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LogUtils.warn("Test case " + result.getName() + " is skipped.");
        //Write log to file
        //Write status to report

        //CaptureHelper.stopRecord();
    }
}
