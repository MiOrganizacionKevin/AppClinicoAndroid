package com.example.myapplication.ui.adapter.doctoresDisponibles;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

public class DoctorCardViewHolder extends RecyclerView.ViewHolder {

    // Aquí, declara tus vistas
    public ImageView doctorImage;
    public TextView doctorName;
    public LinearLayout linearButtonHorarios;
    // ... y cualquier otra vista que tu ítem necesite

    public DoctorCardViewHolder(View itemView) {
        super(itemView);
        doctorImage = itemView.findViewById(R.id.imageViewDoctor);
        doctorName = itemView.findViewById(R.id.textViewDoctorName);
        linearButtonHorarios = itemView.findViewById(R.id.linearLayoutHorariosButtons);
    }
}
