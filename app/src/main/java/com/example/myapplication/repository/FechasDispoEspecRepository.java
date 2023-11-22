package com.example.myapplication.repository;

import android.content.Context;

import com.example.myapplication.apis.FechasDispoEspecApi;
import com.example.myapplication.apis.VitaClinicApiClient;
import com.example.myapplication.dto.FechasDispoEspecDto;
import com.example.myapplication.util.TokenManager;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class FechasDispoEspecRepository {

    VitaClinicApiClient vitaClinic = new VitaClinicApiClient();
    Retrofit retrofit;

    public Observable<FechasDispoEspecDto> fechasDispoEspecialidades(String mes,String anio,String especialidad, Context context){
        retrofit = vitaClinic.getClient2(TokenManager.getToken(context));
        FechasDispoEspecApi fechasDispoEspecApi = retrofit.create(FechasDispoEspecApi.class);

        return Observable.create(emitter -> {
            Call<FechasDispoEspecDto> call = fechasDispoEspecApi.fechasDisponiblesEspec(mes,anio,especialidad);

            call.enqueue(new Callback<FechasDispoEspecDto>() {
                @Override
                public void onResponse(Call<FechasDispoEspecDto> call, Response<FechasDispoEspecDto> response) {
                    if(response.isSuccessful()){
                        FechasDispoEspecDto respuesta = response.body();

                        emitter.onNext(respuesta);
                        emitter.onComplete();
                    }else{
                        emitter.onNext(new FechasDispoEspecDto(0,null));
                        emitter.onComplete();
                    }
                }

                @Override
                public void onFailure(Call<FechasDispoEspecDto> call, Throwable t) {
                    emitter.onError(t);
                }
            });
        });
    }
}
