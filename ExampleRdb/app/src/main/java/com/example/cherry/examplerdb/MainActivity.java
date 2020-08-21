package com.example.cherry.examplerdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cherry.examplerdb.Database.RTable;
import com.example.cherry.examplerdb.Database.RViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText name,roll,number;
    RecyclerView rv;
    public static RViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        roll = findViewById(R.id.roll);
        number = findViewById(R.id.number);
        rv = findViewById(R.id.rv);
        viewModel = new ViewModelProvider(this).get(RViewModel.class);
        /*To read the data from the room database*/
        viewModel.readData().observe(this, new Observer<List<RTable>>() {
            @Override
            public void onChanged(List<RTable> rTables) {
                MyAdapter adapter = new MyAdapter(MainActivity.this,rTables);
                rv.setAdapter(adapter);
                rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            }
        });
    }

    public void save(View view) {
        String sname=name.getText().toString();
        String sroll = roll.getText().toString();
        String snum = number.getText().toString();
        /*To insert the Data*/
        RTable rTable = new RTable();
        rTable.setName(sname);
        rTable.setRoll(sroll);
        rTable.setNumber(snum);
        viewModel.insert(rTable);
        Toast.makeText(this, "Data Inserted", Toast.LENGTH_SHORT).show();

    }
}