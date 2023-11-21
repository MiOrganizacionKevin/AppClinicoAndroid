package com.example.myapplication.apis;

import com.example.myapplication.dto.doctoresDiEs.DoctDispEspRequest;
import com.example.myapplication.dto.doctoresDiEs.DoctoresDispoEspecDto;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface DoctoresDispoEspecApi {

    @POST("api/doctorfechaDispoEspec/busqueda")
    Call<DoctoresDispoEspecDto> docteresDisponiblesEspec(@Body DoctDispEspRequest doctDispEspRequest);
}
