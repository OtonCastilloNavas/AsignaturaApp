package com.cam.asignaturaapp;

import android.arch.persistence.room.Room;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteConstraintException;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.cam.asignaturaapp.objetos.Asignatura;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DBClase dbClase;
    private List<Asignatura> asignaturaList;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbClase = Room.databaseBuilder(this,
                DBClase.class,
                "db").allowMainThreadQueries().build();

//        Asignatura asignatura = new Asignatura();
//        asignatura.setNombre("Android");
//        asignatura.setCreditos(3);
//        dbClase.asignaturaDao().insertar(asignatura);

        RecyclerView recyclerView =  findViewById(R.id.rvAsignatura);
        asignaturaList = new ArrayList<>();
        asignaturaList.addAll(dbClase.asignaturaDao().obtenerTodo());
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        adapter = new Adapter(asignaturaList);
        adapter.setOnDeleteItemClick(new Adapter.OnDeleteItemClick() {
            @Override
            public void onDelete(int pos, Asignatura asignatura) {
                dbClase.asignaturaDao().borrar(asignatura);
                asignaturaList.remove(asignatura);
                adapter.notifyDataSetChanged();
            }
        });
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Asignatura");
        final View view = LayoutInflater.from(this).inflate(R.layout.dialog_form_asignatura,
                null, false);
        builder.setView(view);
        builder.setNegativeButton("Cancelar",null);
        builder.setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                EditText etNombre = view.findViewById(R.id.etNombre);
                EditText etCredito = view.findViewById(R.id.etCredito);
                Asignatura asignatura = new Asignatura();
                asignatura.setNombre(etNombre.getText().toString());
                asignatura.setCreditos(Integer.valueOf(etCredito.getText().toString()));
                try {
                    dbClase.asignaturaDao().insertar(asignatura);
                    asignaturaList.add(asignatura);
                    adapter.notifyDataSetChanged();
                    Toast.makeText(MainActivity.this, "Guardado!", Toast.LENGTH_SHORT).show();
                }
                catch (SQLiteConstraintException e)
                {
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
        return super.onOptionsItemSelected(item);
    }
}
