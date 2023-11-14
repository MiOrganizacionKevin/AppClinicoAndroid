package com.example.myapplication.presenter;

import com.example.myapplication.dto.EspecialidadDto;

import io.reactivex.Observable;

public interface IEspecialidadPresente {

    public Observable<EspecialidadDto> especialidadesDoctor();
}
