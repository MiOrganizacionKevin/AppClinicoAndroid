package com.example.myapplication.presenter;

import com.example.myapplication.dto.FechasDispoEspecDto;

import io.reactivex.Observable;

public interface IFechasDispoEspec {

    public Observable<FechasDispoEspecDto> fechasDisponiblesEspecialidad(String mes,String anio,String especialidad);
}
