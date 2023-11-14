package com.example.myapplication.dto;

import com.example.myapplication.model.Especialidad;

import java.util.List;

public class EspecialidadDto {
    private int total;
    private List<Especialidad> especialidadDoctor;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Especialidad> getEspecialidadDoctor() {
        return especialidadDoctor;
    }

    public void setEspecialidadDoctor(List<Especialidad> especialidadDoctor) {
        this.especialidadDoctor = especialidadDoctor;
    }
}
