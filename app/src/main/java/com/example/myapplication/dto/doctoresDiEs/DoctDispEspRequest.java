package com.example.myapplication.dto.doctoresDiEs;

public class DoctDispEspRequest {

    private String especialidadREQ;
    private String fechaDispoEspecREQ;

    public DoctDispEspRequest(String especialidadREQ, String fechaDispoEspecREQ) {
        this.especialidadREQ = especialidadREQ;
        this.fechaDispoEspecREQ = fechaDispoEspecREQ;
    }

    public String getEspecialidadREQ() {
        return especialidadREQ;
    }

    public void setEspecialidadREQ(String especialidadREQ) {
        this.especialidadREQ = especialidadREQ;
    }

    public String getFechaDispoEspecREQ() {
        return fechaDispoEspecREQ;
    }

    public void setFechaDispoEspecREQ(String fechaDispoEspecREQ) {
        this.fechaDispoEspecREQ = fechaDispoEspecREQ;
    }
}
