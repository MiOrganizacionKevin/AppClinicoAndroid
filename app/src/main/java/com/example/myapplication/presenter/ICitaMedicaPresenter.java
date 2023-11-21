package com.example.myapplication.presenter;

import com.example.myapplication.dto.ResponsePostDto;
import com.example.myapplication.dto.citaMedica.CitaMedicaRequestDto;
import com.example.myapplication.dto.citaMedica.CitaMedicaResponseDto;

import io.reactivex.Observable;

public interface ICitaMedicaPresenter {

    public Observable<ResponsePostDto> crearCitaMedica(CitaMedicaRequestDto citaMedicaRequestDto);

    public Observable<CitaMedicaResponseDto> obtenerCitasMedicas(String uidUsuario);
}
