package com.example.myapplication.model;

public class HorasDoctor {

    private String uid;
    private String hora;
    private String minuto;
    private String doctorFechaDiEs;


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getMinuto() {
        return minuto;
    }

    public void setMinuto(String minuto) {
        this.minuto = minuto;
    }

    public String getDoctorFechaDiEs() {
        return doctorFechaDiEs;
    }

    public void setDoctorFechaDiEs(String doctorFechaDiEs) {
        this.doctorFechaDiEs = doctorFechaDiEs;
    }
}
