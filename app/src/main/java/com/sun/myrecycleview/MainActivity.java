package com.sun.myrecycleview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.recycle_view)
    RecyclerView mRecycleView;
    @BindView(R.id.recycle_view1)
    RecyclerView mRecycleView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        /**
         * 下面是第一个Recycleview
         */
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            list.add("这是第一个RecycleView--" + i);
        }
        MyAdapter adapter = new MyAdapter(this, list);
        mRecycleView.setAdapter(adapter);
        mRecycleView.setLayoutManager(new LinearLayoutManager(this) {
            @Override
            public boolean canScrollVertically() {
                //解决ScrollView里存在多个RecyclerView时滑动卡顿的问题
                // 如果你的RecyclerView是水平滑动的话可以重写canScrollHorizontally方法
                return false;
            }
        });
        //解决数据加载不完的问题
        mRecycleView.setNestedScrollingEnabled(false);
        mRecycleView.setHasFixedSize(true);
        // 解决数据加载完成后, 没有停留在顶部的问题
        mRecycleView.setFocusable(false);


        /**
         * 下面是第二个Recycleview
         */
        List<String> list1 = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            list1.add("这是第二个RecycleView--" + i);
        }
        MyAdapter adapter1 = new MyAdapter(this, list);
        mRecycleView1.setAdapter(adapter1);
        mRecycleView1.setLayoutManager(new LinearLayoutManager(this) {
            @Override
            public boolean canScrollVertically() {
                //解决ScrollView里存在多个RecyclerView时滑动卡顿的问题
                // 如果你的RecyclerView是水平滑动的话可以重写canScrollHorizontally方法
                return false;
            }
        });
        //解决数据加载不完的问题
        mRecycleView1.setNestedScrollingEnabled(false);
        mRecycleView1.setHasFixedSize(true);
        // 解决数据加载完成后, 没有停留在顶部的问题
        mRecycleView1.setFocusable(false);


    }
}
