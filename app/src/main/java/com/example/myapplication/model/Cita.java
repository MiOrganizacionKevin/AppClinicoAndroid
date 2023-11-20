package com.example.myapplication.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Cita {

    String id;
    Doctor doctor;
    DoctorSpeciality codeSpeciality;
    Date fechaCita;

    public Cita(String id, Doctor doctor, DoctorSpeciality codeSpeciality, Date fechaCita) {
        this.id = id;
        this.doctor = doctor;
        this.codeSpeciality = codeSpeciality;
        this.fechaCita = fechaCita;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public DoctorSpeciality getCodeSpeciality() {
        return codeSpeciality;
    }

    public void setCodeSpeciality(DoctorSpeciality codeSpeciality) {
        this.codeSpeciality = codeSpeciality;
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getTimeToShowCard() {
        SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm", Locale.getDefault());
        return timeFormatter.format(fechaCita);
    }

    public String getDateToShowCard() {
        SimpleDateFormat timeFormatter = new SimpleDateFormat("d MMM, yyyy", Locale.getDefault());
        return timeFormatter.format(fechaCita);
    }
}
