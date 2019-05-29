package br.com.unibalsas.crud;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Curso {
    @PrimaryKey(autoGenerate = true)
    private long id;
    @ColumnInfo(name = "nome")
    private String nome;
    @ColumnInfo(name = "descricao")
    private String descricao;

    public Curso(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}