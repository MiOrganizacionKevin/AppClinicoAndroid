package com.example.myapplication.dto.citaMedica;

import com.example.myapplication.model.CitaMedica;

import java.util.List;

public class CitaMedicaResponseDto {
    private int total;
    private List<CitaMedica> citasMedicas;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<CitaMedica> getCitasMedicas() {
        return citasMedicas;
    }

    public void setCitasMedicas(List<CitaMedica> citasMedicas) {
        this.citasMedicas = citasMedicas;
    }
}
