package com.l7.objectreadwritter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.l7.dto.BirthdayHuman;

public class ExcelReader {

	public List<BirthdayHuman> readFromExcelFile(String excelFilePath) throws IOException {

		List<BirthdayHuman> listHumans = new ArrayList<BirthdayHuman>();
		FileInputStream inputstream = new FileInputStream(new File(excelFilePath));
		Workbook workbook = null;
		workbook = new XSSFWorkbook(inputstream);
		try {
			for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
				Sheet Sheet = workbook.getSheetAt(i);
				Iterator<Row> RowIterator = Sheet.iterator();
				RowIterator.next();
				while (RowIterator.hasNext()) {
					Iterator<Cell> cellIterator = RowIterator.next().iterator();
					while (cellIterator.hasNext()) {
						Date dob = cellIterator.next().getDateCellValue();
						String name = cellIterator.next().getStringCellValue();
						String imgsrc = cellIterator.next().getStringCellValue();
						String email = cellIterator.next().getStringCellValue();
						BirthdayHuman obj = new BirthdayHuman(dob, name, imgsrc, email);
						listHumans.add(obj);
					}

				}

			}

		} finally {
			workbook.close();
			inputstream.close();

		}

		return listHumans;
	}

	public double readtempletValueExcelFile(String excelFilePath) throws IOException {

		double result;
		FileInputStream inputstream = new FileInputStream(new File(excelFilePath));
		Workbook workbook = null;

		workbook = new XSSFWorkbook(inputstream);

		try {

			Sheet Sheet = workbook.getSheetAt(0);

			Row row = Sheet.getRow(1);
			Cell cell = row.getCell(0);
			result = cell.getNumericCellValue();

		} finally {
			workbook.close();
			inputstream.close();

		}

		return result;
	}

}
