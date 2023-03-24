package com.example.mybanjir.Home;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import com.example.mybanjir.Alert.AlertCentre;
import com.example.mybanjir.DatabaseTool.DBHandler;
import com.example.mybanjir.Favourite.Favourite;
import com.example.mybanjir.Menu.Menu;
import com.example.mybanjir.Report.Reports;
import com.example.mybanjir.Stats.Status;
import com.google.android.gms.maps.GoogleMap;

/*
    - Home Event Handler Class -

    Handle Main Activity events
 */

public class HomeEventHandler {

    View SelectedView;
    static GoogleMap map;
    Context context;

    /*
        Constructor to initialize variables
    */
    public HomeEventHandler (View v, GoogleMap map, Context context){
        SelectedView = v;
        this.map = map;
        this.context = context;
        CheckView();
    }

    /*
        Check ID of clicked View
     */
    void CheckView(){
        String IDname;
        IDname = SelectedView.getResources().getResourceName(SelectedView.getId());

        switch (IDname) {
            case "com.example.mybanjir:id/Menu":
                LaunchMenu();
                break;
            case "com.example.mybanjir:id/WarningMain":
                LaunchAlert();
                break;
            case "com.example.mybanjir:id/ReportMain":
                LaunchReport();
                break;
            case "com.example.mybanjir:id/StatusMain":
                LaunchStatus();
                break;
            case "com.example.mybanjir:id/FavouritesMain":
                LaunchFavourite();
                break;
            case "com.example.mybanjir:id/CurrentLocate":
                DBHandler dbh = new DBHandler(context);
                MainActivity.currentLocation = dbh.findLocation(dbh.getHome());
                resetMap();
                break;
            default:
                Toast.makeText(SelectedView.getContext(), "Coming Soon!", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    /*
        Launch Menu Activity
    */
    void LaunchMenu(){
        Intent i = new Intent(SelectedView.getContext(), Menu.class);
        SelectedView.getContext().startActivity(i);
    }

    /*
        Launch AlertCentre activity
    */
    void LaunchAlert(){
        Intent i = new Intent(SelectedView.getContext(), AlertCentre.class);
        SelectedView.getContext().startActivity(i);
    }

    /*
        Launch Report activity
    */
    void LaunchReport(){
        Intent i = new Intent(SelectedView.getContext(), Reports.class);
        SelectedView.getContext().startActivity(i);
    }

    /*
        Launch Status activity
     */
    void LaunchStatus(){
        Intent i = new Intent(SelectedView.getContext(), Status.class);
        i.putExtra("Location", MainActivity.currentLocation.getLocationName());
        SelectedView.getContext().startActivity(i);
    }

    /*
        Launch Favourite activity
     */
    void LaunchFavourite(){
        Intent i = new Intent(SelectedView.getContext(), Favourite.class);
        SelectedView.getContext().startActivity(i);
    }

    /*
        Refresh map and return center of map to Home
    */
    void resetMap(){
        MapHandler maphandle = new MapHandler(SelectedView.getContext(), map);
        maphandle.pointHome();
        MainActivity.mainActivity.setStatus();
    }
}

