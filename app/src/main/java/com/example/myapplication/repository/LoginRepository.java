package com.example.myapplication.repository;

import android.util.Log;

import com.example.myapplication.apis.LoginApi;
import com.example.myapplication.apis.VitaClinicApiClient;
import com.example.myapplication.dto.auth.LoginRequestDto;
import com.example.myapplication.dto.auth.LoginResponseDto;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginRepository {

    VitaClinicApiClient vitaClinic = new VitaClinicApiClient();
    Retrofit retrofit = vitaClinic.getClient();

    public Observable<LoginResponseDto> loginResponseDtoObservable(LoginRequestDto loginRequestDto){
        LoginApi loginApi = retrofit.create(LoginApi.class);

        return Observable.create(emitter -> {
            Call<LoginResponseDto> call = loginApi.loginUsuario(loginRequestDto);

            call.enqueue(new Callback<LoginResponseDto>() {
                @Override
                public void onResponse(Call<LoginResponseDto> call, Response<LoginResponseDto> response) {
                    if(response.isSuccessful()){
                        LoginResponseDto respuesta =response.body();
                        Log.d("LoginRepository","Respuesta: "+response.body());
                        emitter.onNext(respuesta);
                        emitter.onComplete();
                    }else{
                        emitter.onNext(new LoginResponseDto());
                        emitter.onComplete();
                    }
                }

                @Override
                public void onFailure(Call<LoginResponseDto> call, Throwable t) {
                    emitter.onError(t);
                }
            });

        });
    }
}
