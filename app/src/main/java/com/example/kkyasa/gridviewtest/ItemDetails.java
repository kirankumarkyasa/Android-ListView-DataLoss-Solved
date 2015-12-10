package com.example.kkyasa.gridviewtest;

/**
 * Created by kkyasa on 11/16/2015.
 */
public class ItemDetails {

    int position;
    boolean x;
    String value;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean isEntered() {
        return x;
    }

    public void setEntered(boolean x) {
        this.x = x;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return ""+position+"/"+x+"/"+value;
    }
}
