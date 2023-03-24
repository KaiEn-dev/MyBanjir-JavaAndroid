package com.example.mybanjir.Report;

import android.os.Build;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.example.mybanjir.Database.Report;
import com.example.mybanjir.Database.Saved;
import com.example.mybanjir.DatabaseTool.DBHandler;
import com.example.mybanjir.Home.MainActivity;

/*
    - Report activity event handler -

    Handle all events in the Reports activity
 */

public class ReportEventHandler {
    View SelectedView;
    Reports SelectedReport;

    /*
        Constructor to initialize variables
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public ReportEventHandler (View v, Reports r){
        SelectedView = v;
        SelectedReport = r;
        CheckView();
    }

    /*
        Check ID of clicked View and take action based on it
    */
    @RequiresApi(api = Build.VERSION_CODES.O)
    void CheckView(){
        String IDname;

        IDname = SelectedView.getResources().getResourceName(SelectedView.getId());

        switch (IDname) {
            case "com.example.mybanjir:id/ReportClose":
                CloseReport();
                Toast.makeText(SelectedView.getContext(), "Report Sent!", Toast.LENGTH_SHORT).show();
                break;
            case "com.example.mybanjir:id/RptFlood":
                RFlood();
                Toast.makeText(SelectedView.getContext(), "Report Sent!", Toast.LENGTH_SHORT).show();
                break;
            case "com.example.mybanjir:id/RptHazard":
                RHazard();
                Toast.makeText(SelectedView.getContext(), "Report Sent!", Toast.LENGTH_SHORT).show();
                break;
            case "com.example.mybanjir:id/RptMap":
                RMap();
                Toast.makeText(SelectedView.getContext(), "Report Sent!", Toast.LENGTH_SHORT).show();
                break;
            case "com.example.mybanjir:id/RptRoad":
                RRoad();
                Toast.makeText(SelectedView.getContext(), "Report Sent!", Toast.LENGTH_SHORT).show();
                break;
            case "com.example.mybanjir:id/RptSos":
                RSos();
                Toast.makeText(SelectedView.getContext(), "Report Sent!", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(SelectedView.getContext(), "Coming Soon!", Toast.LENGTH_SHORT).show();
                break;
        }


    }

    /*
        Close Report activity
    */
    public void CloseReport(){
        SelectedReport.finish();
    }

    /*
        Make Flood Report
    */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void RFlood(){
        DBHandler dbh = new DBHandler(SelectedView.getContext());
        Saved save = dbh.findSaved("Reports");
        int id = save.getValue();
        Report report = new Report(id, MainActivity.currentLocation.getLocationID(), String.valueOf(java.time.LocalDate.now()), String.valueOf(java.time.LocalTime.now()), "Flood", "-");
        dbh.addReport(report);
        save.setValue(id+1);
        dbh.updateSaved(save);
    }

    /*
        Make Hazard Report
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void RHazard(){
        DBHandler dbh = new DBHandler(SelectedView.getContext());
        Saved save = dbh.findSaved("Reports");
        int id = save.getValue();
        Report report = new Report(id, MainActivity.currentLocation.getLocationID(), String.valueOf(java.time.LocalDate.now()), String.valueOf(java.time.LocalTime.now()), "Hazard", "-");
        dbh.addReport(report);
        save.setValue(id+1);
        dbh.updateSaved(save);
    }

    /*
        Make Map issue Report
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void RMap(){
        DBHandler dbh = new DBHandler(SelectedView.getContext());
        Saved save = dbh.findSaved("Reports");
        int id = save.getValue();
        Report report = new Report(id, MainActivity.currentLocation.getLocationID(), String.valueOf(java.time.LocalDate.now()), String.valueOf(java.time.LocalTime.now()), "Map", "-");
        dbh.addReport(report);
        save.setValue(id+1);
        dbh.updateSaved(save);
    }

    /*
        Make Road blockage report
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void RRoad(){
        DBHandler dbh = new DBHandler(SelectedView.getContext());
        Saved save = dbh.findSaved("Reports");
        int id = save.getValue();
        Report report = new Report(id, MainActivity.currentLocation.getLocationID(), String.valueOf(java.time.LocalDate.now()), String.valueOf(java.time.LocalTime.now()), "Road", "-");
        dbh.addReport(report);
        save.setValue(id+1);
        dbh.updateSaved(save);
    }

    /*
        Make SOS report
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void RSos(){
        DBHandler dbh = new DBHandler(SelectedView.getContext());
        Saved save = dbh.findSaved("Reports");
        int id = save.getValue();
        Report report = new Report(id, MainActivity.currentLocation.getLocationID(), String.valueOf(java.time.LocalDate.now()), String.valueOf(java.time.LocalTime.now()), "SOS", "-");
        dbh.addReport(report);
        save.setValue(id+1);
        dbh.updateSaved(save);
    }

}
