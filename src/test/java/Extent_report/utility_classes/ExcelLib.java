package Extent_report.utility_classes;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelLib {

	
		  String filepath=Constants.filepath;
		  public String getExcelData(String SheetNo, int rowNo, int colNo) throws Throwable
		  {
			  FileInputStream fis=new FileInputStream(filepath);
			  Workbook wb=WorkbookFactory.create(fis);
			  Sheet sh=wb.getSheet(SheetNo);
			  Row row=sh.getRow(rowNo);
			  String data=row.getCell(colNo).getStringCellValue();
			  return data;
		  }
		  
		  public void setExcelData(String SheetNo, int rowNo, int colNo, String data) throws Throwable
		  {
			  FileInputStream fis=new FileInputStream(filepath);
			  Workbook wb=WorkbookFactory.create(fis);
			  Sheet sh=wb.getSheet(SheetNo);
			  Row row=sh.getRow(rowNo);
			  Cell cell=row.createCell(colNo);
			  cell.setCellType(cell.CELL_TYPE_STRING);
			  cell.setCellValue(data);
			  FileOutputStream fos1=new FileOutputStream(filepath);
			  wb.write(fos1);
			  wb.close();
		  }
		}

