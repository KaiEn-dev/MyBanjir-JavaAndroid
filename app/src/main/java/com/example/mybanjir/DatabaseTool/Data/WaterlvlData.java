package com.example.mybanjir.DatabaseTool.Data;

import android.content.Context;

import com.example.mybanjir.Database.Waterlvl;
import com.example.mybanjir.DatabaseTool.DBHandler;

/*
    - Water level Data -
 */
public class WaterlvlData {
    // Data
    private static final int id1 = 1;
    private static final int id2 = 2;
    private static final int id3 = 3;
    private static final int id4 = 4;
    private static final int id5 = 5;
    private static final int id6 = 6;
    private static final int id7 = 7;

    private static final float reading1 = 1.1f;
    private static final float reading2 = 1.9f;
    private static final float reading3 = 0.6f;
    private static final float reading4 = 0.9f;
    private static final float reading5 = 0.51f;
    private static final float reading6 = 0.73f;
    private static final float reading7 = 1.03f;

    private static final String rate1 = "normal";
    private static final String rate2 = "receding";
    private static final String rate3 = "rising";

    private static final String rank1 = "normal";
    private static final String rank2 = "high";
    private static final String rank3 = "danger";

    private static final int status1 = 2;
    private static final int status2 = 2;
    private static final int status3 = 1;
    private static final int status4 = 1;
    private static final int status5 = 2;
    private static final int status6 = 1;
    private static final int status7 = 2;

    private static final Waterlvl wl1 = new Waterlvl(id1, reading1, rate2, rank2, status1);
    private static final Waterlvl wl2 = new Waterlvl(id2, reading2, rate2, rank2, status2);
    private static final Waterlvl wl3 = new Waterlvl(id3, reading3, rate1, rank1, status3);
    private static final Waterlvl wl4 = new Waterlvl(id4, reading4, rate3, rank1, status4);
    private static final Waterlvl wl5 = new Waterlvl(id5, reading5, rate3, rank2, status5);
    private static final Waterlvl wl6 = new Waterlvl(id6, reading6, rate1, rank1, status6);
    private static final Waterlvl wl7 = new Waterlvl(id7, reading7, rate3, rank2, status7);


    public WaterlvlData(Context context) {
        insertData(context);
    }

    // Database data input
    public void insertData(Context context){
        DBHandler dbh = new DBHandler(context);
        dbh.addWaterlvl(wl1);
        dbh.addWaterlvl(wl2);
        dbh.addWaterlvl(wl3);
        dbh.addWaterlvl(wl4);
        dbh.addWaterlvl(wl5);
        dbh.addWaterlvl(wl6);
        dbh.addWaterlvl(wl7);
    }
}
