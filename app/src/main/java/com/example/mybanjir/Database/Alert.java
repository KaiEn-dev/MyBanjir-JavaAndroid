package com.example.mybanjir.Database;

/*
    - Alert Data Model Class -

    Stores:
    + Alert Location ID
    + Alert Message
    + Alert created time
 */
public class Alert {

    private int alertLocationID;
    private String alertMessage;
    private String alertTime;

    public Alert() {
    }

    public Alert(int alertLocationID, String alertMessage, String alertTime) {
        this.alertLocationID = alertLocationID;
        this.alertMessage = alertMessage;
        this.alertTime = alertTime;
    }

    public int getAlertLocationID() {
        return alertLocationID;
    }

    public void setAlertLocationID(int alertLocationID) {
        this.alertLocationID = alertLocationID;
    }

    public String getAlertMessage() {
        return alertMessage;
    }

    public void setAlertMessage(String alertMessage) {
        this.alertMessage = alertMessage;
    }

    public String getAlertTime() {
        return alertTime;
    }

    public void setAlertTime(String alertTime) {
        this.alertTime = alertTime;
    }

    @Override
    public String toString() {
        return "Alert{" +
                "alertLocationID=" + alertLocationID +
                ", alertMessage='" + alertMessage + '\'' +
                ", alertTime='" + alertTime + '\'' +
                '}';
    }
}
