package com.example.myapplication.apis;

import com.example.myapplication.dto.FechasDispoEspecDto;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FechasDispoEspecApi {

    @GET("api/fechaDispoEspec/especifico")
    Call<FechasDispoEspecDto> fechasDisponiblesEspec(@Query("mes") String mes, @Query("anio") String anio, @Query("especialidad") String especialidad);
}
