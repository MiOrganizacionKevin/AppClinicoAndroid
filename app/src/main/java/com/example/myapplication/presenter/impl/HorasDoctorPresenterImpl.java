package com.example.myapplication.presenter.impl;

import android.content.Context;

import com.example.myapplication.dto.HorasDoctorDto;
import com.example.myapplication.presenter.IHorasDoctorPresenter;
import com.example.myapplication.repository.HorasDoctorRepository;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import io.reactivex.Observable;

@Module
@InstallIn(ActivityComponent.class)
public class HorasDoctorPresenterImpl implements IHorasDoctorPresenter {

    HorasDoctorRepository repo = new HorasDoctorRepository();

    @Inject
    public HorasDoctorPresenterImpl() {
    }

    @Override
    @Provides
    public Observable<HorasDoctorDto> horasDoctor(String uidDoctorFechaDiEs, Context context) {
        return repo.horasDoctor(uidDoctorFechaDiEs,context);
    }
}
