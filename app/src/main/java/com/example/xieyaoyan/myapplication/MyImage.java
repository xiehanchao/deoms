package com.example.xieyaoyan.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.Random;

/**
 * Created by MAC on 2017/8/22.
 */

@SuppressLint("AppCompatCustomView")
public class MyImage extends ImageView {

    private int randomW;
    private int randomH;
    private int contentWidth;
    private int contentHeight;
    private int thisMeasureWidth;
    private int thisMeasureHeight;
    private int currentX;
    private int currentY;
    private Random random;

    public MyImage(Context context) {
        super(context);
    }

    public MyImage(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyImage(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void layout(int l, int t, int r, int b) {
        LinearLayout parent = (LinearLayout) this.getParent();
        int parentMeasuredWidth = parent.getMeasuredWidth();
        int parentMeasuredHeight = parent.getMeasuredHeight();
        thisMeasureWidth = this.getMeasuredWidth();
        thisMeasureHeight = this.getMeasuredHeight();
        super.layout(0, 0, thisMeasureWidth, thisMeasureHeight);
        contentWidth = parentMeasuredWidth - thisMeasureWidth;
        contentHeight = parentMeasuredHeight - thisMeasureHeight;
        random = new Random();
        randomW = random.nextInt(contentWidth);
        randomH = random.nextInt(contentHeight);
        currentX = MyImage.this.getLeft();
        currentY = MyImage.this.getTop();
        this.post(runnable);
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            MyImage.this.removeCallbacks(this);
            //这是横坐标向左
            if (currentX - randomW > 0) {
                //这是纵坐标向上
                if (currentY - randomH > 0) {
                    MyImage.super.layout(currentX--, currentY--, currentX + thisMeasureWidth, currentY + thisMeasureHeight);
                }
                //这是纵坐标向下
                else {
                    MyImage.super.layout(currentX--, currentY++, currentX + thisMeasureWidth, currentY + thisMeasureHeight);
                }
            }
            //这是横坐标向右
            else {
                //这是纵坐标向上
                if (currentY - randomH > 0) {
                    MyImage.super.layout(currentX++, currentY--, currentX + thisMeasureWidth, currentY + thisMeasureHeight);
                }
                //这是纵坐标向下
                else {
                    MyImage.super.layout(currentX++, currentY++, currentX + thisMeasureWidth, currentY + thisMeasureHeight);
                }
            }
            if (MyImage.this.getLeft() == randomW || MyImage.this.getTop() == randomH) {
                currentX = MyImage.this.getLeft();
                currentY = MyImage.this.getTop();
                randomW = random.nextInt(contentWidth);
                randomH = random.nextInt(contentHeight);
            }
            MyImage.this.invalidate();
            MyImage.this.post(this);
        }
    };
}
