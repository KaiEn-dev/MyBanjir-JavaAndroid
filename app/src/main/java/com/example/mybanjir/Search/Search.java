package com.example.mybanjir.Search;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mybanjir.Database.Favourites;
import com.example.mybanjir.Database.Home;
import com.example.mybanjir.Database.Location;
import com.example.mybanjir.Database.Saved;
import com.example.mybanjir.DatabaseTool.DBHandler;
import com.example.mybanjir.Favourite.Favourite;
import com.example.mybanjir.Home.HomeSetup;
import com.example.mybanjir.Home.MainActivity;
import com.example.mybanjir.Home.MapHandler;
import com.example.mybanjir.Menu.Menu;
import com.example.mybanjir.Menu.MenuEventHandler;
import com.example.mybanjir.R;

import java.util.ArrayList;
import java.util.List;

/*
    Search activity

    interface to search for locations
*/
public class Search extends AppCompatActivity implements SearchView.OnQueryTextListener {

    // Declare Variables
    ListView list;
    ListViewAdapter adapter;
    SearchView editsearch;
    String[] locationNameList;
    ArrayList<LocationNames> arraylist = new ArrayList<LocationNames>();

    boolean homesetup = false;
    boolean favsetup = false;
    boolean mapsearch = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        checkIntent();

        List<String> locationlist = initializeLocations(this);
        locationNameList = locationlist.toArray(new String[0]);

        // Locate the ListView in listview_main.xml
        list = (ListView) findViewById(R.id.listview);

        for (int i = 0; i < locationNameList.length; i++) {
            LocationNames locationNames = new LocationNames(locationNameList[i]);
            // Binds all strings into an array
            arraylist.add(locationNames);
        }

        // Pass results to ListViewAdapter Class
        adapter = new ListViewAdapter(this, arraylist);

        // Binds the Adapter to the ListView
        list.setAdapter(adapter);

        // Locate the EditText in listview_main.xml
        editsearch = (SearchView) findViewById(R.id.search);
        editsearch.setOnQueryTextListener(this);

        /*
           on click Event handler for items in listview
         */
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                LocationNames data= adapter.getItem(position);
                String name = data.getLocationName();

                if(mapsearch){
                    DBHandler dbh = new DBHandler(getApplicationContext());
                    Location searchedlocation = dbh.findLocation(name);
                    MainActivity.currentLocation = searchedlocation;
                    MainActivity.pointSearched = true;
                    endSearch();
                    MenuEventHandler.SelectedMenu.finish();
                }

                if(homesetup){
                    DBHandler dbh = new DBHandler(getApplicationContext());
                    Location homelocation = dbh.findLocation(name);
                    Home home = new Home(1, homelocation.getLocationID());
                    dbh.updateHome(home);
                    endSearch();
                    MainActivity.sethomemap = true;
                    MainActivity.currentLocation = homelocation;
                }

                if(favsetup){
                    DBHandler dbh = new DBHandler(getApplicationContext());
                    Location favlocation = dbh.findLocation(name);
                    dbh.insertFavourites(favlocation.getLocationID());
                    endSearch();
                    Favourite.changesmade = true;
                }
            }
        });

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String text = newText;
        adapter.filter(text);
        return false;
    }

    /*
        instantiate event handler when clicked
     */
    public void Clicked (View v) {
        SearchEventHandler homehandle = new SearchEventHandler(v, Search.this);
    }

    public ArrayList<String> initializeLocations(Context context){
        DBHandler dbh = new DBHandler(context);
        Location location;
        ArrayList<String> ar = new ArrayList<String>();

        Saved saved = dbh.findSaved("Locations");
        int x = saved.getValue();

        for(int i=1 ; i<=x; i++){
            location = dbh.findLocation(i);
            ar.add(location.getLocationName());
        }

        return ar;
    }

    /*
        Close search activity
     */
    public void endSearch(){
        this.finish();
    }

    /*
        Check contents of intent
     */
    public void checkIntent(){
        Intent intent = getIntent();

        if(intent.hasExtra("homesetup")){
            homesetup = true;
        }
        if(intent.hasExtra("favsetup")){
            favsetup = true;
        }
        if(intent.hasExtra("mapsearch")){
            mapsearch = true;
        }

    }


}