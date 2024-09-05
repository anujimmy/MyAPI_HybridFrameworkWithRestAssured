package com.APITesting.Constants;

public enum APIContentType {
    EXT(new String ("text/plain")),
    GSON(new String ("application/json")),
    XML(new String ("application/xml"));

    private final String contentType;

    APIContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getContentType(){
        return contentType;
    }
}


