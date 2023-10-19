package com.example.myapplication.respository.interf;

import com.example.myapplication.model.UsuarioLogin;
import com.example.myapplication.service.interf.UsuarioLoginServiceInterf;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UsuarioLoginRepoInterf {

    public String verificarLoginUsuarioRepo();

}
