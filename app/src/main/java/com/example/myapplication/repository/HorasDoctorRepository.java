package com.example.myapplication.repository;

import android.content.Context;

import com.example.myapplication.apis.HorasDoctorApi;
import com.example.myapplication.apis.VitaClinicApiClient;
import com.example.myapplication.dto.FechasDispoEspecDto;
import com.example.myapplication.dto.HorasDoctorDto;
import com.example.myapplication.util.TokenManager;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HorasDoctorRepository {
    VitaClinicApiClient vitaClinic = new VitaClinicApiClient();
    Retrofit retrofit ;

    public Observable<HorasDoctorDto> horasDoctor(String uidDoctorFechaDiEs, Context context){
        retrofit = vitaClinic.getClient2(TokenManager.getToken(context));
        HorasDoctorApi horasDoctorApi = retrofit.create(HorasDoctorApi.class);

        return Observable.create(emitter -> {
            Call<HorasDoctorDto> call = horasDoctorApi.horasDoctor(uidDoctorFechaDiEs);

            call.enqueue(new Callback<HorasDoctorDto>() {
                @Override
                public void onResponse(Call<HorasDoctorDto> call, Response<HorasDoctorDto> response) {
                    if(response.isSuccessful()){
                        HorasDoctorDto respuesta = response.body();

                        emitter.onNext(respuesta);
                        emitter.onComplete();
                    }else{
                        emitter.onNext(new HorasDoctorDto());
                        emitter.onComplete();
                    }
                }

                @Override
                public void onFailure(Call<HorasDoctorDto> call, Throwable t) {
                    emitter.onError(t);
                }
            });
        });
    }

}
