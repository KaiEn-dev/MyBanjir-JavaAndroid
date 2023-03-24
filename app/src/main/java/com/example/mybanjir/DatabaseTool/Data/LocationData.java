package com.example.mybanjir.DatabaseTool.Data;

import android.content.Context;

import com.example.mybanjir.Database.Location;
import com.example.mybanjir.DatabaseTool.DBHandler;


/*
    - Location Data -
 */
public class LocationData {
    //Data
    private static final String name1 = "Ayer Keroh";
    private static final String name2 = "Ayer Molek";
    private static final String name3 = "Bandar Hilir";
    private static final String name4 = "Bukit Katil";
    private static final String name5 = "Duyong";
    private static final String name6 = "Kesidang";
    private static final String name7 = "Klebang";
    private static final String name8 = "Kota Laksamana";
    private static final String name9 = "Pantai Kundor";
    private static final String name10 = "Paya Rumput";
    private static final String name11 = "Pengkalan Batu";
    private static final String name12 = "Sungai Udang";
    private static final String name13 = "Telok Mas";
    private static final String name14 = "Cheng";
    private static final String name15 = "Malim Jaya";
    private static final String name16 = "Bukit Beruang";
    private static final String name17 = "Taman Merdeka";

    private static final String lat1 = "2.2699";
    private static final String lat2 = "2.2063";
    private static final String lat3 = "2.1926";
    private static final String lat4 = "2.228";
    private static final String lat5 = "2.2039";
    private static final String lat6 = "2.2199";
    private static final String lat7 = "2.2046";
    private static final String lat8 = "2.1952";
    private static final String lat9 = "2.2322";
    private static final String lat10 = "2.2937";
    private static final String lat11 = "2.2417";
    private static final String lat12 = "2.2915";
    private static final String lat13 = "2.1701";
    private static final String lat14 = "2.2648";
    private static final String lat15 = "2.2382";
    private static final String lat16 = "2.2426";
    private static final String lat17 = "2.266";

    private static final String lng1 = "102.2945";
    private static final String lng2 = "102.3063";
    private static final String lng3 = "102.2505";
    private static final String lng4 = "102.2977";
    private static final String lng5 = "102.2977";
    private static final String lng6 = "102.2348";
    private static final String lng7 = "102.2233";
    private static final String lng8 = "102.2421";
    private static final String lng9 = "102.1458";
    private static final String lng10 = "102.2147";
    private static final String lng11 = "102.2463";
    private static final String lng12 = "102.1329";
    private static final String lng13 = "102.3263";
    private static final String lng14 = "102.2147";
    private static final String lng15 = "102.2348";
    private static final String lng16 = "102.2748";
    private static final String lng17 = "102.2451";

    private static final int basin1 = 7;
    private static final int basin2 = 1;
    private static final int basin3 = 3;
    private static final int basin4 = 2;
    private static final int basin5 = 1;
    private static final int basin6 = 2;
    private static final int basin7 = 3;
    private static final int basin8 = 3;
    private static final int basin9 = 4;
    private static final int basin10 = 6;
    private static final int basin11 = 2;
    private static final int basin12 = 4;
    private static final int basin13 = 1;
    private static final int basin14 = 5;
    private static final int basin15 = 5;
    private static final int basin16 = 6;
    private static final int basin17 = 7;

    private static final Location location1 = new Location( 1, name1, lat1, lng1, basin1);
    private static final Location location2 = new Location( 2, name2, lat2, lng2, basin2);
    private static final Location location3 = new Location( 3, name3, lat3, lng3, basin3);
    private static final Location location4 = new Location( 4, name4, lat4, lng4, basin4);
    private static final Location location5 = new Location( 5, name5, lat5, lng5, basin5);
    private static final Location location6 = new Location( 6, name6, lat6, lng6, basin6);
    private static final Location location7 = new Location( 7, name7, lat7, lng7, basin7);
    private static final Location location8 = new Location( 8, name8, lat8, lng8, basin8);
    private static final Location location9 = new Location( 9, name9, lat9, lng9, basin9);
    private static final Location location10 = new Location( 10, name10, lat10, lng10, basin10);
    private static final Location location11 = new Location( 11, name11, lat11, lng11, basin11);
    private static final Location location12 = new Location( 12, name12, lat12, lng12, basin12);
    private static final Location location13 = new Location( 13, name13, lat13, lng13, basin13);
    private static final Location location14 = new Location( 14, name14, lat14, lng14, basin14);
    private static final Location location15 = new Location( 15, name15, lat15, lng15, basin15);
    private static final Location location16 = new Location( 16, name16, lat16, lng16, basin16);
    private static final Location location17 = new Location( 17, name17, lat17, lng17, basin17);

    public LocationData(Context context) {
        insertData(context);
    }

    // Database data input
    public void insertData(Context context) {
        DBHandler dbh = new DBHandler(context);
        dbh.addLocation(location1);
        dbh.increaseLocationcount();
        dbh.addLocation(location2);
        dbh.increaseLocationcount();
        dbh.addLocation(location3);
        dbh.increaseLocationcount();
        dbh.addLocation(location4);
        dbh.increaseLocationcount();
        dbh.addLocation(location5);
        dbh.increaseLocationcount();
        dbh.addLocation(location6);
        dbh.increaseLocationcount();
        dbh.addLocation(location7);
        dbh.increaseLocationcount();
        dbh.addLocation(location8);
        dbh.increaseLocationcount();
        dbh.addLocation(location9);
        dbh.increaseLocationcount();
        dbh.addLocation(location10);
        dbh.increaseLocationcount();
        dbh.addLocation(location11);
        dbh.increaseLocationcount();
        dbh.addLocation(location12);
        dbh.increaseLocationcount();
        dbh.addLocation(location13);
        dbh.increaseLocationcount();
        dbh.addLocation(location14);
        dbh.increaseLocationcount();
        dbh.addLocation(location15);
        dbh.increaseLocationcount();
        dbh.addLocation(location16);
        dbh.increaseLocationcount();
        dbh.addLocation(location17);
        dbh.increaseLocationcount();
       }
}
