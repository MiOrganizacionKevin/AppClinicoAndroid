package com.example.myapplication.dto.doctoresDiEs;

import com.example.myapplication.model.DoctoresDispoEspec;

import java.util.List;

public class DoctoresDispoEspecDto {
    private String total;
    private List<DoctoresDispoEspec> doctorFechaDispoEspec;

//    public DoctoresDispoEspecDto(String total, DoctoresDispoEspecDto doctorFechaDispoEspec) {
//        this.total = total;
//        this.doctorFechaDispoEspec = doctorFechaDispoEspec;
//    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<DoctoresDispoEspec> getDoctorFechaDispoEspec() {
        return doctorFechaDispoEspec;
    }

    public void setDoctorFechaDispoEspec(List<DoctoresDispoEspec> doctorFechaDispoEspec) {
        this.doctorFechaDispoEspec = doctorFechaDispoEspec;
    }
}
