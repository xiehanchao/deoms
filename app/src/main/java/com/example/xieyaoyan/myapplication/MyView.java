package com.example.xieyaoyan.myapplication;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class MyView extends View {


    private Paint mOutPaint;
    private Paint mInPaint;
    private float currentValue;
    public MyView(Context context) {
        super(context);
        init();
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mOutPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mOutPaint.setStrokeWidth(0);
        mOutPaint.setStyle(Paint.Style.STROKE);
        mOutPaint.setColor(Color.BLUE);
        mInPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mInPaint.setColor(mOutPaint.getColor());
    }

    @Override
    protected void onDraw(final Canvas canvas) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        final RectF drawRect = new RectF(paddingLeft, paddingTop, getWidth() - paddingRight, getHeight() - paddingBottom);

        float end = (currentValue * 360);
        float start = 270 - end;
        canvas.drawArc(
                drawRect,
                start,
                end,
                true,
                mInPaint);

        canvas.drawOval(drawRect, mOutPaint);
    }

    public void doAnimation() {
        ValueAnimator anim = ValueAnimator.ofFloat(1f, 0f);
        anim.setDuration(3000);
        anim.setRepeatCount(100);
        anim.setRepeatMode(ValueAnimator.RESTART);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                currentValue = (float) animation.getAnimatedValue();
                MyView.this.invalidate();
            }
        });
        anim.start();
    }
}