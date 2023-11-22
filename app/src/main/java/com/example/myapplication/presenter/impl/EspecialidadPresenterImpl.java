package com.example.myapplication.presenter.impl;

import android.content.Context;

import com.example.myapplication.dto.EspecialidadDto;
import com.example.myapplication.presenter.IEspecialidadPresente;
import com.example.myapplication.repository.EspecialidadRepository;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import io.reactivex.Observable;

@Module
@InstallIn(ActivityComponent.class)
public class EspecialidadPresenterImpl implements IEspecialidadPresente {

    EspecialidadRepository especRepo = new EspecialidadRepository();

    @Inject
    public EspecialidadPresenterImpl() {
    }

    @Override
    @Provides
    public Observable<EspecialidadDto> especialidadesDoctor(Context context) {
        return especRepo.especialidadesDoctores(context);
    }
}
