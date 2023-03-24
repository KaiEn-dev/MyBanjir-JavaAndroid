package com.example.mybanjir.Database;

/*
    - Report Data Model Class -

    Stores:
    + Report ID
    + Report Location ID
    + Report created date
    + Report created time
    + Report Category (About what?)
    + Report Description
 */
public class Report {

    private int reportID;
    private int reportLocationID;
    private String reportDate;
    private String reportTime;
    private String reportAbout;
    private String reportDescription;

    public Report() {
    }

    public Report(int reportID, int reportLocationID, String reportDate, String reportTime, String reportAbout, String reportDescription) {
        this.reportID = reportID;
        this.reportLocationID = reportLocationID;
        this.reportDate = reportDate;
        this.reportTime = reportTime;
        this.reportAbout = reportAbout;
        this.reportDescription = reportDescription;
    }

    public int getReportID() {
        return reportID;
    }

    public void setReportID(int reportID) {
        this.reportID = reportID;
    }

    public int getReportLocationID() {
        return reportLocationID;
    }

    public void setReportLocationID(int reportLocationID) {
        this.reportLocationID = reportLocationID;
    }

    public String getReportDate() {
        return reportDate;
    }

    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }

    public String getReportTime() {
        return reportTime;
    }

    public void setReportTime(String reportTime) {
        this.reportTime = reportTime;
    }

    public String getReportAbout() {
        return reportAbout;
    }

    public void setReportAbout(String reportAbout) {
        this.reportAbout = reportAbout;
    }

    public String getReportDescription() {
        return reportDescription;
    }

    public void setReportDescription(String reportDescription) {
        this.reportDescription = reportDescription;
    }

    @Override
    public String toString() {
        return "Report{" +
                "reportID=" + reportID +
                ", reportLocationID=" + reportLocationID +
                ", reportDate='" + reportDate + '\'' +
                ", reportTime='" + reportTime + '\'' +
                ", reportAbout='" + reportAbout + '\'' +
                ", reportDescription='" + reportDescription + '\'' +
                '}';
    }
}
