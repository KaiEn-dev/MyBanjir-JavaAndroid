package com.example.mybanjir.Menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.mybanjir.Database.Report;
import com.example.mybanjir.DatabaseTool.DBHandler;
import com.example.mybanjir.R;

/*
    - Report History Activity -

    Show details of reports made
 */
public class ReportHistory extends AppCompatActivity {

    int reportid;
    TextView rpt1;
    TextView rpt2;
    TextView rpt3;

    /*
        get data from database and store in variables
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_history);
        DBHandler dbh = new DBHandler(getApplicationContext());
        reportid = dbh.findSaved("Reports").getValue();
        getViews();
        showReports();
    }

    /*
        Get views
     */
    public void getViews(){
        rpt1 = (TextView) findViewById(R.id.ViewReport1);
        rpt2 = (TextView) findViewById(R.id.ViewReport2);
        rpt3 = (TextView) findViewById(R.id.ViewReport3);
    }

    /*
        Close activity when close button is clicked
     */
    public void Clicked(View v){
        this.finish();
    }

    /*
        Show report details
     */
    public void showReports(){
        DBHandler dbh = new DBHandler(getApplicationContext());
        if(reportid == 1){
            rpt1.setVisibility(View.GONE);
            rpt2.setVisibility(View.GONE);
            rpt3.setVisibility(View.GONE);
        }
        if(reportid == 2){
            Report r1 = dbh.findReport(1);
            rpt1.setText(r1.toString());
            rpt2.setVisibility(View.GONE);
            rpt3.setVisibility(View.GONE);
        }
        if(reportid == 3){
            Report r1 = dbh.findReport(1);
            Report r2 = dbh.findReport(2);
            rpt1.setText(r1.toString());
            rpt2.setText(r2.toString());
            rpt3.setVisibility(View.GONE);
        }
        if(reportid > 3){
            Report r1 = dbh.findReport(reportid - 1);
            Report r2 = dbh.findReport(reportid - 2);
            Report r3 = dbh.findReport(reportid - 3);
            rpt1.setText(r1.toString());
            rpt2.setText(r2.toString());
            rpt3.setText(r3.toString());
        }
    }

}