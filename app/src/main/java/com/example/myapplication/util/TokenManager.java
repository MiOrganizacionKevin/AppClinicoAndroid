package com.example.myapplication.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.myapplication.dto.auth.LoginResponseDto;
import com.google.gson.Gson;

public class TokenManager {


    public static String getToken(Context contexto) {

        SharedPreferences sharPrefe = contexto.getSharedPreferences("UsuarioLogueado", Context.MODE_PRIVATE);
        String jsonString = sharPrefe.getString("UsuarioObj","");

        Gson gson = new Gson();
        LoginResponseDto tuObjeto = gson.fromJson(jsonString, LoginResponseDto.class);

        return tuObjeto.getToken();
    }
}
