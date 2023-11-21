package com.example.myapplication.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.myapplication.R;

public class PrincipalFragment extends Fragment {

    NavController navController;
    /*@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }*/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_principal, container, false);

        ImageButton misCitasButton = rootView.findViewById(R.id.misCitasButton);
        ImageButton registrarCitaButton = rootView.findViewById(R.id.registrarCitasButton);

        registrarCitaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abre el fragmento de registro de citas (RegisterCitasFragment)
                /*Fragment registerCitasFragment = new RegistrarCitaFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.nav_host_fragment_content_main, registerCitasFragment); // Reemplaza el contenido actual con el fragmento de registro de citas
                transaction.addToBackStack(null); // Opcional: agrega la transacción a la pila de retroceso
                transaction.commit();*/

                navController = Navigation.findNavController(rootView);
                navController.navigate(R.id.registrarCitaFragment);
            }

        });

        misCitasButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController = Navigation.findNavController(rootView);
                navController.navigate(R.id.misCitasFragment);
            }
        });

        //registrarCitaButton.setOnClickListener(v -> selectFragment(new RegistrarCitaFragment()));
//nav_host_fragment_content_main
        return rootView;
    }

    void selectFragment(Fragment f){
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace(R.id.drawer_layout,f).commit();
    }
}