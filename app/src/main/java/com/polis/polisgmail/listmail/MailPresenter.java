package com.polis.polisgmail.listmail;

import com.polis.polisgmail.dao.Mail;

import java.util.List;

public class MailPresenter {

    private ListMailsActivity view;
    private final MailModel model;

    public MailPresenter(MailModel model) {
        this.model = model;
    }

    public void attachView(ListMailsActivity listMailsActivity) {
        view = listMailsActivity;
    }

    public void detachView() {
        view = null;
    }

    public void loadMails() {
        model.loadMails(new MailModel.LoadMailsCallback() {
            @Override
            public void onLoad(List<Mail> mails) {
                view.showMails(mails);
            }
        });
    }
}
