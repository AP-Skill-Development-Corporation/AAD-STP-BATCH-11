package com.example.cherry.examplerdb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cherry.examplerdb.Database.RTable;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.HoldView> {
    Context context;
    List<RTable> list;
    public MyAdapter(Context context, List<RTable> list) {
        this.context = context;
        this.list = list;
    }
    @NonNull
    @Override
    public HoldView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HoldView(LayoutInflater.from(context).
                inflate(R.layout.row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull HoldView holder, int position) {
        holder.name.setText(list.get(position).getName());
        holder.roll.setText(list.get(position).getRoll());
        holder.number.setText(list.get(position).getNumber());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class HoldView extends RecyclerView.ViewHolder {
        ImageView edit,del;
        TextView name,roll,number;
        public HoldView(@NonNull View itemView) {
            super(itemView);
            edit = itemView.findViewById(R.id.edit);
            del = itemView.findViewById(R.id.del);
            name = itemView.findViewById(R.id.name);
            roll = itemView.findViewById(R.id.roll);
            number  = itemView.findViewById(R.id.number);
        }
    }
}
