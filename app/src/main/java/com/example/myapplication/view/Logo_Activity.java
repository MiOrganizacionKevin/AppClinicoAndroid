package com.example.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.example.myapplication.R;

public class Logo_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_logo);

        //Agregar Animaciones

        Animation animacion1 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_arriba);
        Animation animacion2 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_abajo);

        TextView fromText = findViewById(R.id.fromText);
        TextView VitaClinicText = findViewById(R.id.VitaClinicText);
        //ImageView imageLogoMedicine = findViewById(R.id.imageLogoMedicine);
        TextView imageLogoMedicine = findViewById(R.id.imageLogoMedicine);


        fromText.setAnimation(animacion2);
        VitaClinicText.setAnimation(animacion2);
        imageLogoMedicine.setAnimation(animacion1);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Logo_Activity.this, Login_Activity.class);
                startActivity(intent);
                finish();
            }

        }, 4000);

    }
}