package com.APITesting.DDT;

import com.APITesting.Utils.ExcelUtil;
import org.testng.annotations.Test;

public class LoginDDT {

   @Test(dataProvider = "getdata", dataProviderClass = ExcelUtil.class)
    public void testLoginData(String username, String password){
        System.out.println("UID--> "+ username);
        System.out.println("PWD--> "+ password);
    }
   /* @Test(dataProvider = "getdata", dataProviderClass = ExcelUtil.class)
    public void testLoginData(String fn, String ln){
        System.out.println("UID--> "+ fn);
        System.out.println("PWD--> "+ ln);
    }*/



}
