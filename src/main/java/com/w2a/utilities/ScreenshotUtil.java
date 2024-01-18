package com.w2a.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.w2a.base.BasePage;

public class ScreenshotUtil extends BasePage{

	public static String scrFile;
	
	public static void captureScreenshot()
	{
		Date d = new Date();
		scrFile = d.toString().replace(" ", "_").replace(":","_")+".jpg";
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File(System.getProperty("user.dir")+"//target//extentreports//"+scrFile));
			FileUtils.copyFile(file, new File(".//target//surefire-reports//html//"+scrFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
