package com.example.mybanjir.Search;

import android.view.View;
import android.widget.Toast;

import com.example.mybanjir.Menu.Menu;

/*
    Search activity event handler
 */

public class SearchEventHandler {
    View SelectedView;
    Search SelectedSearch;

    public SearchEventHandler(View v, Search s) {
        SelectedView = v;
        SelectedSearch = s;
        CheckView();
    }

    void CheckView() {
        String IDname;

        IDname = SelectedView.getResources().getResourceName(SelectedView.getId());

        switch (IDname) {
            case "com.example.mybanjir:id/dragdown":
                CloseSearch();
                break;
            default:
                Toast.makeText(SelectedView.getContext(), "Coming Soon!", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void CloseSearch () {
        SelectedSearch.finish();
    }

}
