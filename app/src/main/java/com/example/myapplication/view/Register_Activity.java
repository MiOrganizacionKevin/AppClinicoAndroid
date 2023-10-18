package com.example.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.myapplication.R;

import java.util.Calendar;

public class Register_Activity extends AppCompatActivity {

    private EditText dniEditText, nombreEditText, apellidoPaternoEditText, apellidoMaternoEditText,
            sexoEditText, emailEditText, telefonoEditText, contrasenaEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Inicializa los elementos de la interfaz
        dniEditText = findViewById(R.id.dniEditText);
        nombreEditText = findViewById(R.id.nombreEditText);
        apellidoPaternoEditText = findViewById(R.id.apellidoPaternoEditText);
        apellidoMaternoEditText = findViewById(R.id.apellidoMaternoEditText);
        sexoEditText = findViewById(R.id.sexoEditText);
        emailEditText = findViewById(R.id.emailEditText);
        telefonoEditText = findViewById(R.id.telefonoEditText);
        contrasenaEditText = findViewById(R.id.contrasenaEditText);

        EditText fechaNacimientoEditText = findViewById(R.id.fechaNacimientoEditText);
        Button registrarseButton = findViewById(R.id.registrarseButton);

        fechaNacimientoEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }

            private void showDatePickerDialog() {
                DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;
                        fechaNacimientoEditText.setText(selectedDate);
                    }
                };

                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(Register_Activity.this, dateSetListener, year, month, day);
                datePickerDialog.show();
            }

        });
        registrarseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dni = dniEditText.getText().toString();
                String nombre = nombreEditText.getText().toString();
                String apellidoPaterno = apellidoPaternoEditText.getText().toString();
                String apellidoMaterno = apellidoMaternoEditText.getText().toString();
                String sexo = sexoEditText.getText().toString();
                String fechaNacimiento = fechaNacimientoEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String telefono = telefonoEditText.getText().toString();
                String contrasena = contrasenaEditText.getText().toString();

               /* Intent intent = new Intent(Register_Activity.this, Login_Activity.class);
                startActivity(intent);*/
            }
        });



    }
}