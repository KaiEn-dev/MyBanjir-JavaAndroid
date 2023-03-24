package com.example.mybanjir.Menu;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.example.mybanjir.Search.Search;

/*
    - Menu event handler class -

    Handle events in the Menu activity
 */
public class MenuEventHandler {

    View SelectedView;
    public static Menu SelectedMenu;

    /*
        Constructor to initialize variables
     */
    public MenuEventHandler (View v, Menu m){
        SelectedView = v;
        SelectedMenu = m;
        CheckView();
    }

    /*
        Check ID of clicked Views and take actions based on it
    */
    void CheckView(){
        String IDname;
        IDname = SelectedView.getResources().getResourceName(SelectedView.getId());

        switch (IDname) {
            case "com.example.mybanjir:id/MenuClose":
                CloseMenu();
                break;
            case "com.example.mybanjir:id/Searchbox":
                LaunchSearch();
                break;
            case "com.example.mybanjir:id/Option3Button":
                LaunchReportHistory();
                break;
            default:
                Toast.makeText(SelectedView.getContext(), "Coming Soon!", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    /*
        Close menu activity
     */
    public void CloseMenu(){
        SelectedMenu.finish();
    }

    /*
        Launch Search activity
     */
    public void LaunchSearch(){
        Intent i = new Intent(SelectedView.getContext(), Search.class);
        i.putExtra("mapsearch", 1);
        SelectedView.getContext().startActivity(i);
    }

    /*
        Launch Report history activity
     */
    public void LaunchReportHistory(){
        Intent i = new Intent(SelectedView.getContext(), ReportHistory.class);
        SelectedView.getContext().startActivity(i);
    }
}
