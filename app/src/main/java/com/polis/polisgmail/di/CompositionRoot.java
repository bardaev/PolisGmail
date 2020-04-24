package com.polis.polisgmail.di;

import android.content.Context;

import com.polis.polisgmail.MailLab;

public class CompositionRoot {

    private final Context context;

    private MailLab mailLab;

    public CompositionRoot(Context context) {
        this.context = context;
    }

    public MailLab getMailLab() {
        if (mailLab == null) {
            mailLab = MailLab.get(context);
        }
        return mailLab;
    }
}
