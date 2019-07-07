package com.safc.configuration;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class DbConnection {
  public static String readDataFromExcelFile(String fileName, String sheetName, int row, int column) {
    String cellValue = null;
    try {
      FileInputStream fis = new FileInputStream(fileName);
      HSSFWorkbook workbook = new HSSFWorkbook(fis);
      HSSFSheet sheet = workbook.getSheet(sheetName);
      
      HSSFCell cell = sheet.getRow(row).getCell(column);
      cellValue = cell.getStringCellValue();
      
      fis.close();
    } catch (Exception e) {
      e.printStackTrace();
    } 
    return cellValue;
  }
  
  public static void writeDataToExcelFile(String fileName, String sheetName, String valueToWrite, int row, int column) {
    try {
      HSSFWorkbook myWorkBook;
      File file = new File(fileName);

      
      if (!file.exists()) {
        myWorkBook = new HSSFWorkbook();
        HSSFSheet hSSFSheet = myWorkBook.createSheet(sheetName);
      } else {
        FileInputStream fis = new FileInputStream(file);
        myWorkBook = new HSSFWorkbook(fis);
      } 
      
      HSSFSheet mySheet = myWorkBook.getSheet(sheetName);


      
      HSSFRow myRow = mySheet.getRow(row);
      HSSFCell myCell = myRow.getCell(column);
      myCell.setCellValue(new HSSFRichTextString(valueToWrite));
      FileOutputStream out = new FileOutputStream(fileName);
      myWorkBook.write(out);
      out.flush();
      out.close();
      
        }
    catch (Exception e) {
      e.printStackTrace();
    } 
  }
}
