package com.example.mybanjir.Database;

/*
    -  Favourite location Data Model Class -

    Stores:
    + Favourites ID
    + Favourite location ID
 */
public class Favourites {

    private int favID;
    private int favLocationID;

    public Favourites() {
    }

    public Favourites(int favID, int favLocationID) {
        this.favID = favID;
        this.favLocationID = favLocationID;
    }

    public int getFavID() {
        return favID;
    }

    public void setFavID(int favID) {
        this.favID = favID;
    }

    public int getFavLocationID() {
        return favLocationID;
    }

    public void setFavLocationID(int favLocationID) {
        this.favLocationID = favLocationID;
    }

    @Override
    public String toString() {
        return "Favourites{" +
                "favID=" + favID +
                ", favLocationID=" + favLocationID +
                '}';
    }
}
