package com.example.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.myapplication.R;

public class Register_Cita_Activity extends AppCompatActivity {

    private Spinner especialidadSpinner;
    private Button buscarButton;

    String[] items = {"Medicina", "Pediatría", "Neurología","Cardiología"};

    AutoCompleteTextView autoCompleteTextView;

    ArrayAdapter<String> adapterItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_cita);

        autoCompleteTextView = findViewById(R.id.especialidadTextView);

        //adapterItems = new ArrayAdapter<String>(this, R.layout.list_item,items);

        //autoCompleteTextView.setAdapter(adapterItems);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), "Especialidad: "+item,Toast.LENGTH_LONG).show();
            }
        });

        buscarButton = findViewById(R.id.buscarButton);

        buscarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Acciones a realizar cuando se hace clic en el botón de búsqueda
                //String especialidadSeleccionada = especialidadSpinner.getSelectedItem().toString();
            }
        });


    }
}