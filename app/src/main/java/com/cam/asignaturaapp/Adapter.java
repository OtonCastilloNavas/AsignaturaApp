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

    private List<Asignatura> asignaturaList;

    private OnDeleteItemClick onDeleteItemClick;
    public interface OnDeleteItemClick
    {
        void onDelete(int pos, Asignatura asignatura);
    }

    public void setOnDeleteItemClick(OnDeleteItemClick onDeleteItemClick) {
        this.onDeleteItemClick = onDeleteItemClick;
    }

    public Adapter(List<Asignatura> asignaturaList) {
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
        asignaturaHolder.tvNombre.setText(asignaturaList.get(i).getNombre());
        asignaturaHolder.tvCredito.setText(
                String.valueOf(asignaturaList.get(i).getCreditos()));
    }

    @Override
    public int getItemCount() {
        return asignaturaList.size();
    }

    public class AsignaturaHolder extends RecyclerView.ViewHolder
    {
        TextView tvNombre;
        TextView tvCredito;
        Button btBorrar;
        public AsignaturaHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre=itemView.findViewById(R.id.tvNombre);
            tvCredito=itemView.findViewById(R.id.tvCredito);
            btBorrar= itemView.findViewById(R.id.btBorrar);
            btBorrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onDeleteItemClick.onDelete(getAdapterPosition(),
                            asignaturaList.get(getAdapterPosition()));
                }
            });
        }
    }
}
