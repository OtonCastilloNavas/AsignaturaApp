package com.cam.asignaturaapp;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.cam.asignaturaapp.dao.AsignaturaDao;
import com.cam.asignaturaapp.objetos.Asignatura;

@Database(version = 1,entities = {Asignatura.class})
public abstract class DBClase extends RoomDatabase {
    public abstract AsignaturaDao asignaturaDao();
}
