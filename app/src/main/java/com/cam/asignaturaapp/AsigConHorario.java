package com.cam.asignaturaapp;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import com.cam.asignaturaapp.objetos.Asignatura;
import com.cam.asignaturaapp.objetos.Horario;

import java.util.ArrayList;
import java.util.List;

public class AsigConHorario {

    @Embedded
    private Asignatura asignatura;

    @Relation(entity = Horario.class,
    parentColumn = "id",
    entityColumn = "id_asignatura")
    private List<Horario> horarioList= new ArrayList<>();

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public List<Horario> getHorarioList() {
        return horarioList;
    }

    public void setHorarioList(List<Horario> horarioList) {
        this.horarioList = horarioList;
    }
}
