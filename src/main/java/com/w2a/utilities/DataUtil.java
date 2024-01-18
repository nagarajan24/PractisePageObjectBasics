package com.w2a.utilities;

import java.lang.reflect.Method;
import java.util.Hashtable;

import org.testng.annotations.DataProvider;

import com.w2a.base.BasePage;



public class DataUtil extends BasePage{
	
	@DataProvider(name="dp")
	public Object[][] getData(Method m)
	{
		String sheetName = m.getName();
		int rowNum = excel.getRowCount(sheetName);
		int cellNum = excel.getCellCount(sheetName);
		
		Object[][] data = new Object[rowNum-1][1];
		Hashtable<String,String> table = null;
		
		for(int row=1;row<rowNum;row++)
		{
			table = new Hashtable<String,String>();
			for(int cell=0;cell<cellNum;cell++)
			{
				table.put(excel.getCellData(sheetName, cell, 0), excel.getCellData(sheetName, cell, row));
				data[row-1][0] =table;
			}
		}
		
		return data;
		
	}

}
