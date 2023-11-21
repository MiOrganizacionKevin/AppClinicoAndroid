package com.example.myapplication.ui.adapter.doctoresDisponibles;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.model.Doctor;
import com.example.myapplication.model.HorasDoctor;
import com.example.myapplication.presenter.impl.HorasDoctorPresenterImpl;
import com.example.myapplication.ui.DoctoresDisponiblesFragmentDirections;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;

public class DoctorCardAdapter extends RecyclerView.Adapter<DoctorCardViewHolder> {

    List<Doctor> doctorList;
    //String uidDoctorFechaDispo;
    List<HorasDoctor> horasDoctors;
    NavController navController;

    public DoctorCardAdapter(List<Doctor> doctorList, List<HorasDoctor> horasDoctors, NavController navController) {
        this.doctorList = doctorList;
        this.horasDoctors = horasDoctors;
        this.navController = navController;
    }

    @NonNull
    @Override
    public DoctorCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_doctor_speciality_hour, parent, false);
        return new DoctorCardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DoctorCardViewHolder holder, int position) {
        Doctor doctor = doctorList.get(position);
        holder.doctorName.setText(doctor.getNombre());

        // Carga de la foto del doctor
        Glide
                .with(holder.itemView)
                .load("https://yt3.googleusercontent.com/YEJg4I4uBXLCtWiSek8LRh5KOLOIuajqbN8eIcg-KOJya9NE0SF85lURgekn0c0tt9RTcQ8ifg=s900-c-k-c0x00ffffff-no-rj")
                .centerCrop()
                .circleCrop()
                .placeholder(R.drawable.user_icon)
                .into(holder.doctorImage);

        horasDoctors.forEach(fecha -> {
            Button button = new Button(holder.linearButtonHorarios.getContext());
            button.setText(fecha.getHora()+":"+fecha.getMinuto());

            int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 100, holder.itemView.getResources().getDisplayMetrics()); // ej. 100dp
            int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 36, holder.itemView.getResources().getDisplayMetrics());

            LinearLayout.LayoutParams layoutParams =  new LinearLayout.LayoutParams(width, height);

            int marginInDp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, holder.itemView.getContext().getResources().getDisplayMetrics());
            layoutParams.setMargins(marginInDp, marginInDp, marginInDp, marginInDp);
            button.setLayoutParams(layoutParams);

            button.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.shape_button_horario));
            button.setTextColor(Color.WHITE);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), "Tap on: " + fecha.getHora()+":"+fecha.getMinuto(),Toast.LENGTH_SHORT).show();

                    Context contexto = view.getContext();
                    SharedPreferences sharPrefe = contexto.getSharedPreferences("UsuarioLogueado", Context.MODE_PRIVATE);
                    SharedPreferences.Editor shareEdit = sharPrefe.edit();
                    shareEdit.putString("horaSeleccionada",fecha.getHora()+":"+fecha.getMinuto());
                    shareEdit.putString("nombreDoctor",doctorList.get(position).getNombre());
                    shareEdit.commit();

                    navController.navigate(R.id.confirmacionCitaFragment);
                }
            });
            holder.linearButtonHorarios.addView(button);
        });


    }

    @Override
    public int getItemCount() {
        return doctorList.size();
    }
}
