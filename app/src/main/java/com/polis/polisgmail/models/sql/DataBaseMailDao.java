package com.polis.polisgmail.models.sql;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.polis.polisgmail.dao.Mail;

import java.util.List;

@Dao
public interface DataBaseMailDao {
    @Query("Select * from Mail where uuid = 1")
    public List<Mail> getAll();

    @Query("SELECT * FROM Mail WHERE uuid = :id")
    Mail getById(long id);

    @Insert
    void insert(Mail Mail);

    @Update
    void update(Mail Mail);

    @Delete
    void delete(Mail Mail);
}
