package com.polis.polisgmail.dao;

import java.util.Date;
import java.util.UUID;

public class Mail {

    private UUID uuid;
    private Date date;
    private String from;
    private String to;
    private String theme;
    private String message;


    public Mail() {
        this(UUID.randomUUID());
    }

    public Mail(UUID uuid) {
        this.uuid = uuid;
        this.date = new Date();
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
