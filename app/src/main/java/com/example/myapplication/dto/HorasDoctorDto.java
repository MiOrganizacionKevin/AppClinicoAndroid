package com.example.myapplication.dto;

import com.example.myapplication.model.HorasDoctor;

import java.util.List;

public class HorasDoctorDto {
    private String total;
    private List<HorasDoctor> horasDoctor;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<HorasDoctor> getHorasDoctor() {
        return horasDoctor;
    }

    public void setHorasDoctor(List<HorasDoctor> horasDoctor) {
        this.horasDoctor = horasDoctor;
    }
}
