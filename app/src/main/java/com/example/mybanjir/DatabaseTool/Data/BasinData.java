package com.example.mybanjir.DatabaseTool.Data;

import android.content.Context;

import com.example.mybanjir.Database.Basin;
import com.example.mybanjir.DatabaseTool.DBHandler;


/*
    - Basin Data -
 */
public class BasinData {
    // Data
    private static final String name1 = "Duyong River";
    private static final String name2 = "Malacca River @ Batu Hampar";
    private static final String name3 = "Malim River";
    private static final String name4 = "Udang River";
    private static final String name5 = "Malacca River @ Cheng";
    private static final String name6 = "Malacca River @ Bukit Beruang";
    private static final String name7 = "Malacca River @ Taman Merdeka";

    private static final String lat1 = "2.198171";
    private static final String lat2 = "2.227778";
    private static final String lat3 = "2.217463";
    private static final String lat4 = "2.28188";
    private static final String lat5 = "2.252841";
    private static final String lat6 = "2.243212";
    private static final String lat7 = "2.277058";

    private static final String lng1 = "102.301783";
    private static final String lng2 = "102.26087";
    private static final String lng3 = "102.203024";
    private static final String lng4 = "102.136824";
    private static final String lng5 = "102.235158";
    private static final String lng6 = "102.266175";
    private static final String lng7 = "102.241336";

    private static final String weather = "Cloudy";
    private static final String weather1 = "Sunny";
    private static final String weather2 = "Thunderstorm";
    private static final String weather3 = "Rainy";

    private static final float temp = 31f;

    private static final String date = "12/8/2021";

    private static final String time = "14:15";

    private static final int status1 = 2;
    private static final int status2 = 2;
    private static final int status3 = 1;
    private static final int status4 = 1;
    private static final int status5 = 1;
    private static final int status6 = 1;
    private static final int status7 = 1;

    private static final Basin basin1 = new Basin(1, name1, lat1, lng1, weather1, 31.5f, date, time, 1);
    private static final Basin basin2 = new Basin(2, name2, lat2, lng2, weather, temp, date, time, status2);
    private static final Basin basin3 = new Basin(3, name3, lat3, lng3, weather, temp, date, time, status3);
    private static final Basin basin4 = new Basin(4, name4, lat4, lng4, weather3, 29f, date, time, status4);
    private static final Basin basin5 = new Basin(5, name5, lat5, lng5, weather2, 28f, date, time, 2);
    private static final Basin basin6 = new Basin(6, name6, lat6, lng6, weather, temp, date, time, status6);
    private static final Basin basin7 = new Basin(7, name7, lat7, lng7, weather2, 38f, date, time, 2);

    public BasinData(Context context) {
        insertData(context);
    }

    //
    public void insertData(Context context){
        DBHandler dbh = new DBHandler(context);
        dbh.addBasin(basin1);
        dbh.addBasin(basin2);
        dbh.addBasin(basin3);
        dbh.addBasin(basin4);
        dbh.addBasin(basin5);
        dbh.addBasin(basin6);
        dbh.addBasin(basin7);
    }
}
