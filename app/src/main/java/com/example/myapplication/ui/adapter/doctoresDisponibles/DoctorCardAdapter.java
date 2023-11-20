package com.example.myapplication.ui.adapter.doctoresDisponibles;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.model.Doctor;

import java.util.List;

public class DoctorCardAdapter extends RecyclerView.Adapter<DoctorCardViewHolder> {

    List<Doctor> doctorList;

    public DoctorCardAdapter(List<Doctor> listDoctor) {
        this.doctorList = listDoctor;
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
                .load(doctor.getFoto())
                .centerCrop()
                .circleCrop()
                .placeholder(R.drawable.user_icon)
                .into(holder.doctorImage);
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
