package com.example.wisdomsong.bean;

public class ApiException <T>{
    private T data;
    private int errorCode;
    private String errorMsg;

    public ApiException(T data, int errorCode, String errorMsg) {
        data = data;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return "ApiException{" +
                "Data=" + data +
                ", errorCode=" + errorCode +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }
}
