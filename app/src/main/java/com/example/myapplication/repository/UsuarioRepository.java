package com.example.myapplication.repository;

import com.example.myapplication.apis.UsuarioApi;
import com.example.myapplication.apis.VitaClinicApiClient;
import com.example.myapplication.dto.ResponsePostDto;
import com.example.myapplication.dto.UsuarioDto;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class UsuarioRepository {

    VitaClinicApiClient vitaClinic = new VitaClinicApiClient();
    Retrofit retrofit = vitaClinic.getClient();

    public Observable<ResponsePostDto> registroUsuario(UsuarioDto usuarioDto){
        UsuarioApi usuarioApi = retrofit.create(UsuarioApi.class);

        return Observable.create(emitter -> {
            Call<ResponsePostDto> call = usuarioApi.registroUsuario(usuarioDto);

            call.enqueue(new Callback<ResponsePostDto>() {
                @Override
                public void onResponse(Call<ResponsePostDto> call, Response<ResponsePostDto> response) {
                    if(response.isSuccessful()){
                        ResponsePostDto respuesta = response.body();

                        emitter.onNext(respuesta);
                        emitter.onComplete();
                    }else{
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
}
