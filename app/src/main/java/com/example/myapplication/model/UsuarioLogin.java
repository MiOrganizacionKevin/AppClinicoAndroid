package com.example.myapplication.model;

public class UsuarioLogin {

    String dniUsuario;
    String claveUsuario;

    public UsuarioLogin(String dniUsuario, String claveUsuario) {
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
