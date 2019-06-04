package com.cam.asignaturaapp.objetos;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "asignTB")
public class Asignatura {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "nombre_asig")
    private String nombre;

    private int creditos;

    public Asignatura() {
    }

    public Asignatura(int id, String nombre, int creditos) {
        this.id = id;
        this.nombre = nombre;
        this.creditos = creditos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }
}
