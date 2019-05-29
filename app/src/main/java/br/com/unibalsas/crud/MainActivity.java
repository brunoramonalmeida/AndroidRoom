package br.com.unibalsas.crud;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.room.Room;

public class MainActivity extends AppCompatActivity {

    static AppDatabase db;
    Button btnAdd, btnLimpar;
    static AdapterCursosPersonalizado adapter;
    List<Curso> cursos;
    ListView listaDeCursos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "cursos").allowMainThreadQueries().build();

        cursos = new ArrayList<>();

        listaDeCursos = (ListView) findViewById(R.id.lista);
        listaDeCursos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

        btnAdd = findViewById(R.id.adicionar);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,InsertActivity.class));
            }
        });

        btnLimpar = findViewById(R.id.limpar);
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.clearAllTables();
                Toast.makeText(getApplicationContext(),"BD zerado", Toast.LENGTH_LONG).show();
            }
        });

        LiveData<List<Curso>> liveData = db.userDao().getAll();
        liveData.observe(this, new Observer<List<Curso>>() {
            @Override
            public void onChanged(@Nullable List<Curso> cursos) {
                atualizarCursos(cursos);
            }
        });
    }

    public void atualizarCursos(List<Curso> cursos)
    {
        adapter = new AdapterCursosPersonalizado(cursos, this);
        listaDeCursos.setAdapter(adapter);
    }
}