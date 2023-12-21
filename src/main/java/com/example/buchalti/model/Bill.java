package com.example.buchalti.model;

import java.util.Date;

public class Bill {
    private int id;
    private String description;
    private double amount;
    private Date date;
    private String attachmentPath;

    public Bill(int id, String description, double amount, Date date, String attachmentPath) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.attachmentPath = attachmentPath;
    }

    public Bill(String description, double amount, Date date, String attachmentPath) {
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.attachmentPath = attachmentPath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAttachmentPath() {
        return attachmentPath;
    }

    public void setAttachmentPath(String attachmentPath) {
        this.attachmentPath = attachmentPath;
    }
}
