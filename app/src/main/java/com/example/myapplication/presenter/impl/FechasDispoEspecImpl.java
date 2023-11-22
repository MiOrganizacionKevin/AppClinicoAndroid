package com.example.myapplication.presenter.impl;

import android.content.Context;

import com.example.myapplication.dto.FechasDispoEspecDto;
import com.example.myapplication.presenter.IFechasDispoEspec;
import com.example.myapplication.repository.EspecialidadRepository;
import com.example.myapplication.repository.FechasDispoEspecRepository;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import io.reactivex.Observable;

@Module
@InstallIn(ActivityComponent.class)
public class FechasDispoEspecImpl implements IFechasDispoEspec {

    FechasDispoEspecRepository repo = new FechasDispoEspecRepository();

    @Inject
    public FechasDispoEspecImpl() {
    }

    @Override
    @Provides
    public Observable<FechasDispoEspecDto> fechasDisponiblesEspecialidad(String mes, String anio, String especialidad, Context context) {
        return repo.fechasDispoEspecialidades(mes,anio,especialidad,context);
    }
}
