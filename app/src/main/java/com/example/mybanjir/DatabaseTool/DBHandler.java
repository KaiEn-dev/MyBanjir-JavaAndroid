package com.example.mybanjir.DatabaseTool;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.mybanjir.Database.Alert;
import com.example.mybanjir.Database.Basin;
import com.example.mybanjir.Database.Favourites;
import com.example.mybanjir.Database.Home;
import com.example.mybanjir.Database.Location;
import com.example.mybanjir.Database.Notification;
import com.example.mybanjir.Database.Rainfall;
import com.example.mybanjir.Database.Report;
import com.example.mybanjir.Database.Saved;
import com.example.mybanjir.Database.Waterlvl;

/*
    - Database Helper Class -
*/
public class DBHandler extends SQLiteOpenHelper {

    // Logcat tag
    private static final String LOG = "DatabaseHandler";

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    public static final String DATABASE_NAME = "MyBanjirDB";

    // Table Names
    private static final String TABLE_LOCATION = "location";
    private static final String TABLE_BASIN = "basin";
    private static final String TABLE_WATERLVL = "waterlvl";
    private static final String TABLE_RAINFALL = "rainfall";
    private static final String TABLE_ALERT = "alert";
    private static final String TABLE_NOTIFICATION = "notification";
    private static final String TABLE_FAVOURITES = "favourites";
    private static final String TABLE_HOME = "home";
    private static final String TABLE_REPORT = "report";
    private static final String TABLE_SAVED = "save";


    // Location Table - column names
    private static final String KEY_LOCATION_ID = "location_ID";
    private static final String KEY_LOCATION_NAME = "location_name";
    private static final String KEY_LOCATION_LAT = "location_lat";
    private static final String KEY_LOCATION_LNG = "location_lng";
    private static final String KEY_LOCATION_BASIN_ID= "location_basinID";


    // Basin Table - column names
    private static final String KEY_BASIN_ID = "basin_ID";
    private static final String KEY_BASIN_NAME = "basin_name";
    private static final String KEY_BASIN_LAT = "basin_lat";
    private static final String KEY_BASIN_LNG = "basin_lng";
    private static final String KEY_BASIN_WEATHER = "basin_weather";
    private static final String KEY_BASIN_TEMP = "basin_temp";
    private static final String KEY_BASIN_DATE = "basin_date";
    private static final String KEY_BASIN_TIME = "basin_time";
    private static final String KEY_BASIN_STATUS = "basin_status";

    // Waterlvl Table - column names
    private static final String KEY_WATERLVL_BASIN_ID = "waterlvl_ID";
    private static final String KEY_WATERLVL_READING = "waterlvl_reading";
    private static final String KEY_WATERLVL_RATE = "waterlvl_rate";
    private static final String KEY_WATERLVL_RANK = "waterlvl_rank";
    private static final String KEY_WATERLVL_STATUS = "waterlvl_status";

    // Rainfall Table - column names
    private static final String KEY_RAINFALL_BASIN_ID = "rainfall_ID";
    private static final String KEY_RAINFALL_READING = "rainfall_reading";
    private static final String KEY_RAINFALL_RANK = "rainfall_rank";
    private static final String KEY_RAINFALL_TOTAL = "rainfall_total";
    private static final String KEY_RAINFALL_STATUS = "rainfall_status";

    // Alert Table - column names
    private static final String KEY_ALERT_LOCATION_ID = "alert_location_ID";
    private static final String KEY_ALERT_MESSAGE = "alert_message";
    private static final String KEY_ALERT_TIME = "alert_time";

    // Notification Table - column names
    private static final String KEY_NOTI_ID = "noti_ID";
    private static final String KEY_NOTI_TITLE = "noti_title";
    private static final String KEY_NOTI_MESSAGE = "noti_message";
    private static final String KEY_NOTI_TIME = "noti_time";

    // Favourites Table - column names
    private static final String KEY_FAV_ID = "fav_ID";
    private static final String KEY_FAV_LOCATION_ID = "fav_location_ID";

    // Home Table - column names
    private static final String KEY_HOME_ID = "home_ID";
    private static final String KEY_HOME_LOCATION_ID = "home_location_ID";

    // Report Table - column names
    private static final String KEY_REPORT_ID = "report_ID";
    private static final String KEY_REPORT_LOCATION_ID = "report_location_ID";
    private static final String KEY_REPORT_DATE = "report_date";
    private static final String KEY_REPORT_TIME = "report_time";
    private static final String KEY_REPORT_ABOUT = "report_about";
    private static final String KEY_REPORT_DESC = "report_desc";

    // Saved Table - column names
    private static final String KEY_SAVE_DATA = "save_data";
    private static final String KEY_SAVE_VALUE = "save_value";

    // Table Creation Statements
    private static final String CREATE_TABLE_LOCATION = "CREATE TABLE " + TABLE_LOCATION + "(" + KEY_LOCATION_ID + " INTEGER PRIMARY KEY," + KEY_LOCATION_NAME + " TEXT," + KEY_LOCATION_LAT + " TEXT," + KEY_LOCATION_LNG + " TEXT," + KEY_LOCATION_BASIN_ID + " INTEGER" + ")";
    private static final String CREATE_TABLE_BASIN = "CREATE TABLE " + TABLE_BASIN + "(" + KEY_BASIN_ID + " INTEGER PRIMARY KEY," + KEY_BASIN_NAME + " TEXT," + KEY_BASIN_LAT + " TEXT," + KEY_BASIN_LNG + " TEXT," + KEY_BASIN_WEATHER + " TEXT," + KEY_BASIN_TEMP + " FLOAT," + KEY_BASIN_DATE + " TEXT," +  KEY_BASIN_TIME + " TEXT," +  KEY_BASIN_STATUS + " INTEGER" + ")";
    private static final String CREATE_TABLE_WATERLVL = "CREATE TABLE " + TABLE_WATERLVL + "(" + KEY_WATERLVL_BASIN_ID + " INTEGER," + KEY_WATERLVL_READING + " FLOAT," + KEY_WATERLVL_RATE + " TEXT," + KEY_WATERLVL_RANK + " TEXT," + KEY_WATERLVL_STATUS + " INTEGER" + ")";
    private static final String CREATE_TABLE_RAINFALL = "CREATE TABLE " + TABLE_RAINFALL + "(" + KEY_RAINFALL_BASIN_ID + " INTEGER," +  KEY_RAINFALL_READING + " FLOAT," + KEY_RAINFALL_RANK + " TEXT," +  KEY_RAINFALL_TOTAL + " FLOAT," +  KEY_RAINFALL_STATUS + " INTEGER" + ")";
    private static final String CREATE_TABLE_ALERT = "CREATE TABLE " + TABLE_ALERT + "(" + KEY_ALERT_LOCATION_ID + " INTEGER," +  KEY_ALERT_MESSAGE + " TEXT," +  KEY_ALERT_TIME + " TEXT" + ")";
    private static final String CREATE_TABLE_NOTI = "CREATE TABLE " + TABLE_NOTIFICATION + "(" + KEY_NOTI_ID + " INTEGER PRIMARY KEY," + KEY_NOTI_TITLE + " TEXT," + KEY_NOTI_MESSAGE + " TEXT," + KEY_NOTI_TIME + " TEXT" + ")";
    private static final String CREATE_TABLE_FAV = "CREATE TABLE " + TABLE_FAVOURITES + "(" + KEY_FAV_ID + " INTEGER PRIMARY KEY," + KEY_FAV_LOCATION_ID + " INTEGER" + ")";
    private static final String CREATE_TABLE_HOME = "CREATE TABLE " + TABLE_HOME + "(" + KEY_HOME_ID + " INTEGER PRIMARY KEY," + KEY_HOME_LOCATION_ID + " INTEGER" + ")";
    private static final String CREATE_TABLE_REPORT = "CREATE TABLE " + TABLE_REPORT + "(" + KEY_REPORT_ID + " INTEGER PRIMARY KEY," + KEY_REPORT_LOCATION_ID + " TEXT," + KEY_REPORT_DATE + " TEXT," + KEY_REPORT_TIME + " TEXT," + KEY_REPORT_ABOUT + " TEXT," + KEY_REPORT_DESC + " TEXT" + ")";
    private static final String CREATE_TABLE_SAVE = "CREATE TABLE " + TABLE_SAVED + "(" + KEY_SAVE_DATA + " TEXT," + KEY_SAVE_VALUE + " INTEGER" + ")";

    // Constructor
    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /*
        Create database tables
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_LOCATION);
        db.execSQL(CREATE_TABLE_BASIN);
        db.execSQL(CREATE_TABLE_WATERLVL);
        db.execSQL(CREATE_TABLE_RAINFALL);
        db.execSQL(CREATE_TABLE_ALERT);
        db.execSQL(CREATE_TABLE_NOTI);
        db.execSQL(CREATE_TABLE_FAV);
        db.execSQL(CREATE_TABLE_HOME);
        db.execSQL(CREATE_TABLE_REPORT);
        db.execSQL(CREATE_TABLE_SAVE);
    }

    /*
        Drop old database and create a updated one
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOCATION);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BASIN);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_WATERLVL);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RAINFALL);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ALERT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTIFICATION);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FAVOURITES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HOME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_REPORT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SAVED);

        // create new tables
        onCreate(db);
    }

    /*
        Close database
     */
    public void closeDB() {
        SQLiteDatabase db = this.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();
    }


    /*
        Methods for TABLE_SAVED
     */

    // Add Saved to table
    public void addSaved (Saved saved){
        ContentValues values = new ContentValues();
        values.put(KEY_SAVE_DATA, saved.getData());
        values.put(KEY_SAVE_VALUE, saved.getValue());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_SAVED, null, values);
        db.close();
    }

    // Get Saved using saved name
    public Saved findSaved(String name){
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_SAVED + " WHERE " + KEY_SAVE_DATA + " = \"" + name + "\"";
        Cursor cursor = db.rawQuery(selectQuery, null);
        Saved saved = new Saved();
        if(cursor.moveToFirst()){
            cursor.moveToFirst();
            saved.setData(cursor.getString(cursor.getColumnIndexOrThrow(KEY_SAVE_DATA)));
            saved.setValue(cursor.getInt(cursor.getColumnIndexOrThrow(KEY_SAVE_VALUE)));
        } else {
            saved = null;
        }
        cursor.close();
        db.close();
        return saved;
    }

    // Update Saved
    public void updateSaved(Saved saved){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_SAVE_VALUE, saved.getValue());
        // updating row
        db.update(TABLE_SAVED, values, KEY_SAVE_DATA + " = ?", new String[] { String.valueOf(saved.getData()) });
    }
    public void increaseLocationcount(){
        Saved saved = findSaved("Locations");
        int x = saved.getValue();
        saved = new Saved("Locations", x+1);
        updateSaved(saved);
    }

    /*
        Methods for TABLE_LOCATION
     */

    // Add location to table
    public void addLocation (Location location){
        ContentValues values = new ContentValues();
        values.put(KEY_LOCATION_ID, location.getLocationID());
        values.put(KEY_LOCATION_NAME, location.getLocationName());
        values.put(KEY_LOCATION_LAT, location.getLocationLat());
        values.put(KEY_LOCATION_LNG, location.getLocationLng());
        values.put(KEY_LOCATION_BASIN_ID, location.getLocationBasin());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_LOCATION, null, values);
        db.close();
    }

    // Remove location from table
    public void removeLocation(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_LOCATION, KEY_LOCATION_ID + " = ?",
                new String[] { String.valueOf(id) });
    }

    // Get location using location ID
    public Location findLocation(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE_LOCATION + " WHERE " + KEY_LOCATION_ID + " = " + id;
        Cursor cursor = db.rawQuery(selectQuery, null);
        Location location = new Location();
        if(cursor.moveToFirst()){
            cursor.moveToFirst();
            location.setLocationID(cursor.getInt(cursor.getColumnIndexOrThrow(KEY_LOCATION_ID)));
            location.setLocationName(cursor.getString(cursor.getColumnIndexOrThrow(KEY_LOCATION_NAME)));
            location.setLocationLat(cursor.getString(cursor.getColumnIndexOrThrow(KEY_LOCATION_LAT)));
            location.setLocationLng(cursor.getString(cursor.getColumnIndexOrThrow(KEY_LOCATION_LNG)));
            location.setLocationBasin(cursor.getInt(cursor.getColumnIndexOrThrow(KEY_LOCATION_BASIN_ID)));
        } else {
            location = null;
        }
        cursor.close();
        db.close();
        return location;
    }

    // Get location using location name
    public Location findLocation(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE_LOCATION + " WHERE " + KEY_LOCATION_NAME + " = \"" + name + "\"";
        Cursor cursor = db.rawQuery(selectQuery, null);
        Location location = new Location();
        if(cursor.moveToFirst()){
            cursor.moveToFirst();
            location.setLocationID(cursor.getInt(cursor.getColumnIndexOrThrow(KEY_LOCATION_ID)));
            location.setLocationName(cursor.getString(cursor.getColumnIndexOrThrow(KEY_LOCATION_NAME)));
            location.setLocationLat(cursor.getString(cursor.getColumnIndexOrThrow(KEY_LOCATION_LAT)));
            location.setLocationLng(cursor.getString(cursor.getColumnIndexOrThrow(KEY_LOCATION_LNG)));
            location.setLocationBasin(cursor.getInt(cursor.getColumnIndexOrThrow(KEY_LOCATION_BASIN_ID)));
        } else {
            location = null;
        }
        cursor.close();
        db.close();
        return location;
    }

    /*
        Methods for TABLE_BASIN
     */

    // Add basin to table
    public void addBasin (Basin basin){
        ContentValues values = new ContentValues();
        values.put(KEY_BASIN_ID, basin.getBasinID());
        values.put(KEY_BASIN_NAME, basin.getBasinName());
        values.put(KEY_BASIN_LAT, basin.getBasinLat());
        values.put(KEY_BASIN_LNG, basin.getBasinLng());
        values.put(KEY_BASIN_WEATHER, basin.getBasinWeather());
        values.put(KEY_BASIN_TEMP, basin.getBasinTemp());
        values.put(KEY_BASIN_DATE, basin.getBasinDate());
        values.put(KEY_BASIN_TIME, basin.getBasinTime());
        values.put(KEY_BASIN_STATUS, basin.getBasinStatus());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_BASIN, null, values);
        db.close();
    }

    // Get basin using basin name
    public Basin findBasin(String name){
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_BASIN + " WHERE " + KEY_BASIN_NAME + " = \"" + name + "\"";
        Cursor cursor = db.rawQuery(selectQuery, null);
        Basin basin = new Basin();
        if(cursor.moveToFirst()){
            cursor.moveToFirst();
            basin.setBasinID(cursor.getInt(cursor.getColumnIndexOrThrow(KEY_BASIN_ID)));
            basin.setBasinName(cursor.getString(cursor.getColumnIndexOrThrow(KEY_BASIN_NAME)));
            basin.setBasinLat(cursor.getString(cursor.getColumnIndexOrThrow(KEY_BASIN_LAT)));
            basin.setBasinLng(cursor.getString(cursor.getColumnIndexOrThrow(KEY_BASIN_LNG)));
            basin.setBasinWeather(cursor.getString(cursor.getColumnIndexOrThrow(KEY_BASIN_WEATHER)));
            basin.setBasinTemp(cursor.getFloat(cursor.getColumnIndexOrThrow(KEY_BASIN_TEMP)));
            basin.setBasinDate(cursor.getString(cursor.getColumnIndexOrThrow(KEY_BASIN_DATE)));
            basin.setBasinTime(cursor.getString(cursor.getColumnIndexOrThrow(KEY_BASIN_TIME)));
            basin.setBasinStatus(cursor.getInt(cursor.getColumnIndexOrThrow(KEY_BASIN_STATUS)));
        } else {
            basin = null;
        }
        cursor.close();
        db.close();
        return basin;
    }

    // Get basin using basin ID
    public Basin findBasin(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_BASIN + " WHERE " + KEY_BASIN_ID + " = " + id;
        Cursor cursor = db.rawQuery(selectQuery, null);
        Basin basin = new Basin();
        if(cursor.moveToFirst()){
            cursor.moveToFirst();
            basin.setBasinID(cursor.getInt(cursor.getColumnIndexOrThrow(KEY_BASIN_ID)));
            basin.setBasinName(cursor.getString(cursor.getColumnIndexOrThrow(KEY_BASIN_NAME)));
            basin.setBasinLat(cursor.getString(cursor.getColumnIndexOrThrow(KEY_BASIN_LAT)));
            basin.setBasinLng(cursor.getString(cursor.getColumnIndexOrThrow(KEY_BASIN_LNG)));
            basin.setBasinWeather(cursor.getString(cursor.getColumnIndexOrThrow(KEY_BASIN_WEATHER)));
            basin.setBasinTemp(cursor.getFloat(cursor.getColumnIndexOrThrow(KEY_BASIN_TEMP)));
            basin.setBasinDate(cursor.getString(cursor.getColumnIndexOrThrow(KEY_BASIN_DATE)));
            basin.setBasinTime(cursor.getString(cursor.getColumnIndexOrThrow(KEY_BASIN_TIME)));
            basin.setBasinStatus(cursor.getInt(cursor.getColumnIndexOrThrow(KEY_BASIN_STATUS)));
        } else {
            basin = null;
        }
        cursor.close();
        db.close();
        return basin;
    }

    // Update basin
    public void updateBasin(Basin basin){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_BASIN_WEATHER, basin.getBasinWeather());
        values.put(KEY_BASIN_TEMP, basin.getBasinTemp());
        values.put(KEY_BASIN_DATE, basin.getBasinDate());
        values.put(KEY_BASIN_TIME, basin.getBasinTime());
        values.put(KEY_BASIN_STATUS, basin.getBasinStatus());

        // updating row
        db.update(TABLE_BASIN, values, KEY_BASIN_ID + " = ?", new String[] { String.valueOf(basin.getBasinID()) });
    }

    /*
        Methods for TABLE_WATERLVL
     */

    // Add water level to table
    public void addWaterlvl (Waterlvl waterlvl){
        ContentValues values = new ContentValues();
        values.put(KEY_WATERLVL_BASIN_ID, waterlvl.getBasinID());
        values.put(KEY_WATERLVL_READING, waterlvl.getBasinWL());
        values.put(KEY_WATERLVL_RATE, waterlvl.getBasinWLRate());
        values.put(KEY_WATERLVL_RANK, waterlvl.getBasinWLRank());
        values.put(KEY_WATERLVL_STATUS, waterlvl.getBasinWLStatus());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_WATERLVL, null, values);
        db.close();
    }

    // Get water level using basin id
    public Waterlvl findWaterlvl(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE_WATERLVL + " WHERE " + KEY_WATERLVL_BASIN_ID + " = " + id;

        Cursor cursor = db.rawQuery(selectQuery, null);

        Waterlvl waterlvl = new Waterlvl();

        if(cursor.moveToFirst()){
            cursor.moveToFirst();
            waterlvl.setBasinID(cursor.getInt(cursor.getColumnIndexOrThrow(KEY_WATERLVL_BASIN_ID)));
            waterlvl.setBasinWL(cursor.getFloat(cursor.getColumnIndexOrThrow(KEY_WATERLVL_READING)));
            waterlvl.setBasinWLRate(cursor.getString(cursor.getColumnIndexOrThrow(KEY_WATERLVL_RATE)));
            waterlvl.setBasinWLRank(cursor.getString(cursor.getColumnIndexOrThrow(KEY_WATERLVL_RANK)));
            waterlvl.setBasinWLStatus(cursor.getInt(cursor.getColumnIndexOrThrow(KEY_WATERLVL_STATUS)));
        } else {
            waterlvl = null;
        }

        cursor.close();
        db.close();

        return waterlvl;
    }

    // Update water level
    public void updateWaterlvl(Waterlvl waterlvl){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_WATERLVL_READING, waterlvl.getBasinWL());
        values.put(KEY_WATERLVL_RATE, waterlvl.getBasinWLRate());
        values.put(KEY_WATERLVL_RANK, waterlvl.getBasinWLRank());
        values.put(KEY_WATERLVL_STATUS, waterlvl.getBasinWLStatus());

        // updating row
        db.update(TABLE_WATERLVL, values, KEY_WATERLVL_BASIN_ID + " = ?", new String[] { String.valueOf(waterlvl.getBasinID()) });
    }

    /*
        Methods for TABLE_RAINFALL
     */

    // Add rainfall to table
    public void addRainfall (Rainfall rain){
        ContentValues values = new ContentValues();
        values.put(KEY_RAINFALL_BASIN_ID, rain.getBasinID());
        values.put(KEY_RAINFALL_READING, rain.getBasinRF());
        values.put(KEY_RAINFALL_RANK, rain.getBasinRFRank());
        values.put(KEY_RAINFALL_TOTAL, rain.getBasinRFTotal());
        values.put(KEY_RAINFALL_STATUS, rain.getBasinRFStatus());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_RAINFALL, null, values);
        db.close();
    }

    // Get rainfall using basin ID
    public Rainfall findRainfall(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE_RAINFALL + " WHERE " + KEY_RAINFALL_BASIN_ID + " = " + id;

        Cursor cursor = db.rawQuery(selectQuery, null);

        Rainfall rainfall = new Rainfall();

        if(cursor.moveToFirst()){
            cursor.moveToFirst();
            rainfall.setBasinID(cursor.getInt(cursor.getColumnIndexOrThrow(KEY_RAINFALL_BASIN_ID)));
            rainfall.setBasinRF(cursor.getFloat(cursor.getColumnIndexOrThrow(KEY_RAINFALL_READING)));
            rainfall.setBasinRFRank(cursor.getString(cursor.getColumnIndexOrThrow(KEY_RAINFALL_RANK)));
            rainfall.setBasinRFTotal(cursor.getFloat(cursor.getColumnIndexOrThrow(KEY_RAINFALL_TOTAL)));
            rainfall.setBasinRFStatus(cursor.getInt(cursor.getColumnIndexOrThrow(KEY_RAINFALL_STATUS)));
        } else {
            rainfall = null;
        }

        cursor.close();
        db.close();

        return rainfall;
    }

    // Update rainfall
    public void updateRainfall(Rainfall rain){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_RAINFALL_READING, rain.getBasinRF());
        values.put(KEY_RAINFALL_RANK, rain.getBasinRFRank());
        values.put(KEY_RAINFALL_TOTAL, rain.getBasinRFTotal());
        values.put(KEY_RAINFALL_STATUS, rain.getBasinRFStatus());

        // updating row
        db.update(TABLE_RAINFALL, values, KEY_RAINFALL_BASIN_ID + " = ?", new String[] { String.valueOf(rain.getBasinID()) });
    }

    /*
        Methods for TABLE_ALERT
     */

    // Add Alert to table
    public void addAlert (Alert alert){
        ContentValues values = new ContentValues();
        values.put(KEY_ALERT_LOCATION_ID, alert.getAlertLocationID());
        values.put(KEY_ALERT_MESSAGE, alert.getAlertMessage());
        values.put(KEY_ALERT_TIME, alert.getAlertTime());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_ALERT, null, values);
        db.close();
    }

    // Remove alert from table
    public void removeAlert(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_ALERT, KEY_ALERT_LOCATION_ID + " = ?",
                new String[] { String.valueOf(id) });
    }

    // Get alert using alert ID
    public Alert findAlert(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE_ALERT + " WHERE " + KEY_ALERT_LOCATION_ID + " = " + id;

        Cursor cursor = db.rawQuery(selectQuery, null);

        Alert alert = new Alert();

        if(cursor.moveToFirst()){
            cursor.moveToFirst();
            alert.setAlertLocationID(cursor.getInt(cursor.getColumnIndexOrThrow(KEY_ALERT_LOCATION_ID)));
            alert.setAlertMessage(cursor.getString(cursor.getColumnIndexOrThrow(KEY_ALERT_MESSAGE)));
            alert.setAlertTime(cursor.getString(cursor.getColumnIndexOrThrow(KEY_ALERT_TIME)));
        } else {
            alert = null;
        }

        cursor.close();
        db.close();

        return alert;
    }

    // Update Alert
    public void updateAlert(Alert alert){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_ALERT_TIME, alert.getAlertTime());

        // updating row
        db.update(TABLE_ALERT, values, KEY_ALERT_LOCATION_ID + " = ?", new String[] { String.valueOf(alert.getAlertLocationID()) });
    }

    /*
        Methods for TABLE_NOTIFICATION
     */

    // Add Notification to table
    public void addNotification (Notification noti){
        ContentValues values = new ContentValues();
        values.put(KEY_NOTI_ID, noti.getNotiID());
        values.put(KEY_NOTI_TITLE, noti.getNotiTitle());
        values.put(KEY_NOTI_MESSAGE, noti.getNotiMessage());
        values.put(KEY_NOTI_TIME, noti.getNotiTime());

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_NOTIFICATION, null, values);
        db.close();
    }

    // Remove notification form table
    public void removeNotification(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NOTIFICATION, KEY_NOTI_ID + " = ?",
                new String[] { String.valueOf(id) });
    }

    // Get notification using notification ID
    public Notification findNotification(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE_NOTIFICATION + " WHERE " + KEY_NOTI_ID + " = " + id;

        Cursor cursor = db.rawQuery(selectQuery, null);

        Notification noti = new Notification();

        if(cursor.moveToFirst()){
            cursor.moveToFirst();
            noti.setNotiID(cursor.getInt(cursor.getColumnIndexOrThrow(KEY_NOTI_ID)));
            noti.setNotiTitle(cursor.getString(cursor.getColumnIndexOrThrow(KEY_NOTI_TITLE)));
            noti.setNotiMessage(cursor.getString(cursor.getColumnIndexOrThrow(KEY_NOTI_MESSAGE)));
            noti.setNotiTime(cursor.getString(cursor.getColumnIndexOrThrow(KEY_NOTI_TIME)));
        } else {
            noti = null;
        }

        cursor.close();
        db.close();

        return noti;
    }

    // Update notification
    public void updateNotification(Notification noti){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_NOTI_TIME, noti.getNotiTime());

        // updating row
        db.update(TABLE_NOTIFICATION, values, KEY_NOTI_ID + " = ?", new String[] { String.valueOf(noti.getNotiID()) });
    }

    /*
        Methods for TABLE_FAVOURITES
     */

    // Add favourite to table
    public void addFavourites (Favourites fav){
        ContentValues values = new ContentValues();
        values.put(KEY_FAV_ID, fav.getFavID());
        values.put(KEY_FAV_LOCATION_ID, fav.getFavLocationID());

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_FAVOURITES, null, values);
        db.close();
    }

    // Insert location ID into existing favorites
    public void insertFavourites (int id){
        Saved saved = findSaved("Favourites");
        Favourites fav = new Favourites(saved.getValue(), id);
        updateFavourites(fav);
        Saved newfav = new Saved("Favourites", (saved.getValue() + 1));
        updateSaved(newfav);
    }

    // Delete favourites by setting location ID to 0
    public void removeFavourites(int id){
        Favourites fav = new Favourites(id, 0);
        updateFavourites(fav);
        arrangeFavourites();
    }

    // Sort Favourties to ensure rows with lower index is always occupied first
    public void arrangeFavourites(){
        Favourites f1 = new Favourites(1, 0);
        Favourites f2 = new Favourites(2, 0);
        Favourites f3 = new Favourites(3, 0);
        Favourites x1 = findFavourites(1);
        Favourites x2 = findFavourites(2);
        Favourites x3 = findFavourites(3);
        int counter = 1;
        if (x1.getFavLocationID() != 0){
            switch(counter) {
                case 1:
                    f1.setFavLocationID(x1.getFavLocationID());
                    counter ++;
                    break;
                default:
                    break;
            }
        }
        if (x2.getFavLocationID() != 0){
            switch(counter) {
                case 1:
                    f1.setFavLocationID(x2.getFavLocationID());
                    counter ++;
                    break;
                case 2:
                    f2.setFavLocationID(x2.getFavLocationID());
                    counter ++;
                    break;
                default:
                    break;
            }
        }
        if (x3.getFavLocationID() != 0){
            switch(counter) {
                case 1:
                    f1.setFavLocationID(x3.getFavLocationID());
                    counter ++;
                    break;
                case 2:
                    f2.setFavLocationID(x3.getFavLocationID());
                    counter ++;
                    break;
                case 3:
                    f3.setFavLocationID(x3.getFavLocationID());
                    counter ++;
                    break;
                default:
                    break;
            }
        }
        updateFavourites(f1);
        updateFavourites(f2);
        updateFavourites(f3);
        Saved saved = new Saved("Favourites", counter);
        updateSaved(saved);
    }

    // Get favourite using favourite ID
    public Favourites findFavourites(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE_FAVOURITES + " WHERE " + KEY_FAV_ID + " = " + id;

        Cursor cursor = db.rawQuery(selectQuery, null);

       Favourites fav = new Favourites();

        if(cursor.moveToFirst()){
            cursor.moveToFirst();
            fav.setFavID(cursor.getInt(cursor.getColumnIndexOrThrow(KEY_FAV_ID)));
            fav.setFavLocationID(cursor.getInt(cursor.getColumnIndexOrThrow(KEY_FAV_LOCATION_ID)));
        } else {
            fav = null;
        }

        cursor.close();
        db.close();

        return fav;
    }

    // Update Favourite
    public void updateFavourites(Favourites fav){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_FAV_LOCATION_ID, fav.getFavLocationID());

        // updating row
        db.update(TABLE_FAVOURITES, values, KEY_FAV_ID + " = ?", new String[] { String.valueOf(fav.getFavID()) });
    }

    /*
        Methods for TABLE_HOME
     */

    // Add home to table
    public void addHome (Home home){
        ContentValues values = new ContentValues();
        values.put(KEY_HOME_LOCATION_ID, home.getHomeLocationID());

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_HOME, null, values);
        db.close();
    }

    // Delete home by setting location ID to 0
    public void removeHome(){
        Home h = new Home(1, 0);
        updateHome(h);
    }

    // Update home location ID
    public void insertHome(int id){
        Home h = new Home(1, id);
        updateHome(h);
    }

    // Get Home location ID
    public int getHome(){
        return findHome().getHomeLocationID();
    }

    // Get Home object
    public Home findHome(){
        SQLiteDatabase db = this.getWritableDatabase();
        int id = 1;
        String selectQuery = "SELECT * FROM " + TABLE_HOME + " WHERE " + KEY_HOME_ID + " = " + id;

        Cursor cursor = db.rawQuery(selectQuery, null);

        Home h = new Home();

        if(cursor.moveToFirst()){
            cursor.moveToFirst();
            h.setHomeID(cursor.getInt(cursor.getColumnIndexOrThrow(KEY_HOME_ID)));
            h.setHomeLocationID(cursor.getInt(cursor.getColumnIndexOrThrow(KEY_HOME_LOCATION_ID)));
        } else {
            h = null;
        }

        cursor.close();
        db.close();

        return h;
    }

    // Update home
    public void updateHome(Home home){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_HOME_LOCATION_ID, home.getHomeLocationID());

        String id = "1";

        // updating row
        db.update(TABLE_HOME, values, KEY_HOME_ID + " = ?", new String[] { id });
    }

    /*
        Methods for TABLE_REPORT
    */

    // Add report to table
    public void addReport (Report report){
        ContentValues values = new ContentValues();
        values.put(KEY_REPORT_ID, report.getReportID());
        values.put(KEY_REPORT_LOCATION_ID, report.getReportLocationID());
        values.put(KEY_REPORT_DATE, report.getReportDate());
        values.put(KEY_REPORT_TIME, report.getReportTime());
        values.put(KEY_REPORT_ABOUT, report.getReportAbout());
        values.put(KEY_REPORT_DESC, report.getReportDescription());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_REPORT, null, values);
        db.close();
        Saved oldS = findSaved("Reports");
        Saved newS = new Saved("Reports", (oldS.getValue()+1));
        updateSaved(newS);
    }

    //Get report using report ID
    public Report findReport(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE_REPORT + " WHERE " + KEY_REPORT_ID + " = " + id;

        Cursor cursor = db.rawQuery(selectQuery, null);

        Report rpt = new Report();

        if(cursor.moveToFirst()){
            cursor.moveToFirst();
            rpt.setReportID(cursor.getInt(cursor.getColumnIndexOrThrow(KEY_REPORT_ID)));
            rpt.setReportLocationID(cursor.getInt(cursor.getColumnIndexOrThrow(KEY_REPORT_LOCATION_ID)));
            rpt.setReportDate(cursor.getString(cursor.getColumnIndexOrThrow(KEY_REPORT_DATE)));
            rpt.setReportTime(cursor.getString(cursor.getColumnIndexOrThrow(KEY_REPORT_TIME)));
            rpt.setReportAbout(cursor.getString(cursor.getColumnIndexOrThrow(KEY_REPORT_ABOUT)));
            rpt.setReportDescription(cursor.getString(cursor.getColumnIndexOrThrow(KEY_REPORT_DESC)));
        } else {
            rpt = null;
        }

        cursor.close();
        db.close();

        return rpt;
    }


}
