package com.polis.polisgmail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.polis.polisgmail.dao.Mail;

import java.util.List;

public class MailPagerActivity extends AppCompatActivity {

    private static final String EXTRA_MAIL_ID = "mail_id_pager";

    private ViewPager viewPager;
    private List<Mail> mailList;

    public static Intent newIntent(Context context, Long uuid) {
        Intent intent = new Intent(context, MailPagerActivity.class);
        intent.putExtra(EXTRA_MAIL_ID, uuid);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail_pager);

        Long uuid = (Long) getIntent().getSerializableExtra(EXTRA_MAIL_ID);

        viewPager = findViewById(R.id.mail_view_pager);

        mailList = MailLab.get(this).getMails();

        FragmentManager fragmentManager = getSupportFragmentManager();
        viewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                Mail mail = mailList.get(position);
                return MailFragment.newInstance(mail.getUuid());
            }

            @Override
            public int getCount() {
                return mailList.size();
            }
        });

        for (int i = 0; i < mailList.size(); i++) {
            if (mailList.get(i).getUuid().equals(uuid)) {
                viewPager.setCurrentItem(i);
                break;
            }
        }
    }
}
