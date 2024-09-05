package com.APITesting.Modules;

import com.APITesting.Payloads.Requests.Booking;
import com.APITesting.Payloads.Response.BookingResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ResponseManager {

    ObjectMapper objectMapper;

    /*------FUNCTION DESC : De-Serializer - to create POJO obj from json as String
    --------AUTHOR: anu
    --------DATE CREATED : initial framework development
    --------LAST MODIFIED BY:
    --------LAST MODIFIED ON: 05-09-2024
    --------COMMENTS ON LAST MODIFICATION: ---------------*/

    public BookingResponse JsonToObject_BookingResp(String jsonStr) throws JsonProcessingException {
        objectMapper = new ObjectMapper();
        BookingResponse bookingResponse = objectMapper.readValue(jsonStr, BookingResponse.class);
        return bookingResponse;
    }

    public Booking JsonToObject_Booking(String jsonStr) throws JsonProcessingException {
        objectMapper = new ObjectMapper();
        Booking booking = objectMapper.readValue(jsonStr, Booking.class);
        return booking;
    }


}
