package com.example.myapplication.apis;

import com.example.myapplication.dto.ResponsePostDto;
import com.example.myapplication.dto.citaMedica.CitaMedicaRequestDto;
import com.example.myapplication.dto.citaMedica.CitaMedicaResponseDto;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface CitaMedicaApi {

    @POST("api/citaMedica")
    Call<ResponsePostDto> guardarCitaMedica(@Body CitaMedicaRequestDto citaMedicaRequestDto);

    @GET("api/citaMedica/especifico")
    Call<CitaMedicaResponseDto> obtenerCitasMedicas(@Query("uid") String uidUsuario);
}
