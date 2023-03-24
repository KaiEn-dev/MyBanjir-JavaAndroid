package com.example.mybanjir.Stats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mybanjir.Alert.AlertCentre;
import com.example.mybanjir.Alert.AlertEventHandler;
import com.example.mybanjir.Database.Basin;
import com.example.mybanjir.Database.Location;
import com.example.mybanjir.Database.Rainfall;
import com.example.mybanjir.Database.Waterlvl;
import com.example.mybanjir.DatabaseTool.DBHandler;
import com.example.mybanjir.R;

import org.w3c.dom.Text;

/*
    - Status activity -

    Show detailed information of a location
 */
public class Status extends AppCompatActivity {

    Location currentLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);
        checkIntent();
        setStatus();
    }

    /*
        Instantiate Event Handler on click
     */
    public void Clicked (View v) {
        StatusEventHandler statushandle = new StatusEventHandler(v, Status.this);
    }

    /*
        Get intent extra contents
     */
    public void checkIntent(){
        Intent intent = getIntent();
        DBHandler dbh = new DBHandler(getApplicationContext());
        String name  = intent.getStringExtra("Location");
        currentLocation = dbh.findLocation(name);
    }

    /*
        Set up information display for the selected location
    */
    public void setStatus() {
        TextView title = (TextView) findViewById(R.id.StatusLocation);
        TextView date = (TextView) findViewById(R.id.StatusDate);
        TextView time = (TextView) findViewById(R.id.StatusTime);
        TextView wlreading = (TextView) findViewById(R.id.StatusWLReading);
        TextView wlrate = (TextView) findViewById(R.id.StatusWLRate);
        TextView wlrank = (TextView) findViewById(R.id.StatusWLRank);

        TextView rfreading = (TextView) findViewById(R.id.StatusRFReading);
        TextView rfrank = (TextView) findViewById(R.id.StatusRFRank);
        TextView rftotal = (TextView) findViewById(R.id.TotalRFReading);
        View WLstatus = (View) findViewById(R.id.WLcolorcode);
        View RFstatus = (View) findViewById(R.id.RFcolorcode);

        DBHandler dbh = new DBHandler(getApplicationContext());
        Basin basin = dbh.findBasin(currentLocation.getLocationBasin());
        Waterlvl WL = dbh.findWaterlvl(basin.getBasinID());
        Rainfall RF = dbh.findRainfall(basin.getBasinID());
        int WLcolor = WL.getBasinWLStatus();
        int RFcolor = RF.getBasinRFStatus();

        title.setText(currentLocation.getLocationName());
        date.setText(basin.getBasinDate());
        time.setText(basin.getBasinTime());
        wlreading.setText(Float.toString(WL.getBasinWL()) + " m");
        wlrate.setText(WL.getBasinWLRate());
        wlrank.setText(WL.getBasinWLRank());
        rfreading.setText(Float.toString(RF.getBasinRF()) + " mm");
        rfrank.setText(RF.getBasinRFRank());
        rftotal.setText(Float.toString(RF.getBasinRFTotal()) + " mm");


        int color1 = Color.parseColor("#5cf436");
        int color2 = Color.parseColor("#f4ab36");
        int color3 = Color.parseColor("#f43636");

        switch (WLcolor){
            case 1:
                WLstatus.setBackgroundColor(color1);
                break;
            case 2:
                WLstatus.setBackgroundColor(color2);
                break;
            case 3:
                WLstatus.setBackgroundColor(color3);
                break;
            default:
                break;
        }

        switch (RFcolor){
            case 1:
                RFstatus.setBackgroundColor(color1);
                break;
            case 2:
                RFstatus.setBackgroundColor(color2);
                break;
            case 3:
                RFstatus.setBackgroundColor(color3);
                break;
            default:
                break;
        }

    }
}