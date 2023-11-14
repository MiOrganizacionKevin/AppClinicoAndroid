package com.example.myapplication.apis;

import com.example.myapplication.dto.EspecialidadDto;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EspecialidadApi {

    @GET("api/especialidadDoctor")
    Call<EspecialidadDto> especialidadesDoctor();
}
