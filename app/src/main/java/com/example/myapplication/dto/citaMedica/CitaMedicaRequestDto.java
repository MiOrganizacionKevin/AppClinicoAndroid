package com.example.myapplication.dto.citaMedica;

import com.example.myapplication.model.Usuario;

public class CitaMedicaRequestDto {

    private String usuario;
    private String nombreDoctor;
    private String fechaDeCita;
    private String especialidad;
    private String hora;

    public CitaMedicaRequestDto(String usuario, String nombreDoctor, String fechaDeCita, String especialidad, String hora) {
        this.usuario = usuario;
        this.nombreDoctor = nombreDoctor;
        this.fechaDeCita = fechaDeCita;
        this.especialidad = especialidad;
        this.hora = hora;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombreDoctor() {
        return nombreDoctor;
    }

    public void setNombreDoctor(String nombreDoctor) {
        this.nombreDoctor = nombreDoctor;
    }

    public String getFechaDeCita() {
        return fechaDeCita;
    }

    public void setFechaDeCita(String fechaDeCita) {
        this.fechaDeCita = fechaDeCita;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

}
