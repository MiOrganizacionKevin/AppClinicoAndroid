package com.example.myapplication.view;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.myapplication.R;

public class VistaPrincipal_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_principal);

        ImageButton misCitasButton = findViewById(R.id.misCitasButton);
        ImageButton registrarCitaButton = findViewById(R.id.registrarCitasButton);
        ImageButton misCitas2Button = findViewById(R.id.misCitas2Button);

        misCitasButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent = new Intent(VistaPrincipal_Activity.this, Citas_Activity.class);
                startActivity(intent);*/
            }
        });

        misCitas2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent = new Intent(VistaPrincipal_Activity.this, Citas_Activity.class);
                startActivity(intent);*/
            }
        });

        registrarCitaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent = new Intent(VistaPrincipal_Activity.this, Register_Citas_Activity.class);
                startActivity(intent);*/
            }
        });

    }
}