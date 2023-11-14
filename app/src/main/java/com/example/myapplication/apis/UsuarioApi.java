package com.example.myapplication.apis;

import com.example.myapplication.dto.RegUsuResponseDto;
import com.example.myapplication.dto.UsuarioDto;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UsuarioApi {

    @POST("api/usuarios")
    Call<RegUsuResponseDto> registroUsuario(@Body UsuarioDto usuarioDto);
}
