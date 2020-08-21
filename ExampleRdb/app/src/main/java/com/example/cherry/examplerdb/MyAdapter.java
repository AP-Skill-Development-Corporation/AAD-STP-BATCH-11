package com.example.cherry.examplerdb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cherry.examplerdb.Database.RTable;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.bottomsheet.BottomSheetDialog;

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
    public void onBindViewHolder(@NonNull HoldView holder, final int position) {
        holder.name.setText(list.get(position).getName());
        holder.roll.setText(list.get(position).getRoll());
        holder.number.setText(list.get(position).getNumber());
        holder.del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.viewModel.delete(list.get(position));
                Toast.makeText(context, "Item Deleted",
                        Toast.LENGTH_SHORT).show();
            }
        });
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
            edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ViewGroup viewGroup = view.findViewById(R.id.content);
                    View v = LayoutInflater.from(context).
                            inflate(R.layout.update,viewGroup,false);

                    final EditText sname = v.findViewById(R.id.name);
                    final EditText sroll = v.findViewById(R.id.roll);
                    final EditText snum = v.findViewById(R.id.number);
                    Button update = v.findViewById(R.id.update);
                    Button cancel = v.findViewById(R.id.cancel);

                    final BottomSheetDialog dialog=new BottomSheetDialog(context);
                    dialog.setContentView(v);
                    dialog.setCancelable(false);

                    sname.setText(name.getText().toString());
                    sroll.setText(roll.getText().toString());
                    sroll.setEnabled(false);
                    snum.setText(number.getText().toString());

                    update.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            RTable rTable = new RTable();
                            rTable.setName(sname.getText().toString());
                            rTable.setRoll(sroll.getText().toString());
                            rTable.setNumber(snum.getText().toString());
                            MainActivity.viewModel.update(rTable);
                            Toast.makeText(context, "Data Updated",
                                    Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                    });
                    cancel.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.dismiss();
                        }
                    });
                    dialog.show();
                }
            });
        }
    }
}
