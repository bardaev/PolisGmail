package com.polis.polisgmail.listmail;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.polis.polisgmail.R;
import com.polis.polisgmail.dao.Mail;
import com.polis.polisgmail.listmail.listeners.OnSetMail;

import java.util.List;

public class MailAdapter extends RecyclerView.Adapter<MailAdapter.MailHolder> {

    private List<Mail> mailList;

    public MailAdapter(List<Mail> mail) {
        this.mailList = mail;
    }

    @NonNull
    @Override
    public MailAdapter.MailHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_mail, parent, false);
        return new MailHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MailHolder holder, int position) {
        Mail mail = mailList.get(position);
        holder.bind(mail);
    }

    @Override
    public int getItemCount() {
        return mailList.size();
    }

    public void setMails(List<Mail> mails) {
        mailList.clear();
        mailList.addAll(mails);
        notifyDataSetChanged();
    }

    static class MailHolder extends RecyclerView.ViewHolder {

        private Mail mail;

        private TextView sender;
        private TextView theme;

        public MailHolder(@NonNull View itemView) {
            super(itemView);

            sender = itemView.findViewById(R.id.mail_from);
            theme = itemView.findViewById(R.id.mail_theme);

            itemView.setOnClickListener(new OnSetMail());
        }

        public void bind(Mail mail) {
            this.mail = mail;
            sender.setText(mail.getFrom());
            theme.setText(mail.getTheme());
        }
    }
}
