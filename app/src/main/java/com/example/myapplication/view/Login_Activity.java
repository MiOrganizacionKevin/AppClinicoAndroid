package com.example.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.R;
import com.example.myapplication.model.UsuarioLogin;
import com.example.myapplication.respository.UsuarioLoginRepo;
import com.example.myapplication.view.interf.LoginInterf;

public class Login_Activity extends AppCompatActivity implements LoginInterf {

    private EditText editTextDNI, editTextPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextDNI = findViewById(R.id.editTextDNI);
        editTextPassword = findViewById(R.id.editTextPassword);



        Button buttonLogin = findViewById(R.id.buttonLogin);
        Button buttonCreateAccount = findViewById(R.id.buttonCreateAccount);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                //System.out.println("DNI:"+editTextDNI.getText());
                //System.out.println("DNI:"+editTextPassword.getText());

                //pasarAMainActivity();
            }
        });

        buttonCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Intent intent = new Intent(Login_Activity.this, Register_Activity.class);
                startActivity(intent);*/
                //pasarAMainActivity();


            }
        });
    }


    @Override
    public UsuarioLogin loginUsuaView() {
        return null;
    }
}