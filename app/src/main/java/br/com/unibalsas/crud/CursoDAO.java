package br.com.unibalsas.crud;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface CursoDAO {
    @Query("SELECT * FROM curso")
    List<Curso> getAll();

    @Query("SELECT * FROM curso WHERE id IN (:cursoIds)")
    List<Curso> loadAllByIds(int[] cursoIds);

    @Query("SELECT * FROM curso WHERE nome LIKE :first AND " +
            "descricao LIKE :last LIMIT 1")
    Curso findByName(String first, String last);

    @Insert
    void insertAll(Curso... cursos);

    @Delete
    void delete(Curso curso);
}
