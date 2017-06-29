package com.leon.swipeToLoadLayout;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;

/**
 * Created by leon on 2017/6/29.
 */

public class SwipeToLoadLayoutWrapper extends LinearLayout {
    private SwipeToLoadLayout mSwipe;
    private RecyclerView mRecyclerView;
    private LayoutInflater mLayoutInflater;

    public SwipeToLoadLayoutWrapper(Context context) {
        super(context);
    }

    public SwipeToLoadLayoutWrapper(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public SwipeToLoadLayoutWrapper(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public SwipeToLoadLayoutWrapper(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        mLayoutInflater = LayoutInflater.from(context);
        mLayoutInflater.inflate(R.layout.layout_swipe_to_load_layout_wrapper, this);
        mSwipe = (SwipeToLoadLayout) findViewById(R.id.swipe);
        mRecyclerView = (RecyclerView) findViewById(R.id.swipe_target);
    }

    public void setHeaderView(View headerView) {
        mSwipe.setRefreshHeaderView(headerView);
        setLoadMoreStartListener();
    }

    public void setFooterView(View footerView) {
        mSwipe.setLoadMoreFooterView(footerView);
    }

    public void setDefaultHeadAndFoot() {
        Context context = getContext();
        setHeaderView(mLayoutInflater.inflate(R.layout.layout_google_header, mSwipe, false));
        setFooterView(mLayoutInflater.inflate(R.layout.layout_google_footer, mSwipe, false));
    }

    private void setLoadMoreStartListener() {
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE ) {
                    if (!ViewCompat.canScrollVertically(recyclerView, 1)){
                        mSwipe.setLoadingMore(true);
                    }
                }
            }
        });
    }

    public SwipeToLoadLayout getSwipe() {
        return mSwipe;
    }

    public RecyclerView getRecyclerView() {
        return mRecyclerView;
    }
}
