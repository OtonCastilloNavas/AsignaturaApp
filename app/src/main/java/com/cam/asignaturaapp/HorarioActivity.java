package com.cam.asignaturaapp;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.cam.asignaturaapp.objetos.Horario;

import java.util.ArrayList;
import java.util.List;

public class HorarioActivity extends AppCompatActivity {

    private RecyclerView rvHorario;
    private AdapterHorario adapterHorario;
    private List<HorarioConAsig> horarioList= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario);
        rvHorario= findViewById(R.id.rvHorario);
        DBClase dbClase = Room.databaseBuilder(this,
                DBClase.class,
                "db").allowMainThreadQueries().build();
        horarioList.addAll(dbClase.horarioDao().obtenerTodo());
        adapterHorario= new AdapterHorario(horarioList);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rvHorario.setLayoutManager(manager);
        rvHorario.setAdapter(adapterHorario);
    }
}
