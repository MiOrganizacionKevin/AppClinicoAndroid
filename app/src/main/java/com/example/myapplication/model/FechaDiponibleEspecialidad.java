package com.example.myapplication.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class FechaDiponibleEspecialidad {
    String id;
    Date fechaDisponibilidad;

    public FechaDiponibleEspecialidad(String id, Date fechaDisponibilidad) {
        this.id = id;
        this.fechaDisponibilidad = fechaDisponibilidad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getFechaDisponibilidad() {
        return fechaDisponibilidad;
    }

    public void setFechaDisponibilidad(Date fechaDisponibilidad) {
        this.fechaDisponibilidad = fechaDisponibilidad;
    }

    public String getDateToShowCard() {
        SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm", Locale.getDefault());
        return timeFormatter.format(fechaDisponibilidad);
    }
}
