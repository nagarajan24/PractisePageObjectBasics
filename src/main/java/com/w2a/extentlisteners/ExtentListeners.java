package com.w2a.extentlisteners;

import java.util.Arrays;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.w2a.utilities.ScreenshotUtil;
import com.w2a.utilities.TestCaseRunMode;

public class ExtentListeners implements ITestListener {

	Date d = new Date();
	String extentReportFile = "Extent_" + d.toString().replace(" ", "_").replace(":", "_") + ".html";
	private ExtentReports extent = ExtentManager.configExtentReport(".//target//extentreports//" + extentReportFile);
	public static ExtentTest test;

	public void onTestStart(ITestResult result) {
		if (!TestCaseRunMode.getTestRunMode(result.getMethod().getMethodName())) {
			throw new SkipException("Skipping the test as run mode is set as NO");
		}

		test = extent
				.createTest(result.getTestClass().getName() + "--@TestCase--" + result.getMethod().getMethodName());

	}

	public void onTestSuccess(ITestResult result) {
		// Label
		String mtdName = "<b>" + "testcase: " + result.getMethod().getMethodName() + " passed</b>";
		Markup m = MarkupHelper.createLabel(mtdName, ExtentColor.GREEN);
		test.pass(m);

	}

	public void onTestFailure(ITestResult result) {

		// exception msg
		String expMsg = Arrays.toString(result.getThrowable().getStackTrace());
		test.fail(expMsg);

		// Screenshot
		ScreenshotUtil.captureScreenshot();
		String scrFileName = ScreenshotUtil.scrFile;

		// reportng
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log("<a href=" + scrFileName + " target=\"_blanks\">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<a href=" + scrFileName + " target=\"_blank\"><img src=" + scrFileName
				+ " width=200 height=200></img></a>");

		// extentreport
		test.fail("<b>Screenshot</b><br>",MediaEntityBuilder.createScreenCaptureFromPath(scrFileName).build());
		

		// Label
		String mtdName = "<b>" + "testcase: " + result.getMethod().getMethodName() + " failed</b>";
		Markup m = MarkupHelper.createLabel(mtdName, ExtentColor.RED);
		test.fail(m);

	}

	public void onTestSkipped(ITestResult result) {
		// Label
		String mtdName = "<b>" + "testcase: " + result.getMethod().getMethodName() + " skipped</b>";
		Markup m = MarkupHelper.createLabel(mtdName, ExtentColor.YELLOW);
		test.skip(m);

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		if (extent != null) {
			extent.flush();
		}

	}

}
