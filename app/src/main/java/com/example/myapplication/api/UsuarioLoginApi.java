package com.example.myapplication.api;

import com.example.myapplication.model.UsuarioLogin;

import retrofit2.Call;
import retrofit2.http.POST;

public interface UsuarioLoginApi {

    @POST("/api/usuarios")
    Call<UsuarioLogin> postUsuarioLogin(UsuarioLogin usuarioLogin);



}
