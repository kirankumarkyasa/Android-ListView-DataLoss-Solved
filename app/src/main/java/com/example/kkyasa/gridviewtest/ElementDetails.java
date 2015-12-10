package com.example.kkyasa.gridviewtest;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * Created by kkyasa on 11/17/2015.
 */
public class ElementDetails {

    int viewType;
    ArrayList<String> contentList;
    LinkedHashMap<String,Boolean> multiSelectContentList;
    ArrayList<String> selectList;
    String contentType;
    String key;
    String value;
    boolean isEntered;
    int position;

    public LinkedHashMap<String, Boolean> getMultiSelectContentList() {
        return multiSelectContentList;
    }

    public void setMultiSelectContentList(LinkedHashMap<String,Boolean> multiSelectContentList) {
        this.multiSelectContentList = multiSelectContentList;
    }

    public ArrayList<String> getSelectList() {
        return selectList;
    }

    public void setSelectList(ArrayList<String> selectList) {
        this.selectList = selectList;
    }


    public boolean isEntered() {
        return isEntered;
    }

    public void setIsEntered(boolean isEntered) {
        this.isEntered = isEntered;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    public ArrayList<String> getContentList() {
        return contentList;
    }

    public void setContentList(ArrayList<String> contentList) {
        this.contentList = contentList;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}
