package com.example.myapplication.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.dto.auth.LoginResponseDto;
import com.example.myapplication.model.CitaMedica;
import com.example.myapplication.presenter.impl.CitaMedicaPresenterImpl;
import com.example.myapplication.ui.adapter.citasMedicas.CitaCardAdapter;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;

public class MisCitasFragment extends Fragment {

    private List<CitaMedica> citasUsuario;
    private RecyclerView recyclerView;
    private CitaCardAdapter adapter;

    CitaMedicaPresenterImpl citaMedicaPresenter = new CitaMedicaPresenterImpl();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_mis_citas, container, false);

        recyclerView = rootView.findViewById(R.id.recylerMisCitas);

        //-----------------
        Context contexto = getContext();
        SharedPreferences sharPrefe = contexto.getSharedPreferences("UsuarioLogueado", Context.MODE_PRIVATE);
        String jsonString = sharPrefe.getString("UsuarioObj","");

        Gson gson = new Gson();
        LoginResponseDto tuObjeto = gson.fromJson(jsonString, LoginResponseDto.class);

        //-----------------
        citasUsuario = new ArrayList<>();

        citaMedicaPresenter.obtenerCitasMedicas(tuObjeto.getUsuario().getUid())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        misCitas -> {
                            if(misCitas.getCitasMedicas() == null){
                                System.out.println("No hay datos");
                            }else{
                                misCitas.getCitasMedicas().forEach( citaMedica -> {
                                    citasUsuario.add(citaMedica);
                                });
                                adapter = new CitaCardAdapter(citasUsuario);
                                recyclerView.setAdapter(adapter);
                                recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
                            }
                        }
                );

        return rootView;
    }
}