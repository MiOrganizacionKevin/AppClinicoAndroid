package com.example.myapplication.ui;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.dto.EspecialidadDto;
import com.example.myapplication.dto.FechasDispoEspecDto;
import com.example.myapplication.model.Especialidad;
import com.example.myapplication.presenter.impl.EspecialidadPresenterImpl;
import com.example.myapplication.presenter.impl.FechasDispoEspecImpl;
import com.example.myapplication.ui.adapter.FechasDispoEspeAdapterHolder;
import com.example.myapplication.util.FechaDispoEspec;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

@AndroidEntryPoint
public class RegistrarCitaFragment extends Fragment {

    NavController navController;

    private Spinner especialidadSpinner;
    private Button buscarButton;
    private String especialidadSelect;
    //private CalendarView calendarView;

    ArrayList<FechaDispoEspec> lista;
    RecyclerView recyclerView;

    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapterItems;
    Disposable disposable;

    @Inject
    FechasDispoEspecImpl fechasDispoEspec;

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
        navController = NavHostFragment.findNavController(this);
        View rootView = inflater.inflate(R.layout.fragment_registrar_cita, container, false);

        buscarButton = rootView.findViewById(R.id.buscarButton);
        //calendarView = rootView.findViewById(R.id.calendarView);
        recyclerView = rootView.findViewById(R.id.recyclerId);

        buscarButton.setEnabled(false);
        buscarButton.setTextColor(Color.WHITE);
        //calendarView.setVisibility(View.GONE);

        especPresenter.especialidadesDoctor(requireContext())
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
                especialidadSelect=item;
                buscarButton.setEnabled(true);
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
                //calendarView.setVisibility(View.VISIBLE);
                listaDeFechasDisponiblesEspec();
                //crearRecyclerView();


            }
        });
    }

    public void listaDeFechasDisponiblesEspec(){

        // Obtener una instancia de Calendar con la fecha actual
        Calendar calendar = Calendar.getInstance();

        // Obtener el mes actual (los meses en Calendar comienzan desde 0)
        int mesActual = calendar.get(Calendar.MONTH) + 1;


       disposable = fechasDispoEspec.fechasDisponiblesEspecialidad(Integer.toString(mesActual),"2023",especialidadSelect,getContext())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        fechDisEsp -> {
                            crearRecyclerView(fechDisEsp);
                        }
                );

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        // Cancela la suscripción en onDestroy()
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }

    public void crearRecyclerView(FechasDispoEspecDto listaFechasDispo){
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false));

        lista = new ArrayList<>();

        // Initializing the SDF
        SimpleDateFormat SDFormat = new SimpleDateFormat();
        // Getting al DateFormatSymbols
        DateFormatSymbols DFSymbol = new DateFormatSymbols(new Locale("es", "ES"));
        //DateFormatSymbols DFSymbol = SDFormat.getDateFormatSymbols();
        // Getting the months
        String[] month = DFSymbol.getShortMonths();



        listaFechasDispo.getFechas().forEach( fechas -> {
            lista.add(new FechaDispoEspec(fechas.getUid(),month[Integer.parseInt(listaFechasDispo.getFechas().get(0).getMes())-1],fechas.getDia(),fechas.getEspecialidad()));
        });


        FechasDispoEspeAdapterHolder adapter = new FechasDispoEspeAdapterHolder(lista);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(requireContext(),"Selecion: "+lista.get(recyclerView.getChildAdapterPosition(view)).getDia(),Toast.LENGTH_LONG);
                System.out.println("Seleccion: "+ lista.get(recyclerView.getChildAdapterPosition(view)).getDia());
                String uidFechaDispo = lista.get(recyclerView.getChildAdapterPosition(view)).getUid();
                String dia = lista.get(recyclerView.getChildAdapterPosition(view)).getDia();
                String mes = lista.get(recyclerView.getChildAdapterPosition(view)).getMes();
                String espec = lista.get(recyclerView.getChildAdapterPosition(view)).getEspecialidad().getNombre();
                System.out.println("Dia: "+dia);
                System.out.println("Uid: "+uidFechaDispo);
                System.out.println("Mes: "+mes);
                System.out.println("Especialidad: "+espec);
                navController.navigate(RegistrarCitaFragmentDirections.actionRegistrarCitaFragmentToDoctoresDisponiblesFragment(espec, dia+" "+mes+" 2023",uidFechaDispo));

            }
        });

        recyclerView.setAdapter(adapter);
    }
}