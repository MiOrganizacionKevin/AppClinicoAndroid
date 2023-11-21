package com.example.myapplication.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.util.FechaDispoEspec;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class FechasDispoEspeAdapterHolder extends RecyclerView.Adapter<FechasDispoEspeAdapterHolder.ViewFechasDispoEspeAdapterHolder> implements View.OnClickListener {

    ArrayList<FechaDispoEspec> lista;
    View.OnClickListener listener;

    public FechasDispoEspeAdapterHolder(ArrayList<FechaDispoEspec> lista) {
        this.lista = lista;
    }



    public class ViewFechasDispoEspeAdapterHolder extends RecyclerView.ViewHolder {

        TextView mes;
        TextView dia;

        public ViewFechasDispoEspeAdapterHolder(@NonNull View itemView) {
            super(itemView);

            mes = itemView.findViewById(R.id.txtMes);
            dia = itemView.findViewById(R.id.txtDia);
        }

        public void asignarDatos(FechaDispoEspec fechaDispoEspec) {
            mes.setText(fechaDispoEspec.getMes());
            dia.setText(fechaDispoEspec.getDia());
        }
    }

    @NonNull
    @Override
    public FechasDispoEspeAdapterHolder.ViewFechasDispoEspeAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fecha_dispo_espec,null,false);

        // Aquí agregamos el ItemDecoration para el margen inferior
//        int marginBottom = parent.getResources().getDimensionPixelSize(R.dimen.item_margin_bottom); // Ajusta esta dimensión según tus necesidades
//        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
//        layoutParams.bottomMargin = marginBottom;
//
//        view.setLayoutParams(layoutParams);

        view.setOnClickListener(this);

        return new ViewFechasDispoEspeAdapterHolder(view);
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if(listener != null){
            listener.onClick(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull FechasDispoEspeAdapterHolder.ViewFechasDispoEspeAdapterHolder holder, int position) {
        holder.asignarDatos(lista.get(position));
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }


}
