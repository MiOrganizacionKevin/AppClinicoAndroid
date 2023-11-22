package com.example.myapplication.repository;

import android.content.Context;
import android.util.Log;

import com.example.myapplication.apis.DoctoresDispoEspecApi;
import com.example.myapplication.apis.VitaClinicApiClient;
import com.example.myapplication.dto.EspecialidadDto;
import com.example.myapplication.dto.doctoresDiEs.DoctDispEspRequest;
import com.example.myapplication.dto.doctoresDiEs.DoctoresDispoEspecDto;
import com.example.myapplication.util.TokenManager;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DoctoresDispoEspecRepository {
    VitaClinicApiClient vitaClinic = new VitaClinicApiClient();
    Retrofit retrofit;

    public Observable<DoctoresDispoEspecDto> doctoresDisponiblesEspecialidad(DoctDispEspRequest doctDispEspRequest, Context context){
        retrofit = vitaClinic.getClient2(TokenManager.getToken(context));
        DoctoresDispoEspecApi doctoresDispoEspecApi = retrofit.create(DoctoresDispoEspecApi.class);

        return Observable.create(emitter -> {
            Call<DoctoresDispoEspecDto> call = doctoresDispoEspecApi.docteresDisponiblesEspec(doctDispEspRequest);

            call.enqueue(new Callback<DoctoresDispoEspecDto>() {
                @Override
                public void onResponse(Call<DoctoresDispoEspecDto> call, Response<DoctoresDispoEspecDto> response) {
                    if(response.isSuccessful()){
                        DoctoresDispoEspecDto respuesta = response.body();
                        Log.d("DoctoresDispoEspec","Respuesta: "+response.body());
                        emitter.onNext(respuesta);
                        emitter.onComplete();
                    }else{
                        emitter.onNext(new DoctoresDispoEspecDto());
                        emitter.onComplete();
                    }
                }

                @Override
                public void onFailure(Call<DoctoresDispoEspecDto> call, Throwable t) {
                    emitter.onError(t);
                }
            });
        });
    }
}
