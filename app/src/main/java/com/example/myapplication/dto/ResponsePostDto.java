package com.example.myapplication.dto;

public class ResponsePostDto {
    private String msg;
    private Boolean success = false;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
