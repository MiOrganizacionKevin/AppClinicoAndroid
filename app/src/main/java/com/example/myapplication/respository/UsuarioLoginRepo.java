package com.example.myapplication.respository;

import android.content.Context;
import android.widget.Toast;

import com.example.myapplication.api.UsuarioLoginApi;
import com.example.myapplication.model.UsuarioLogin;
import com.example.myapplication.respository.interf.UsuarioLoginRepoInterf;
import com.example.myapplication.view.Login_Activity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UsuarioLoginRepo implements UsuarioLoginRepoInterf{

    private Context context;

    @Override
    public String verificarLoginUsuarioRepo() {



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UsuarioLoginApi usuarioLoginService = retrofit.create(UsuarioLoginApi.class);

        Call<UsuarioLogin> repo1 = usuarioLoginService.postUsuarioLogin(new UsuarioLogin("3333333","kevinpumaille"));

        repo1.enqueue(new Callback<UsuarioLogin>() {
            @Override
            public void onResponse(Call<UsuarioLogin> call, Response<UsuarioLogin> response) {
                response.body().getDniUsuario();
            }

            @Override
            public void onFailure(Call<UsuarioLogin> call, Throwable t) {
                Toast.makeText(context, "Error al iniciar sesion", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
