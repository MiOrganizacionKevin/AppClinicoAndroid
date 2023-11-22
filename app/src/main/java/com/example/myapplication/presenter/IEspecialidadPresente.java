package com.example.myapplication.presenter;

import android.content.Context;

import com.example.myapplication.dto.EspecialidadDto;

import io.reactivex.Observable;

public interface IEspecialidadPresente {

    public Observable<EspecialidadDto> especialidadesDoctor(Context context);
}
