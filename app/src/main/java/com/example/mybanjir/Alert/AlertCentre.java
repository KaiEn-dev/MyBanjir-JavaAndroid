package com.example.mybanjir.Alert;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.mybanjir.DatabaseTool.DBHandler;
import com.example.mybanjir.R;

/*
    - Alert Centre Activity -

    Display all flood alerts & notifications in one place
 */
public class AlertCentre extends AppCompatActivity {

    public static AlertCentre alertcentre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_centre);
        alertcentre = AlertCentre.this;
        FloodTab();
    }

    /*
        Instantiate Event Handler when clickable views are clicked
     */
    public void Clicked (View v) {
        AlertEventHandler alerthandle = new AlertEventHandler(v, AlertCentre.this);
    }

    /*
        Change page layout when Flood Tab is selected
     */
    public void FloodTab(){
        // Get Views
        View line1 = (View)findViewById(R.id.OptionLine1);
        View line2 = (View)findViewById(R.id.OptionLine2);
        ConstraintLayout box1 = (ConstraintLayout) findViewById(R.id.AlertOptionFlood);
        ConstraintLayout box2 = (ConstraintLayout) findViewById(R.id.AlertOptionNotification);
        TextView a1L = (TextView) findViewById(R.id.A1location);
        TextView a2L = (TextView) findViewById(R.id.A2location);
        TextView a3L = (TextView) findViewById(R.id.A3location);
        TextView a1i = (TextView) findViewById(R.id.A1info);
        TextView a2i = (TextView) findViewById(R.id.A2info);
        TextView a3i = (TextView) findViewById(R.id.A3info);
        TextView a1t = (TextView) findViewById(R.id.A1time);
        TextView a2t = (TextView) findViewById(R.id.A2time);
        TextView a3t = (TextView) findViewById(R.id.A3time);
        ScrollView container1 = (ScrollView) findViewById(R.id.FloodDetails);
        ScrollView container2 = (ScrollView) findViewById(R.id.NotificationDetails);

        // Get data from database
        DBHandler dbh = new DBHandler(getApplicationContext());
        String name1 = dbh.findLocation(2).getLocationName();
        String name2 = dbh.findLocation(4).getLocationName();
        String name3 = dbh.findLocation(5).getLocationName();
        String info1 = dbh.findAlert(2).getAlertMessage();
        String info2 = dbh.findAlert(4).getAlertMessage();
        String info3 = dbh.findAlert(5).getAlertMessage();
        String time1 = dbh.findAlert(2).getAlertTime();
        String time2 = dbh.findAlert(4).getAlertTime();
        String time3 = dbh.findAlert(5).getAlertTime();

        // Make layout changes
        line1.setBackgroundColor(Color.parseColor("#FFFFFF"));
        line2.setBackgroundColor(Color.parseColor("#717171"));
        box1.setClickable(false);
        box2.setClickable(true);
        a1L.setText(name1);
        a2L.setText(name2);
        a3L.setText(name3);
        a1i.setText(info1);
        a2i.setText(info2);
        a3i.setText(info3);
        a1t.setText(time1);
        a2t.setText(time2);
        a3t.setText(time3);
        container1.setVisibility(View.VISIBLE);
        container2.setVisibility(View.GONE);
    }

    /*
        Change page layout when Notification Tab is selected
     */
    public void NotiTab(){
        // Get views
        View line1 = (View)findViewById(R.id.OptionLine1);
        View line2 = (View)findViewById(R.id.OptionLine2);
        ConstraintLayout box1 = (ConstraintLayout) findViewById(R.id.AlertOptionFlood);
        ConstraintLayout box2 = (ConstraintLayout) findViewById(R.id.AlertOptionNotification);
        ScrollView container1 = (ScrollView) findViewById(R.id.FloodDetails);
        ScrollView container2 = (ScrollView) findViewById(R.id.NotificationDetails);

        // Make layout changes
        line1.setBackgroundColor(Color.parseColor("#717171"));
        line2.setBackgroundColor(Color.parseColor("#FFFFFF"));
        box1.setClickable(true);
        box2.setClickable(false);
        container1.setVisibility(View.GONE);
        container2.setVisibility(View.VISIBLE);
    }
}