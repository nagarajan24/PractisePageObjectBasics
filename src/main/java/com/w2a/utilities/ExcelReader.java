package com.w2a.utilities;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	public String path;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public FileInputStream fis;
	
	public ExcelReader(String path)
	{
		try {
			this.path = path;
			fis = new FileInputStream(path);
			workbook  = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);
			fis.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public int getRowCount(String sheetName)
	{
		sheet = workbook.getSheet(sheetName);
		if(sheet==null)
		{
			return -1;
		}
		return sheet.getLastRowNum()+1;
	}
	

	public int getCellCount(String sheetName)
	{
		sheet = workbook.getSheet(sheetName);
		if(sheet==null)
		{
			return -1;
		}
		row = sheet.getRow(0);
		if(row==null)
		{
			return -1;
			
		}
		return row.getLastCellNum();
	}
	
	public String getCellData(String sheetName, int cellNum, int rowNum)
	{
		if(rowNum<0)
		{
			return "";
		}
		
		if(cellNum<0)
		{
			return "";
		}
		sheet = workbook.getSheet(sheetName);
		if(sheet==null)
		{
			return "";
		}
		row= sheet.getRow(rowNum);
		if(row==null)
		{
			return "";
		}
		cell = row.getCell(cellNum);
		if(cell==null)
		{
			return "";
		}
		if(cell.getCellType() == cell.CELL_TYPE_STRING)
		{
			return cell.getStringCellValue();
		}
		else if(cell.getCellType() == cell.CELL_TYPE_NUMERIC)
		{
			return String.valueOf(cell.getNumericCellValue());
		}
		else if(cell.getCellType() == cell.CELL_TYPE_BOOLEAN)
		{
			return String.valueOf(cell.getBooleanCellValue());
		}
		else
		{
			return "";
		}
		
	}
	
	public String getCellData(String sheetName, String colName, int rowNum)
	{
		if(rowNum<0)
		{
			return "";
		}
		
		sheet = workbook.getSheet(sheetName);
		if(sheet==null)
		{
			return "";
		}
		
		int cellNum=-1;
		row = sheet.getRow(0);
		for(int i=0;i<row.getLastCellNum();i++)
		{
			if(row.getCell(i).getStringCellValue().trim().equalsIgnoreCase(colName))
			{
				cellNum=i;
			}
		}
		
		
		if(cellNum<0)
		{
			return "";
		}
		row= sheet.getRow(rowNum);
		if(row==null)
		{
			return "";
		}
		cell = row.getCell(cellNum);
		if(cell==null)
		{
			return "";
		}
		if(cell.getCellType() == cell.CELL_TYPE_STRING)
		{
			return cell.getStringCellValue();
		}
		else if(cell.getCellType() == cell.CELL_TYPE_NUMERIC)
		{
			return String.valueOf(cell.getNumericCellValue());
		}
		else if(cell.getCellType() == cell.CELL_TYPE_BOOLEAN)
		{
			return String.valueOf(cell.getBooleanCellValue());
		}
		else
		{
			return "";
		}
		
	}
	
}
