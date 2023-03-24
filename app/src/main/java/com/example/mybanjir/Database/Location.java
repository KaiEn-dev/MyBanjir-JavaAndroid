package com.example.mybanjir.Database;

/*
    - Location Data Model Class -

    Stores:
    + Location ID
    + Location Name
    + Location Latitude
    + Location Longitude
    + Location Basin ID
 */
public class Location {

    private int locationID;
    private String locationName;
    private String locationLat;
    private String locationLng;
    private int locationBasin;

    public Location(){
    }

    public Location(int id, String name, String lat, String lng, int basin){
        this.locationID = id;
        this.locationName = name;
        this.locationLat = lat;
        this.locationLng = lng;
        this.locationBasin = basin;
    }

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationLat() {
        return locationLat;
    }

    public void setLocationLat(String locationLat) {
        this.locationLat = locationLat;
    }

    public String getLocationLng() {
        return locationLng;
    }

    public void setLocationLng(String locationLng) {
        this.locationLng = locationLng;
    }

    public int getLocationBasin() {
        return locationBasin;
    }

    public void setLocationBasin(int locationBasin) {
        this.locationBasin = locationBasin;
    }

    @Override
    public String toString() {
        return "Location{" +
                "locationID=" + locationID +
                ", locationName='" + locationName + '\'' +
                ", locationLat='" + locationLat + '\'' +
                ", locationLng='" + locationLng + '\'' +
                ", locationBasin=" + locationBasin +
                '}';
    }
}
