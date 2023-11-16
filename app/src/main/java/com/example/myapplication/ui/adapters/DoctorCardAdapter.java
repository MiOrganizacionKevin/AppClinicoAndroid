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
import com.example.myapplication.model.Doctor;

import java.util.List;

public class DoctorCardAdapter extends RecyclerView.Adapter<DoctorCardViewHolder> {
    private List<Doctor> doctorList;

    public DoctorCardAdapter(List<Doctor> doctorList) {
        this.doctorList = doctorList;
    }

    @Override
    public DoctorCardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_doctor_speciality_hour, parent, false);
        return new DoctorCardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DoctorCardViewHolder holder, int position) {
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

        doctor.getListHorarios().forEach(fecha -> {
            Button button = new Button(holder.linearButtonHorarios.getContext());
            button.setText(fecha.getDateToShowCard());

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
                    Toast.makeText(view.getContext(), "Tap on: " + fecha.getDateToShowCard(),Toast.LENGTH_SHORT).show();
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
