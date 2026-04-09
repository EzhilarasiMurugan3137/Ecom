package utils;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import base.BaseClass;

public class MyListenerClass implements ITestListener {

	ExtentReports extent = ExtentReportNG.getInstance();
	ExtentTest test;
	WebDriver driver;

	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		System.out.println("Started: " + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Case Passed: " + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Failed: " + result.getName());
		test.log(Status.FAIL, "Test Case Failed: " + result.getName());
		test.fail(result.getThrowable());

		try {
			Object testInstance = result.getInstance();
			Class<?> clazz = result.getTestClass().getRealClass();
			driver = (WebDriver) clazz.getField("driver").get(testInstance);

			String screenshotPath = ((BaseClass) testInstance).captureScreenshot(result.getName());

			test.addScreenCaptureFromPath(screenshotPath);

		} catch (Exception e) {
			System.out.println("Exception while taking screenshot in Listener: " + e.getMessage());
		}
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		System.out.println("Suite execution finished. Report generated.");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		test.log(Status.SKIP, "Test Case Skipped: " + result.getName());
	}
}