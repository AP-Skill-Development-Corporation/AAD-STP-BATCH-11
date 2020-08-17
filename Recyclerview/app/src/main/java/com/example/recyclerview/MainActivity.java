package com.example.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    int images[];
    String names[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclr1);
        recyclerView.setAdapter(new Myadapter());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        setData();
    }

    private void setData() {
        images= new int[]{R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,
                R.drawable.e,R.drawable.f,R.drawable.g,R.drawable.h,
                R.drawable.i,R.drawable.j};
       names=new String[]{"Arjun Reddy","Bahubali","chatrapathi","Damarukam","Ega",
       "F2","Gangaleader","Hello","I","Jalsa"};

    }
    class Myadapter extends RecyclerView.Adapter<Myadapter.ViewInfo>{

        @NonNull
        @Override
        public Myadapter.ViewInfo onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view=LayoutInflater.from(MainActivity.this).inflate(R.layout.row_item,
                    parent,false);
            return new ViewInfo(view);
        }

        @Override
        public void onBindViewHolder(@NonNull Myadapter.ViewInfo holder, int position) {
            holder.imageView.setImageResource(images[position]);
            holder.textView.setText(names[position]);

        }

        @Override
        public int getItemCount() {
            return images.length;
        }

        public class ViewInfo extends RecyclerView.ViewHolder {
            ImageView imageView;
            TextView textView;
            public ViewInfo(@NonNull View itemView) {
                super(itemView);
                imageView=itemView.findViewById(R.id.img1);
                textView=itemView.findViewById(R.id.tex1);
            }
        }
    }

    }

