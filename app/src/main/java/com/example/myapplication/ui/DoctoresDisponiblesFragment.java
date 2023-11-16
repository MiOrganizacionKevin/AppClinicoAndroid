package com.example.myapplication.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.Doctor;
import com.example.myapplication.ui.adapters.DoctorCardAdapter;
import com.example.myapplication.util.MockData;

import java.util.List;


public class DoctoresDisponiblesFragment extends Fragment {

    private List<Doctor> doctoresDisponibles;
    private RecyclerView recyclerView;
    private DoctorCardAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        DoctoresDisponiblesFragmentArgs args = DoctoresDisponiblesFragmentArgs.fromBundle(getArguments());
        String specility = args.getSpecialityToSearch();
        String date = args.getDateToSearch();

        View rootView =  inflater.inflate(R.layout.fragment_doctores_disponibles, container, false);

        TextView textDate = rootView.findViewById(R.id.textDate);
        TextView textSpeciality = rootView.findViewById(R.id.textSpeciality);
        recyclerView = rootView.findViewById(R.id.recycler_view_doctores);

        textDate.setText(date);
        textSpeciality.setText(specility);

        MockData generatorMockData = new MockData();
        doctoresDisponibles = generatorMockData.getDoctoresDisponibles();
        adapter = new DoctorCardAdapter(doctoresDisponibles);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));

        return rootView;
    }
}