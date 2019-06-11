package com.cam.asignaturaapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.cam.asignaturaapp.objetos.Asignatura;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.AsignaturaHolder> {

    private List<AsigConHorario> asignaturaList;

    private OnDeleteItemClick onDeleteItemClick;
    public interface OnDeleteItemClick
    {
        void onDelete(int pos, Asignatura asignatura);
    }

    public void setOnDeleteItemClick(OnDeleteItemClick onDeleteItemClick) {
        this.onDeleteItemClick = onDeleteItemClick;
    }

    private onEditItemClick onEditItemClick;
    public interface  onEditItemClick
    {
        void onEdit(int pos, Asignatura asignatura);
    }

    public void setOnEditItemClick(Adapter.onEditItemClick onEditItemClick) {
        this.onEditItemClick = onEditItemClick;
    }

    private onHorarioItemClick onHorarioItemClick;
    public interface onHorarioItemClick
    {
        void onHorario(int pos, Asignatura asignatura);
    }

    public void setOnHorarioItemClick(Adapter.onHorarioItemClick onHorarioItemClick) {
        this.onHorarioItemClick = onHorarioItemClick;
    }

    public Adapter(List<AsigConHorario> asignaturaList) {
        this.asignaturaList = asignaturaList;
    }

    @NonNull
    @Override
    public AsignaturaHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_asignatura,null,false);
        return new AsignaturaHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AsignaturaHolder asignaturaHolder, int i) {
        asignaturaHolder.tvNombre.setText(asignaturaList.get(i).getAsignatura().getNombre());
        asignaturaHolder.tvCredito.setText(
                String.valueOf(asignaturaList.get(i).getAsignatura().getCreditos()));
        asignaturaHolder.tvCantHorario.setText(
                String.valueOf(asignaturaList.get(i).getHorarioList().size()));
    }

    @Override
    public int getItemCount() {
        return asignaturaList.size();
    }

    public class AsignaturaHolder extends RecyclerView.ViewHolder
    {
        TextView tvNombre;
        TextView tvCredito;
        TextView tvCantHorario;
        Button btBorrar;
        Button btEditar;
        Button btHorario;
        public AsignaturaHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre=itemView.findViewById(R.id.tvNombre);
            tvCredito=itemView.findViewById(R.id.tvCredito);
            tvCantHorario=itemView.findViewById(R.id.tvCantHorario);
            btBorrar= itemView.findViewById(R.id.btBorrar);
            btBorrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onDeleteItemClick.onDelete(getAdapterPosition(),
                            asignaturaList.get(getAdapterPosition()).getAsignatura());
                }
            });

            btEditar= itemView.findViewById(R.id.btEditar);
            btEditar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onEditItemClick.onEdit(getAdapterPosition(),
                            asignaturaList.get(getAdapterPosition()).getAsignatura());
                }
            });

            btHorario= itemView.findViewById(R.id.btHorario);
            btHorario.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onHorarioItemClick.onHorario(getAdapterPosition(),
                            asignaturaList.get(getAdapterPosition()).getAsignatura());
                }
            });
        }
    }
}