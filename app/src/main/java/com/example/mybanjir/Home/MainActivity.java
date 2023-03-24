package com.example.mybanjir.Home;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mybanjir.Database.Basin;
import com.example.mybanjir.Database.Home;
import com.example.mybanjir.Database.Location;
import com.example.mybanjir.Database.Rainfall;
import com.example.mybanjir.Database.Waterlvl;
import com.example.mybanjir.DatabaseTool.DBCreator;
import com.example.mybanjir.DatabaseTool.DBHandler;
import com.example.mybanjir.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;

/*
    - Main activity -
 */

public class MainActivity extends AppCompatActivity implements GoogleMap.OnMarkerClickListener, OnMapReadyCallback {

    public static boolean sethomemap = false;
    public static int pointFav = 0;
    public static boolean pointSearched = false;
    GoogleMap map;
    public static final Double StartingLat = 2.189600;
    public static final Double StartingLng = 102.250100;
    public static final LatLng StartingPoint = new LatLng(StartingLat, StartingLng);
    public static Location currentLocation;
    static MainActivity mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBCreator dbc = new DBCreator(getApplicationContext());

        // Get a handle to the fragment and register the callback.
        MapFragment mapFragment = (MapFragment) getFragmentManager() .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        checkHomeSetup();
        mainActivity = MainActivity.this;
    }

    /*
       Instantiate Event Handler when views are clicked
    */
    public void Clicked (View v) {
        HomeEventHandler homehandle = new HomeEventHandler(v, map, getApplicationContext());
    }

    /*
        Get a handle to the GoogleMap object and display marker.
        Set up markers on the map
    */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(StartingPoint, 15f));

        // Customise the styling of the base map using a JSON object in the raw resource file.
        try {
            boolean success = googleMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(
                            this, R.raw.style_json));

            if (!success) {
                Log.e("MAPSTYLING", "Style parsing failed.");
            }
        } catch (Resources.NotFoundException e) {
            Log.e("MAPSTYLING", "Can't find style. Error: ", e);
        }

        // Set up pointers
        DBHandler dbh = new DBHandler(this);
        Home home = dbh.findHome();
        if(home.getHomeLocationID() != 0){
            MapHandler maphandle = new MapHandler(getApplicationContext(), map);
            maphandle.pointHome();
            setStatus();
        }
        MapHandler newhandle = new MapHandler(getApplicationContext(), map);
        newhandle.setPointers();

        // Set a listener for marker click.
        map.setOnMarkerClickListener(this);
    }

    public void checkHomeSetup(){
        DBHandler dbh = new DBHandler(this);
        Home home = dbh.findHome();

        if(home.getHomeLocationID() == 0){
            Intent i = new Intent(this, HomeSetup.class);
            this.startActivity(i);
        }
    }

    /*
        Move map to wanted location on resume
    */
    @Override
    protected void onResume() {
        super.onResume();
        if(sethomemap){
            MapHandler maphandle = new MapHandler(getApplicationContext(), map);
            maphandle.pointHome();
            setStatus();
            sethomemap = false;
        }

        if(pointSearched){
            MapHandler maphandle = new MapHandler(getApplicationContext(), map);
            maphandle.pointSearched();
            setStatus();
            pointSearched = false;
        }

        switch (pointFav){
            case 1:
                MapHandler maphandle1 = new MapHandler(getApplicationContext(), map);
                maphandle1.pointFav1();
                setStatus();
                pointFav = 0;
                break;
            case 2:
                MapHandler maphandle2 = new MapHandler(getApplicationContext(), map);
                maphandle2.pointFav2();
                setStatus();
                pointFav = 0;
                break;
            case 3:
                MapHandler maphandle3 = new MapHandler(getApplicationContext(), map);
                maphandle3.pointFav3();
                setStatus();
                pointFav = 0;
                break;
            default:
                break;
        }
    }

    /*
        Take action based on clicked marker
    */
    @Override
    public boolean onMarkerClick(final Marker marker) {
        DBHandler dbh = new DBHandler(getApplicationContext());
        switch (marker.getTitle()){
            case "Home":
                Home home = dbh.findHome();
                currentLocation = dbh.findLocation(home.getHomeLocationID());
                break;
            case "Favourite1":
                currentLocation = dbh.findLocation(dbh.findFavourites(1).getFavLocationID());
                break;
            case "Favourite2":
                currentLocation = dbh.findLocation(dbh.findFavourites(2).getFavLocationID());
                break;
            case "Favourite3":
                currentLocation = dbh.findLocation(dbh.findFavourites(3).getFavLocationID());
                break;
            default:
                currentLocation = dbh.findLocation(marker.getTitle());
                break;
        }
        setStatus();
        return false;
    }

    /*
        Display location data based on selected location
    */
    public void setStatus(){
        // Get views
        TextView title = (TextView) findViewById(R.id.MainStatusLocation);
        TextView weathertext = (TextView) findViewById(R.id.MainStatusWeatherName);
        TextView temptext = (TextView) findViewById(R.id.MainStatusTempReading);
        TextView waterlvltext = (TextView) findViewById(R.id.MainStatusWLReading);
        TextView raintext = (TextView) findViewById(R.id.MainStatusRFReading);
        ImageView statuscolor = (ImageView) findViewById(R.id.mainstatuscolor);
        ImageView weathericon = (ImageView) findViewById(R.id.MainStatusWeatherIcon);

        // Get data from database
        DBHandler dbh = new DBHandler(getApplicationContext());
        Basin basin = dbh.findBasin(currentLocation.getLocationBasin());
        Waterlvl WL = dbh.findWaterlvl(basin.getBasinID());
        Rainfall RF = dbh.findRainfall(basin.getBasinID());
        int status = basin.getBasinStatus();

        // Change view contents to show data
        title.setText(currentLocation.getLocationName());
        weathertext.setText(basin.getBasinWeather());
        temptext.setText(Float.toString(basin.getBasinTemp()) + "°C");
        waterlvltext.setText(Float.toString(WL.getBasinWL()) + " m");
        raintext.setText(Float.toString(RF.getBasinRF()) + " mm");
        int color1 = Color.parseColor("#5cf436");
        int color2 = Color.parseColor("#f4ab36");
        int color3 = Color.parseColor("#f43636");
        switch (status){
            case 1:
                statuscolor.setColorFilter(color1);
                break;
            case 2:
                statuscolor.setColorFilter(color2);
                break;
            case 3:
                statuscolor.setColorFilter(color3);
                break;
            default:
                break;
        }
        String w = basin.getBasinWeather();
        switch (w){
            case "Cloudy":
                weathericon.setImageResource(R.drawable.cloudy);
                break;
            case "Rainy":
                weathericon.setImageResource(R.drawable.raining);
                break;
            case "Thunderstorm":
                weathericon.setImageResource(R.drawable.thunderstorm);
                break;
            case "Sunny":
                weathericon.setImageResource(R.drawable.sunny);
                break;
            default:
                break;
        }
    }
}