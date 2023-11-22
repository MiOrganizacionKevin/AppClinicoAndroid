package com.example.myapplication.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.dto.auth.LoginResponseDto;
import com.example.myapplication.dto.citaMedica.CitaMedicaRequestDto;
import com.example.myapplication.model.Usuario;
import com.example.myapplication.presenter.impl.CitaMedicaPresenterImpl;
import com.google.gson.Gson;

import io.reactivex.android.schedulers.AndroidSchedulers;

public class ConfirmacionCitaFragment extends Fragment {

    CitaMedicaPresenterImpl citaMedicaPresenter = new CitaMedicaPresenterImpl();
    NavController navController;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_confirmacion_cita, container, false);

        //Recuperar Usuario logueado
        Context contexto = getContext();
        SharedPreferences sharPrefe = contexto.getSharedPreferences("UsuarioLogueado", Context.MODE_PRIVATE);
        String jsonString = sharPrefe.getString("UsuarioObj","");

        String horaCita = sharPrefe.getString("horaSeleccionada","");
        String fechaCita = sharPrefe.getString("fechaCita","");
        String especialidad = sharPrefe.getString("especialidad","");
        String nombreDoctor = sharPrefe.getString("nombreDoctor","");


        System.out.println("Hora: "+horaCita);
        Gson gson = new Gson();
        LoginResponseDto tuObjeto = gson.fromJson(jsonString, LoginResponseDto.class);

        //---------------
        TextView txtHora = rootView.findViewById(R.id.txtHora);
        TextView txtFechaCita = rootView.findViewById(R.id.txtFechaCita);
        TextView txtEspec = rootView.findViewById(R.id.txtEspecialidad);
        TextView txtNombreDoct = rootView.findViewById(R.id.txtNombreDoctor);
        Button btnCrearCita = rootView.findViewById(R.id.btnConfirCita);
        //---------------
        txtHora.setText(horaCita);
        txtFechaCita.setText(fechaCita);
        txtEspec.setText(especialidad);
        txtNombreDoct.setText(nombreDoctor);

        btnCrearCita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CitaMedicaRequestDto citaMedicaRequestDto = new CitaMedicaRequestDto(tuObjeto.getUsuario().getUid(),nombreDoctor,fechaCita,especialidad,horaCita);

                citaMedicaPresenter.crearCitaMedica(citaMedicaRequestDto,getContext())
                        .subscribeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                citaMedica ->{
                                    if(citaMedica.getSuccess()){
                                        System.out.println("Se registro");
                                        Toast.makeText(view.getContext(), "Se registro la Cita",Toast.LENGTH_SHORT).show();
                                        navController = Navigation.findNavController(rootView);
                                        navController.navigate(R.id.principalFragment);
                                    }else{
                                        System.out.println("No se registro");
                                    }
                                }
                        );
            }

        });


        return rootView;
    }
}