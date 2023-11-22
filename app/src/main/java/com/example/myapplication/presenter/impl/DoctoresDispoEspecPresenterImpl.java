package com.example.myapplication.presenter.impl;

import android.content.Context;

import com.example.myapplication.dto.doctoresDiEs.DoctDispEspRequest;
import com.example.myapplication.dto.doctoresDiEs.DoctoresDispoEspecDto;
import com.example.myapplication.presenter.IDoctoresDispoEspecPresenter;
import com.example.myapplication.repository.DoctoresDispoEspecRepository;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import io.reactivex.Observable;

@Module
@InstallIn(ActivityComponent.class)
public class DoctoresDispoEspecPresenterImpl implements IDoctoresDispoEspecPresenter {

    DoctoresDispoEspecRepository repo = new DoctoresDispoEspecRepository();

    @Inject
    public DoctoresDispoEspecPresenterImpl() {
    }

    @Override
    @Provides
    public Observable<DoctoresDispoEspecDto> doctoresDisponiblesEspecialidad(DoctDispEspRequest doctDispEspRequest, Context context) {
        return repo.doctoresDisponiblesEspecialidad(doctDispEspRequest,context);
    }
}
