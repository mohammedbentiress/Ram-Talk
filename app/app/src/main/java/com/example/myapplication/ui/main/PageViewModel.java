package com.example.myapplication.ui.main;

import androidx.lifecycle.ViewModel;

import com.example.myapplication.Item;

import java.util.List;

public class PageViewModel extends ViewModel {

    private int index;
    private List<Item> data;

    public List<Item> getData() {
        return data;
    }

    public void setData(List<Item> data) {
        this.data = data;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}