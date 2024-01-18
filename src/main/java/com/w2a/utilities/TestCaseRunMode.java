package com.w2a.utilities;

import com.w2a.base.BasePage;

public class TestCaseRunMode extends BasePage{
	
	
	public static Boolean getTestRunMode(String testName)
	{
		String sheetName = "testcases";
		int rows = excel.getRowCount(sheetName);
		
		for(int row=1;row<rows;row++)
		{
			String testcaseName = excel.getCellData(sheetName, "testname", row);
			
			if(testcaseName.trim().equalsIgnoreCase(testName))
			{
				String runMode = excel.getCellData(sheetName, "runmode", row);
				
				if(runMode.trim().equalsIgnoreCase("Y"))
				{
					return true;
				}
			
			}
			
		}
		
		return false;
		
	}

}