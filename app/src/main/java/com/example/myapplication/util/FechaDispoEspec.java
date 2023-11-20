package com.example.myapplication.util;

public class FechaDispoEspec {

    private String mes;
    private String dia;

    public FechaDispoEspec(String mes, String dia) {
        this.mes = mes;
        this.dia = dia;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }
}
