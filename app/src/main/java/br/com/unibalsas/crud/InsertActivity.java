package br.com.unibalsas.crud;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static br.com.unibalsas.crud.MainActivity.db;

public class InsertActivity extends AppCompatActivity {

    EditText nome, descricao;
    Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        nome = (EditText) findViewById(R.id.editNome);
        descricao = (EditText) findViewById(R.id.editDescricao);
        btnCadastrar = findViewById(R.id.btnCadastrar);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrar();
                Toast.makeText(getApplicationContext(),"Cadastrado com sucesso",Toast.LENGTH_LONG).show();

                finish();
            }
        });
    }

    void cadastrar()
    {
        String nome = this.nome.getText().toString();
        String descricao = this.descricao.getText().toString();
        Curso c = new Curso(nome,descricao);
        db.userDao().insertAll(c);

    }
}
