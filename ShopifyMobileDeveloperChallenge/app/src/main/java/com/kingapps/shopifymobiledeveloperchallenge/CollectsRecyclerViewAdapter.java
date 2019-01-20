package com.kingapps.shopifymobiledeveloperchallenge;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class CollectsRecyclerViewAdapter extends RecyclerView.Adapter<CollectsRecyclerViewAdapter.ViewHolder>{
    private static final String TAG = "CollectsRecyclerViewAdapter";

    private ArrayList <String>  mNames = new ArrayList<>();
    private Context mContext;

    public CollectsRecyclerViewAdapter(ArrayList<String> mNames, Context mContext) {
        this.mNames = mNames;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_collections_list_layout, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: called.");
        holder.data.setText(mNames.get(position));
    }

    @Override
    public int getItemCount() {
        return mNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView data;
        ConstraintLayout parentLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            data = itemView.findViewById(R.id.dataText);
            parentLayout = itemView.findViewById(R.id.parentLayout);
        }
    }
}
