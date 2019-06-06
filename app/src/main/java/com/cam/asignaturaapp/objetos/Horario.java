package com.cam.asignaturaapp.objetos;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;
import static android.arch.persistence.room.ForeignKey.RESTRICT;

@Entity
public class Horario {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String lugar;
    private String dia;
    private String hora;

    @ForeignKey(entity = Asignatura.class,
            parentColumns = "id",
            childColumns = "id_asignatura",
    onDelete = CASCADE,
    onUpdate = RESTRICT)
    private int id_asignatura;

    public Horario() {
    }

    public Horario(int id, String lugar, String dia, String hora, int id_asignatura) {
        this.id = id;
        this.lugar = lugar;
        this.dia = dia;
        this.hora = hora;
        this.id_asignatura=id_asignatura;
    }

    public int getId_asignatura() {
        return id_asignatura;
    }

    public void setId_asignatura(int id_asignatura) {
        this.id_asignatura = id_asignatura;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
