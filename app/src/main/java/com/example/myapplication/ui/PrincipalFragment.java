package com.example.myapplication.ui;

import android.os.Bundle;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityMainBinding;

public class PrincipalFragment extends Fragment {

    public PrincipalFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    //Metodo para mostrar contenido del fragmento
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_principal, container, false);

        // Inflate the layout for this fragment
        return view;
    }
}