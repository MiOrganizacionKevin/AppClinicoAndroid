package com.example.myapplication.ui.adapter.citasMedicas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.model.CitaMedica;

import java.util.List;

public class CitaCardAdapter extends RecyclerView.Adapter<CitaCardViewHolder>{

    private List<CitaMedica> citasList;

    public CitaCardAdapter(List<CitaMedica> citaList) {
        this.citasList = citaList;
    }

    @NonNull
    @Override
    public CitaCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_cita, parent, false);
        return new CitaCardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CitaCardViewHolder holder, int position) {

        CitaMedica cita = citasList.get(position);
        holder.doctorName.setText(cita.getNombreDoctor());
        holder.citaDate.setText(cita.getFechaDeCita());
        holder.citaTime.setText(cita.getHora());
        holder.citaSpeciality.setText(cita.getEspecialidad());

        // Carga de la foto del doctor
        Glide
                .with(holder.itemView)
                .load("https://cdn.euroinnova.edu.es/img/subidasEditor/doctor-5871743_640-1610073541.webp")
                .centerCrop()
                .circleCrop()
                .placeholder(R.drawable.user_icon)
                .into(holder.doctorImage);
    }

    @Override
    public int getItemCount() {
        return citasList.size();
    }
}
