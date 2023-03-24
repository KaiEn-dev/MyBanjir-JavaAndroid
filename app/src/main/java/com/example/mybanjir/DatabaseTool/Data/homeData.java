package com.example.mybanjir.DatabaseTool.Data;

import android.content.Context;

import com.example.mybanjir.Database.Home;
import com.example.mybanjir.DatabaseTool.DBHandler;


/*
    - Home Data -
 */
public class homeData {
    // Data
    private static final Home home = new Home(1, 0);

    public homeData(Context context) {
        insertHome(context);
    }

    // Database data input
    public void insertHome(Context context){
        DBHandler dbh = new DBHandler(context);
        dbh.addHome(home);
    }
}
