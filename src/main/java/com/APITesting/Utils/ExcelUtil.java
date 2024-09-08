package com.APITesting.Utils;

import com.APITesting.Payloads.Requests.Booking;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;



public class ExcelUtil {

    //File inputstream to read the file
    //get the data into an object array

    static Workbook book;
    static Sheet sheet;
    public static String file_path;
    public static Booking booking;


   public static Object[][] getTestDataFromExcel(String sheet_name) throws IOException {

       FileInputStream file;

       try {
           file_path = System.getProperty("user.dir") + PropertyReaderUtil.readKey("testdata_location");
//           file_name = String.valueOf(createPath(PropertyReaderUtil.readKey("test_loc")));
       } catch (Exception e) {
           throw new RuntimeException("Issue with property file - testdata_location"+ e);
       }

       try{
           file = new FileInputStream(file_path);
       }catch(FileNotFoundException e){
           throw new RuntimeException(e);
       }

       book = WorkbookFactory.create(file);
       sheet = book.getSheet(sheet_name);
       Object [][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
       for (int i = 0; i < sheet.getLastRowNum(); i++) {
           for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
               switch (sheet.getRow(i+1).getCell(j).getCellType()){
                   case BLANK:
                       data [i][j] = "";
                       break;
                   case STRING:
                       data [i][j] = sheet.getRow(i+1).getCell(j).toString();
                       break;
                   case BOOLEAN:
                       data [i][j] = sheet.getRow(i+1).getCell(j).getBooleanCellValue();
                       break;
                   case NUMERIC:
                       data [i][j] = sheet.getRow(i+1).getCell(j).getNumericCellValue();
                       break;
                   default:
                       Reporter.log("Only Blank,string, boolean & numeric values are handled in excel");
                       throw new RuntimeException(new Exception("Test Data in Excel Only Blank,string,boolean & numeric values are handled in excel"));
               }
              /* switch (sheet.getRow(0).getCell(j).toString()){
                   case "strfirstname:

                       break;
                   case STRING:

                       break;
                   case BOOLEAN:
                       break;
                   case NUMERIC:
                       break;
                   default:
                       Reporter.log("Onlu booking object parameters are handles");
                       break;
               }*/

           }

       }
        return data;
   }


    @DataProvider
    public Object[][] getdata() throws IOException {
        return getTestDataFromExcel("createtoken");
    }



}
