package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.tx1);
    }

    public void enter(View view) {
        String s=editText.getText().toString();
        Intent i = new Intent(this,Main2Activity.class);
        i.putExtra("android",s);
        startActivity(i);
    }
}
