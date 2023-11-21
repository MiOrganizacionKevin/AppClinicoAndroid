package com.example.myapplication.model;

public class DoctoresDispoEspec {

    private String uid;
    private Doctor doctor;
    private FechasDisponiblesEspecialidad fechaDispoEspec;

    public DoctoresDispoEspec(String uid, Doctor doctor, FechasDisponiblesEspecialidad fechaDispoEspec) {
        this.uid = uid;
        this.doctor = doctor;
        this.fechaDispoEspec = fechaDispoEspec;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public FechasDisponiblesEspecialidad getFechaDispoEspec() {
        return fechaDispoEspec;
    }

    public void setFechaDispoEspec(FechasDisponiblesEspecialidad fechaDispoEspec) {
        this.fechaDispoEspec = fechaDispoEspec;
    }
}
