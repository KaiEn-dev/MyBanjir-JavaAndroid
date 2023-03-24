package com.example.mybanjir.Database;

/*
    - Home location Data Model Class -

    Stores:
    + Home ID
    + Home location ID
 */
public class Home {

    private int homeID;
    private int homeLocationID;

    public Home() {
    }

    public Home(int homeID, int homeLocationID) {
        this.homeID = homeID;
        this.homeLocationID = homeLocationID;
    }

    public int getHomeID() {
        return homeID;
    }

    public void setHomeID(int homeID) {
        this.homeID = homeID;
    }

    public int getHomeLocationID() {
        return homeLocationID;
    }

    public void setHomeLocationID(int homeLocationID) {
        this.homeLocationID = homeLocationID;
    }

    @Override
    public String toString() {
        return "Home{" +
                "homeID=" + homeID +
                ", homeLocationID=" + homeLocationID +
                '}';
    }
}
