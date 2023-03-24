package com.example.mybanjir.DatabaseTool.Data;

import android.content.Context;

import com.example.mybanjir.Database.Favourites;
import com.example.mybanjir.DatabaseTool.DBHandler;


/*
    - Favourites Data -
 */
public class FavouritesData {
    // Data
    private static final int id1 = 1;
    private static final int id2 = 2;
    private static final int id3 = 3;

    private static final int location1 = 0;
    private static final int location2 = 0;
    private static final int location3 = 0;

    private static final Favourites fav1 = new Favourites(id1, location1);
    private static final Favourites fav2 = new Favourites(id2, location2);
    private static final Favourites fav3 = new Favourites(id3, location3);

    public FavouritesData(Context context) {
        insertFavourites(context);
    }

    // Database data input
    public void insertFavourites(Context context){
        DBHandler dbh = new DBHandler(context);
        dbh.addFavourites(fav1);
        dbh.addFavourites(fav2);
        dbh.addFavourites(fav3);
    }

}
