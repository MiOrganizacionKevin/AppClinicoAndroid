package com.example.myapplication.model;

public class FechasDisponiblesEspecialidad {

    private String uid;
    private String mes;
    private String dia;
    private String anio;
    private Especialidad especialidad;

    public FechasDisponiblesEspecialidad(String uid, String mes, String dia, String anio, Especialidad especialidad) {
        this.uid = uid;
        this.mes = mes;
        this.dia = dia;
        this.anio = anio;
        this.especialidad = especialidad;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
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

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }
}
