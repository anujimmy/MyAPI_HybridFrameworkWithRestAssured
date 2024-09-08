package com.APITesting.Utils;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class FillowUtil {
    public static String file_path;

    public static String fetchDataFromXLSX(String sheetName,String id, String fieldName) throws FilloException {
        String value = null;
        Fillo fillo = new Fillo();
        Connection connection = null;

        try {
            file_path = System.getProperty("user.dir") + PropertyReaderUtil.readKey("testdata_Booking");
//           file_name = String.valueOf(createPath(PropertyReaderUtil.readKey("test_loc")));
        } catch (Exception e) {
            throw new RuntimeException("Issue with property file - testdata_location"+ e);
        }


        try {
            connection = fillo.getConnection(file_path);
        } catch (FilloException e) {
            throw new RuntimeException("Issue with Fillow connection "+ file_path + e);
        }
        String query = "Select * from " + sheetName + " " + "where ID='" + id + "'";

        Recordset recordset = connection.executeQuery(query);
        while(recordset.next()){
            value = recordset.getField(fieldName);
        }
        recordset.close();
        connection.close();

        return value;

    }



}
