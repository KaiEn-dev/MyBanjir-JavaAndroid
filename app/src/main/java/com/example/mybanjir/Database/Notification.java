package com.example.mybanjir.Database;

/*
    - Notification Data Model Class -

    Stores:
    + Notification ID
    + Notification Title
    + Notification Message
    + Notification created time
 */
public class Notification {
    private int notiID;
    private String notiTitle;
    private String notiMessage;
    private String notiTime;

    public Notification() {
    }

    public Notification(int id, String notiTitle, String notiMessage, String notiTime) {
        this.notiID = id;
        this.notiTitle = notiTitle;
        this.notiMessage = notiMessage;
        this.notiTime = notiTime;
    }

    public int getNotiID() {
        return notiID;
    }

    public void setNotiID(int notiID) {
        this.notiID = notiID;
    }

    public String getNotiTitle() {
        return notiTitle;
    }

    public void setNotiTitle(String notiTitle) {
        this.notiTitle = notiTitle;
    }

    public String getNotiMessage() {
        return notiMessage;
    }

    public void setNotiMessage(String notiMessage) {
        this.notiMessage = notiMessage;
    }

    public String getNotiTime() {
        return notiTime;
    }

    public void setNotiTime(String notiTime) {
        this.notiTime = notiTime;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "notiID=" + notiID +
                ", notiTitle='" + notiTitle + '\'' +
                ", notiMessage='" + notiMessage + '\'' +
                ", notiTime='" + notiTime + '\'' +
                '}';
    }
}


