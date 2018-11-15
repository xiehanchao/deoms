package com.example.xieyaoyan.myapplication;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

import android.widget.ArrayAdapter;

public class CustomE extends AppCompatActivity {
    private MyListView mListView;
    private List<String> mDates;
    private MyScrollView mYscrollview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custome);
        initData();
        mListView = findViewById(R.id.id_recyclerview);
        mListView.setFocusable(false);
        mYscrollview = findViewById(R.id.my_scrollview);
        mListView.setScrollview(mYscrollview);
        mYscrollview.setListView(mListView);
        mListView.setAdapter(new ArrayAdapter<String>(this, R.layout.item_home, mDates));
    }

    protected void initData()
    {
        mDates = new ArrayList<>();
        for (int i = 'A'; i < 'Z'; i++)
        {
            mDates.add("" + (char) i);
        }
    }

}