package com.example.mybanjir.Database;

/*
    - Water level Data Model Class -

    Stores:
    + Basin ID
    + Water level reading
    + Water level change rate/pattern
    + Water level severity ranking
    + Water level safety status
 */
public class Waterlvl {

    private int basinID;
    private float basinWL;
    private String basinWLRate;
    private String basinWLRank;
    private int basinWLStatus;

    public Waterlvl() {
    }

    public Waterlvl(int basinID, float basinWL, String basinWLRate, String basinWLRank, int basinWLStatus) {
        this.basinID = basinID;
        this.basinWL = basinWL;
        this.basinWLRate = basinWLRate;
        this.basinWLRank = basinWLRank;
        this.basinWLStatus = basinWLStatus;
    }

    public int getBasinID() {
        return basinID;
    }

    public void setBasinID(int basinID) {
        this.basinID = basinID;
    }

    public float getBasinWL() {
        return basinWL;
    }

    public void setBasinWL(float basinWL) {
        this.basinWL = basinWL;
    }

    public String getBasinWLRate() {
        return basinWLRate;
    }

    public void setBasinWLRate(String basinWLRate) {
        this.basinWLRate = basinWLRate;
    }

    public String getBasinWLRank() {
        return basinWLRank;
    }

    public void setBasinWLRank(String basinWLRank) {
        this.basinWLRank = basinWLRank;
    }

    public int getBasinWLStatus() {
        return basinWLStatus;
    }

    public void setBasinWLStatus(int basinWLStatus) {
        this.basinWLStatus = basinWLStatus;
    }

    @Override
    public String toString() {
        return "Waterlvl{" +
                "basinID=" + basinID +
                ", basinWL=" + basinWL +
                ", basinWLRate='" + basinWLRate + '\'' +
                ", basinWLRank='" + basinWLRank + '\'' +
                ", basinWLStatus=" + basinWLStatus +
                '}';
    }
}
