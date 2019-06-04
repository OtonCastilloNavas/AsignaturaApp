package com.cam.asignaturaapp.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.cam.asignaturaapp.objetos.Asignatura;

import java.util.List;

@Dao
public interface AsignaturaDao {

    @Insert
    void insertar(Asignatura asignatura);

    @Delete
    void borrar(Asignatura asignatura);

    @Update
    void actualizar(Asignatura asignatura);

    @Query("select * from asignTB order by nombre_asig")
    List<Asignatura> obtenerTodo();

    @Query("select * from asignTB where nombre_asig=:nombre")
    List<Asignatura> obtenerPorNombre(String nombre);
}
