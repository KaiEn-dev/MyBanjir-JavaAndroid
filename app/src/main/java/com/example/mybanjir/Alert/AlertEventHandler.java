package com.example.mybanjir.Alert;

import android.view.View;
import android.widget.Toast;

/*
   - Alert Centre Event Handler Class -

   Handle all Alert Centre events
 */
public class AlertEventHandler {

    View SelectedView;
    AlertCentre SelectedAlertCentre;

    /*
        Constructor to initialize variables
     */
    public AlertEventHandler (View v, AlertCentre a){
        SelectedView = v;
        SelectedAlertCentre = a;
        CheckView();
    }

    /*
        Check ID of clicked Views and take actions based on it
     */
    void CheckView(){
        String IDname;
        IDname = SelectedView.getResources().getResourceName(SelectedView.getId());

        switch (IDname) {
            case "com.example.mybanjir:id/AlertCentreClose":
                CloseCentre();
                break;
            case "com.example.mybanjir:id/AlertOptionFlood":
                goFlood();
                break;
            case "com.example.mybanjir:id/AlertOptionNotification":
                goNoti();
                break;
            default:
                Toast.makeText(SelectedView.getContext(), "Coming Soon!", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    /*
        Close Alert Centre activity
     */
    public void CloseCentre(){
        SelectedAlertCentre.finish();
    }

    /*
        Call method when Flood tab is selected
     */
    public void goFlood() {
        AlertCentre.alertcentre.FloodTab();
    }

    /*
        Call method when Notification tab is selected
     */
    public void goNoti(){
        AlertCentre.alertcentre.NotiTab();
    }
}
