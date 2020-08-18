package com.example.cherry.examplework;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.Constraints;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

import android.os.Bundle;
import android.view.View;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    OneTimeWorkRequest firstrequest;
    PeriodicWorkRequest secondrequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Constraints constraints=new Constraints
                .Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED).build();
        firstrequest = new OneTimeWorkRequest
                .Builder(Firstwork.class)
                .setConstraints(constraints)
                .build();
        secondrequest = new PeriodicWorkRequest
                .Builder(SecondWork.class,15, TimeUnit.MINUTES)
                .build();
    }

    public void work(View view) {
        WorkManager.getInstance(this).enqueue(firstrequest);
        WorkManager.getInstance(this).enqueue(secondrequest);
    }
}