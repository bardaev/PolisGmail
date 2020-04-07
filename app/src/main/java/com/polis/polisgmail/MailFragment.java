package com.polis.polisgmail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.polis.polisgmail.dao.Mail;

import java.util.UUID;

public class MailFragment extends Fragment {

    private static final String ARG_MAIL_ID = "mail_id_fragment";

    private Mail mail;

    private TextView mailTheme;
    private TextView mailFrom;
    private TextView mailTo;
    private TextView mailDate;
    private TextView mailMessage;

    public static MailFragment newInstance(UUID mailId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_MAIL_ID, mailId);

        MailFragment fragment = new MailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID uuid = (UUID) getArguments().getSerializable(ARG_MAIL_ID);
        mail = MailLab.get(getActivity()).getMail(uuid);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mail, container, false);

        mailTheme = view.findViewById(R.id.message_mail_theme);
        mailFrom = view.findViewById(R.id.message_mail_from);
        mailTo = view.findViewById(R.id.message_mail_to);
        mailDate = view.findViewById(R.id.message_mail_date);
        mailMessage = view.findViewById(R.id.message_mail_message);

        mailTheme.setText(mail.getTheme());
        mailFrom.setText(mail.getFrom());
        mailTo.setText(mail.getTo());
        mailDate.setText(mail.getDate().toString());
        mailMessage.setText(mail.getMessage());

        return view;
    }
}
