package com.giangnth.listeners;

import com.giangnth.helpers.CaptureHelper;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    //Chạy 1 lần
    @Override
    public void onStart(ITestContext result) {
        System.out.println("Setup môi trường onStart: " + result.getStartDate());
        //Initialize report
        //connect to database
        //call api get token
    }

    //Chạy 1 lần
    @Override
    public void onFinish(ITestContext result) {
        System.out.println("Kết thúc bộ test: " + result.getEndDate());
        //generate report
        //send email
    }

    //Chạy tương ứng với 1 testcase được gọi
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Bắt đầu chạy test case: " + result.getName());
        //count_total++;
        //Write log to file
        //CaptureHelper.startRecord(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test case " + result.getName() + " is passed.");
        System.out.println("==> Status: " + result.getStatus());
        //count_passed++;
        //Write log to file
        //Write status to report

        //CaptureHelper.stopRecord();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test case " + result.getName() + " is failed.");
        System.out.println("==> Status: " + result.getStatus());
        //count_failed++;
        System.out.println("==> Lý do lỗi: " + result.getThrowable());
        //chụp ảnh khi case fail
        CaptureHelper.takeScreenShot(result.getName());
        //create ticket on Jira
        //Write log to file
        //Write status to report

        //CaptureHelper.stopRecord();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test case " + result.getName() + " is skipped.");
        System.out.println("==> Status: " + result.getStatus());
        //Write log to file
        //Write status to report

        //CaptureHelper.stopRecord();
    }
}
