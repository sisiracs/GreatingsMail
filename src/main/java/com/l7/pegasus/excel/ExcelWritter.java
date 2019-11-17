package com.l7.pegasus.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWritter {

	public void createExcel(String filename,double val) throws IOException {
		// TODO Auto-generated method stub
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet();
		
		XSSFRow row=sheet.createRow(1);
		XSSFCell cell =row.createCell(0);
		
		cell.setCellValue(val);
		
		FileOutputStream out = new FileOutputStream(new File(filename));
		 workbook.write(out); 
         out.close(); 
         workbook.close();
			
		
		
	}

}
