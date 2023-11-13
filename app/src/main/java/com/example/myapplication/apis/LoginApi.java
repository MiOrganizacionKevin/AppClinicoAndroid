package com.example.myapplication.apis;

import com.example.myapplication.dto.auth.LoginRequestDto;
import com.example.myapplication.dto.auth.LoginResponseDto;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginApi {

    @POST("api/auth/login")
    Call<LoginResponseDto> loginUsuario(@Body LoginRequestDto loginRequestDto);

}
