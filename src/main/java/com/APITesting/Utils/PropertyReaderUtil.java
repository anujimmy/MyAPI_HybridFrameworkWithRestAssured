package com.APITesting.Utils;

import java.io.File;
import java.io.FileInputStream;


import java.util.Properties;

public class PropertyReaderUtil {

    public PropertyReaderUtil() {
    }

    public static String readKey(String key) throws Exception{
        FileInputStream fileInputStream = new FileInputStream(new File(System.getProperty("user.dir")+"/src/main/java/com/APITesting/resources/TDP.properties"));
        Properties p = new Properties();
        p.load(fileInputStream);
        if (p.getProperty(key) == null){
            throw new Exception("Property reader utility Exception -> not able to find the key - "+ key + "in file");
        }else{
            return p.getProperty(key);
        }
    }
    /*public static Path createPath(String p){
        Path path = Paths.get(p);
        return path;
    }*/
}
