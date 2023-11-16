package com.example.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.dto.auth.LoginRequestDto;
import com.example.myapplication.model.Usuario;
import com.example.myapplication.repository.LoginRepository;
import com.google.gson.Gson;

import io.reactivex.android.schedulers.AndroidSchedulers;

public class Login_Activity extends AppCompatActivity {

    private EditText editTextDNI, editTextPassword;
    private ProgressBar progressBar;

    LoginRepository loginRepo = new LoginRepository();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextDNI = findViewById(R.id.editTextDNI);
        editTextPassword = findViewById(R.id.editTextPassword);

        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);

        usuarioEstaLogueado();
//
//        Button buttonLogin = findViewById(R.id.buttonLogin);
//        Button buttonCreateAccount = findViewById(R.id.buttonCreateAccount);
//
//        buttonLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Login_Activity.this, MainActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        buttonCreateAccount.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Login_Activity.this, Register_Activity.class);
//                startActivity(intent);
//            }
//        });
    }

    private void usuarioEstaLogueado() {
        SharedPreferences prefs = getSharedPreferences("UsuarioLogueado", Context.MODE_PRIVATE);
        boolean isLogged = prefs.getBoolean("isLogged", false);

        if (isLogged) {
            // El usuario ha iniciado sesión, abrir directamente la MainActivity
            startActivity(new Intent(this, MainActivity.class));
            finish();  // Opcional: Finalizar esta actividad para que no aparezca en la pila
        }
    }

    public void startDefaultUser(View view) {
        SharedPreferences sharPrefe = getSharedPreferences("MockApp", Context.MODE_PRIVATE);
        SharedPreferences.Editor shareEdit = sharPrefe.edit();
        Gson gson = new Gson();
        var mockUsuario = new Usuario();
        mockUsuario.setUid("mockUID");
        mockUsuario.setDniUsuario(44556677);
        mockUsuario.setNombreUsuario("Juan");
        mockUsuario.setApellidoUsuario("García");
        mockUsuario.setCorreoUsuario("juan-garcia@gmail.com");
        mockUsuario.setRol("Doctor");
        mockUsuario.setEstado(true);
        shareEdit.putString("UsuarioObj", gson.toJson(mockUsuario));
        shareEdit.putBoolean("isLogged",true);
        shareEdit.apply();

        Intent intent = new Intent(Login_Activity.this, MainActivity.class);

        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
    public void iniciarSesionBtn(View view){

        progressBar.setVisibility(View.VISIBLE);

        loginRepo.loginResponseDtoObservable(new LoginRequestDto(editTextDNI.getText().toString(),editTextPassword.getText().toString()))
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        login -> {
                            if(login.getUsuario() == null){
                                progressBar.setVisibility(View.GONE);
                                Toast.makeText(this,"Usuario incorrecto",Toast.LENGTH_SHORT).show();
                                Log.d("LoginActivity","Usuario incorrecto");
                            }else{
                                Gson gson = new Gson();
                                progressBar.setVisibility(View.GONE);
                                //TuObjeto tuObjeto = gson.fromJson(jsonString, TuObjeto.class);
                                Log.d("LoginActivity","Ingreso El usuario: "+gson.toJson(login));

                                SharedPreferences sharPrefe = getSharedPreferences("UsuarioLogueado", Context.MODE_PRIVATE);

                                SharedPreferences.Editor shareEdit = sharPrefe.edit();
                                shareEdit.putString("UsuarioObj",gson.toJson(login));
                                shareEdit.putBoolean("isLogged",true);
                                shareEdit.commit();

                                Intent intent = new Intent(Login_Activity.this, MainActivity.class);

                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);
                                finish();

                            }

                        }
                );


    }
}