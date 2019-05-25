package br.com.unibalsas.crud;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import androidx.room.Room;
import br.com.unibalsas.crud.Curso;
import br.com.unibalsas.crud.R;

public class MainActivity extends AppCompatActivity {

    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "cursos").build();

        List<Curso> cursos = todosOsCursos();

        ListView listaDeCursos = (ListView) findViewById(R.id.lista);

        //chamada da nossa implementação
        AdapterCursosPersonalizado adapter =
                new AdapterCursosPersonalizado(cursos, this);

        listaDeCursos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

        listaDeCursos.setAdapter(adapter);
    }

    public List<Curso> todosOsCursos() {
        return db.userDao().getAll();
    }
}