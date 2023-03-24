package com.example.mybanjir.DatabaseTool.Data;

import android.content.Context;

import com.example.mybanjir.Database.Alert;
import com.example.mybanjir.DatabaseTool.DBHandler;

/*
    - Alert Data -
 */
public class AlertData {
    // Data
    private static final int id1 = 2;
    private static final int id2 = 4;
    private static final int id3 = 5;

    private static final String msg1 = "Status: Danger";
    private static final String msg2 = "Status: Danger";
    private static final String msg3 = "Status: Moderate";

    private static final String time1 = "20 mins ago";
    private static final String time2 = "1 hour ago";
    private static final String time3 = "1 hour ago";

    private static final Alert a1 = new Alert(id1, msg1, time1);
    private static final Alert a2 = new Alert(id2, msg2, time2);
    private static final Alert a3 = new Alert(id3, msg3, time3);

    public AlertData(Context context) {
        insertData(context);
    }

    // Database data input
    public void insertData(Context context){
        DBHandler dbh = new DBHandler(context);
        dbh.addAlert(a1);
        dbh.addAlert(a2);
        dbh.addAlert(a3);
    }
}
