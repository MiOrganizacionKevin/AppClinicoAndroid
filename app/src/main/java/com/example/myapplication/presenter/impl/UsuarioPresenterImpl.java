package com.example.myapplication.presenter.impl;

import com.example.myapplication.dto.ResponsePostDto;
import com.example.myapplication.dto.UsuarioDto;
import com.example.myapplication.presenter.IUsuarioPresenter;
import com.example.myapplication.repository.UsuarioRepository;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import io.reactivex.Observable;

@Module
@InstallIn(ActivityComponent.class)
public class UsuarioPresenterImpl implements IUsuarioPresenter {

    private UsuarioRepository usuRepo = new UsuarioRepository();

    @Inject
    public UsuarioPresenterImpl(){

    }

    @Override
    @Provides
    public Observable<ResponsePostDto> registroUsuario(UsuarioDto usuarioDto) {
        return usuRepo.registroUsuario(usuarioDto);
    }
}
