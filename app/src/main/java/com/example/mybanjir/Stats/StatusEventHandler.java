package com.example.mybanjir.Stats;

import android.view.View;
import android.widget.Toast;

import com.example.mybanjir.Alert.AlertCentre;

/*
    Status activity event handler class

    Handle events in the status activity
 */

public class StatusEventHandler {

    View SelectedView;
    Status SelectedStatus;

    /*
        Constructor to initialize Variables
    */
    public StatusEventHandler (View v, Status s){
        SelectedView = v;
        SelectedStatus = s;
        CheckView();
    }

    /*
        Check ID of clicked View and take actions based on it
    */
    void CheckView(){
        String IDname;

        IDname = SelectedView.getResources().getResourceName(SelectedView.getId());

        switch (IDname) {
            case "com.example.mybanjir:id/StatusClose":
                CloseMenu();
                break;
            default:
                Toast.makeText(SelectedView.getContext(), "Coming Soon!", Toast.LENGTH_SHORT).show();
                break;
        }


    }

    /*
        Close AlertCentre activity
     */
    public void CloseMenu(){
        SelectedStatus.finish();
    }

}
