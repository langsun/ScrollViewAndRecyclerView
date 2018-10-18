# ScrollViewAndRecyclerView
ScrollView嵌套RecyclerView，实现recycleview加载全部数据，只让ScrollView滑动，实现一个长屏功能
### 核心代码
Java代码

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
 xxx.Xml代码  NestedScrollView
 
     <android.support.v4.widget.NestedScrollView
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="vertical">

            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="350dp">

                <TextView
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"
                    android:gravity="center"
                    android:text="这是一个LinearLayout" />
            </LinearLayout>

            <TextView
                android:layout_width="match_parent"
                android:layout_height="300dp"
                android:background="@color/colorAccent"
                android:gravity="center"
                android:text="这是一个TextView" />

            <android.support.v7.widget.RecyclerView
                android:id="@+id/recycle_view"
                android:layout_width="match_parent"
                android:layout_height="wrap_content" />

            <TextView
                android:layout_width="match_parent"
                android:layout_height="300dp"
                android:background="@color/colorPrimaryDark"
                android:gravity="center"
                android:text="这是一个TextView" />

            <android.support.v7.widget.RecyclerView
                android:id="@+id/recycle_view1"
                android:layout_width="match_parent"
                android:layout_height="wrap_content" />
        </LinearLayout>
    </android.support.v4.widget.NestedScrollView>
