package com.example.myapplication.ui.adapters;

import android.graphics.Color;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.model.Cita;
import com.example.myapplication.model.Doctor;

import java.util.List;

public class CitaCardAdapter extends RecyclerView.Adapter<CitaCardViewHolder> {
    private List<Cita> citasList;

    public CitaCardAdapter(List<Cita> citaList) {
        this.citasList = citaList;
    }

    @Override
    public CitaCardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_cita, parent, false);
        return new CitaCardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CitaCardViewHolder holder, int position) {
        Cita cita = citasList.get(position);
        holder.doctorName.setText(cita.getDoctor().getNombre());
        holder.citaDate.setText(cita.getDateToShowCard());
        holder.citaTime.setText(cita.getTimeToShowCard());
        holder.citaSpeciality.setText(cita.getCodeSpeciality().getNombre());

        // Carga de la foto del doctor
        Glide
                .with(holder.itemView)
                .load(cita.getDoctor().getFoto())
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
