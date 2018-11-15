package com.example.xieyaoyan.myapplication;

import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.List;


public class CustomA extends AppCompatActivity{
    private List<ImageView> pointsList = new ArrayList<ImageView>();
    private int count = 0;
    private LinearLayout points;
    private ImageView image;
    private LinearLayout parentRL;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customa);
        parentRL= (LinearLayout) findViewById(R.id.parentRL);
        points = (LinearLayout) findViewById(R.id.points);
        image= (ImageView) findViewById(R.id.image1);
        handler.sendEmptyMessage(1);

    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (points.getChildCount() == 6) {
                points.removeAllViews();
            }
            ImageView imageView = new ImageView(CustomA.this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(12, 12);
            params.leftMargin = 8;
            imageView.setLayoutParams(params);
            imageView.setBackgroundResource(R.drawable.a);
            pointsList.add(imageView);
            points.addView(pointsList.get(count), -1);
            count++;
            handler.sendEmptyMessageDelayed(1, 1000);
        }
    };
}
