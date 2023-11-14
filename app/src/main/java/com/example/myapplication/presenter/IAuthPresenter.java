package com.example.myapplication.presenter;

import com.example.myapplication.dto.auth.LoginRequestDto;
import com.example.myapplication.dto.auth.LoginResponseDto;

import io.reactivex.Observable;

public interface IAuthPresenter {

    public Observable<LoginResponseDto> loginUsuario(LoginRequestDto loginRequestDto);
}
