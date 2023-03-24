package com.example.mybanjir.DatabaseTool;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import com.example.mybanjir.Database.Location;
import com.example.mybanjir.DatabaseTool.Data.AlertData;
import com.example.mybanjir.DatabaseTool.Data.BasinData;
import com.example.mybanjir.DatabaseTool.Data.FavouritesData;
import com.example.mybanjir.DatabaseTool.Data.LocationData;
import com.example.mybanjir.DatabaseTool.Data.RainData;
import com.example.mybanjir.DatabaseTool.Data.SavedData;
import com.example.mybanjir.DatabaseTool.Data.WaterlvlData;
import com.example.mybanjir.DatabaseTool.Data.homeData;

/*
    - Database Data Initializer Class -

    Populate database when app is first launched after installation
 */

public class DBCreator {

    DBHandler dbh;

    /*
        Constructor that checks the database and populate it if it's empty
     */
    public DBCreator(Context context) {
        dbh = new DBHandler(context);
        DBpopulate(context, checkDataBase(context));
    }

    /*
        Populate database if database is empty
     */
    public void DBpopulate(Context context, boolean DBexist){
        if (!DBexist) {
            dummyData();
            dataInsertion(context);
        }
    }

    /*
        Check whether database is empty
     */
    public boolean checkDataBase(Context context) {
        SQLiteDatabase checkDB = null;
        try {
            checkDB = SQLiteDatabase.openDatabase(String.valueOf(context.getDatabasePath(DBHandler.DATABASE_NAME)), null,
                    SQLiteDatabase.OPEN_READONLY);
            checkDB.close();
        } catch (SQLiteException e) {
            // database doesn't exist yet.
        }
        return checkDB != null;
    }

    /*
        Dummy query operations to trigger SQLOpenHelper to create database
     */
    public void dummyData() {
        Location location = new Location(999, "test", "test", "test", 1);
        dbh.addLocation(location);
        dbh.removeLocation(999);
    }

    /*
        Insert Data into their respective tables
     */
    public void dataInsertion(Context context){
        SavedData saveddata = new SavedData(context);
        LocationData locationdata = new LocationData(context);
        BasinData basindata = new BasinData(context);
        WaterlvlData wldata = new WaterlvlData(context);
        RainData raindata = new RainData(context);
        FavouritesData favdata = new FavouritesData(context);
        homeData homedata = new homeData(context);
        AlertData alertdata = new AlertData(context);
    }

}
