package com.mindtree.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	public static ArrayList<String> getData() throws IOException {
		FileInputStream fis = new FileInputStream(".\\test-input\\Data.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rows = sheet.iterator(); //selected the first row
		Row firstRow = rows.next(); //selected the hole row
		ArrayList<String> a = new ArrayList<String>();
		
		
		Row secondRow = rows.next();
		
		Iterator<Cell> cells = secondRow.cellIterator();// for every cells
		while(cells.hasNext()) {
			Cell cell = cells.next();
			String cellValue = cell.getStringCellValue();
			a.add(cellValue);
		}
		
		return a;
		
		
		
	}
	
	
	
	
	/*
	 * public ArrayList<String> getData(String testcaseName) throws IOException {
	 * 
	 * ArrayList<String> a = new ArrayList<String>();
	 * 
	 * FileInputStream fis = new FileInputStream(".\\test-input\\Data.xlsx");
	 * 
	 * System.out.println("file found"); XSSFWorkbook workbook = new
	 * XSSFWorkbook(fis);
	 * 
	 * int sheets = workbook.getNumberOfSheets();
	 * 
	 * for (int i = 0; i < sheets; i++) {
	 * 
	 * if (workbook.getSheetName(i).equalsIgnoreCase("Sheet1")) {
	 * 
	 * XSSFSheet sheet = workbook.getSheetAt(i);
	 * 
	 * Iterator<Row> rows = sheet.iterator();
	 * 
	 * Row firstrow = rows.next();
	 * 
	 * //Iterator<Cell> ce = firstrow.iterator();
	 * 
	 * /*int column = 0; while (ce.hasNext()) {
	 * 
	 * Cell c1 = ce.next();
	 * 
	 * if (c1.getStringCellValue().equalsIgnoreCase("Iphone 13 pro max")) { break; }
	 * 
	 * column++; }
	 * 
	 * System.out.println("tets cases column pesent at this index :" + column);
	 * 
	 * int c = 0;
	 * 
	 * while (rows.hasNext()) {
	 * 
	 * Row r = rows.next();
	 * 
	 * Cell v = r.getCell();
	 * 
	 * if (v != null && v.getStringCellValue().equalsIgnoreCase(testcaseName)) {
	 * 
	 * Iterator<Cell> cv = r.cellIterator();
	 * 
	 * while (cv.hasNext()) { Cell h = cv.next();
	 * 
	 * System.out.println("column index :" + c); c++;
	 * 
	 * a.add(h.getStringCellValue()); }
	 * 
	 * break; } } }
	 * 
	 * }
	 * 
	 * return a; }
	 */

}
