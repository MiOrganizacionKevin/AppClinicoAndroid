package com.example.myapplication.manejoErrores;

import com.example.myapplication.dto.auth.LoginResponseDto;

public class ApiResponse <T> extends LoginResponseDto {
    private boolean success;
    private T data;
    private String errorMessage;

    public ApiResponse(boolean success, T data, String errorMessage) {
        this.success = success;
        this.data = data;
        this.errorMessage = errorMessage;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
