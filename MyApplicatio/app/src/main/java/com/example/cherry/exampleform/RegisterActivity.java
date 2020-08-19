package com.example.cherry.exampleform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText uname,umail,upass;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        uname = findViewById(R.id.uname);
        umail = findViewById(R.id.umail);
        upass = findViewById(R.id.upass);
        preferences = getSharedPreferences("Data",MODE_PRIVATE);
    }

    public void register(View view) {
        String n = uname.getText().toString();
        String m = umail.getText().toString();
        String p = upass.getText().toString();
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("name",n);
        editor.putString("mail",m);
        editor.putString("pass",p);
        editor.commit();
        Toast.makeText(this, "Successfully Registered",
                Toast.LENGTH_SHORT).show();
    }
    public void login(View view) {
        startActivity(new Intent(this,LoginActivity.class));
    }
}