package com.example.myapplication.presenter;

import com.example.myapplication.dto.doctoresDiEs.DoctDispEspRequest;
import com.example.myapplication.dto.doctoresDiEs.DoctoresDispoEspecDto;

import io.reactivex.Observable;

public interface IDoctoresDispoEspecPresenter {

    public Observable<DoctoresDispoEspecDto> doctoresDisponiblesEspecialidad(DoctDispEspRequest doctDispEspRequest);
}
