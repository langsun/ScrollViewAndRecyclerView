package com.sun.myrecycleview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sun on 18/10/18.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context mContext;
    private List<String> mList;

    public MyAdapter(Context mContext, List<String> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.mName.setText(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_name)
        TextView mName;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
