package com.APITesting.Constants;

import com.APITesting.Utils.PropertyReaderUtil;

public class EndPoints  {

    public static final String base_URL;

    static {
        try {
            base_URL = PropertyReaderUtil.readKey("RESTurl");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static  String base_PATH_CreateBooking = "/booking";
    public static  String base_PATH_UpdateBooking = "/booking";
    public static  String base_PATH_GetBooking = "/booking";
    public static  String base_PATH_GetToken = "/auth";

    public static final String base_PATH_HealthCheck = "/ping";

}
