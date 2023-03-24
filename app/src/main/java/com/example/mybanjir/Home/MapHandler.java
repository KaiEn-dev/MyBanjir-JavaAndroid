package com.example.mybanjir.Home;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Log;

import androidx.core.content.ContextCompat;

import com.example.mybanjir.Database.Favourites;
import com.example.mybanjir.Database.Home;
import com.example.mybanjir.Database.Location;
import com.example.mybanjir.Database.Saved;
import com.example.mybanjir.DatabaseTool.DBHandler;
import com.example.mybanjir.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

/*
    - Map Handler Class -

    Handle all map functionalities
 */

public class MapHandler {

    Context context;
    static GoogleMap map;

    /*
        Constructors to initialize variables
     */

    public MapHandler(Context context) {
        this.context = context;
    }

    public MapHandler(Context context, GoogleMap map) {
        this.context = context;
        this.map = map;
    }

    /*
        Move map to Searched location
     */
    public void pointSearched(){
        DBHandler dbh = new DBHandler(context);
        Location location = MainActivity.currentLocation;
        Double lat = Double.valueOf(location.getLocationLat());
        Double lng = Double.valueOf(location.getLocationLng());
        LatLng pointHome = new LatLng(lat, lng);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(pointHome, 15f));
    }

    /*
        Move map to home location
     */
    public void pointHome() {
        DBHandler dbh = new DBHandler(context);
        Home home = dbh.findHome();
        Location location = dbh.findLocation(home.getHomeLocationID());
        Double lat = Double.valueOf(location.getLocationLat());
        Double lng = Double.valueOf(location.getLocationLng());
        LatLng pointHome = new LatLng(lat, lng);

        map.moveCamera(CameraUpdateFactory.newLatLngZoom(pointHome, 15f));
        MainActivity.currentLocation = location;
        setPointers();
    }

    /*
        Move map to favourite 1 location
     */
    public void pointFav1(){
        DBHandler dbh = new DBHandler(context);
        Favourites fav1 = dbh.findFavourites(1);
        Location location = dbh.findLocation(fav1.getFavLocationID());
        Double lat = Double.valueOf(location.getLocationLat());
        Double lng = Double.valueOf(location.getLocationLng());
        LatLng pointHome = new LatLng(lat, lng);

        map.moveCamera(CameraUpdateFactory.newLatLngZoom(pointHome, 15f));
        MainActivity.currentLocation = location;
        setPointers();
    }

    /*
        Move map to favourite 2 location
     */
    public void pointFav2(){
        DBHandler dbh = new DBHandler(context);
        Favourites fav2 = dbh.findFavourites(2);
        Location location = dbh.findLocation(fav2.getFavLocationID());
        Double lat = Double.valueOf(location.getLocationLat());
        Double lng = Double.valueOf(location.getLocationLng());
        LatLng pointHome = new LatLng(lat, lng);

        map.moveCamera(CameraUpdateFactory.newLatLngZoom(pointHome, 15f));
        MainActivity.currentLocation = location;
        setPointers();
    }

    /*
        Move map to favourite 3 location
     */
    public void pointFav3(){
        DBHandler dbh = new DBHandler(context);
        Favourites fav3 = dbh.findFavourites(3);
        Location location = dbh.findLocation(fav3.getFavLocationID());
        Double lat = Double.valueOf(location.getLocationLat());
        Double lng = Double.valueOf(location.getLocationLng());
        LatLng pointHome = new LatLng(lat, lng);

        map.moveCamera(CameraUpdateFactory.newLatLngZoom(pointHome, 15f));
        MainActivity.currentLocation = location;
        setPointers();
    }

    /*
        Set up all Markers on the map
     */
    public void setPointers(){
        map.clear();
        DBHandler dbh = new DBHandler(context);
        Saved fav = dbh.findSaved("Favourites");
        Saved location = dbh.findSaved("Locations");
        int favCount = fav.getValue();
        int locationCount = location.getValue();

        String[] locationNames;
        LatLng[] coordinates;
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<LatLng> clist = new ArrayList<LatLng>();
        //ArrayList<MarkerOptions> = new ArrayList<MarkerOptions>();

        for(int i = 0; i < locationCount; i++){
            String name = dbh.findLocation(i+1).getLocationName();
            list.add(name);
        }

        for(int i = 0; i < locationCount; i++){
            LatLng point = new LatLng(Double.valueOf(dbh.findLocation(i+1).getLocationLat()), Double.valueOf(dbh.findLocation(i+1).getLocationLng()));
            clist.add(point);
        }

        locationNames = list.toArray(new String[0]);
        coordinates = clist.toArray(new LatLng[0]);

        if(dbh.getHome() != 0){
            int x = dbh.getHome();
            Location home = dbh.findLocation(x);
            String homelocation = home.getLocationName();

            for(int i = 0; i < locationCount; i++){
                Log.i("BURGER", String.valueOf(locationCount));
                if(locationNames[i].equals(homelocation)){
                    locationNames[i] = "Home";
                }
            }
        }

        if(favCount > 1){
            for(int i = 1; i < favCount; i++){
                Favourites favv = dbh.findFavourites(i);
                Location favlocate = dbh.findLocation(favv.getFavLocationID());
                String favname = favlocate.getLocationName();

                for(int j = 0 ; j < locationCount ; j++){
                    if(locationNames[j].equals(favname)){
                        locationNames[j] = "Favourite" + i;
                    }
                }
            }
        }

        for(int i = 0 ; i < locationCount ; i++){
            map.addMarker(new MarkerOptions().position(coordinates[i]).title(locationNames[i]));
        }
    }
}
