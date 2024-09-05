package com.APITesting.Modules;

import com.APITesting.Payloads.Requests.Booking;
import com.APITesting.Payloads.Requests.Bookingdates;
import com.APITesting.Utils.FakerUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PayloadManager {

    //JAVA --> JSON
    //Use GSON or Jackson
    // SERIALIZER here I am using Jackson to convert booking object to JSON string

    ObjectMapper objectMapper;

    /*------FUNCTION DESC : Serializer - to create json String from POJO class - Booking
    --------AUTHOR: anu
    --------DATE CREATED : initial framework development
    --------LAST MODIFIED BY:
    --------LAST MODIFIED ON: 05-09-2024
    --------COMMENTS ON LAST MODIFICATION: ---------------*/


    public String createPayload_CreateRequest() throws JsonProcessingException {
        objectMapper = new ObjectMapper();

        Bookingdates oBookingDate = new Bookingdates();
            oBookingDate.setCheckin("2013-02-23");
            oBookingDate.setCheckout("2014-10-23");
        Booking oBooking = new Booking();
            oBooking.setFirstname(FakerUtil.getFirstName());
            oBooking.setLastname(FakerUtil.getLastName());
            oBooking.setTotalprice(1000);
            oBooking.setDepositpaid(true);
            oBooking.setAdditionalneeds("Airport Pickup");
            oBooking.setBookingdates(oBookingDate);

        String jsonStr = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(oBooking);

        return jsonStr;
    }


}
