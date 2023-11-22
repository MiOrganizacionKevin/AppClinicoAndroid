package com.example.myapplication.repository;

import android.content.Context;

import com.example.myapplication.apis.CitaMedicaApi;
import com.example.myapplication.apis.VitaClinicApiClient;
import com.example.myapplication.dto.HorasDoctorDto;
import com.example.myapplication.dto.ResponsePostDto;
import com.example.myapplication.dto.citaMedica.CitaMedicaRequestDto;
import com.example.myapplication.dto.citaMedica.CitaMedicaResponseDto;
import com.example.myapplication.util.TokenManager;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CitaMedicaRepository {

    VitaClinicApiClient vitaClinic = new VitaClinicApiClient();
    Retrofit retrofit;

    public Observable<ResponsePostDto> crearCitaMedica(CitaMedicaRequestDto citaMedicaRequestDto, Context context){
        retrofit = vitaClinic.getClient2(TokenManager.getToken(context));
        CitaMedicaApi citaMedicaApi = retrofit.create(CitaMedicaApi.class);

        return Observable.create(emitter -> {
            Call<ResponsePostDto> call = citaMedicaApi.guardarCitaMedica(citaMedicaRequestDto);

            call.enqueue(new Callback<ResponsePostDto>() {
                @Override
                public void onResponse(Call<ResponsePostDto> call, Response<ResponsePostDto> response) {
                    if(response.isSuccessful()){
                        ResponsePostDto respuesta = response.body();

                        emitter.onNext(respuesta);
                        emitter.onComplete();
                    }else {
                        emitter.onNext(new ResponsePostDto());
                        emitter.onComplete();
                    }
                }

                @Override
                public void onFailure(Call<ResponsePostDto> call, Throwable t) {
                    emitter.onError(t);
                }
            });

        });
    }

    public Observable<CitaMedicaResponseDto> obtenerCitasMedicas(String uidUsuario, Context context){
        retrofit = vitaClinic.getClient2(TokenManager.getToken(context));
        CitaMedicaApi citaMedicaApi = retrofit.create(CitaMedicaApi.class);

        return Observable.create(emitter -> {
            Call<CitaMedicaResponseDto> call = citaMedicaApi.obtenerCitasMedicas(uidUsuario);

            call.enqueue(new Callback<CitaMedicaResponseDto>() {
                @Override
                public void onResponse(Call<CitaMedicaResponseDto> call, Response<CitaMedicaResponseDto> response) {
                    if(response.isSuccessful()){
                        CitaMedicaResponseDto respuesta = response.body();

                        emitter.onNext(respuesta);
                        emitter.onComplete();
                    }else{
                        emitter.onNext(new CitaMedicaResponseDto());
                        emitter.onComplete();
                    }
                }

                @Override
                public void onFailure(Call<CitaMedicaResponseDto> call, Throwable t) {
                    emitter.onError(t);
                }
            });
        });
    }
}
