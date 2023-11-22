package com.example.myapplication.presenter.impl;

import android.content.Context;

import com.example.myapplication.dto.ResponsePostDto;
import com.example.myapplication.dto.citaMedica.CitaMedicaRequestDto;
import com.example.myapplication.dto.citaMedica.CitaMedicaResponseDto;
import com.example.myapplication.presenter.ICitaMedicaPresenter;
import com.example.myapplication.repository.CitaMedicaRepository;

import io.reactivex.Observable;

public class CitaMedicaPresenterImpl implements ICitaMedicaPresenter {

    CitaMedicaRepository repo = new CitaMedicaRepository();

    @Override
    public Observable<ResponsePostDto> crearCitaMedica(CitaMedicaRequestDto citaMedicaRequestDto, Context context) {
        return repo.crearCitaMedica(citaMedicaRequestDto,context);
    }

    @Override
    public Observable<CitaMedicaResponseDto> obtenerCitasMedicas(String uidUsuario, Context context) {
        return repo.obtenerCitasMedicas(uidUsuario,context);
    }
}
