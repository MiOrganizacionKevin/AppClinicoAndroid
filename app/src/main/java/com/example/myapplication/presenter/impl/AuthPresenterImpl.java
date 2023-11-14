package com.example.myapplication.presenter.impl;

import com.example.myapplication.dto.auth.LoginRequestDto;
import com.example.myapplication.dto.auth.LoginResponseDto;
import com.example.myapplication.presenter.IAuthPresenter;
import com.example.myapplication.repository.LoginRepository;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import io.reactivex.Observable;

@Module
@InstallIn(ActivityComponent.class)
public class AuthPresenterImpl implements IAuthPresenter {

    private LoginRepository loginRepo = new LoginRepository();

    @Inject
    public AuthPresenterImpl() {
    }

    @Override
    @Provides
    public Observable<LoginResponseDto> loginUsuario(LoginRequestDto loginRequestDto) {
        return loginRepo.loginResponseDtoObservable(loginRequestDto);
    }
}
