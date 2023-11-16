package com.example.myapplication.model;

import java.util.List;

public class Doctor {

    String id;
    String nombre;
    String foto;
    String estado;
    DoctorSpeciality codeSpeciality;
    List<FechaDiponibleEspecialidad> listHorarios;

    public Doctor(String id, String nombre, String estado, String foto, DoctorSpeciality codeSpeciality, List<FechaDiponibleEspecialidad> listHorarios) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
        this.foto = foto;
        this.codeSpeciality = codeSpeciality;
        this.listHorarios = listHorarios;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public DoctorSpeciality getCodeSpeciality() {
        return codeSpeciality;
    }

    public void setCodeSpeciality(DoctorSpeciality codeSpeciality) {
        this.codeSpeciality = codeSpeciality;
    }

    public List<FechaDiponibleEspecialidad> getListHorarios() {
        return listHorarios;
    }

    public void setListHorarios(List<FechaDiponibleEspecialidad> listHorarios) {
        this.listHorarios = listHorarios;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
