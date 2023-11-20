package com.example.myapplication.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.model.Cita;
import com.example.myapplication.model.Doctor;
import com.example.myapplication.ui.adapters.CitaCardAdapter;
import com.example.myapplication.ui.adapters.DoctorCardAdapter;
import com.example.myapplication.util.MockData;

import java.util.List;

public class MisCitasFragment extends Fragment {

    private List<Cita> citasUsuario;
    private RecyclerView recyclerView;
    private CitaCardAdapter adapter;

    public MisCitasFragment() {
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
        View rootView =  inflater.inflate(R.layout.fragment_mis_citas, container, false);

        recyclerView = rootView.findViewById(R.id.recylerMisCitas);

        MockData generatorMockData = new MockData();
        citasUsuario = generatorMockData.getCitas();
        adapter = new CitaCardAdapter(citasUsuario);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));

        return rootView;
    }
}