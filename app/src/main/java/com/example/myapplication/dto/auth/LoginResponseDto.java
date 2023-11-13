package com.example.myapplication.dto.auth;

import com.example.myapplication.model.Usuario;

public class LoginResponseDto {

    private Usuario usuario;
    private String token;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
