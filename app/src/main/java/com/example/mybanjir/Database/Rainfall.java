package com.example.mybanjir.Database;

/*
    - Rainfall Data Model Class -

    Stores:
    + Basin ID
    + Rainfall Reading
    + Rainfall severity ranking
    + Rainfall Total Reading in the last 3 hours
    + Rainfall safety status
 */
public class Rainfall {

    private int basinID;
    private float basinRF;
    private String basinRFRank;
    private float basinRFTotal;
    private int basinRFStatus;

    public Rainfall() {
    }

    public Rainfall(int basinID, float basinRF, String basinRFRank, float basinRFTotal, int basinRFStatus) {
        this.basinID = basinID;
        this.basinRF = basinRF;
        this.basinRFRank = basinRFRank;
        this.basinRFTotal = basinRFTotal;
        this.basinRFStatus = basinRFStatus;
    }

    public int getBasinID() {
        return basinID;
    }

    public void setBasinID(int basinID) {
        this.basinID = basinID;
    }

    public float getBasinRF() {
        return basinRF;
    }

    public void setBasinRF(float basinRF) {
        this.basinRF = basinRF;
    }

    public String getBasinRFRank() {
        return basinRFRank;
    }

    public void setBasinRFRank(String basinRFRank) {
        this.basinRFRank = basinRFRank;
    }

    public float getBasinRFTotal() {
        return basinRFTotal;
    }

    public void setBasinRFTotal(float basinRFTotal) {
        this.basinRFTotal = basinRFTotal;
    }

    public int getBasinRFStatus() {
        return basinRFStatus;
    }

    public void setBasinRFStatus(int basinRFStatus) {
        this.basinRFStatus = basinRFStatus;
    }

    @Override
    public String toString() {
        return "Rainfall{" +
                "basinID=" + basinID +
                ", basinRF=" + basinRF +
                ", basinRFRank='" + basinRFRank + '\'' +
                ", basinRFTotal=" + basinRFTotal +
                ", basinRFStatus=" + basinRFStatus +
                '}';
    }
}
