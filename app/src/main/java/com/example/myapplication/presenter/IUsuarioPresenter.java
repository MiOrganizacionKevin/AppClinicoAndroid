package com.example.myapplication.presenter;

import com.example.myapplication.dto.ResponsePostDto;
import com.example.myapplication.dto.UsuarioDto;

import io.reactivex.Observable;

public interface IUsuarioPresenter {
    public Observable<ResponsePostDto> registroUsuario(UsuarioDto usuarioDto);
}
