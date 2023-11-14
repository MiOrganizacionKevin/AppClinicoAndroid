package com.example.myapplication.repository;

import com.example.myapplication.apis.UsuarioApi;
import com.example.myapplication.apis.VitaClinicApiClient;
import com.example.myapplication.dto.RegUsuResponseDto;
import com.example.myapplication.dto.UsuarioDto;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class UsuarioRepository {

    VitaClinicApiClient vitaClinic = new VitaClinicApiClient();
    Retrofit retrofit = vitaClinic.getClient();

    public Observable<RegUsuResponseDto> registroUsuario(UsuarioDto usuarioDto){
        UsuarioApi usuarioApi = retrofit.create(UsuarioApi.class);

        return Observable.create(emitter -> {
            Call<RegUsuResponseDto> call = usuarioApi.registroUsuario(usuarioDto);

            call.enqueue(new Callback<RegUsuResponseDto>() {
                @Override
                public void onResponse(Call<RegUsuResponseDto> call, Response<RegUsuResponseDto> response) {
                    if(response.isSuccessful()){
                        RegUsuResponseDto respuesta = response.body();

                        emitter.onNext(respuesta);
                        emitter.onComplete();
                    }else{
                        emitter.onNext(new RegUsuResponseDto());
                        emitter.onComplete();
                    }
                }

                @Override
                public void onFailure(Call<RegUsuResponseDto> call, Throwable t) {
                    emitter.onError(t);
                }
            });

        });
    }
}
