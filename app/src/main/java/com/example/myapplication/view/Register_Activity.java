package com.example.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.R;

public class Register_Activity extends AppCompatActivity {

    private EditText dniEditText, nombreEditText, apellidoEditText,
            emailEditText, contrasenaEditText;

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

        Button registrarseButton = findViewById(R.id.registrarseButton);


        registrarseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dni = dniEditText.getText().toString();
                String nombre = nombreEditText.getText().toString();
                String apellido = apellidoEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String contrasena = contrasenaEditText.getText().toString();

                Intent intent = new Intent(Register_Activity.this, Login_Activity.class);
                startActivity(intent);

            }
        });

    }
}