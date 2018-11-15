package com.example.xieyaoyan.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt1 = findViewById(R.id.bt1);
        Button bt2 = findViewById(R.id.bt2);
        Button bt3 = findViewById(R.id.bt3);
        Button bt4 = findViewById(R.id.bt4);
//        Button bt5 = findViewById(R.id.bt5);


        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
//        bt5.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt1:
                startActivity(new Intent(this, CustomA.class));
                break;
            case R.id.bt2:
                startActivity(new Intent(this, CustomB.class));
                break;
            case R.id.bt3:
                startActivity(new Intent(this, CustomC.class));
                break;
            case R.id.bt4:
                startActivity(new Intent(this, CustomD.class));
                break;

//            case R.id.bt5:
//                startActivity(new Intent(this, CustomE.class));
//                break;
        }
    }
}
