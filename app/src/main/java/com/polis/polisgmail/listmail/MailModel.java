package com.polis.polisgmail.listmail;

import android.content.ContextWrapper;
import android.os.AsyncTask;

import com.polis.polisgmail.App;
import com.polis.polisgmail.MailLab;
import com.polis.polisgmail.dao.Mail;
import com.polis.polisgmail.di.CompositionRoot;

import java.util.List;

public class MailModel {

    private final MailLab mailLab;

    public MailModel(MailLab mailLab) {
        this.mailLab = mailLab;
    }

    public void loadMails(LoadMailsCallback callback) {
        LoadMailsTask loadMailsTask = new LoadMailsTask(callback);
        loadMailsTask.execute();
    }

    interface LoadMailsCallback {
        void onLoad(List<Mail> mails);
    }

    class LoadMailsTask extends AsyncTask<Void, Void, List<Mail>> {

        private final LoadMailsCallback callback;

        LoadMailsTask(LoadMailsCallback callback) {
            this.callback = callback;
        }

        @Override
        protected List<Mail> doInBackground(Void... voids) {
            return mailLab.getMails();
        }

        @Override
        protected void onPostExecute(List<Mail> mails) {
            if (callback != null) {
                callback.onLoad(mails);
            }
        }
    }
}
