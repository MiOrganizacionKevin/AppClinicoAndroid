package com.example.myapplication.apis;

import com.example.myapplication.dto.HorasDoctorDto;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface HorasDoctorApi {

    @GET("api/horasDoctor/especifico")
    Call<HorasDoctorDto> horasDoctor(@Query("uid") String uidDoctorFechaDiEs);
}
