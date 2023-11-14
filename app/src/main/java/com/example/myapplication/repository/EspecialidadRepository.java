package com.example.myapplication.repository;

import com.example.myapplication.apis.EspecialidadApi;
import com.example.myapplication.apis.VitaClinicApiClient;
import com.example.myapplication.dto.EspecialidadDto;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class EspecialidadRepository {
    VitaClinicApiClient vitaClinic = new VitaClinicApiClient();
    Retrofit retrofit = vitaClinic.getClient();

    public Observable<EspecialidadDto> especialidadesDoctores(){
        EspecialidadApi especialidadApi = retrofit.create(EspecialidadApi.class);

        return Observable.create(emitter -> {
            Call<EspecialidadDto> call = especialidadApi.especialidadesDoctor();

            call.enqueue(new Callback<EspecialidadDto>() {
                @Override
                public void onResponse(Call<EspecialidadDto> call, Response<EspecialidadDto> response) {
                    if(response.isSuccessful()){
                        EspecialidadDto respuesta = response.body();

                        emitter.onNext(respuesta);
                        emitter.onComplete();
                    }else{
                        emitter.onNext(new EspecialidadDto());
                        emitter.onComplete();
                    }
                }

                @Override
                public void onFailure(Call<EspecialidadDto> call, Throwable t) {
                    emitter.onError(t);
                }
            });
        });
    }
}
