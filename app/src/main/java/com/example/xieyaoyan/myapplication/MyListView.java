package com.example.xieyaoyan.myapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

public class MyListView extends ListView {

    private boolean mHandleOver;
    private int mLastY = 0;
    private int mDy = 0;

    private final static int TOP = 0;

    private final static int MOVE = 1;

    private final static int BOTTOM = 2;

    private static int CURRENT = TOP;

    private MyScrollView mScrollView;

    public MyListView(Context context) {
        super(context);
        init();

    }

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    public MyListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        this.setOnScrollListener(new OnScrollListener() {
            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (firstVisibleItem == 0) {
                    View firstVisibleItemView = MyListView.this.getChildAt(0);
                    if (firstVisibleItemView != null && firstVisibleItemView.getTop() == 0) {
                        CURRENT = TOP;
                    }
                } else if ((firstVisibleItem + visibleItemCount) == totalItemCount) {
                    View lastVisibleItemView = MyListView.this.getChildAt(MyListView.this.getChildCount() - 1);
                    if (lastVisibleItemView != null && lastVisibleItemView.getBottom() == MyListView.this.getHeight()) {
                        CURRENT = BOTTOM;
                    }
                }else {
                    CURRENT = MOVE;
                }
            }

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
            }
        });
    }

    public void setScrollview(MyScrollView my_scrollview) {
        this.mScrollView = my_scrollview;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        int x = (int) ev.getX();
        int y = (int) ev.getY();
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:{
                mHandleOver = false;
                break;
            }
            case MotionEvent.ACTION_MOVE:{
                mDy = y - mLastY;
                //mDy>0证明是向下滑动
                //CURRENT == TOP是证明，ListView已经滑动到了顶部
                //这时候滑动的事件就应该交给ScrollView了，允许
                //ScrollView对事件进行拦截询问。
                if (mDy > 0 && CURRENT == TOP){
                    this.mScrollView.setIsBottom(false);
                    this.mScrollView.requestDisallowInterceptTouchEvent(false);
                }
                break;
            }
            case MotionEvent.ACTION_CANCEL:{
                //这句话三两句解释不清楚啊，可以看我另一片关于事件
                //分发的博客
                //https://blog.csdn.net/qq_29951983/article/details/60469655
                this.mScrollView.setIsBottom(true);
                this.mScrollView.requestDisallowInterceptTouchEvent(false);
                break;
            }
            case MotionEvent.ACTION_UP:{
                //证明手指滑动放在了ListView上面，没有放在
                //ScrollView上面，mHandleOver在ScrollView
                //中进行了处理，用于判断当前滑动是在ScrollView
                //还是ListView
                mHandleOver = true;
                break;
            }
        }
        mLastY = y;
        return super.dispatchTouchEvent(ev);
    }

    public boolean getHandleOver(){
        return mHandleOver;
    }
}
