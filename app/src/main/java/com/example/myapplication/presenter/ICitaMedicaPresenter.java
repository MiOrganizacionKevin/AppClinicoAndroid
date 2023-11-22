package com.example.myapplication.presenter;

import android.content.Context;

import com.example.myapplication.dto.ResponsePostDto;
import com.example.myapplication.dto.citaMedica.CitaMedicaRequestDto;
import com.example.myapplication.dto.citaMedica.CitaMedicaResponseDto;

import io.reactivex.Observable;

public interface ICitaMedicaPresenter {

    public Observable<ResponsePostDto> crearCitaMedica(CitaMedicaRequestDto citaMedicaRequestDto, Context context);

    public Observable<CitaMedicaResponseDto> obtenerCitasMedicas(String uidUsuario, Context context);
}
