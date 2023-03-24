package com.example.mybanjir.DatabaseTool.Data;

import android.content.Context;

import com.example.mybanjir.Database.Rainfall;
import com.example.mybanjir.DatabaseTool.DBHandler;

/*
    - Rain Data -
 */
public class RainData {
    // Data
    private static final int id1 = 1;
    private static final int id2 = 2;
    private static final int id3 = 3;
    private static final int id4 = 4;
    private static final int id5 = 5;
    private static final int id6 = 6;
    private static final int id7 = 7;

    private static final float reading = 0f;

    private static final String rank1 = "no rain";
    private static final String rank2 = "moderate";
    private static final String rank3 = "heavy";

    private static final float total = 0f;
    private static final float total1 = 13.6f;
    private static final float total2 = 15.2f;
    private static final float total3 = 14f;

    private static final int status1 = 1;
    private static final int status2 = 2;
    private static final int status3 = 3;

    private static final Rainfall rf1 = new Rainfall(id1, reading, rank1, total, status1);
    private static final Rainfall rf2 = new Rainfall(id2, reading, rank1, total, status1);
    private static final Rainfall rf3 = new Rainfall(id3, reading, rank1, total, status1);
    private static final Rainfall rf4 = new Rainfall(id4, 11.8f, rank2, total1, status2);
    private static final Rainfall rf5 = new Rainfall(id5, 14.5f, rank2, total2, status2);
    private static final Rainfall rf6 = new Rainfall(id6, reading, rank1, total, status1);
    private static final Rainfall rf7 = new Rainfall(id7, 13.7f, rank2, total3, status2);

    public RainData(Context context) {
        insertData(context);
    }

    // Database data input
    public void insertData(Context context){
        DBHandler dbh = new DBHandler(context);
        dbh.addRainfall(rf1);
        dbh.addRainfall(rf2);
        dbh.addRainfall(rf3);
        dbh.addRainfall(rf4);
        dbh.addRainfall(rf5);
        dbh.addRainfall(rf6);
        dbh.addRainfall(rf7);
    }

}
