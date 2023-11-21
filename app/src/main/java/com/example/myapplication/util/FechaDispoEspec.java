package com.example.myapplication.util;

import com.example.myapplication.model.Especialidad;

public class FechaDispoEspec {

    private String uid;
    private String mes;
    private String dia;
    private Especialidad especialidad;

    public FechaDispoEspec(String uid, String mes, String dia, Especialidad especialidad) {
        this.uid = uid;
        this.mes = mes;
        this.dia = dia;
        this.especialidad = especialidad;
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

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }
}
