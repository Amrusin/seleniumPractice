package com.GenericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	/**
	 * 
	 * @param SheetName
	 * @param rowno
	 * @param cellno
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public String ReadDataFromExcel(String SheetName,int rowno, int cellno) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IpathConstant.ExcelPath);
			Workbook wb=WorkbookFactory.create(fis);
			Sheet sh=wb.getSheet(SheetName);
			String value=sh.getRow(rowno).getCell(cellno).getStringCellValue();
			return value;
				}
	
	public int getTotalRowCount(String Sheetname) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IpathConstant.ExcelPath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(Sheetname);
		int rowcount=sh.getLastRowNum();
		return rowcount;
		}
	
	public void writeDataInToExcel(String Sheetname,int rowno,int cellno, String data) throws EncryptedDocumentException, IOException
	{
	FileInputStream fis=new FileInputStream(IpathConstant.ExcelPath);
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sh=wb.getSheet(Sheetname);
	sh.createRow(rowno).createCell(cellno).setCellValue(data);
	FileOutputStream fos= new FileOutputStream(IpathConstant.ExcelPath);
	wb.write(fos);
	wb.close();
}
	public HashMap<String, String> readMultipleData(String Sheetname, int cellno) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new  FileInputStream(IpathConstant.ExcelPath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(Sheetname);
		int rowcount=sh.getLastRowNum();
		
		HashMap<String, String> map= new HashMap<String, String>();
		for(int i=0; i<=rowcount;i++)
		{
			String key=sh.getRow(i).getCell(cellno).getStringCellValue();
			String value=sh.getRow(i).getCell(cellno+1).getStringCellValue();
			map.put(key,value);
		}
		return map;
	}
}
