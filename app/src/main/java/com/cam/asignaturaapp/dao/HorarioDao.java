package com.cam.asignaturaapp.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.cam.asignaturaapp.HorarioConAsig;
import com.cam.asignaturaapp.objetos.Horario;

import java.util.List;

@Dao
public interface HorarioDao {

    @Insert
    void insertar(Horario horario);

    @Delete
    void borrar(Horario horario);

    @Update
    void actualizar(Horario horario);

    @Query("Select nombre_asig,horario.* from horario inner join asignTB on asignTB.id=id_asignatura")
    List<HorarioConAsig> obtenerTodo();
}
