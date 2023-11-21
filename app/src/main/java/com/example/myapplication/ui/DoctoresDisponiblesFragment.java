package com.example.myapplication.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.dto.EspecialidadDto;
import com.example.myapplication.dto.doctoresDiEs.DoctDispEspRequest;
import com.example.myapplication.model.Doctor;
import com.example.myapplication.presenter.impl.DoctoresDispoEspecPresenterImpl;
import com.example.myapplication.presenter.impl.HorasDoctorPresenterImpl;
import com.example.myapplication.ui.adapter.doctoresDisponibles.DoctorCardAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;
import io.reactivex.android.schedulers.AndroidSchedulers;

@AndroidEntryPoint
public class DoctoresDisponiblesFragment extends Fragment {

    private List<Doctor> doctoresDisponibles;
    private RecyclerView recyclerView;
    private DoctorCardAdapter adapter;

    private String uidDocFechDiEs;

    @Inject
    DoctoresDispoEspecPresenterImpl doctoresDispoEspecPresenter;

    @Inject
    HorasDoctorPresenterImpl horasDoctorPresenter;

    public DoctoresDisponiblesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        DoctoresDisponiblesFragmentArgs args = DoctoresDisponiblesFragmentArgs.fromBundle(getArguments());
        String specility = args.getSpecialityToSearch();
        String date = args.getDateToSearch();
        String uidFechaDispo = args.getFechaDispoEspe();

        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_doctores_disponibles, container, false);

        TextView textDate = rootView.findViewById(R.id.textDate);
        TextView textSpeciality = rootView.findViewById(R.id.textSpeciality);

        recyclerView = rootView.findViewById(R.id.recycler_view_doctores);

        textDate.setText(date);
        textSpeciality.setText(specility);

        //-----------------------------
        Context contexto = getContext();
        SharedPreferences sharPrefe = contexto.getSharedPreferences("UsuarioLogueado", Context.MODE_PRIVATE);
        SharedPreferences.Editor shareEdit = sharPrefe.edit();
        shareEdit.putString("fechaCita",date);
        shareEdit.putString("especialidad",specility);
        shareEdit.commit();
        //-----------------------------

        doctoresDisponibles = new ArrayList<>();
        //Peticion de Fechas de doctores disponibles por especialidad
        doctoresDispoEspecPresenter.doctoresDisponiblesEspecialidad(new DoctDispEspRequest(specility,uidFechaDispo))
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        doctFechasDispoEsp -> {
                            Log.d("DoctoresDispoEspec","Respuesta: "+doctFechasDispoEsp.getTotal());
                            if(doctFechasDispoEsp.getTotal() == null){
                                System.out.println("No hay nada");
                            }else{
                                doctFechasDispoEsp.getDoctorFechaDispoEspec().forEach( docFecDis -> {
                                    doctoresDisponibles.add(new Doctor(docFecDis.getUid(),docFecDis.getDoctor().getNombre(),null));
                                    uidDocFechDiEs = docFecDis.getUid();
                                });

                                horasDoctorPresenter.horasDoctor(uidDocFechDiEs)
                                        .subscribeOn(AndroidSchedulers.mainThread())
                                        .subscribe(
                                                horDoc -> {
                                                    adapter = new DoctorCardAdapter(doctoresDisponibles,horDoc.getHorasDoctor(), NavHostFragment.findNavController(this));
                                                    recyclerView.setAdapter(adapter);
                                                    recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
                                                }
                                        );

                                //adapter = new DoctorCardAdapter(doctoresDisponibles);

                            }

                        }
                );

        return rootView;
    }
}