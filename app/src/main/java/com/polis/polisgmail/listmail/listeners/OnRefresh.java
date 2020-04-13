package com.polis.polisgmail.listmail.listeners;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.polis.polisgmail.listmail.MailAdapter;

public class OnRefresh implements SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout swipeRefreshLayout;
    private MailAdapter mailAdapter;

    public OnRefresh(SwipeRefreshLayout swipeRefreshLayout, MailAdapter mailAdapter) {
        this.swipeRefreshLayout = swipeRefreshLayout;
        this.mailAdapter = mailAdapter;
    }

    @Override
    public void onRefresh() {
        swipeRefreshLayout.setRefreshing(true);
        mailAdapter.notifyDataSetChanged();
        swipeRefreshLayout.setRefreshing(false);
    }
}
