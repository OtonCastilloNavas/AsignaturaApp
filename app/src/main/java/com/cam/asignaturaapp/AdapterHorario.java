package com.cam.asignaturaapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cam.asignaturaapp.objetos.Horario;

import java.util.ArrayList;
import java.util.List;

public class AdapterHorario extends RecyclerView.Adapter<AdapterHorario.HorarioHolder> {

private List<HorarioConAsig> horariosList= new ArrayList<>();

    public AdapterHorario(List<HorarioConAsig> horariosList) {
        this.horariosList = horariosList;
    }
    @NonNull
    @Override
    public HorarioHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_horario,viewGroup,false);
        return new HorarioHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorarioHolder horarioHolder, int i) {
        horarioHolder.tvNomAsig.setText(horariosList.get(i).getAsignatura().getNombre());
        horarioHolder.tvLugar.setText(horariosList.get(i).getHorario().getLugar());
        horarioHolder.tvHora.setText(horariosList.get(i).getHorario().getHora());
        horarioHolder.tvDia.setText(horariosList.get(i).getHorario().getDia());
    }

    @Override
    public int getItemCount() {
        return horariosList.size();
    }

    public class HorarioHolder extends RecyclerView.ViewHolder
    {
        private TextView tvNomAsig;
        private TextView tvDia;
        private TextView tvHora;
        private TextView tvLugar;

        public HorarioHolder(@NonNull View itemView) {
            super(itemView);
            tvNomAsig= itemView.findViewById(R.id.tvNomAsig);
            tvDia= itemView.findViewById(R.id.tvDia);
            tvHora= itemView.findViewById(R.id.tvHora);
            tvLugar= itemView.findViewById(R.id.tvLugar);
        }
    }
}