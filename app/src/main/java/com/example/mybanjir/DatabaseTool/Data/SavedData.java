package com.example.mybanjir.DatabaseTool.Data;

import android.content.Context;

import com.example.mybanjir.Database.Saved;
import com.example.mybanjir.DatabaseTool.DBHandler;

/*
    - Saved Data -
 */
public class SavedData {
    // Data
    private static final String id1 = "Favourites";
    private static final String id2 = "Reports";
    private static final String id3 = "Alerts";
    private static final String id4 = "Notifications";
    private static final String id5 = "Locations";


    private static final int value1 = 1;
    private static final int value2 = 1;
    private static final int value3 = 1;
    private static final int value4 = 1;
    private static final int value5 = 0;

    private static final Saved save1 = new Saved(id1, value1);
    private static final Saved save2 = new Saved(id2, value2);
    private static final Saved save3 = new Saved(id3, value3);
    private static final Saved save4 = new Saved(id4, value4);
    private static final Saved save5 = new Saved(id5, value5);

    public SavedData(Context context) {
        insertData(context);
    }

    // Database data input
    public void insertData(Context context){
        DBHandler dbh = new DBHandler(context);
        dbh.addSaved(save1);
        dbh.addSaved(save2);
        dbh.addSaved(save3);
        dbh.addSaved(save4);
        dbh.addSaved(save5);

    }
}
