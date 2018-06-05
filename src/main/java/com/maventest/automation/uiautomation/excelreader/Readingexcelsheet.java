package com.maventest.automation.uiautomation.excelreader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;






import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Readingexcelsheet {
	
	public FileOutputStream fileout=null;
	
	public String path;
	public FileInputStream fis;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
     public XSSFCell cell;
    public XSSFRow row;

    public Readingexcelsheet(String path) throws IOException{
    	
    	this.path=path;
    	try {
			fis= new FileInputStream(path);
			workbook =new XSSFWorkbook(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @SuppressWarnings({"deprecation"})
    public String[][]  getDataFromSheet(String SheetName, String ExcelName)
    {
    String[][] dataSets = null;
    try {
		XSSFSheet sheet =workbook.getSheet(SheetName);
		int totalRow=sheet.getLastRowNum() +1;
		System.out.println(totalRow);
		int totalColumn=sheet.getRow(0).getLastCellNum();
		System.out.println(totalColumn);
		dataSets= new String[totalRow-1][totalColumn];
		for(int i=1;i<=totalRow;i++){
			
		XSSFRow rows= sheet.getRow(i);
		for(int j=0;j<=totalColumn;j++){
			
			XSSFCell cell = rows.getCell(j);
			System.out.println("cell");
			
			if (cell.getCellType()== Cell.CELL_TYPE_STRING)
				dataSets[i - 1][j]=cell.getStringCellValue();
			else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
				String cellText=String.valueOf(cell.getNumericCellValue());
				dataSets[i- 1][j]=cellText;
				}else 
					dataSets[i-1][j]=String.valueOf(cell.getBooleanCellValue());
			}
		
		}
		return dataSets;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println("Exception in reading file"+ e.getMessage());
		e.printStackTrace();
	}
	return dataSets;
    }
    @SuppressWarnings("deprecation")
    
    public String getCellData(String sheetName, String colName, int rowNum)
    {
    	int col_num=0;
    	try {
			int index =workbook.getSheetIndex(sheetName);
			sheet= workbook.getSheetAt(index);
			XSSFRow row =sheet.getRow(0);
			for(int i=0;i<=row.getLastCellNum();i++){
				if(row.getCell(i).getStringCellValue().equalsIgnoreCase(colName)){col_num=i;
				break;}
				
			}
			row=sheet.getRow(rowNum-1);
			XSSFCell cell=row.getCell(col_num);
			if(cell.getCellType()==Cell.CELL_TYPE_STRING){return cell.getStringCellValue();}
			else if(cell.getCellType()==Cell.CELL_TYPE_BLANK) {return "";}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    
    }
	
    	
}

