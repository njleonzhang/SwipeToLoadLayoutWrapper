package com.leon.swipetoloadlayoutwrapper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leon.swipeToLoadLayout.SwipeToLoadLayoutWrapper;

public class MainActivity extends AppCompatActivity {
    private SwipeToLoadLayoutWrapper mWrapper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWrapper = (SwipeToLoadLayoutWrapper) findViewById(R.id.swipe_wrapper);

        RecyclerView recyclerView = mWrapper.getRecyclerView();

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        recyclerView.setAdapter(new RecyclerView.Adapter() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.item_test, null);
                return new MyViewHolder(view);
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

            }

            @Override
            public int getItemCount() {
                return 100;
            }

            class MyViewHolder extends RecyclerView.ViewHolder {

                MyViewHolder(View itemView) {
                    super(itemView);
                }
            }
        });

        mWrapper.setDefaultHeadAndFoot();
    }
}
