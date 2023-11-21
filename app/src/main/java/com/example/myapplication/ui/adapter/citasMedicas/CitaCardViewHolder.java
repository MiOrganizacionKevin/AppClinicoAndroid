package com.example.myapplication.ui.adapter.citasMedicas;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.R;

public class CitaCardViewHolder extends RecyclerView.ViewHolder {

    public ImageView doctorImage;
    public TextView doctorName;
    public TextView citaDate;
    public TextView citaTime;
    public TextView citaSpeciality;

    public CitaCardViewHolder(View itemView) {
        super(itemView);
        doctorImage = itemView.findViewById(R.id.citaDoctorImage);
        doctorName = itemView.findViewById(R.id.textDoctorName);
        citaDate = itemView.findViewById(R.id.textDateCita);
        citaTime = itemView.findViewById(R.id.textTimeCita);
        citaSpeciality = itemView.findViewById(R.id.textSpecialityCita);
    }
}
