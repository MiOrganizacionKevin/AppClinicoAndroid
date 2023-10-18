package com.example.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.myapplication.R;

public class RegistrarCita_Activity extends AppCompatActivity {

    private Spinner especialidadSpinner;
    private Button buscarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_cita);

        // Inicializar el Spinner
        especialidadSpinner = findViewById(R.id.especialidadSpinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.opciones_especialidad, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        especialidadSpinner.setAdapter(adapter);

        // Inicializar el botón de búsqueda
        buscarButton = findViewById(R.id.buscarButton);

        // Configurar el evento de clic del botón
        buscarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Acciones a realizar cuando se hace clic en el botón de búsqueda
                String especialidadSeleccionada = especialidadSpinner.getSelectedItem().toString();
            }
        });
    }
}