package com.example.mybanjir.Favourite;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mybanjir.DatabaseTool.DBHandler;
import com.example.mybanjir.Home.MainActivity;
import com.example.mybanjir.Search.Search;

import org.w3c.dom.Text;

/*
    - Favourites Event Handler Class -

    Handle all favourite activity events
 */

public class FavouriteEventHandler {

    View SelectedView;
    Context context;
    Favourite SelectedFavourite;
    static boolean editable = true;

    /*
        Constructor to initialize variables
     */
    public FavouriteEventHandler(View view, Favourite favourite, Context context) {
        this.SelectedView = view;
        this.context = context;
        this.SelectedFavourite = favourite;
        CheckView();
    }

    /*
        Check ID of clicked Views and take actions based on it
     */
    public void CheckView() {
        String IDname;
        IDname = SelectedView.getResources().getResourceName(SelectedView.getId());

        switch (IDname) {
            case "com.example.mybanjir:id/Fav1":
                goFav1();
                closeFavourite();
                break;
            case "com.example.mybanjir:id/Fav2":
                goFav2();
                closeFavourite();
                break;
            case "com.example.mybanjir:id/Fav3":
                goFav3();
                closeFavourite();
                break;
            case "com.example.mybanjir:id/AddFav":
                launchSearch();
                break;
            case "com.example.mybanjir:id/EditFav":
                launchEdit();
                break;
            case "com.example.mybanjir:id/CloseFav":
                closeFavourite();
                break;
            case "com.example.mybanjir:id/Fav1Remove":
                remove1();
                break;
            case "com.example.mybanjir:id/Fav2Remove":
                remove2();
                break;
            case "com.example.mybanjir:id/Fav3Remove":
                remove3();
                break;
            default:
                Toast.makeText(SelectedView.getContext(), "Coming Soon!", Toast.LENGTH_SHORT).show();
                break;

        }

    }

    /*
        Set Favourite location 1 to be the center of map
    */
    void goFav1(){
        MainActivity.pointFav = 1;
    }

    /*
    Set Favourite location 2 to be the center of map
     */
    void goFav2(){
        MainActivity.pointFav = 2;
    }

    /*
        Set Favourite location 3 to be the center of map
     */
    void goFav3(){
        MainActivity.pointFav = 3;
    }

    /*
        Start Search activity
     */
    void launchSearch(){
        Intent i = new Intent(SelectedView.getContext(), Search.class);
        i.putExtra("favsetup", 1);
        SelectedView.getContext().startActivity(i);
    }

    /*
        Remove favourite 1
     */
    void remove1(){
        DBHandler dbh = new DBHandler(context);
        dbh.removeFavourites(1);
        Favourite.favAct.setFav();
        editable = true;
    }

    /*
        Remove favourite 2
     */
    void remove2(){
        DBHandler dbh = new DBHandler(context);
        dbh.removeFavourites(2);
        Favourite.favAct.setFav();
        editable = true;
    }

    /*
        Remove favourite 3
     */
    void remove3(){
        DBHandler dbh = new DBHandler(context);
        dbh.removeFavourites(3);
        Favourite.favAct.setFav();
        editable = true;
    }

    /*
        Open/Close editing mode
     */
    void launchEdit(){
        if(editable){
            Favourite.favAct.editMode();
            editable = false;
        }else{
            Favourite.favAct.setFav();
            editable = true;
        }

    }

    /*
        Close Favourite activity
     */
    void closeFavourite(){
        SelectedFavourite.finish();
        editable = true;
    }

}
