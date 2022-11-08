package com.hcmut.learningsystemserverrest.service.response;

import java.util.Map;

public class CustomResponse {
    private String message;
    private Integer errorCode;
    private Map<String, Object> data;

    public CustomResponse() {}

    public CustomResponse(String message, Integer errorCode, Map<String, Object> data) {
        this.message = message;
        this.errorCode = errorCode;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
