package com.example.myapplication.presenter;

import com.example.myapplication.model.UsuarioLogin;
import com.example.myapplication.presenter.interf.LoginPresenterInterf;
import com.example.myapplication.view.interf.LoginInterf;

public class LoginPresenter implements LoginPresenterInterf {

    private LoginInterf loginInterf;



    @Override
    public void verificarLoginView() {
        UsuarioLogin usuarioLogin =loginInterf.loginUsuaView();
    }



    /////////////////////////////////////////


    @Override
    public void verificarLoginModel() {

    }
}
