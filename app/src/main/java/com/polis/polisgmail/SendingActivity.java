package com.polis.polisgmail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.api.client.util.DateTime;
import com.polis.polisgmail.dao.Mail;
import com.polis.polisgmail.models.sql.DataBase;
import com.polis.polisgmail.models.sql.DataBaseMailDao;

import java.util.Date;

public class SendingActivity extends AppCompatActivity {

    private Button send;
    private EditText sendTo;
    private EditText mailTitle;
    private EditText fullText;

    private DataBase db;
    private DataBaseMailDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sending);
        init();

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Mail mail = new Mail();
                mail.from = "Zaglushka MAIL :))))";
                mail.date = new Date().toString();
                mail.to = String.valueOf(sendTo.getText());
                mail.theme = String.valueOf(mailTitle.getText());
                mail.message = String.valueOf(fullText.getText());
                dao.insert(mail);
                finish();
            }
        });
    }

    private void init() {
        send = findViewById(R.id.send);
        sendTo = findViewById(R.id.sendTo);
        mailTitle = findViewById(R.id.mailTitle);
        fullText = findViewById(R.id.fullText);

        db = Room.databaseBuilder(getApplicationContext(),
                DataBase.class, "DataBase").allowMainThreadQueries().build();
        dao = db.mailDao();
    }
}
