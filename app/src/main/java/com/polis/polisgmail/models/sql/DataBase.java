package com.polis.polisgmail.models.sql;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.polis.polisgmail.dao.Mail;

@Database(entities = {Mail.class}, version = 1)
public abstract class DataBase extends RoomDatabase {
    public abstract DataBaseMailDao mailDao();
}
