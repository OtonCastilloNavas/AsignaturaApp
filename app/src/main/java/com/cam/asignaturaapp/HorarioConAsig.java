package com.cam.asignaturaapp;

import android.arch.persistence.room.Embedded;

import com.cam.asignaturaapp.objetos.Asignatura;
import com.cam.asignaturaapp.objetos.Horario;

import java.util.List;


public class HorarioConAsig {
    @Embedded
    private Asignatura asignatura;

    @Embedded
    private Horario horario;

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }
}
