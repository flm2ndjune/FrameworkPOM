package com.adactinhotelapp.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	static FileInputStream fis1;
	
	public static HashMap<String,String> getTestDataFromExcel(String testcaseName)
	{
		
		try {
			fis1=new FileInputStream("src\\test\\resources\\testdata\\excels\\MasterTestData.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		XSSFWorkbook wb=null;
		try {
			wb=new XSSFWorkbook(fis1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		XSSFSheet  ws=wb.getSheet("regression");
		
		ArrayList<Row>  testCaseRows=getTestCaseRows(ws,testcaseName);
		
		HashMap<String, String> testDataMap=new HashMap<String, String>();
		
		for(int i=1;i<testCaseRows.get(0).getLastCellNum();i++)
		{
			testDataMap.put(testCaseRows.get(0).getCell(i).getStringCellValue(), 
										testCaseRows.get(1).getCell(i).getStringCellValue());
		}
		
		return testDataMap;
		
	}

	private static ArrayList<Row> getTestCaseRows(XSSFSheet ws, String testcaseName) {
		
		ArrayList<Row> allRows=new ArrayList<Row>();
		
		for(int i=0;i<=ws.getLastRowNum();i++)
		{
			if(ws.getRow(i)!=null)
			{
				allRows.add(ws.getRow(i));
			}
			
		}
		
		ArrayList<Row> testCaseRows=new ArrayList<Row>();
		
		for(int i=0;i<allRows.size();i++)
		{
			if(allRows.get(i).getCell(0).getStringCellValue().equalsIgnoreCase(testcaseName))
			{
				testCaseRows.add(allRows.get(i));
			}
		}
		
		return testCaseRows;
		
		
		
		
	}

}
