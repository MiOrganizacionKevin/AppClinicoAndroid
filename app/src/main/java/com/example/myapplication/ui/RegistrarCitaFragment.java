package com.example.myapplication.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.myapplication.R;

public class RegistrarCitaFragment extends Fragment {

    private Spinner especialidadSpinner;
    private Button buscarButton;

    String[] items = {"Medicina", "Pediatría", "Neurología","Cardiología"};

    AutoCompleteTextView autoCompleteTextView;

    ArrayAdapter<String> adapterItems;


    public RegistrarCitaFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_registrar_cita, container, false);

        // Infla el diseño del fragmento
        View rootView = inflater.inflate(R.layout.fragment_registrar_cita, container, false);

        //return inflater.inflate(R.layout.fragment_register_citas, container, false);

        // Configura las vistas y eventos
        autoCompleteTextView = rootView.findViewById(R.id.especialidadTextView);
        adapterItems = new ArrayAdapter<>(requireActivity(), R.layout.list_item, items);
        autoCompleteTextView.setAdapter(adapterItems);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast toast = Toast.makeText(requireContext(), "Especialidad: " + item, Toast.LENGTH_LONG);
                toast.setGravity(Gravity.TOP, 0, 1500); // Ajusta la posición aquí (en este ejemplo, 0 y 100)
                toast.show();
            }
        });


        buscarButton = rootView.findViewById(R.id.buscarButton);

        buscarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Acciones a realizar cuando se hace clic en el botón de búsqueda
            }
        });

        return rootView;
    }
}