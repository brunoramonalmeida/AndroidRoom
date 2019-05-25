package br.com.unibalsas.crud;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Curso.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CursoDAO userDao();
}