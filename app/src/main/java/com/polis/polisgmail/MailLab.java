package com.polis.polisgmail;

import android.content.Context;

import androidx.room.Room;

import com.polis.polisgmail.dao.Mail;
import com.polis.polisgmail.models.sql.DataBase;
import com.polis.polisgmail.models.sql.DataBaseMailDao;

import java.util.List;

public class MailLab {

    private static MailLab mailLab;

    private List<Mail> mailList;

    private DataBase db;
    private DataBaseMailDao dao;

    public static MailLab get(Context context) {
        if (mailLab == null) {
            mailLab = new MailLab(context);
        }

        return mailLab;
    }

    private MailLab(Context context) {

        db = Room.databaseBuilder(context.getApplicationContext(),
                DataBase.class, "DataBase").allowMainThreadQueries().build();
        dao = db.mailDao();
      }

    public List<Mail> getMails() {
        return mailList = dao.getAll();
    }

    public Mail getMail(Long uuid) {
        for (Mail mail : mailList) {
            if (mail.getUuid().equals(uuid)) {
                return mail;
            }
        }

        return null;
    }
}
