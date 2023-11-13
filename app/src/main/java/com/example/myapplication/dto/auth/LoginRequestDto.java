package com.example.myapplication.dto.auth;

public class LoginRequestDto {
    private String dniUsuario;
    private String claveUsuario;

    public LoginRequestDto(String dniUsuario, String claveUsuario) {
        this.dniUsuario = dniUsuario;
        this.claveUsuario = claveUsuario;
    }

    public String getDniUsuario() {
        return dniUsuario;
    }

    public void setDniUsuario(String dniUsuario) {
        this.dniUsuario = dniUsuario;
    }

    public String getClaveUsuario() {
        return claveUsuario;
    }

    public void setClaveUsuario(String claveUsuario) {
        this.claveUsuario = claveUsuario;
    }
}
