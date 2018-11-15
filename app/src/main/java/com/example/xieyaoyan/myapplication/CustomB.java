package com.example.xieyaoyan.myapplication;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.xieyaoyan.myapplication.databinding.CustombBinding;
public class CustomB extends AppCompatActivity{
    private CustomProcess customProcess;
    private CustombBinding viewDataBinding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.customb);
        customProcess = (CustomProcess) findViewById(R.id.process);
    }
}
