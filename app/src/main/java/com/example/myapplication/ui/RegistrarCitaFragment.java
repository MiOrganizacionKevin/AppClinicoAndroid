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
import com.example.myapplication.dto.EspecialidadDto;
import com.example.myapplication.model.Especialidad;
import com.example.myapplication.presenter.impl.EspecialidadPresenterImpl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;
import io.reactivex.android.schedulers.AndroidSchedulers;

@AndroidEntryPoint
public class RegistrarCitaFragment extends Fragment {

    private Spinner especialidadSpinner;
    private Button buscarButton;

    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapterItems;

    @Inject
    EspecialidadPresenterImpl especPresenter;


    public RegistrarCitaFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_registrar_cita, container, false);

        especPresenter.especialidadesDoctor()
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        especialidad -> {
                            List<String> listaItems = creacionDeListaItems(especialidad);
                            listaEspecialidadView(rootView,listaItems);
                        }
                );

        //Boton BUSCAR
        botonBuscar(rootView);

        return rootView;
    }

    public List<String> creacionDeListaItems(EspecialidadDto listaDto){

        List<String> items = new ArrayList<>();

        listaDto.getEspecialidadDoctor().forEach( nombre -> {
            items.add(nombre.getNombre());
        });

        return items;
    }


    public void listaEspecialidadView(View view, List<String> items){
        // Configura las vistas y eventos
        autoCompleteTextView = view.findViewById(R.id.especialidadTextView);
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
    }

    public void botonBuscar(View view){
        buscarButton = view.findViewById(R.id.buscarButton);

        buscarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });
    }
}