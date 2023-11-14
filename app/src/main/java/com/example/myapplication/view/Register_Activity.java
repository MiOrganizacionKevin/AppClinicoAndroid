package com.example.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.dto.UsuarioDto;
import com.example.myapplication.presenter.impl.UsuarioPresenterImpl;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;
import io.reactivex.android.schedulers.AndroidSchedulers;

@AndroidEntryPoint
public class Register_Activity extends AppCompatActivity {

    private EditText dniEditText, nombreEditText, apellidoEditText,
            emailEditText, contrasenaEditText;
    private Button registrarseButton;

    @Inject
    UsuarioPresenterImpl usuarioPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Inicializa los elementos de la interfaz

        dniEditText = findViewById(R.id.dniEditText);
        nombreEditText = findViewById(R.id.nombreEditText);
        apellidoEditText = findViewById(R.id.apellidoEditText);
        emailEditText = findViewById(R.id.emailEditText);
        contrasenaEditText = findViewById(R.id.contrasenaEditText);

        registrarseButton = findViewById(R.id.registrarseButton);

    }

    public void registrarUsuarioBtn(View view){

        usuarioPresenter.registroUsuario(new UsuarioDto(Integer.parseInt(dniEditText.getText().toString()),nombreEditText.getText().toString(),apellidoEditText.getText().toString(),emailEditText.getText().toString(),contrasenaEditText.getText().toString()))
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        registro ->{
                            if(registro.getSuccess()){
                                Intent intent = new Intent(Register_Activity.this, Login_Activity.class);
                                startActivity(intent);
                                System.out.println("Dni: "+Integer.parseInt(dniEditText.getText().toString()));
                                System.out.println("nombre: "+nombreEditText.getText().toString());
                                System.out.println("apellido: "+apellidoEditText.getText().toString());
                                System.out.println("email: "+emailEditText.getText().toString());
                                System.out.println("clave: "+contrasenaEditText.getText().toString());
                            }else{
                                Toast.makeText(this,registro.getMsg(),Toast.LENGTH_SHORT).show();
                            }
                        }
                );
    }
}