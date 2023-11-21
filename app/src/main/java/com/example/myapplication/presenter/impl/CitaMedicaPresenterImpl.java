package com.example.myapplication.presenter.impl;

import com.example.myapplication.dto.ResponsePostDto;
import com.example.myapplication.dto.citaMedica.CitaMedicaRequestDto;
import com.example.myapplication.dto.citaMedica.CitaMedicaResponseDto;
import com.example.myapplication.presenter.ICitaMedicaPresenter;
import com.example.myapplication.repository.CitaMedicaRepository;

import io.reactivex.Observable;

public class CitaMedicaPresenterImpl implements ICitaMedicaPresenter {

    CitaMedicaRepository repo = new CitaMedicaRepository();

    @Override
    public Observable<ResponsePostDto> crearCitaMedica(CitaMedicaRequestDto citaMedicaRequestDto) {
        return repo.crearCitaMedica(citaMedicaRequestDto);
    }

    @Override
    public Observable<CitaMedicaResponseDto> obtenerCitasMedicas(String uidUsuario) {
        return repo.obtenerCitasMedicas(uidUsuario);
    }
}
