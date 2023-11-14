package com.example.myapplication.presenter;

import com.example.myapplication.dto.RegUsuResponseDto;
import com.example.myapplication.dto.UsuarioDto;

import io.reactivex.Observable;

public interface IUsuarioPresenter {
    public Observable<RegUsuResponseDto> registroUsuario(UsuarioDto usuarioDto);
}
