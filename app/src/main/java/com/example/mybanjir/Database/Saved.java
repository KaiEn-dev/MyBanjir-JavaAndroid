package com.example.mybanjir.Database;


/*
    - Saved Data Model Class -

    Stores:
    + Data name
    + Data value
 */
public class Saved {

    private String data;
    private int value;

    public Saved() {
    }

    public Saved(String data, int value) {
        this.data = data;
        this.value = value;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Saved{" +
                "data='" + data + '\'' +
                ", value=" + value +
                '}';
    }
}
