package com.example.myapplication.dto;

import com.example.myapplication.model.FechasDisponiblesEspecialidad;

import java.util.List;

public class FechasDispoEspecDto {

    private int total;
    private List<FechasDisponiblesEspecialidad> fechas;

    public FechasDispoEspecDto(int total, List<FechasDisponiblesEspecialidad> fechas) {
        this.total = total;
        this.fechas = fechas;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<FechasDisponiblesEspecialidad> getFechas() {
        return fechas;
    }

    public void setFechas(List<FechasDisponiblesEspecialidad> fechas) {
        this.fechas = fechas;
    }
}
