package com.example.myapplication.presenter;

import android.content.Context;

import com.example.myapplication.dto.HorasDoctorDto;

import io.reactivex.Observable;

public interface IHorasDoctorPresenter {

    public Observable<HorasDoctorDto> horasDoctor(String uidDoctorFechaDiEs, Context context);
}
