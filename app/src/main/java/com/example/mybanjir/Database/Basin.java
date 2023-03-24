package com.example.mybanjir.Database;

/*
    - Basin Data Model Class -

    Stores:
    + Basin ID
    + Basin Name
    + Basin position latitude
    + Basin position longitude
    + Basin Weather
    + Basin Temperature
    + Basin last updated date
    + Basin last updated time
    + Basin safety status
 */
public class Basin {

    private int basinID;
    private String basinName;
    private String basinLat;
    private String basinLng;
    private String basinWeather;
    private float basinTemp;
    private String basinDate;
    private String basinTime;
    private int basinStatus;

    public Basin(){
    }

    public Basin(int id, String name, String lat, String lng, String weather, float temp, String date, String time, int status){
        this.basinID = id;
        this.basinName = name;
        this.basinLat = lat;
        this.basinLng = lng;
        this.basinWeather = weather;
        this.basinTemp = temp;
        this.basinDate = date;
        this.basinTime = time;
        this.basinStatus = status;
    }

    public void setBasinID(int id){
        this.basinID = id;
    }

    public int getBasinID(){
        return this.basinID;
    }

    public void setBasinName(String name){
        this.basinName = name;
    }

    public String getBasinName(){
        return this.basinName;
    }

    public void setBasinLat(String lat){
        this.basinLat = lat;
    }

    public String getBasinLat(){
        return this.basinLat;
    }

    public void setBasinLng(String lng){
        this.basinLng = lng;
    }

    public String getBasinLng(){
        return this.basinLng;
    }

    public String getBasinWeather() {
        return basinWeather;
    }

    public void setBasinWeather(String weather){
        this.basinWeather = weather;
    }

    public void setBasinTemp(float basinTemp) {
        this.basinTemp = basinTemp;
    }

    public float getBasinTemp(){
        return this.basinTemp;
    }

    public void setBasinDate(String date){
        this.basinDate = date;
    }

    public String getBasinDate(){
        return this.basinDate;
    }

    public void setBasinTime(String time){
        this.basinTime = time;
    }

    public String getBasinTime(){
        return this.basinTime;
    }

    public void setBasinStatus(int status){
        this.basinStatus = status;
    }

    public int getBasinStatus(){
        return this.basinStatus;
    }

    @Override
    public String toString() {
        return "Basin{" +
                "basinID=" + basinID +
                ", basinName='" + basinName + '\'' +
                ", basinLat='" + basinLat + '\'' +
                ", basinLng='" + basinLng + '\'' +
                ", basinWeather='" + basinWeather + '\'' +
                ", basinTemp=" + basinTemp +
                ", basinDate='" + basinDate + '\'' +
                ", basinTime='" + basinTime + '\'' +
                ", basinStatus=" + basinStatus +
                '}';
    }
}
