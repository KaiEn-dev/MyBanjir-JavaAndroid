package com.example.mybanjir.Report;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.mybanjir.R;

/*
    - Report activity -

    Interface for making reports
*/

public class Reports extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
    }

    /*
        Instantiate Event Handler when views are clicked
     */
    public void Clicked (View v) {
        ReportEventHandler reporthandle = new ReportEventHandler(v, Reports.this);
    }

}