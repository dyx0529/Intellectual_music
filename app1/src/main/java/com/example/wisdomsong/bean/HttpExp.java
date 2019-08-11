package com.example.wisdomsong.bean;

public class HttpExp extends Throwable {
    private int errorCode;
    private String errorMsg;

    public HttpExp(int errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
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
        return "HttpExp{" +
                "errorCode=" + errorCode +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }
}
