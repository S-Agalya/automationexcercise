package utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelRead {
    public static String EXCELREAD="userdata.xlsx";
    public static Object[][] readExcel(String sheetname){
        try(FileInputStream fis=new FileInputStream(EXCELREAD);
            Workbook workbook=new XSSFWorkbook(fis)){
            Sheet sheet=workbook.getSheet(sheetname);
            int rowCount = sheet.getPhysicalNumberOfRows();
            int colCount = sheet.getRow(0).getLastCellNum();

            Object[][] data=new Object[rowCount-1][colCount];
            for(int i=1;i<rowCount;i++){
                Row row=sheet.getRow(i);
                for(int j=0;j<colCount;j++){
                    Cell cell=row.getCell(j);
                    data[i-1][j]=cell.toString();
                }
            }
            return data;
        }
        catch (IOException e){
            System.out.println("error occured"+e);
            return null;
        }

    }
}
//package utils;
//
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//
//public class ExcelRead {
//
//    // ✅ Declare global path variable
//    public static String excelPath = "userdata.xlsx";
//
//    // ✅ Use global path inside the method
//    public static Object[][] getData(String sheetName) {
//        try (FileInputStream fis = new FileInputStream(excelPath);
//             Workbook workbook = new XSSFWorkbook(fis)) {
//
//            Sheet sheet = workbook.getSheet(sheetName);
//            int rowCount = sheet.getPhysicalNumberOfRows();
//            int colCount = sheet.getRow(0).getLastCellNum();
//
//            Object[][] data = new Object[rowCount - 1][colCount];
//
//            for (int i = 1; i < rowCount; i++) {
//                Row row = sheet.getRow(i);
//                for (int j = 0; j < colCount; j++) {
//                    Cell cell = row.getCell(j);
//                    data[i - 1][j] = cell.toString();
//                }
//            }
//            return data;
//
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//}

