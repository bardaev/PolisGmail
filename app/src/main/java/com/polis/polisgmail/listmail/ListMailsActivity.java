package com.polis.polisgmail.listmail;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.polis.polisgmail.App;
import com.polis.polisgmail.MailLab;
import com.polis.polisgmail.R;
import com.polis.polisgmail.dao.Mail;
import com.polis.polisgmail.di.CompositionRoot;
import com.polis.polisgmail.listmail.listeners.OnRefresh;

import java.util.ArrayList;
import java.util.List;

public class ListMailsActivity extends AppCompatActivity {

    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView mailRecyclerView;
    private MailAdapter mailAdapter;

    private MailPresenter mailPresenter;

    private CompositionRoot compositionRoot;

    private MailLab mailLab;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    public void init() {
        compositionRoot = ((App) getApplication()).getCompositionRoot();

        mailLab = compositionRoot.getMailLab();

        swipeRefreshLayout = findViewById(R.id.mail_list_refresh);
        mailRecyclerView = findViewById(R.id.mail_recycler_view);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        swipeRefreshLayout.setOnRefreshListener(new OnRefresh(swipeRefreshLayout, mailAdapter));
        mailRecyclerView.setLayoutManager(linearLayoutManager);
        mailRecyclerView.setAdapter(mailAdapter);

        mailAdapter = new MailAdapter(mailLab.getMails());
        MailModel mailModel = new MailModel(mailLab);
        mailPresenter = new MailPresenter(mailModel);
        mailPresenter.attachView(this);
        mailPresenter.loadMails();
    }

    public void showMails(List<Mail> mails) {
        mailAdapter.setMails(mails);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mailPresenter.detachView();
    }
}
