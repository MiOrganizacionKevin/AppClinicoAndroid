package com.example.myapplication.model;

public class Doctor {
    private String uid;
    private String nombre;
    private Especialidad especialidad;

    public Doctor(String uid, String nombre, Especialidad especialidad) {
        this.uid = uid;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

}
