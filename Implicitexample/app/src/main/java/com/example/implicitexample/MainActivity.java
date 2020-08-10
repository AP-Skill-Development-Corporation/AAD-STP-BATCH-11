package com.example.implicitexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText e1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.edit1);
    }

    public void browser(View view) {
        Uri uri=Uri.parse("https://"+e1.getText().toString());
        Intent intent= new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);

    }
}
