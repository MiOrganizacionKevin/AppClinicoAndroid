package com.example.myapplication.apis;

import androidx.annotation.NonNull;

import com.example.myapplication.util.Constants;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class VitaClinicApiClient {

    private Retrofit retrofit;

    public OkHttpClient httpClienteInterceptor(){

        return new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @NonNull
                    @Override
                    public Response intercept(@NonNull Chain chain) throws IOException {
                        Request originalRequest = chain.request();

                        return chain.proceed(originalRequest);
                    }
                })
                .connectTimeout(60, TimeUnit.SECONDS)
                .build();
    }

    public OkHttpClient httpClienteInterceptor2(String token){

        return new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @NonNull
                    @Override
                    public Response intercept(@NonNull Chain chain) throws IOException {
                        Request originalRequest = chain.request();

                        Request requestWithToken = originalRequest.newBuilder()
                                .header("x-token",token)
                                .build();
                        return chain.proceed(requestWithToken);
                    }
                })
                .connectTimeout(60, TimeUnit.SECONDS)
                .build();
    }

    public Retrofit getClient2(String token) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASEURL)
                    .client(httpClienteInterceptor2(token))
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASEURL)
                    .client(httpClienteInterceptor())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
