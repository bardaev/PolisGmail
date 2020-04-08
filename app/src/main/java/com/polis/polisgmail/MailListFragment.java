package com.polis.polisgmail;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.polis.polisgmail.dao.Mail;

import java.util.List;

public class MailListFragment extends Fragment {

    private RecyclerView mailRecyclerView;
    private MailAdapter mailAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mail_list, container, false);

        mailRecyclerView = view.findViewById(R.id.mail_recycler_view);
        mailRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    private void updateUI() {
        MailLab mailLab = MailLab.get(getActivity());
        List<Mail> mailList = mailLab.getMails();

        if (mailAdapter == null) {
            mailAdapter = new MailAdapter(mailList);
            mailRecyclerView.setAdapter(mailAdapter);
        } else {
            mailAdapter.notifyDataSetChanged();
        }
    }

    private class MailHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private Mail mail;

        private TextView sender;
        private TextView theme;

        public MailHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_mail, parent, false));

            sender = itemView.findViewById(R.id.mail_from);
            theme = itemView.findViewById(R.id.mail_theme);

            itemView.setOnClickListener(this);
        }

        public void bind(Mail mail) {
            this.mail = mail;
            sender.setText(mail.getFrom());
            theme.setText(mail.getTheme());
        }

        @Override
        public void onClick(View v) {
            Intent intent = MailPagerActivity.newIntent(getActivity(), mail.getUuid());
            startActivity(intent);
        }
    }

    private class MailAdapter extends RecyclerView.Adapter<MailHolder> {

        private List<Mail> mailList;

        public MailAdapter(List<Mail> mails) {
            mailList = mails;
        }

        @NonNull
        @Override
        public MailHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new MailHolder(layoutInflater, parent);
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
    }
}
