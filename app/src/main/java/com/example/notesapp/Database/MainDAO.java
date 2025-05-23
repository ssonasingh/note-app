package com.example.notesapp.Database;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.notesapp.Models.Notes;

import java.util.List;

@Dao
public interface MainDAO {
    @Insert(onConflict = REPLACE) //same existing ID will be replace
    void insert(Notes notes);

    @Query("SELECT * FROM notes ORDER BY id DESC")//new come first
    List<Notes> getAll();//all notes from data base

    @Query("UPDATE notes SET title = :title, notes = :notes WHERE ID = :id")
    void update(int id,String title, String notes);

    @Delete
    void delete(Notes notes);

    @Query("UPDATE notes SET pinned = :pin WHERE ID = :id ")
    void pin(int id, boolean pin);



}
